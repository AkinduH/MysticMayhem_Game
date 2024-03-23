import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class UpgradeCharacter implements Serializable {

    static Map<String, Armour> ArmourMap = new HashMap<>();
    static{
        ArmourMap.put("chainmail",Armour.createChainmail());
        ArmourMap.put("regalia",Armour.createRegalia());
        ArmourMap.put("fleece",Armour.createFleece());
    }
    static Map<String, Artefact> ArtefactMap = new HashMap<>();
    static{
        ArtefactMap.put("excalibur",Artefact.createExcalibur());
        ArtefactMap.put("amulet",Artefact.createAmulet());
        ArtefactMap.put("crystal",Artefact.createCrystal());
    }

    public static void Armour(Player player,int num){
        System.out.println("Armours:");
        System.out.println();
        System.out.println("Name    : | Chainmail  |  Regalia  |  Fleece |");
        System.out.println("Price   :    70 gc        105 gc     150 gc");
        System.out.println("Attack  :   no change    no change  no change");
        System.out.println("Defence :     +1            +1         +2");
        System.out.println("Health  :   no change    no change     +1");
        System.out.println("Speed   :     -1         no change     -1");
        System.out.println();
        player.buyArmour(num, selectArmour(player, ArmourMap.get("chainmail"), ArmourMap.get("regalia"), ArmourMap.get("fleece")));
    }

    public static void ExistingPlayerArmour(Player player,int num,String armour){

        player.buyArmour(num, ArmourMap.get(armour));
    }

    public static void Artefact(Player player,int num){
        System.out.println("Artefacts:");
        System.out.println();
        System.out.println("Name    : | Excalibur  |  Amulet  |  Crystal |");
        System.out.println("Price   :    150 gc       200 gc     210 gc");
        System.out.println("Attack  :     +2            +1         +2");
        System.out.println("Defence :   no change       -1         +1");
        System.out.println("Health  :   no change       +1         -1");
        System.out.println("Speed   :   no change       +1         -1");
        System.out.println();
        player.buyArtefact(num,selectArtefact(player, ArtefactMap.get("excalibur"), ArtefactMap.get("amulet"), ArtefactMap.get("crystal")));
    }

    public static void ExistingPlayerArtefact(Player player,int num,String artefact){

        player.buyArtefact(num, ArtefactMap.get(artefact));
    }

    static Armour selectArmour(Player player, Armour e1, Armour e2, Armour e3) {
        Armour selected = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Available gold Coins = " + player.getCoins());
        System.out.println("Select an Armour:");
        System.out.println("1. " + e1.getName() + " (" + e1.getPrice() + " gc)");
        System.out.println("2. " + e2.getName() + " (" + e2.getPrice() + " gc)");
        System.out.println("3. " + e3.getName() + " (" + e3.getPrice() + " gc)");
        System.out.println("4. " + "Cancel Buying");

        try{
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    selected = e1;
                    break;
                case 2:
                    selected = e2;
                    break;
                case 3:
                    selected = e3;
                    break;
                case 4:
                    selected = null;
                    break;
                default:
                    System.out.println("Invalid choice");
                    return selectArmour(player, e1, e2, e3);
            }
        }catch(InputMismatchException e){
            System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
            sc.nextLine();
            selectArmour(player, e1, e2, e3);
        }

        if (selected != null && player.getCoins() < selected.getPrice()) {
            System.out.println("Insufficient balance to buy " + selected.getName() + ". Please select another Armour.");
            selected = selectArmour(player, e1, e2, e3);
        }

        return selected;
    }


    static Artefact selectArtefact(Player player, Artefact e1, Artefact e2, Artefact e3) {
        Artefact selected = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Available gold Coins = " + player.getCoins());
        System.out.println("Select an Artefact:");
        System.out.println("1. " + e1.getName() + " (" + e1.getPrice() + " gc)");
        System.out.println("2. " + e2.getName() + " (" + e2.getPrice() + " gc)");
        System.out.println("3. " + e3.getName() + " (" + e3.getPrice() + " gc)");
        System.out.println("4. " + "Cancel Buying");

        try{
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    selected = e1;
                    break;
                case 2:
                    selected = e2;
                    break;
                case 3:
                    selected = e3;
                    break;
                case 4:
                    selected = null;
                    break;
                default:
                    System.out.println("Invalid choice");
                    return selectArtefact(player, e1, e2, e3);
            }
        }catch(InputMismatchException e){
            System.out.println("\u001B[31m" + "Invalid choice. Please try again." + "\u001B[0m");
            sc.nextLine();
            selectArtefact(player, e1, e2, e3);
        }

        if (selected != null && player.getCoins() < selected.getPrice()) {
            System.out.println("Insufficient balance to buy " + selected.getName() + ". Please select another Artefact.");
            selected = selectArtefact(player, e1, e2, e3);
        }

        return selected;
    }



}
