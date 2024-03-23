import java.util.List;

class Archer extends Character{
    Archer(String name, String category, int price, double attack, double defense, double health, double speed) {
        super(name, category, price, attack, defense, health, speed);
    }

    public Archer(Archer original) {
        super(original.getName(), original.getCategory(), original.getPrice(), original.getAttack(), original.getDefense(), original.getHealth(), original.getSpeed());
    }

    static Archer createShooter() {
        return new Archer("Shooter", "Highlander", 80, 11, 4, 6, 9);
    }

    static Archer createRanger() {
        return new Archer("Ranger", "Highlander", 115, 14, 5, 8, 10);
    }

    static Archer createSunfire() {
        return new Archer("Sunfire", "Sunchildren", 160, 15, 5, 7, 14);
    }

    static Archer createZing() {
        return new Archer("Zing","Sunchildren", 200, 16, 9, 11, 14);
    }

    static Archer createSaggitarius() {
        return new Archer("Saggitarius","Mystic", 230, 18, 7, 12, 17);
    }


    void Heal(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

    void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }
}