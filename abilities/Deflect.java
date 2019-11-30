package abilities;

import constants.Constants;
import heros.*;


public class Deflect implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) 0.2;
        private static final float KNIGHT_BONUS = (float) 0.4;
        private static final float PYRO_BONUS = (float) 0.3;
        private static final float LEVEL_BONUS = (float) 0.02;
    }

    public final float addTerrainBonus(final Hero hero, final float dmg) {
        float damage = dmg;
        if (hero.getTerrain().equals("D")) {
            damage += Math.round(Constants.DESERT_BONUS * damage);
        }
        return damage;
    }

    @Override
    public final void visit(final Knight hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.DEFLECT * hero.getGivenDmg());
        dmg += Math.round(dmg * Damage.KNIGHT_BONUS);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

    @Override
    public final void visit(final Wizard hero, final int level) {

    }

    @Override
    public final void visit(final Rogue hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.DEFLECT * hero.getGivenDmg());
        dmg += Math.round(dmg * Damage.ROGUE_BONUS);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

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

