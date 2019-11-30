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
 * parameter, by applying the damages specific to Fireblast ability and
 * the modifiers specific to every hero.
 */
public class Fireblast implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.2;
        private static final float KNIGHT_BONUS = (float) 0.2;
        private static final float PYRO_BONUS = (float) -0.1;
        private static final float WIZARD_BONUS = (float) 0.05;
        private static final int LEVEL_BONUS = 50;

    }

    /**
     * The method calculates the new damage, after adding the terrain bonus.
     * @param hero The hero that gives the damage
     * @param dmg The initial damage
     * @return The modified damage
     */
    public final float addTerrainBonus(final Hero hero, final float dmg) {
        float damage = dmg;
        if (hero.getTerrain().equals("V")) {
            damage += Math.round(Constants.VOLCANIC_BONUS * damage);
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
        dmg = Math.round(Constants.FIREBLAST + Damage.KNIGHT_BONUS * Constants.FIREBLAST);
        dmg = Math.round(addTerrainBonus(hero, dmg));
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    /**
     * @param hero The Wizard hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final  void visit(final Wizard hero, final int level) {
        int hp;
        float dmg;
        int d;
        dmg = Math.round(Constants.FIREBLAST + Damage.WIZARD_BONUS * Constants.FIREBLAST);
        d = Constants.FIREBLAST;
        dmg = addTerrainBonus(hero, dmg);
        d = Math.round(addTerrainBonus(hero, d));
        hp = hero.getHp() - Math.round(dmg);
        hero.sethp(hp);
        hero.setTakenDmg(Math.round(d));
    }
    /**
     * @param hero The Rogue hero that receives the damage
     * @param level The level of the Rogue hero
     */
    @Override
    public final  void visit(final Rogue hero, final int level) {
        int hp;
        int dmg;
        dmg = Math.round(Constants.FIREBLAST + Damage.ROGUE_BONUS * Constants.FIREBLAST);
        dmg = Math.round(addTerrainBonus(hero, dmg));
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    /**
     * @param hero The Pyromancer hero that receives the damage
     * @param level The level of the Pyromancer hero
     */
    @Override
    public final  void visit(final Pyromancer hero, final int level) {
        int hp;
        int dmg;
        dmg = Math.round(Constants.FIREBLAST + Damage.PYRO_BONUS * Constants.FIREBLAST);
        dmg = Math.round(addTerrainBonus(hero, dmg));
        hp = hero.getHp() - dmg;
        hero.sethp(hp);

    }
}
