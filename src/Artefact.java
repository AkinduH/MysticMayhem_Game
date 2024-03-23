class Artefact extends Equipment {
    Artefact(String name, int price, double defenseBonus, double healthBonus, double attackBonus, double speedBonus) {
        super(name,price,defenseBonus,healthBonus,attackBonus,speedBonus);
    }

    static Artefact createExcalibur() {
        return new Artefact("Excalibur", 150, 0, 0, 2, 0);
    }

    static Artefact createAmulet() {
        return new Artefact("Amulet", 200, -1, 1, 1, 1);
    }

    static Artefact createCrystal() {
        return new Artefact("Crystal", 210, 1, -1, 2, -1);
    }
}