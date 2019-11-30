package main;

import fileio.FileSystem;
import game.Game;
import heros.Hero;
import heros.HeroFactory;

import java.util.LinkedList;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        LinkedList<Hero> heros = new LinkedList<Hero>();
        LinkedList<String> heroNames = new LinkedList<String>(gameInput.getRace());
        for (String hero : heroNames) {
            heros.add(HeroFactory.getHero(hero));
        }

        for (int i = 0; i < heros.size(); i++) {
            int row = gameInput.getPos1().get(i);
            int col = gameInput.getPos2().get(i);
            heros.get(i).setRow(row);
            heros.get(i).setCol(col);
            heros.get(i).setTerrain(gameInput.getMap().get(row).get(col));
        }
        int nrMoves = gameInput.getRounds() * gameInput.getNrPlayers();

        for (int i = 0; i < nrMoves; i++) {
            Hero hero = heros.get(i % gameInput.getRounds());
            hero.addMove(gameInput.getMoves().get(i));
        }

        for (int i = 0; i < gameInput.getRounds(); i++) {
            for (Hero hero : heros) {
                hero.moveOnMap(hero.getHeroMoves().get(i));
            }
            for (Hero hero : heros) {
                if (hero.getHp() < 0) {
                    break;
                }
            }
            for (int j = 0; j < heros.size(); j++) {
                for (int k = j + 1; k < heros.size(); k++) {
                    Hero hero1 = heros.get(j);
                    Hero hero2 = heros.get(k);
                    if (hero1.getRow() == hero2.getRow()
                            && hero1.getCol() == hero2.getCol()
                            && hero1.getHp() > 0 && hero2.getHp() > 0) {
                        Game.fight(hero1, hero2);
                        if (hero1.getHp() < 0) {
                            hero2.setxp(hero1);
                        }
                        if (hero2.getHp() < 0) {
                            hero1.setxp(hero2);
                        }
                        hero1.updateLevel();
                        hero2.updateLevel();
                        hero1.setTakenDmg(hero1.getTakenDmg() * (-1));
                        hero2.setTakenDmg(hero2.getTakenDmg() * (-1));
                        hero1.setGivenDmg(hero1.getGivenDmg() * (-1));
                        hero2.setGivenDmg(hero2.getGivenDmg() * (-1));
                    }
                }
            }
            Game.setRound();
        }

        try {
            String mInputPath = args[0];
            String mOutputPath = args[1];
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (Hero hero:heros) {
                if (hero.getHp() > 0) {
                    fs.writeWord(String.valueOf(hero.getClass()
                            .getSimpleName().charAt(0))
                            + " " + hero.getLevel()
                            + " " + hero.getxp() + " " + hero.getHp()
                            + " " + hero.getRow() + " " + hero.getCol());
                } else {
                    fs.writeWord(String.valueOf(hero.getClass()
                            .getSimpleName().charAt(0)) + " " + "dead");
                }
                fs.writeWord("\n");
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}

