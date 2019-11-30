package abilities;

import constants.Constants;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

public class Slam implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.2;
        private static final float KNIGHT_BONUS = (float) 0.2;
        private static final float PYRO_BONUS = (float) -0.1;
        private static final float WIZARD_BONUS = (float) 0.05;
        private static final int LEVEL_BONUS = 40;
    }
    public final int addTerrainBonus(final Hero hero, final int dmg) {
        int damage = dmg;
        if (hero.getTerrain().equals("L")) {
            damage += Math.round(Constants.LAND_BONUS * damage);

        }
        return damage;
    }
    @Override
    public final  void visit(final Knight hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.SLAM + Damage.KNIGHT_BONUS
                * Constants.SLAM + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
        hero.setMobility(false);
    }

    @Override
    public final  void visit(final Wizard hero, final int level) {
        int dmg;
        int hp;
        int d;
        dmg = Math.round(Constants.SLAM + Damage.WIZARD_BONUS
                * Constants.SLAM + Damage.LEVEL_BONUS * level);
        d = Constants.SLAM;
        dmg = addTerrainBonus(hero, dmg);
        d = addTerrainBonus(hero, d);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
        hero.setMobility(false);
        hero.setTakenDmg(d);
    }

    @Override
    public final  void visit(final Rogue hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.SLAM + Damage.ROGUE_BONUS
                * Constants.SLAM + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
        hero.setMobility(false);
    }

    @Override
    public final  void visit(final Pyromancer hero, final int level) {
        int dmg;
        int hp;
        dmg = Math.round(Constants.SLAM + Damage.PYRO_BONUS
                * Constants.SLAM + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
        hero.setMobility(false);
    }
}
