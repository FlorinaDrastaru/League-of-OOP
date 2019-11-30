package game;

import abilities.Backstab;
import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Paralysis;
import abilities.Slam;
import constants.Constants;
import heros.Hero;

/**
 * The class implements methods related to the game, to a fight
 * and to the features that a hero has after a fight.
 */
public final class Game {
    private Game() { }

    private static int round = 1;

    public static void setRound() {
        round++;
    }

    public static int getRound() {
        return round;
    }

    /**
     * The method calculates the damage after applying the critical hit.
     * @param dmg The initial damage
     * @return The new damage, after adding the critical bonus
     */
    public static float addCriticalBonus(final float dmg) {
        float damage = dmg;
        if (Game.getRound() == 1) {
            damage = Math.round(damage * Constants.CRITICAL_BONUS);
        }
        return damage;
    }

    /**
     * Method updates the xp, the level and restores the values
     * of the taken and given damage in a fight.
     * @param hero1 The first hero from a fight
     * @param hero2 The second hero from a fight
     */
    public static void updateHeroFeatures(final Hero hero1, final Hero hero2) {
        if (hero1.getHp() < 0) {
            hero2.setXp(hero1);
        }
        if (hero2.getHp() < 0) {
            hero1.setXp(hero2);
        }
        hero1.updateLevel();
        hero2.updateLevel();
        hero1.setTakenDmg(hero1.getTakenDmg() * (-1));
        hero2.setTakenDmg(hero2.getTakenDmg() * (-1));
        hero1.setGivenDmg(hero1.getGivenDmg() * (-1));
        hero2.setGivenDmg(hero2.getGivenDmg() * (-1));
    }

    /**
     * The method implements the fight.
     * Every player attack the other one with his abilities.
     * @param h1 The first hero from a fight
     * @param h2 The second hero from a fight
     */
    public static void fight(Hero h1, Hero h2) {
        // Wizard hero has to attack the second one in order to calculate
        // the damage for Deflect ability
        if (h1.getClass().getSimpleName().equals("Wizard")) {
            Hero h = h1;
            h1 = h2;
            h2 = h;
        }
        if (h1.getClass().getSimpleName().equals("Knight")) {
            Execute execute = new Execute();
            Slam slam = new Slam();
            h2.accept(execute, h2.getLevel());
            h2.accept(slam, h2.getLevel());
            // The damage that a hero takes is the damage that
            // the other one gives
            h1.setGivenDmg(h2.getTakenDmg());
        }

        if (h1.getClass().getSimpleName().equals("Wizard")) {
            Drain drain = new Drain();
            Deflect deflect = new Deflect();
            h2.accept(drain, h2.getLevel());
            if (!h2.getClass().getSimpleName().equals("Wizard")) {
                h2.accept(deflect, h2.getLevel());
            }
        }

        if (h1.getClass().getSimpleName().equals("Rogue")) {
            Backstab backstab = new Backstab();
            Paralysis paralysis = new Paralysis();
            h2.accept(backstab, h2.getLevel());
            h2.accept(paralysis, h2.getLevel());
            // The damage that a hero takes is the damage that
            // the other one gives
            h1.setGivenDmg(h2.getTakenDmg());
        }

        if (h1.getClass().getSimpleName().equals("Pyromancer")) {
            Fireblast fireblast = new Fireblast();
            Ignite ignite = new Ignite();
            h2.accept(fireblast, h2.getLevel());
            h2.accept(ignite, h2.getLevel());
            h1.applyIgn();
            if (h1.getApplyIgn() > Constants.ROUND) {
                h1.setApplyIgn(1);
            }
            // The damage that a hero takes is the damage that
            // the other one gives
            h1.setGivenDmg(h2.getTakenDmg());
        }

        if (h2.getClass().getSimpleName().equals("Knight")) {
            Execute execute = new Execute();
            Slam slam = new Slam();
            h1.accept(execute, h1.getLevel());
            h1.accept(slam, h1.getLevel());
        }

        if (h2.getClass().getSimpleName().equals("Pyromancer")) {
            Fireblast fireblast = new Fireblast();
            Ignite ignite = new Ignite();
            h1.accept(fireblast, h1.getLevel());
            h1.accept(ignite, h1.getLevel());
            h2.applyIgn();
            if (h2.getApplyIgn() > Constants.ROUND) {
                h2.setApplyIgn(1);
            }
        }

        if (h2.getClass().getSimpleName().equals("Wizard")) {
            Drain drain = new Drain();
            Deflect deflect = new Deflect();
            h1.accept(drain, h1.getLevel());
            if (!h1.getClass().getSimpleName().equals("Wizard")) {
                h1.accept(deflect, h1.getLevel());
            }
        }

        if (h2.getClass().getSimpleName().equals("Rogue")) {
            Backstab backstab = new Backstab();
            Paralysis paralysis = new Paralysis();
            h1.accept(backstab, h1.getLevel());
            h1.accept(paralysis, h1.getLevel());
        }
    }
}

