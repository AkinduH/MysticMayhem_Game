import java.io.Serializable;
import java.util.*;

public class CreatePlayers implements Serializable {

    private static Scanner scanner = new Scanner(System.in);

    static Map<String, Character> characteMap2 = new HashMap<>();
    static{
        characteMap2.put("shooter", Archer.createShooter());
        characteMap2.put("ranger", Archer.createRanger());
        characteMap2.put("sunfire", Archer.createSunfire());
        characteMap2.put("zing", Archer.createZing());
        characteMap2.put("saggitarius", Archer.createSaggitarius());

        characteMap2.put("squire", Knight.createSquire());
        characteMap2.put("cavalier", Knight.createCavalier());
        characteMap2.put("templar", Knight.createTemplar());
        characteMap2.put("zoro", Knight.createZoro());
        characteMap2.put("swiftblade", Knight.createSwiftblade());

        characteMap2.put("warlock", Mage.createWarlock());
        characteMap2.put("illusionist", Mage.createIllusionist());
        characteMap2.put("enchanter", Mage.createEnchanter());
        characteMap2.put("conjurer", Mage.createConjurer());
        characteMap2.put("eldritch", Mage.createEldritch());

        characteMap2.put("soother", Healer.createSoother());
        characteMap2.put("medic", Healer.createMedic());
        characteMap2.put("alchemist", Healer.createAlchemist());
        characteMap2.put("saint", Healer.createSaint());
        characteMap2.put("lightbringer", Healer.createLightbringer());

        characteMap2.put("dragon", MythicalCreature.createDragon());
        characteMap2.put("basilisk", MythicalCreature.createBasilisk());
        characteMap2.put("hydra", MythicalCreature.createHydra());
        characteMap2.put("phoenix", MythicalCreature.createPhoenix());
        characteMap2.put("pegasus", MythicalCreature.createPegasus());
    }


    public static void createExistingPlayer(String playerName,String playerUsername,String playerHomeGround){
        Player player = new Player(playerName, playerUsername, Main_MysticMayhem.nextUserID++, 1030, playerHomeGround);
        player.setXp(32);
        player.createArmy(Givenewcharacter(characteMap2.get("ranger")));
        player.createArmy(Givenewcharacter(characteMap2.get("squire")));
        player.createArmy(Givenewcharacter(characteMap2.get("warlock")));
        player.createArmy(Givenewcharacter(characteMap2.get("medic")));
        player.createArmy(Givenewcharacter(characteMap2.get("dragon")));
        UpgradeCharacter.ExistingPlayerArmour(player,0,"chainmail");
        UpgradeCharacter.ExistingPlayerArtefact(player,3,"amulet");
        UserManager.addPlayer(player);
    }

    static Character Givenewcharacter(Character character1){
        if (character1 instanceof Archer) {
            return new Archer((Archer) character1);
        } else if (character1 instanceof Knight) {
            return new Knight((Knight) character1);
        } else if (character1 instanceof Mage) {
            return new Mage((Mage) character1);
        } else if (character1 instanceof Healer) {
            return new Healer((Healer) character1);
        } else if (character1 instanceof MythicalCreature) {
            return new MythicalCreature((MythicalCreature) character1);
        } else {
            return null;
        }
    }

