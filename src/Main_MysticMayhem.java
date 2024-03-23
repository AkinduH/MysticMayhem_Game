import java.io.Serializable;

public class Main_MysticMayhem implements Serializable {
    static int nextUserID = 0;

    public static void main(String[] args) {
        UserManager.loadPlayersFromFile();

        if (UserManager.getPlayers().isEmpty()) {
            CreatePlayers.createExistingPlayer("GeraltofRivia", "whitewolf", "Marshland");
        }
        Menu.Heading();
        Menu.displayMainMenu();
    }

}













































