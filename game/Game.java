package game;

import abilities.*;
import constants.Constants;
import heros.Hero;

public final class Game {


    private Game() {
    }

    private static int round = 1;

    public static void setRound() {
        round++;
    }

    public static int getRound() {
        return round;
    }

    public static float addCriticalBonus(final float dmg) {
        float damage = dmg;
        if (Game.getRound() == 1) {
            damage = Math.round(damage * Constants.CRITICAL_BONUS);
        }
        return damage;
    }

    public static void fight(Hero h1, Hero h2) {
        if (h1.getClass().getSimpleName().equals("Wizard")) {
            Hero h = h1;
            h1 = h2;
            h2 = h;
        }

        if (h1.getClass().getSimpleName().equals("Wizard")) {
            Drain drain = new Drain();
            Deflect deflect = new Deflect();
            h2.accept(drain, h2.getLevel());
            if (!h2.getClass().getSimpleName().equals("Wizard")) {
                h2.accept(deflect, h2.getLevel());
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

        if (h1.getClass().getSimpleName().equals("Pyromancer")) {
            Fireblast fireblast = new Fireblast();
            Ignite ignite = new Ignite();
            h2.accept(fireblast, h2.getLevel());
            h2.accept(ignite, h2.getLevel());
            h1.applyIgn();
            if (h1.getApplyIgn() > Constants.ROUND) {
                h1.setApplyIgn(1);
            }
            h1.setGivenDmg(h2.getTakenDmg());
        }

        if (h1.getClass().getSimpleName().equals("Knight")) {
            Execute execute = new Execute();
            Slam slam = new Slam();
            h2.accept(execute, h2.getLevel());
            h2.accept(slam, h2.getLevel());
            h1.setGivenDmg(h2.getTakenDmg());
        }

        if (h2.getClass().getSimpleName().equals("Knight")) {
            Execute execute = new Execute();
            Slam slam = new Slam();
            h1.accept(execute, h1.getLevel());
            h1.accept(slam, h1.getLevel());
        }
    }
}