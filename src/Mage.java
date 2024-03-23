import java.util.List;

class Mage extends Character {
    Mage(String name, String category, int price, double attack, double defense, double health, double speed) {
        super(name, category, price, attack, defense, health, speed);
    }

    public Mage(Mage original) {
        super(original.getName(), original.getCategory(), original.getPrice(), original.getAttack(), original.getDefense(), original.getHealth(), original.getSpeed());
    }

    static Mage createWarlock() {
        return new Mage("Warlock", "Marshlander", 100, 12, 7, 10, 12);
    }

    static Mage createIllusionist() {
        return new Mage("Illusionist","Mystic", 120, 13, 8, 12, 14);
    }

    static Mage createEnchanter() {
        return new Mage("Enchanter", "Highlander", 160, 16, 10, 13, 16);
    }

    static Mage createConjurer() {
        return new Mage("Conjurer", "Highlander", 195, 18, 15, 14, 12);
    }

    static Mage createEldritch() {
        return new Mage("Eldritch","Mystic", 270, 19, 17, 18, 14);
    }




    void Heal(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

    void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

}