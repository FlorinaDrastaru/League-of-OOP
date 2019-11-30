package abilities;

import constants.Constants;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

public class Drain implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.2;
        private static final float KNIGHT_BONUS = (float) 0.2;
        private static final float PYRO_BONUS = (float) -0.1;
        private static final float WIZARD_BONUS = (float) 0.05;
        private static final float LEVEL_BONUS = (float) 0.05;
        private static final float VAL = (float) 0.3;

    }

    @Override
    public final void visit(final Knight hero, final int level) {
        int hpBase = (int) Math.round(Math.min(Damage.VAL * hero.getFullhp(), hero.getHp()));
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.KNIGHT_BONUS;
        if (hero.getTerrain().equals("D")) {
            procent += procent * Constants.DESERT_BONUS;
        }
        dmg = Math.round(procent * hpBase);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    @Override
    public final void visit(final Wizard hero, final int level) {
        int hpBase = (int) Math.round(Math.min(Damage.VAL * hero.getFullhp(), hero.getHp()));
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.WIZARD_BONUS;
        dmg = Math.round(procent * hpBase);
        if (hero.getTerrain().equals("D")) {
            dmg += Math.round(dmg * Constants.DESERT_BONUS);
        }
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    @Override
    public final void visit(final Rogue hero, final int level) {
        int hpBase = (int) Math.round(Math.min(Damage.VAL * hero.getFullhp(), hero.getHp()));
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.ROGUE_BONUS;
        dmg = Math.round(procent * hpBase);
        if (hero.getTerrain().equals("D")) {
            dmg += Math.round(dmg * Constants.DESERT_BONUS);
        }
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }

    @Override
    public final void visit(final Pyromancer hero, final int level) {
        int hpBase = (int) Math.round(Math.min(Damage.VAL * hero.getFullhp(), hero.getHp()));
        int dmg;
        int hp;
        float procent;
        procent = Constants.DRAIN + Constants.DRAIN * Damage.PYRO_BONUS;
        if (hero.getTerrain().equals("D")) {
            procent += procent * Constants.DESERT_BONUS;
        }
        dmg = Math.round(procent * hpBase);
        hp = hero.getHp() - dmg;
        hero.sethp(hp);
    }
}

