package abilities;

import constants.Constants;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

public class Ignite implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.2;
        private static final float KNIGHT_BONUS = (float) 0.2;
        private static final float PYRO_BONUS = (float) -0.1;
        private static final float WIZARD_BONUS = (float) 0.05;
        private static final int LEVEL_BONUS = 20;

    }

    public final float addTerrainBonus(final Hero hero, final float dmg) {
        float damage = dmg;
        if (hero.getTerrain().equals("V")) {
            damage += Math.round(Constants.VOLCANIC_BONUS * damage);
        }
        return damage;
    }

    @Override
    public final  void visit(final Knight hero, final int level) {
        int hp;
        float dmg;
        int roundDmg;
        dmg = Math.round(Constants.IGNITE + Damage.KNIGHT_BONUS
                * Constants.IGNITE + Damage.LEVEL_BONUS * level);
        roundDmg = Math.round(Constants.IGNITE_ROUND
                + Damage.KNIGHT_BONUS * Constants.IGNITE_ROUND);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

    @Override
    public final  void visit(final Wizard hero, final int level) {
        int hp;
        float dmg;
        int d;
        dmg = Math.round(Constants.IGNITE
                + Damage.PYRO_BONUS * Constants.IGNITE
                + Damage.LEVEL_BONUS * level);
        d = Constants.IGNITE;
        dmg = addTerrainBonus(hero, dmg);
        d = Math.round(addTerrainBonus(hero, d));
        hp = hero.getHp() - Math.round(dmg);
        hero.sethp(hp);
        hero.setTakenDmg(d);
    }

    @Override
    public final  void visit(final Rogue hero, final int level) {
        int hp;
        float dmg;
        dmg = Math.round(Constants.IGNITE
                + Damage.ROGUE_BONUS * Constants.IGNITE
                + Damage.LEVEL_BONUS * level);
        dmg = Math.round(addTerrainBonus(hero, dmg));
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

    @Override
    public final  void visit(final Pyromancer hero, final int level) {
        int hp;
        float dmg;
        dmg = Math.round(Constants.IGNITE
                + Damage.PYRO_BONUS * Constants.IGNITE
                + Damage.LEVEL_BONUS * level);
        dmg = Math.round(addTerrainBonus(hero, dmg));
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }
}

