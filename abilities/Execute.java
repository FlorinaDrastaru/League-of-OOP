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
 * parameter, by applying the damages specific to Execute ability and
 * the modifiers specific to every hero.
 */
public class Execute implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) 0.15;
        private static final float PYRO_BONUS = (float) 0.1;
        private static final float WIZARD_BONUS = (float) -0.2;
        private static final float LIMIT = (float) 0.2;
        private static final int LEVEL_BONUS = 30;
    }

    /**
     * The method calculates the new damage, after adding the terrain bonus.
     * @param hero The hero that gives the damage
     * @param dmg The initial damage
     * @return The modified damage
     */
    public final int addTerrainBonus(final Hero hero, final int dmg) {
        int damage = dmg;
        if (hero.getTerrain().equals("L")) {
            damage += Math.round(Constants.LAND_BONUS * damage);
        }
        return damage;
    }

    /**
     * @param hero The Knight hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final  void visit(final Knight hero, final int level) {
        int hp;
        int dmg;
        float hpLimit = hero.getFullhp() * Damage.LIMIT;
        if (hero.getHp() < hpLimit) {
            hp = 0;
        } else {
            dmg = Constants.EXECUTE + Damage.LEVEL_BONUS * level;
            dmg = addTerrainBonus(hero, dmg);
            hp = hero.getHp() - dmg;
        }
        hero.sethp(hp);
    }

    /**
     * @param hero The Wizard hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final  void visit(final Wizard hero, final int level) {
        int hp;
        int dmg = 0;
        int d = 0;
        float hpLimit = hero.getFullhp() * Damage.LIMIT;
        if (hero.getHp() < hpLimit) {
            hp = 0;
        } else {
            dmg = Math.round(Constants.EXECUTE + Damage.WIZARD_BONUS * Constants.EXECUTE
                            + Damage.LEVEL_BONUS * level);
            d = Constants.EXECUTE;
            dmg = addTerrainBonus(hero, dmg);
            d = addTerrainBonus(hero, d);
            hp = hero.getHp() - dmg;
        }
        hero.sethp(hp);
        hero.setTakenDmg(d);
    }
    /**
     * @param hero The Rogue hero that receives the damage
     * @param level The level of the Rogue hero
     */
    @Override
    public final void visit(final Rogue hero, final int level) {
        int hp;
        int dmg;
        float hpLimit = hero.getFullhp() * Damage.LIMIT;
        if (hero.getHp() < hpLimit) {
            hp = 0;
        } else {
            dmg = Math.round(Constants.EXECUTE + Damage.ROGUE_BONUS * Constants.EXECUTE
                            + Damage.LEVEL_BONUS * level);
            dmg = addTerrainBonus(hero, dmg);
            hp = hero.getHp() - dmg;
        }
        hero.sethp(hp);
    }
    /**
     * @param hero The Pyromancer hero that receives the damage
     * @param level The level of the Pyromancer hero
     */
    @Override
    public final void visit(final Pyromancer hero, final int level) {
        int hp;
        int dmg;
        float hpLimit = hero.getFullhp() * Damage.LIMIT;
        if (hero.getHp() < hpLimit) {
            hp = 0;
        } else {
            dmg = Math.round(Constants.EXECUTE + Damage.PYRO_BONUS * Constants.EXECUTE
                            + Damage.LEVEL_BONUS * level);
            dmg = addTerrainBonus(hero, dmg);
            hp = hero.getHp() - dmg;
        }
        hero.sethp(hp);
    }
}

