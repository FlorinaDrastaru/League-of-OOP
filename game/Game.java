package game;

import abilities.Deflect;
import abilities.Drain;
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
    }
}