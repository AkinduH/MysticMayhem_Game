
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

class Player implements Serializable {
    private String name, username;
    private int userID, xp, coins;
    ArrayList<Character> army;

    Armour armour[] = new Armour[5];
    Artefact artefact[] = new Artefact[5];
    String homeGround;


    Player(String name, String username, int userID, int coins, String homeGround) {
        this.name = name;
        this.username = username;
        this.userID = userID;
        this.coins = coins;
        this.homeGround = homeGround;
        this.army = new ArrayList<Character>();
        xp = 0;
    }

    Player(Player original) {
        this.name = original.name;
        this.username = original.username;
        this.userID = original.userID;
        this.xp = original.xp;
        this.coins = original.coins;
        this.homeGround = original.homeGround;
        this.army = new ArrayList<>();
        for (Character c : original.army) {
            if (c instanceof Archer) {
                this.army.add(new Archer((Archer) c));
            } else if (c instanceof Knight) {
                this.army.add(new Knight((Knight) c));
            } else if (c instanceof Mage) {
                this.army.add(new Mage((Mage) c));
            } else if (c instanceof Healer) {
                this.army.add(new Healer((Healer) c));
            } else if (c instanceof MythicalCreature) {
                this.army.add(new MythicalCreature((MythicalCreature) c));
            }
        }
        this.armour = original.armour.clone();
        this.artefact = original.artefact.clone();
    }
    void createArmy(Character CH) {
        if (CH == null) {
            System.out.println("\u001B[33m" + "No Character taken" + "\u001B[0m");
        } else {
            if (CH instanceof Archer) {
                army.add(0, CH);
            } else if (CH instanceof Knight) {
                army.add(1, CH);
            } else if (CH instanceof Mage) {
                army.add(2, CH);
            } else if (CH instanceof Healer) {
                army.add(3, CH);
            } else if (CH instanceof MythicalCreature) {
                army.add(4, CH);
            }
            coins -= CH.getPrice();
        }

    }


    void buyArmour(int i, Armour armour) {
        if (armour == null) {
            System.out.println("\u001B[33m" + "Buying Cancelled" + "\u001B[0m");
        } else if (this.armour[i] == null){
            this.armour[i] = armour;
            army.get(i).setPrice(army.get(i).getPrice() + (int) Math.round(0.2 * armour.getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() + armour.getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() + armour.getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() + armour.getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() + armour.getSpeedBonus());
            coins -= (int) armour.getPrice();
        } else {
            army.get(i).setPrice(army.get(i).getPrice() - (int) Math.round(0.2 * this.armour[i].getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() - this.armour[i].getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() - this.armour[i].getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() - this.armour[i].getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() - this.armour[i].getSpeedBonus());
            coins += this.armour[i].getPrice();
            System.out.println("\u001B[31m" + "Previouse " + this.armour[i].getName() + " was sold." + "\u001B[0m");
            this.armour[i] = armour;
            army.get(i).setPrice(army.get(i).getPrice() + (int) Math.round(0.2 * armour.getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() + armour.getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() + armour.getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() + armour.getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() + armour.getSpeedBonus());
            coins -= armour.getPrice();
            System.out.println("\u001B[32m" + armour.getName() + " Buying was successfull" + "\u001B[0m");
        }
    }

    void buyArtefact(int i, Artefact artefact) {
        if (artefact == null) {
            System.out.println("\u001B[33m" + "Buying Cancelled" + "\u001B[0m");
        } else if (this.artefact[i] == null){
            this.artefact[i] = artefact;
            army.get(i).setPrice(army.get(i).getPrice() + (int) Math.round(0.2 * artefact.getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() + artefact.getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() + artefact.getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() + artefact.getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() + artefact.getSpeedBonus());
            coins -= artefact.getPrice();
        } else {
            army.get(i).setPrice(army.get(i).getPrice() - (int) Math.round(0.2 * this.artefact[i].getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() - this.artefact[i].getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() - this.artefact[i].getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() - this.artefact[i].getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() - this.artefact[i].getSpeedBonus());
            coins += this.artefact[i].getPrice();
            System.out.println("\u001B[31m" + "Previouse " + this.artefact[i].getName() + " was sold." + "\u001B[0m");
            this.artefact[i] = artefact;
            army.get(i).setPrice(army.get(i).getPrice() + (int) Math.round(0.2 * artefact.getPrice()));
            army.get(i).setDefense(army.get(i).getDefense() + artefact.getDefenseBonus());
            army.get(i).setHealth(army.get(i).getHealth() + artefact.getHealthBonus());
            army.get(i).setAttack(army.get(i).getAttack() + artefact.getAttackBonus());
            army.get(i).setSpeed(army.get(i).getSpeed() + artefact.getSpeedBonus());
            coins -= artefact.getPrice();
            System.out.println("\u001B[32m" + artefact.getName() + " Buying was successfull" + "\u001B[0m");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Character> getArmy() {
        return army;
    }

    public void setArmy(ArrayList<Character> army) {
        this.army = army;
    }

    public Armour[] getArmour() {
        return armour;
    }

    public void setArmour(Armour[] armour) {
        this.armour = armour;
    }

    public Artefact[] getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact[] artefact) {
        this.artefact = artefact;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }
}