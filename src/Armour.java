class Armour extends Equipment {
    Armour(String name, int price, double defenseBonus, double healthBonus, double attackBonus, double speedBonus) {
        super(name,price,defenseBonus,healthBonus,attackBonus,speedBonus);
    }

    static Armour createChainmail() {
        return new Armour("Chainmail", 70, 1, 0, 0, -1);
    }

    static Armour createRegalia() {
        return new Armour("Regalia", 105, 1, 0, 0, 0);
    }

    static Armour createFleece() {
        return new Armour("Fleece", 150, 2, 1, 0, -1);
    }

}