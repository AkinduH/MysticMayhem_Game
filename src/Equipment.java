import java.io.Serializable;

abstract class Equipment implements Serializable {
    private String name;
    private int price;
    private double defenseBonus, healthBonus, attackBonus, speedBonus;

    Equipment(String name, int price, double defenseBonus, double healthBonus, double attackBonus, double speedBonus) {
        this.name = name;
        this.price = price;
        this.defenseBonus = defenseBonus;
        this.healthBonus = healthBonus;
        this.attackBonus = attackBonus;
        this.speedBonus = speedBonus;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getAttackBonus() {
        return attackBonus;
    }

    public double getDefenseBonus() {
        return defenseBonus;
    }

    public double getHealthBonus() {
        return healthBonus;
    }

    public double getSpeedBonus() {
        return speedBonus;
    }

}
