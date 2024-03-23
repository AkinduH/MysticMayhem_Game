import java.util.List;

class Healer extends Character  {
    Healer(String name, String category, int price, double attack, double defense, double health, double speed) {
        super(name, category, price, attack, defense, health, speed);
    }

    public Healer(Healer original) {
        super(original.getName(), original.getCategory(), original.getPrice(), original.getAttack(), original.getDefense(), original.getHealth(), original.getSpeed());
    }

    static Healer createSoother() {
        return new Healer("Soother","Sunchildren", 95, 10, 8, 9, 6);
    }

    static Healer createMedic() {
        return new Healer("Medic", "Highlander", 125, 12, 9, 10, 7);
    }

    static Healer createAlchemist() {
        return new Healer("Alchemist", "Marshlander", 150, 13, 13, 13, 13);
    }

    static Healer createSaint() {
        return new Healer("Saint","Mystic", 200, 16, 14, 17, 9);
    }

    static Healer createLightbringer() {
        return new Healer("Lightbringer","Sunchildren", 260, 17, 15, 19, 12);
    }

    void Heal(Player attacker,List<Character> attackOrder) {
        Character lowestHealth = attackOrder.get(0);
        for (Character c : attackOrder) {
            if (c.getHealth() < lowestHealth.getHealth()) {
                lowestHealth = c;
            }
        }
        double healing = Math.round(0.1 * getAttack() * 10.0) / 10.0;
        lowestHealth.setHealth(Math.round((lowestHealth.getHealth() + healing) * 10.0) / 10.0);
        System.out.println(getName() + " heals " + lowestHealth.getName());
        System.out.println(lowestHealth.getName() + "'s health: " + lowestHealth.getHealth());

    }

    void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder){
        Character lowestHealth = attackOrder.get(0);
        for (Character c : attackOrder) {
            if (c.getHealth() < lowestHealth.getHealth()) {
                lowestHealth = c;
            }
        }
        double healing = Math.round(0.1 * 0.2 * getAttack() * 10.0) / 10.0;
        lowestHealth.setHealth(Math.round((lowestHealth.getHealth() + healing) * 10.0) / 10.0);
        System.out.println("\u001B[33m" + "Bonus heal of  " + getName() + " to " + lowestHealth.getName() + " in Hillcrest" + "\u001B[0m");
        System.out.println(lowestHealth.getName() + "'s health: " + lowestHealth.getHealth());
    }

    void attack(Character defender_, Player attacker, Player defender) {
        System.out.println(("Can't Attack"));
    }

    void Hillcrest_attack_bonus(Character defender1, Player attacker, Player defender){
        System.out.println(("Can't Attack"));
    }


}