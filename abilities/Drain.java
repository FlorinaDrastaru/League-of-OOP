package abilities;

import constants.Constants;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

/**
 * The class implements method 'visit' so it can be applied to all heros.
 * Every 'visit' method modifies the hp of the type of hero received as
 * parameter, by applying the damages specific to Drain ability and
 * the modifiers specific to every hero.
 */
public class Drain implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.2;
        private static final float KNIGHT_BONUS = (float) 0.2;
        private static final float PYRO_BONUS = (float) -0.1;
        private static final float WIZARD_BONUS = (float) 0.05;
        private static final float LEVEL_BONUS = (float) 0.05;
        private static final float VAL = (float) 0.3;

    }

    /**
     * The method calculates the basic hp of Wizard hero.
     * @param hero The hero whose base hp I calculate
     * @return The basic hp
     */

    public final int calcHpBase(final Hero hero) {
        int hpBase = Math.round(Math.min(Damage.VAL * hero.getFullhp(), hero.getHp()));
        return hpBase;
    }

    /**
     * @param hero The Knight hero that receives the damage
     * @param level The level of the Knight hero
     */

    @Override
    public final void visit(final Knight hero, final int level) {
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.KNIGHT_BONUS
                + Damage.LEVEL_BONUS * level;
        if (hero.getTerrain().equals("D")) {
            procent += procent * Constants.DESERT_BONUS;
        }
        dmg = Math.round(procent * calcHpBase(hero));
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    /**
     * @param hero The Wizard hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final void visit(final Wizard hero, final int level) {
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.WIZARD_BONUS
                + Damage.LEVEL_BONUS * level;
        dmg = Math.round(procent * calcHpBase(hero));
        if (hero.getTerrain().equals("D")) {
            dmg += Math.round(dmg * Constants.DESERT_BONUS);
        }
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }
    /**
     * @param hero The Rogue hero that receives the damage
     * @param level The level of the Rogue hero
     */
    @Override
    public final void visit(final Rogue hero, final int level) {
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.ROGUE_BONUS
                + Damage.LEVEL_BONUS * level;
        dmg = Math.round(procent * calcHpBase(hero));
        if (hero.getTerrain().equals("D")) {
            dmg += Math.round(dmg * Constants.DESERT_BONUS);
        }
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }
    /**
     * @param hero The Pyromancer hero that receives the damage
     * @param level The level of the Pyromancer hero
     */
    @Override
    public final void visit(final Pyromancer hero, final int level) {
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.PYRO_BONUS
                + Damage.LEVEL_BONUS * level;
        if (hero.getTerrain().equals("D")) {
            procent += procent * Constants.DESERT_BONUS;
        }
        dmg = Math.round(procent * calcHpBase(hero));
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }
}

