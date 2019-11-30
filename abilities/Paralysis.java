package abilities;

import constants.Constants;
import game.Game;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;


/**
 * The class implements method 'visit' so it can be applied to all heros.
 * Every 'visit' method modifies the hp of the type of hero received as
 * parameter, by applying the damages specific to Paralysis ability and
 * the modifiers specific to every hero.
 */
public class Paralysis implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.1;
        private static final float KNIGHT_BONUS = (float) -0.2;
        private static final float PYRO_BONUS = (float) 0.2;
        private static final float WIZARD_BONUS = (float) 0.25;
        private static final int LEVEL_BONUS = 40;
    }

    /**
     * The method calculates the new damage, after adding the terrain bonus.
     * @param hero The hero that gives the damage
     * @param dmg The initial damage
     * @return The modified damage
     */
    public final int addTerrainBonus(final Hero hero, final int dmg) {
        int damage = dmg;
        if (hero.getTerrain().equals("W")) {
            damage += Math.round(Constants.WOODS_BONUS * damage);
        }
        return damage;
    }

    /**
     * @param hero The Knight hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final  void visit(final Knight hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.KNIGHT_BONUS * Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    /**
     * @param hero The Wizard hero that receives the damage
     * @param level The level of the Knight hero
     */
    @Override
    public final  void visit(final Wizard hero, final int level) {
        int dmg;
        int hp;
        int d;
        d = Math.round(Constants.ROUND_DMG_ROGUE);
        dmg = Math.round(Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.WIZARD_BONUS * Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        d = addTerrainBonus(hero, d);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
        hero.setTakenDmg(d);
    }


    /**
     * @param hero The Rogue hero that receives the damage
     * @param level The level of the Rogue hero
     */
    @Override
    public final  void visit(final Rogue hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.ROGUE_BONUS * Constants.ROUND_DMG_ROGUE * Game.getRound()
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    /**
     * @param hero The Pyromancer hero that receives the damage
     * @param level The level of the Pyromancer hero
     */
    @Override
    public final  void visit(final Pyromancer hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.ROUND_DMG_ROGUE + Damage.PYRO_BONUS * Constants.ROUND_DMG_ROGUE
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - Math.round(dmg);
        hero.sethp(hp);
    }

}

