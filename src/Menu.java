

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Menu implements Serializable {
    private static Scanner scanner = new Scanner(System.in);


    public static void Heading() {
        System.out.println("\n" +
                "           ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗                            \n" +
                "           ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗                           \n" +
                "           ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║                           \n" +
                "           ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║                           \n" +
                "           ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝                           \n" +
                "            ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝                            \n" +
                "███╗   ███╗██╗   ██╗███████╗████████╗██╗ ██████╗    ███╗   ███╗ █████╗ ██╗   ██╗██╗  ██╗███████╗███╗   ███╗    \n" +
                "████╗ ████║╚██╗ ██╔╝██╔════╝╚══██╔══╝██║██╔════╝    ████╗ ████║██╔══██╗╚██╗ ██╔╝██║  ██║██╔════╝████╗ ████║    \n" +
                "██╔████╔██║ ╚████╔╝ ███████╗   ██║   ██║██║         ██╔████╔██║███████║ ╚████╔╝ ███████║█████╗  ██╔████╔██║    \n" +
                "██║╚██╔╝██║  ╚██╔╝  ╚════██║   ██║   ██║██║         ██║╚██╔╝██║██╔══██║  ╚██╔╝  ██╔══██║██╔══╝  ██║╚██╔╝██║    \n" +
                "██║ ╚═╝ ██║   ██║   ███████║   ██║   ██║╚██████╗    ██║ ╚═╝ ██║██║  ██║   ██║   ██║  ██║███████╗██║ ╚═╝ ██║    \n" +
                "╚═╝     ╚═╝   ╚═╝   ╚══════╝   ╚═╝   ╚═╝ ╚═════╝    ╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝    \n" +
                "                                                                                                               \n");
    }

    public static void displayMainMenu() {
        System.out.println();
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║  Mystic Mayhem Main menu    ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 1. Create a new Player      ║");
        System.out.println("║ 2. List of Previous Players ║");
        System.out.println("║ 3. Save and Exit            ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CreatePlayers.createPlayer();
                    break;
                case 2:
                    listPlayers();
                    break;
                case 3:
                    UserManager.savePlayersToFile();
                    System.out.println("Exiting...");
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
                    displayMainMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31m" + "Please enter the option number." + "\u001B[0m");
            scanner.nextLine();
            displayMainMenu();
        }
        System.exit(0);

    }





    public static void PlayerMainMenu(Player player) {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("        " + player.getUsername() + "  Player Menu ");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║ 1. Upgrade Your Characters        ║");
        System.out.println("║ 2. Change your Name               ║");
        System.out.println("║ 3. Attack Another Player          ║");
        System.out.println("║ 4. Buy New Characters             ║");
        System.out.println("║ 5. Player Stats                   ║");
        System.out.println("║ 6. Back                           ║");
        System.out.println("║ 7. Save and Exit                  ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Select the Character you want to upgrade");
                    System.out.println("1. " + player.army.get(0).getName() + "\n"
                            + "2. " + player.army.get(1).getName() + "\n"
                            + "3. " + player.army.get(2).getName() + "\n"
                            + "4. " + player.army.get(3).getName() + "\n"
                            + "5. " + player.army.get(4).getName());
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice1) {
                        case 1:
                            CharacterUpgradeMenu(player, 0);
                            break;
                        case 2:
                            CharacterUpgradeMenu(player, 1);
                            break;
                        case 3:
                            CharacterUpgradeMenu(player, 2);
                            break;
                        case 4:
                            CharacterUpgradeMenu(player, 3);
                            break;
                        case 5:
                            CharacterUpgradeMenu(player, 4);
                            break;
                        default:
                            System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
                            PlayerMainMenu(player);
                    }
                    break;
                case 2:
                    System.out.println("Enter the new Name");
                    String new_name = scanner.nextLine();
                    player.setName(new_name);
                    System.out.println("\u001B[34m" + "Player name changed successfully!" + "\u001B[0m");
                    PlayerMainMenu(player);
                    break;
                case 3:
                    listPlayerstoattack(player);
                    break;

                case 4:
                    CreatePlayers.Buynewcharacters(player);
                    break;

                case 5:
                    System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
                    System.out.println(player.getName() + " (" + player.getUsername() + ")");
                    System.out.println(player.getHomeGround());
                    System.out.println("XP : " + player.getXp() + "  Gold coins : " + player.getCoins());
                    for (int i = 0; i < player.army.size(); i++) {
                        if (player.armour[i] != null && player.artefact[i] != null) {
                            System.out.println(player.army.get(i).getName() + " + " + player.armour[i].getName() + " + " + player.artefact[i].getName());
                        } else if (player.armour[i] != null && player.artefact[i] == null) {
                            System.out.println(player.army.get(i).getName() + " + " + player.armour[i].getName());
                        } else if (player.armour[i] == null && player.artefact[i] != null) {
                            System.out.println(player.army.get(i).getName() + " + " + player.artefact[i].getName());
                        } else {
                            System.out.println(player.army.get(i).getName());
                        }
                    }
                    System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
                    System.out.println();
                    PlayerMainMenu(player);
                    break;

                case 6:
                    displayMainMenu();
                    break;

                case 7:
                    UserManager.savePlayersToFile();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
                    PlayerMainMenu(player);

            }


        }catch(InputMismatchException e){
            System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
            scanner.nextLine();
            PlayerMainMenu(player);
        }
    }

    private static void listPlayerstoattack(Player player1) {
        if (UserManager.getPlayers().size() == 1) {
            System.out.println("\u001B[31m" + "No players to Attack." + "\u001B[0m");
            PlayerMainMenu(player1);
        } else {
            System.out.println("List of Players:");
            System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
            System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
            for (Player player2 : UserManager.getPlayers()) {
                if (player1 != player2) {
                    System.out.println(player2.getName() + " (" + "\u001B[34m" + player2.getUsername() + "\u001B[0m" + ")" + "  XP : " + player2.getXp());
                    System.out.println(player2.getName() + "'s Army");
                    for (int i = 0; i < player2.army.size(); i++) {
                        System.out.print(player2.army.get(i).getName() + " ");
                    }
                    System.out.println();
                }
                System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
            }
            System.out.println("\u001B[34m" + "Type the user name of the player you need to attack" + "\u001B[0m");
            String defender = scanner.nextLine();
            for (Player def : UserManager.getPlayers()) {
                if (def.getUsername().equalsIgnoreCase(defender)) {
                    Battle battle = new Battle(player1, def);
                    if (player1.army.size() != 5) {
                        System.out.println("\u001B[33m" + "Your army is not fully completed,So can't start a battle" + "\u001B[0m");
                        PlayerMainMenu(player1);
                    } else if (def.army.size() != 5) {
                        System.out.println("\u001B[33m" + "Your enemy army is not fully completed,So can't start a battle" + "\u001B[0m");
                        PlayerMainMenu(player1);
                    } else {
                        battle.start();
                        PlayerMainMenu(player1);
                    }
                }
            }
            System.out.println("\u001B[31m" + "Player not found." + "\u001B[0m");
            System.out.println("Do you want to reselect a player ?");
            System.out.println("Enter the option number");
            System.out.println("\u001B[33m" + "(Entering a wrong input will take you back to the main menu)" + "\u001B[0m");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int Choice = scanner.nextInt();
            scanner.nextLine();
            switch (Choice) {
                case 1:
                    listPlayerstoattack(player1);
                    break;
                case 2:
                    PlayerMainMenu(player1);
                    break;
            }

        }
    }

    public static void CharacterUpgradeMenu(Player player, int num) {
        System.out.println();
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("     " + player.army.get(num).getName() + " Menu    ");
        System.out.println("╠═════════════════════════════════════════╣");
        System.out.println("║ 1. Buy Armour                           ║");
        System.out.println("║ 2. Buy Artefact                         ║");
        System.out.println("║ 3. Back                                 ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    UpgradeCharacter.Armour(player, num);
                    CharacterUpgradeMenu(player, num);
                    break;
                case 2:
                    UpgradeCharacter.Artefact(player, num);
                    CharacterUpgradeMenu(player, num);
                    break;
                case 3:
                    PlayerMainMenu(player);
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
                    CharacterUpgradeMenu(player, num);
            }

        }catch(InputMismatchException e){
            System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
            scanner.nextLine();
            CharacterUpgradeMenu(player, num);
        }
    }


    static boolean isUsernameUsed(String username) {
        for (Player p : UserManager.getPlayers()) {
            if (p.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    private static void listPlayers() {
        if (UserManager.getPlayers().isEmpty()) {
            System.out.println("\u001B[31m" + "No players found." + "\u001B[0m");
        } else {
            System.out.println("List of Players:");
            System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
            for (Player player : UserManager.getPlayers()) {
                System.out.println(player.getName() + " (" + "\u001B[34m" + player.getUsername() + "\u001B[0m" + ")" + " | Available gold Coins = " + player.getCoins() + " | XP :" + player.getXp() + " |");
                System.out.println(player.getName() + "'s Army");
                for (int i=0; i<player.army.size(); i++){
                    System.out.print(player.army.get(i).getName() + " ");
                }
                System.out.println();
                System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
            }
        }
        System.out.println("Do you want to use a existing player ?");
        System.out.println("\u001B[34m" + "    If yes, Please enter the player user name" + "\u001B[0m");
        System.out.println("If No please enter no");
        String player_old = scanner.nextLine();
        for (Player player_o : UserManager.getPlayers()) {
            if (player_o.getUsername().equalsIgnoreCase(player_old) && !player_o.getUsername().equals("whitewolf")) {
                PlayerMainMenu(player_o);
            }
        }
        if (player_old.equals("no")){
            System.out.println("\u001B[33m" + "No player taken." + "\u001B[0m");
            displayMainMenu();
        }
        if (player_old.equals("whitewolf")){
            System.out.println("\u001B[31m" + "Can't take this player" + "\u001B[0m");
            displayMainMenu();
        }
        System.out.println("\u001B[31m" + "No such a player available" + "\u001B[0m");
        displayMainMenu();
    }


}

