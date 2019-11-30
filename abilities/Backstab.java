package abilities;

import constants.Constants;
import game.Game;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;


public class Backstab implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) 0.2;
        private static final float KNIGHT_BONUS = (float) -0.1;
        private static final float PYRO_BONUS = (float) 0.25;
        private static final float WIZARD_BONUS = (float) 0.25;
        private static final int LEVEL_BONUS = 20;


    }
    public final float addTerrainBonus(final Hero hero, final float dmg) {
        float damage = dmg;
        if (hero.getTerrain().equals("W")) {
            damage += Math.round(Constants.WOODS_BONUS * damage);
            damage = Game.addCriticalBonus(damage);

        }
        return damage;
    }
    @Override
    public final void visit(final Knight hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.BACKSTAB + Damage.KNIGHT_BONUS * Constants.BACKSTAB
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }


    @Override
    public final void visit(final Wizard hero, final int level) {
        float dmg;
        int hp;
        float d;
        dmg = Math.round(Constants.BACKSTAB + Damage.WIZARD_BONUS * Constants.BACKSTAB
                + Damage.LEVEL_BONUS * level);
        d = Math.round(Constants.BACKSTAB);
        dmg = addTerrainBonus(hero, dmg);
        d = addTerrainBonus(hero, d);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
        hero.setTakenDmg((int) d);
    }

    @Override
    public final void visit(final Rogue hero, final int level) {
        float dmg;
        int hp;
        dmg = Math.round(Constants.BACKSTAB + Damage.ROGUE_BONUS * Constants.BACKSTAB
                + Damage.LEVEL_BONUS * level);
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - (int) dmg;
        hero.sethp(hp);
    }

    @Override
    public final void visit(final Pyromancer hero, final int level) {
        float dmg;
        int hp;
        dmg = Constants.BACKSTAB + Damage.PYRO_BONUS * Constants.BACKSTAB
                + Damage.LEVEL_BONUS * level;
        dmg = addTerrainBonus(hero, dmg);
        hp = hero.getHp() - Math.round(dmg);
        hero.sethp(hp);
    }
}

