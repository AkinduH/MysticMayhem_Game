import java.util.List;

class MythicalCreature extends Character {
    MythicalCreature(String name, String category, int price, double attack, double defense, double health, double speed) {
        super(name, category, price, attack, defense, health, speed);
    }

    public MythicalCreature(MythicalCreature original) {
        super(original.getName(), original.getCategory(), original.getPrice(), original.getAttack(), original.getDefense(), original.getHealth(), original.getSpeed());
    }

    static MythicalCreature createDragon() {
        return new MythicalCreature("Dragon","Sunchildren", 120, 12, 14, 15, 8);
    }

    static MythicalCreature createBasilisk() {
        return new MythicalCreature("Basilisk", "Marshlander", 165, 15, 11, 10, 12);
    }

    static MythicalCreature createHydra() {
        return new MythicalCreature("Hydra", "Marshlander", 205, 12, 16, 15, 11);
    }

    static MythicalCreature createPhoenix() {
        return new MythicalCreature("Phoenix","Sunchildren", 275, 17, 13, 17, 19);
    }

    static MythicalCreature createPegasus() {
        return new MythicalCreature("Pegasus","Mystic", 340, 14, 18, 20, 20);
    }


    void Heal(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

    void Hillcrest_Heal_bonus(Player attacker,List<Character> attackOrder){
        System.out.println(("Can't Heal"));
    }

}