    public static void createPlayer() {
        System.out.println("Enter your name:");
        String playerName = scanner.nextLine();
        System.out.println("Enter a username:");
        String playerUsername = scanner.nextLine();
        while (Menu.isUsernameUsed(playerUsername)) {
            System.out.println("\u001B[33m" + "Username already taken. Please enter a different username:" + "\u001B[0m");
            playerUsername = scanner.nextLine();
        }
        String playerHomeGround = "null";
        System.out.println("Select home ground (1.Hillcrest/2.Marshland/3.Desert/4.Arcane):");

        while (!playerHomeGround.equals("Hillcrest") && !playerHomeGround.equals("Marshland") && !playerHomeGround.equals("Desert") && !playerHomeGround.equals("Arcane")){

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        playerHomeGround = "Hillcrest";
                        break;
                    case 2:
                        playerHomeGround = "Marshland";
                        break;
                    case 3:
                        playerHomeGround = "Desert";
                        break;
                    case 4:
                        playerHomeGround = "Arcane";
                        break;
                    default:
                        System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");

                }
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "Please enter the option number." + "\u001B[0m");
                scanner.nextLine();
            }
        }

        Player player = new Player(playerName, playerUsername, Main_MysticMayhem.nextUserID++, 500, playerHomeGround);

        System.out.println("Create your army:");
        System.out.println();
        System.out.println("Archers:");
        System.out.println();
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println("Name    : | Shooter  |  Ranger  |  Sunfire  |  Zing  |  Saggitarius |");
        System.out.println("Price   :    80 gc      115 gc     160 gc     200 gc     230 gc");
        System.out.println("Attack  :     11          14         15         16         18");
        System.out.println("Defence :      4           5          5          9          7");
        System.out.println("Health  :      6           8          7         11         12");
        System.out.println("Speed   :      9          10         14         14         17");
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println();
        System.out.println("Select an archer:");
        player.createArmy(selectCharacter(true, player, characteMap2.get("shooter"), characteMap2.get("ranger"), characteMap2.get("sunfire"), characteMap2.get("zing"), characteMap2.get("saggitarius")));

        System.out.println("\nKnights:");
        System.out.println();
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println("Name    : | Squire  |  Cavalier  |  Templar  |  Zoro  |  Swiftblade |");
        System.out.println("Price   :    85 gc      110 gc     155 gc     180 gc     250 gc");
        System.out.println("Attack  :      8           10         14         17         18");
        System.out.println("Defence :      9           12         16         16         20");
        System.out.println("Health  :      7            7         12         13         17");
        System.out.println("Speed   :      8           10         12         14         13");
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println();
        System.out.println("Select a knight:");
        player.createArmy(selectCharacter(true, player, characteMap2.get("squire"), characteMap2.get("cavalier"), characteMap2.get("templar"), characteMap2.get("zoro"), characteMap2.get("swiftblade")));

        System.out.println("\nMages:");
        System.out.println();
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println("Name    : | Warlock  |  Illusionist  |  Enchanter  |  Conjurer  |  Eldritch |");
        System.out.println("Price   :   100 gc       120 gc        160 gc        195 gc       270 gc");
        System.out.println("Attack  :     12            13            16            18           19");
        System.out.println("Defence :      7             8            10            15           17");
        System.out.println("Health  :     10            12            13            14           18");
        System.out.println("Speed   :     12            14            16            12           14");
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println();
        System.out.println("Select a mage:");
        player.createArmy(selectCharacter(true, player, characteMap2.get("warlock"), characteMap2.get("illusionist"), characteMap2.get("enchanter"), characteMap2.get("conjurer"), characteMap2.get("eldritch")));

        System.out.println("\nHealers:");
        System.out.println();
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println("Name    : | Soother  |  Medic  |  Alchemist  |  Saint  |  Lightbringer |");
        System.out.println("Price   :    95 gc      125 gc     150 gc     200 gc     260 gc");
        System.out.println("Attack  :     10          12          13         16         17");
        System.out.println("Defence :      8           9          13         14         15");
        System.out.println("Health  :      9          10          13         17         19");
        System.out.println("Speed   :      6           7          13          9         12");
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println();
        System.out.println("Select a healer:");
        player.createArmy(selectCharacter(true, player, characteMap2.get("soother"), characteMap2.get("medic"), characteMap2.get("alchemist"), characteMap2.get("saint"), characteMap2.get("lightbringer")));

        System.out.println("\nMythical Creatures:");
        System.out.println();
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println("Name    : | Dragon  |  Basilisk  |  Hydra  |  Phoenix  |  Pegasus |");
        System.out.println("Price   :   120 gc      165 gc     205 gc     275 gc     340 gc");
        System.out.println("Attack  :     12          15         12         17         14");
        System.out.println("Defence :     14          11         16         13         18");
        System.out.println("Health  :     15          10         15         17         20");
        System.out.println("Speed   :      8          12         11         19         20");
        System.out.println("\u001B[33m" + "-------------------------------------------------------------------------------" + "\u001B[0m");
        System.out.println();
        System.out.println("Select a mythical creature:");
        player.createArmy(selectCharacter(true, player, characteMap2.get("dragon"), characteMap2.get("basilisk"), characteMap2.get("hydra"), characteMap2.get("phoenix"), characteMap2.get("pegasus")));

        UserManager.addPlayer(player);
        System.out.println("\u001B[34m" + "Player created successfully!" + "\u001B[0m");
        Menu.PlayerMainMenu(player);
    }
    public static void Buynewcharacters(Player player) {

        System.out.println("Select an archer:");
        player.createArmy(selectCharacter(false,player, characteMap2.get("shooter"), characteMap2.get("ranger"), characteMap2.get("sunfire"), characteMap2.get("zing"), characteMap2.get("saggitarius")));
        System.out.println("Select a knight:");
        player.createArmy(selectCharacter(false,player, characteMap2.get("squire"), characteMap2.get("cavalier"), characteMap2.get("templar"), characteMap2.get("zoro"), characteMap2.get("swiftblade")));
        System.out.println("Select a mage:");
        player.createArmy(selectCharacter(false,player, characteMap2.get("warlock"), characteMap2.get("illusionist"), characteMap2.get("enchanter"), characteMap2.get("conjurer"), characteMap2.get("eldritch")));
        System.out.println("Select a healer:");
        player.createArmy(selectCharacter(false,player, characteMap2.get("soother"), characteMap2.get("medic"), characteMap2.get("alchemist"), characteMap2.get("saint"), characteMap2.get("lightbringer")));
        System.out.println("Select a mythical creature:");
        player.createArmy(selectCharacter(false,player, characteMap2.get("dragon"), characteMap2.get("basilisk"), characteMap2.get("hydra"), characteMap2.get("phoenix"), characteMap2.get("pegasus")));

        Menu.PlayerMainMenu(player);
    }
    static Character selectCharacter(boolean FisrtTurn,Player player, Character c1, Character c2, Character c3, Character c4, Character c5) {
        Character selected = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Available gold Coins = " + player.getCoins());
        System.out.println("1. " + c1.getName() + " (" + c1.getPrice() + " gc)");
        System.out.println("2. " + c2.getName() + " (" + c2.getPrice() + " gc)");
        System.out.println("3. " + c3.getName() + " (" + c3.getPrice() + " gc)");
        System.out.println("4. " + c4.getName() + " (" + c4.getPrice() + " gc)");
        System.out.println("5. " + c5.getName() + " (" + c5.getPrice() + " gc)");
        System.out.println("6. " + "Skip");
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    selected = c1;
                    break;
                case 2:
                    selected = c2;
                    break;
                case 3:
                    selected = c3;
                    break;
                case 4:
                    selected = c4;
                    break;
                case 5:
                    selected = c5;
                    break;
                case 6:
                    if (player.army.size() != 5){
                        System.out.println("\u001B[33m" + "You can't Skip Buying at the first chance" + "\u001B[0m");
                        return selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
                    }else{
                        selected = null;
                    }
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
                    return selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
            }
        } catch (InputMismatchException e) {
            System.out.println("\u001B[31m" + "Please enter the option number." + "\u001B[0m");
            return selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);

        }
        if (selected != null && player.getCoins() < selected.getPrice()) {
            System.out.println("\u001B[33m" + "Insufficient balance to buy " + selected.getName() + ". Please select another character." + "\u001B[0m");
            return selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
        }


        if (FisrtTurn){
            if (selected instanceof Archer) {
                if (player.getCoins() < selected.getPrice() + 420) {
                    System.out.println("\u001B[33m" + "Warning: You can't buy " + selected.getName() + ", because you will run out of coins." + "\u001B[0m"); // Print in yellow
                    System.out.println("Please select another character.");
                    selected = selectCharacter(FisrtTurn, player, c1, c2, c3, c4, c5);
                }
                return selected;
            } else if (selected instanceof Knight) {
                if (player.getCoins() < selected.getPrice() + 335){
                    System.out.println("\u001B[33m" + "Warning: You can't buy " + selected.getName() + ", because you will run out of coins." + "\u001B[0m"); // Print in yellow
                    System.out.println("Please select another character.");
                    selected = selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
                }
                return selected;
            } else if (selected instanceof Mage) {
                if (player.getCoins() < selected.getPrice() + 215){
                    System.out.println("\u001B[33m" + "Warning: You can't buy " + selected.getName() + ", because you will run out of coins." + "\u001B[0m"); // Print in yellow
                    System.out.println("Please select another character.");
                    selected = selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
                }
                return selected;
            } else if (selected instanceof Healer) {
                if (player.getCoins() < selected.getPrice() + 120){
                    System.out.println("\u001B[33m" + "Warning: You can't buy " + selected.getName() + ", because you will run out of coins." + "\u001B[0m"); // Print in yellow
                    System.out.println("Please select another character.");
                    selected = selectCharacter(FisrtTurn,player, c1, c2, c3, c4, c5);
                }
                return selected;
            } else if (selected instanceof MythicalCreature) {
                return selected;
            } else {
                return null;
            }
        }else{
            if (selected instanceof Archer) {
                player.setCoins(player.getCoins() + (int) Math.round(0.9 * player.army.get(0).getPrice()));
                System.out.println("\u001B[31m" + "Previouse " + player.army.get(0).getName() + " was sold." + "\u001B[0m");
                player.army.remove(0);
                player.armour[0] = null;
                player.artefact[0] = null;
                System.out.println("\u001B[32m" + "New " + selected.getName() + " successfully bought." + "\u001B[0m");
                return new Archer((Archer) selected);
            } else if (selected instanceof Knight) {
                player.setCoins(player.getCoins() + (int) Math.round(0.9 * player.army.get(1).getPrice()));
                System.out.println("\u001B[31m" + "Previouse " + player.army.get(1).getName() + " was sold." + "\u001B[0m");
                player.army.remove(1);
                player.armour[1] = null;
                player.artefact[1] = null;
                System.out.println("\u001B[32m" + "New " + selected.getName() + " successfully bought." + "\u001B[0m");
                return new Knight((Knight) selected);
            } else if (selected instanceof Mage) {
                player.setCoins(player.getCoins() + (int) Math.round(0.9 * player.army.get(2).getPrice()));
                System.out.println("\u001B[31m" + "Previouse " + player.army.get(2).getName() + " was sold." + "\u001B[0m");
                player.army.remove(2);
                player.armour[2] = null;
                player.artefact[2] = null;
                System.out.println("\u001B[32m" + "New " + selected.getName() + " successfully bought." + "\u001B[0m");
                return new Mage((Mage) selected);
            } else if (selected instanceof Healer) {
                player.setCoins(player.getCoins() + (int) Math.round(0.9 * player.army.get(3).getPrice()));
                System.out.println("\u001B[31m" + "Previouse " + player.army.get(3).getName() + " was sold." + "\u001B[0m");
                player.army.remove(3);
                player.armour[3] = null;
                player.artefact[3] = null;
                System.out.println("\u001B[32m" + "New " + selected.getName() + " successfully bought." + "\u001B[0m");
                return new Healer((Healer) selected);
            } else if (selected instanceof MythicalCreature) {
                player.setCoins(player.getCoins() + (int) Math.round(0.9 * player.army.get(4).getPrice()));
                System.out.println("\u001B[31m" + "Previouse " + player.army.get(4).getName() + " was sold." + "\u001B[0m");
                player.army.remove(4);
                player.armour[4] = null;
                player.artefact[4] = null;
                System.out.println("\u001B[32m" + "New " + selected.getName() + " successfully bought." + "\u001B[0m");
                return new MythicalCreature((MythicalCreature) selected);
            } else {
                return null;
            }
        }


    }
}

