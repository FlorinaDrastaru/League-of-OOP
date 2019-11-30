package abilities;

import constants.Constants;
import game.Game;
import heros.Hero;
import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

public class Paralysis implements Visitor {
    private static class Damage {
        private static final float ROGUE_BONUS = (float) -0.1;
        private static final float KNIGHT_BONUS = (float) -0.2;
        private static final float PYRO_BONUS = (float) 0.2;
        private static final float WIZARD_BONUS = (float) 0.25;
        private static final int LEVEL_BONUS = 40;
    }
    public final int addTerrainBonus(final Hero hero, final int dmg) {
        int damage = dmg;
        if (hero.getTerrain().equals("W")) {
            damage += Math.round(Constants.WOODS_BONUS * damage);
        }
        return damage;
    }

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

