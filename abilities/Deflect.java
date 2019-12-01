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
 * parameter, by applying the damages specific to Deflect ability and
 * the modifiers specific to every hero.
 */

public class Deflect implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) 0.2;
        private static final float KNIGHT_BONUS = (float) 0.4;
        private static final float PYRO_BONUS = (float) 0.3;
        private static final float LEVEL_BONUS = (float) 0.02;
    }

    /**
     * The method calculates the new damage, after adding the terrain bonus.
     * @param hero The hero that gives the damage
     * @param dmg The initial damage
     * @return The modified damage
     */
    public final float addTerrainBonus(final Hero hero, final float dmg) {
        float damage = dmg;
        if (hero.getTerrain().equals("D")) {
            damage += Math.round(Constants.DESERT_BONUS * damage);
        }
        return damage;
    }

    /**
     * @param hero The Knight hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final void visit(final Knight hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.DEFLECT * hero.getGivenDmg() + Damage.LEVEL_BONUS * level);
        dmg += Math.round(dmg * Damage.KNIGHT_BONUS);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

    /**
     * The Wizard hero can't be attacked by another Wizard hero
     * with Deflect ability.
     */
    @Override
    public final void visit(final Wizard hero, final int level) {

    }

    /**
     * @param hero The Rogue hero that receives the damage
     * @param level The level of the Rogue hero
     */
    @Override
    public final void visit(final Rogue hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.DEFLECT * hero.getGivenDmg() + Damage.LEVEL_BONUS * level);
        dmg += Math.round(dmg * Damage.ROGUE_BONUS);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }
    /**
     * @param hero The Pyromancer hero that receives the damage
     * @param level The level of the Pyromancer hero
     */
    @Override
    public final void visit(final Pyromancer hero, final int level) {
        float dmg;
        int hp;
        dmg = Constants.DEFLECT + Constants.DEFLECT
                * Damage.PYRO_BONUS + Damage.LEVEL_BONUS * level;
        if (hero.getTerrain().equals("D")) {
            dmg += dmg * Constants.DESERT_BONUS;
        }
        dmg = dmg * hero.getGivenDmg();
        hp = hero.getHp() - Math.round(dmg);
        hero.sethp(hp);
    }
}

