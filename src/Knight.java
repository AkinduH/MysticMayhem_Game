import java.util.List;

class Knight extends Character  {
    Knight(String name, String category, int price, double attack, double defense, double health, double speed) {
        super(name, category, price, attack, defense, health, speed);
    }

    public Knight(Knight original) {
        super(original.getName(), original.getCategory(), original.getPrice(), original.getAttack(), original.getDefense(), original.getHealth(), original.getSpeed());

    }
    static Knight createSquire() {
        return new Knight("Squire", "Marshlander", 85, 8, 9, 7, 8);
    }

    static Knight createCavalier() {
        return new Knight("Cavalier", "Highlander", 110, 10, 12, 7, 10);
    }

    static Knight createTemplar() {
        return new Knight("Templar","Sunchildren", 155, 14, 16, 12, 12);
    }

    static Knight createZoro() {
        return new Knight("Zoro", "Highlander", 180, 17, 16, 13, 14);
    }

    static Knight createSwiftblade() {
        return new Knight("Swiftblade", "Marshlander", 250, 18, 20, 17, 13);
    }



    void Heal(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

    void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }
}