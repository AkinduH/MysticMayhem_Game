

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements Serializable {
    private static final String PLAYER_FILE = "players.dat";
    private static List<Player> players = new ArrayList<>();

    public static void savePlayersToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(PLAYER_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(players);
            out.close();
            fileOut.close();
            System.out.println("Players data saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadPlayersFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(PLAYER_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            players = (List<Player>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Players data loaded successfully!");
        } catch (IOException ex) {
            System.out.println("No player data found. Starting with an empty list.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }
}