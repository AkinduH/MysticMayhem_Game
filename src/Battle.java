import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Battle implements Serializable {
    private Player attacker_Copy;
    private Player defender_Copy;

    static Player attacker_T;
    static Player defender_T;

    int turn = 2;
    Character K1 = null;
    Character K2 = null;
    int A = 0;
    int D = 0;

    public Battle(Player attacker, Player defender) {
        this.attacker_T = attacker;
        this.defender_T = defender;
        this.attacker_Copy = new Player(attacker);
        this.defender_Copy = new Player(defender);
    }

    public void start() {
        System.out.println(attacker_Copy.getName() + " vs. " + defender_Copy.getName());

        List<Character> allCharacters = new ArrayList<>();
        allCharacters.addAll(attacker_Copy.getArmy());
        allCharacters.addAll(defender_Copy.getArmy());

        if (defender_Copy.getHomeGround().equals("Hillcrest")) {
            for (Character Ch : allCharacters) {
                if (Ch.getCategory().equals("Highlander")) {
                    Ch.setAttack(Ch.getAttack() + 1);
                    Ch.setDefense(Ch.getDefense() + 1);
                } else if (Ch.getCategory().equals("Marshlander") || Ch.getCategory().equals("Sunchildren")) {
                    Ch.setSpeed(Ch.getSpeed() - 1);
                }
            }
        } else if (defender_Copy.getHomeGround().equals("Marshland")) {
            for (Character Ch : allCharacters) {
                if (Ch.getCategory().equals("Marshlander")) {
                    Ch.setDefense(Ch.getDefense() + 2);
                } else if (Ch.getCategory().equals("Sunchildren")) {
                    Ch.setAttack(Ch.getAttack() - 1);
                } else if (Ch.getCategory().equals("Mystic")) {
                    Ch.setSpeed(Ch.getSpeed() - 1);
                }
            }
        } else if (defender_Copy.getHomeGround().equals("Desert")) {
            for (Character Ch : allCharacters) {
                if (Ch.getCategory().equals("Marshlander")) {
                    Ch.setHealth(Ch.getHealth() - 1);
                } else if (Ch.getCategory().equals("Sunchildren")) {
                    Ch.setAttack(Ch.getAttack() + 1);
                }
            }
        } else if (defender_Copy.getHomeGround().equals("Arcane")) {
            for (Character Ch : allCharacters) {
                if (Ch.getCategory().equals("Mystic")) {
                    Ch.setAttack(Ch.getAttack() + 2);
                } else if (Ch.getCategory().equals("Highlander") || Ch.getCategory().equals("Marshlander")) {
                    Ch.setSpeed(Ch.getSpeed() - 1);
                    Ch.setDefense(Ch.getDefense() - 1);
                }
            }
        }

        boolean attackerTurn = true;
        while (turn <= 21) {
            if (attackerTurn) {
                List<Character> defenseOrder1 = prepareArmy(defender_Copy);
                List<Character> attackOrder1 = prepareAttackers(attacker_Copy);
                if (A == attackOrder1.size()){
                    A = 0;
                }
                Character attacker_ch1 = attackOrder1.get(A);
                if (K1 != null){
                    if(attacker_ch1.equals(K1)){
                        A++;
                        if (A >= attackOrder1.size()){
                            A = 0;
                        }
                        attacker_ch1 = attackOrder1.get(A);
                    }
                }
                attackerTurn = attackTurn(attacker_Copy, defender_Copy,attacker_ch1, defenseOrder1, defender_Copy.getHomeGround(), attackerTurn);
                K1 = attacker_ch1;
                turn++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                if (defenseOrder1.isEmpty()) {
                    break;
                }
            } else {
                List<Character> defenseOrder2 = prepareArmy(attacker_Copy);
                List<Character> attackOrder2 = prepareAttackers(defender_Copy);
                if (D == attackOrder2.size()){
                    D = 0;
                }
                Character attacker_ch2 = attackOrder2.get(D);
                if (K2 != null){
                    if(attacker_ch2.equals(K2)){
                        D++;
                        if (D >= attackOrder2.size()){
                            D = 0;
                        }
                        attacker_ch2 = attackOrder2.get(D);
                    }
                }
                attackerTurn = attackTurn(defender_Copy, attacker_Copy,attacker_ch2, defenseOrder2, defender_Copy.getHomeGround(), attackerTurn);
                K2 = attacker_ch2;
                turn++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                if (defenseOrder2.isEmpty()) {
                    break;
                }
            }
        }
        checkBattleOutcome(attacker_Copy, defender_Copy);
    }

    private List<Character> prepareArmy(Player player) {
        List<Character> defenseOrder = new ArrayList<>();
        for (Character c : player.getArmy()) {
            if (c.getHealth() > 0) {
                defenseOrder.add(c);
            }
        }
        defenseOrder.sort(Comparator.comparingDouble(Character::getDefense).thenComparing(Comparator.comparingInt(c -> {
            if (c instanceof Healer) return 5;
            else if (c instanceof MythicalCreature) return 4;
            else if (c instanceof Archer) return 3;
            else if (c instanceof Knight) return 2;
            else return 1;
        })));
        return defenseOrder;
    }

    private List<Character> prepareAttackers(Player player) {
        List<Character> AttackOrder = new ArrayList<>();
        for (Character c : player.getArmy()) {
            if (c.getHealth() > 0) {
                AttackOrder.add(c);
            }
        }
        AttackOrder.sort(Comparator.comparingDouble(Character::getSpeed).reversed().thenComparing(Comparator.comparingInt(c -> {
            if (c instanceof Archer) return 1;
            else if (c instanceof Knight) return 2;
            else if (c instanceof MythicalCreature) return 3;
            else if (c instanceof Mage) return 4;
            else return 5;
        })));
        return AttackOrder;
    }




    private boolean attackTurn(Player attacker, Player defender,Character attacker_ch, List<Character> defenseOrder, String Home, boolean attackerTurn) {

        if (Home.equals("Arcane") && attacker_ch.getCategory().equals("Mystic")) {
            double health = attacker_ch.getHealth() * 1.1;
            attacker_ch.setHealth(Math.round(health * 10.0) / 10.0);
        }

        if (attacker_ch == null || defenseOrder.isEmpty()) {
            return !attackerTurn;
        }

        Character defender_ch = defenseOrder.get(0);

        if (attacker_ch instanceof Healer) {
            System.out.print("Turn " + turn/2 + " : ");
            System.out.println(attacker.getUsername());
            List<Character> Heal_to_attackers = prepareAttackers(attacker);
            attacker_ch.Heal(attacker,Heal_to_attackers);
            if (Home.equals("Hillcrest") && attacker_ch.getCategory().equals("Highlander")) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                attacker_ch.Hillcrest_Heal_bonus(attacker,Heal_to_attackers);
            }
        } else {
            System.out.print("Turn " + turn/2 + " : ");
            System.out.println(attacker.getUsername());
            attacker_ch.attack(defender_ch, attacker, defender);
            if (defender_ch.getHealth() <= 0) {
                defenseOrder.remove(defender_ch);
                if (defenseOrder.isEmpty()) {
                    return !attackerTurn;
                }
            }

            if (Home.equals("Hillcrest") && attacker_ch.getCategory().equals("Highlander")) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                Character defender_ch2 = defenseOrder.get(0);
                attacker_ch.Hillcrest_attack_bonus(defender_ch2, attacker, defender);
            }
        }
        return !attackerTurn;
    }

    static void checkBattleOutcome(Player attacker, Player defender) {
        boolean attackerAlive = false, defenderAlive = false;
        for (Character c : attacker.getArmy()) {
            if (c.getHealth() > 0) {
                attackerAlive = true;
                break;
            }
        }
        for (Character c : defender.getArmy()) {
            if (c.getHealth() > 0) {
                defenderAlive = true;
                break;
            }
        }
        System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
        System.out.println("Final result");
        System.out.println();
        if (attackerAlive && !defenderAlive) {
            System.out.println(attacker.getName() + " won!");
            attacker_T.setXp(attacker_T.getXp() + 1);
            attacker_T.setCoins(attacker_T.getCoins() + (int) Math.round(0.1 * defender_T.getCoins()));
            defender_T.setCoins(defender_T.getCoins() - (int) Math.round(0.1 * defender_T.getCoins()));
        } else if (!attackerAlive && defenderAlive) {
            System.out.println(defender.getName() + " won!");
            defender_T.setXp(defender_T.getXp() + 1);
            defender_T.setCoins(defender_T.getCoins() + (int) Math.round(0.1 * attacker_T.getCoins()));
            attacker_T.setCoins(attacker_T.getCoins() - (int) Math.round(0.1 * attacker_T.getCoins()));
        } else {
            System.out.println("Draw");
        }
        System.out.println("\u001B[33m" + "---------------------------------------------------------" + "\u001B[0m");
        System.out.println(attacker_T.getName() + " XP: " + attacker_T.getXp() + " gold coins: " + attacker_T.getCoins());
        System.out.println(defender_T.getName() + " XP: " + defender_T.getXp() + " gold coins: " + defender_T.getCoins());
    }
}