import java.io.Serializable;
import java.util.List;

abstract class Character implements Serializable {
    private String name;
    private String category;
    private int price;
    private double attack, defense, health, speed;

    Character(String name, String category, int price, double attack, double defense, double health, double speed) {
        this.name = name;
        this.category= category;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }


    void attack(Character defender_, Player attacker, Player defender) {
        double damage = (0.5 * attack - 0.1 * defender_.getDefense());
        defender_.setHealth((Math.round((defender_.getHealth() - damage) * 10.0) / 10.0));
        System.out.println(name + " attacks " + defender_.getName());
        if (defender_.getHealth() <= 0) {
            System.out.println(defender_.getName() + "'s health: " + 0);
            System.out.println(name + "'s health: " + health);
            System.out.println("\u001B[31m" + defender_.getName() + " died!" + "\u001B[0m");
        }else{
            System.out.println(defender_.getName() + "'s health: " + defender_.getHealth());
            System.out.println(name + "'s health: " + health);
        }
    }

    void Hillcrest_attack_bonus(Character defender_, Player attacker, Player defender){
        double damage = (0.5 * 0.2 * attack - 0.1 * defender_.getDefense());
        defender_.setHealth((Math.round((defender_.getHealth() - damage) * 10.0) / 10.0));
        System.out.println("\u001B[33m" + "Bonus attack of  " + name + " to " + defender_.getName() + " in Hillcrest" + "\u001B[0m");
        if (defender_.health <= 0) {
            System.out.println(defender_.getName() + "'s health: " + 0);
            System.out.println(name + "'s health: " + health);
            System.out.println("\u001B[31m" + defender_.getName() + " died!" + "\u001B[0m");
        }else{
            System.out.println(defender_.getName() + "'s health: " + defender_.getHealth());
            System.out.println(name + "'s health: " + health);
        }
    }

    abstract void Heal(Player attacker,List<Character> attackOrder);

    abstract void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder);


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}


