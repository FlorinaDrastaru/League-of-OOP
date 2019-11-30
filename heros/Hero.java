package heros;



import abilities.Visitor;
import constants.Constants;

import java.util.LinkedList;

public class Hero implements Visitable {
    private int xp;
    private int level;
    private int hp;
    private int hpRise;
    private int row;
    private int col;
    private LinkedList<String> heroMoves;
    private int fullhp;
    private String terrain;
    private boolean mobility;
    private int applyIgn;
    private int takenDmg;
    private int givenDmg;

    Hero(final int hp, final int hpRise) {
        xp = 0;
        level = 0;
        heroMoves = new LinkedList<String>();
        this.hp = hp;
        this.hpRise = hpRise;
        this.fullhp = hp;
        mobility = true;
        applyIgn = 0;
        takenDmg = 0;
        givenDmg = 0;
    }


    public final void setTerrain(final String terrain) {
        this.terrain = terrain;
    }

    public final String getTerrain() {
        return terrain;
    }

    public final int getxp() {
        return xp;
    }

    public final void setxp(final int xpValue) {
        this.xp = xpValue;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final void updateLevel() {
        int xpLevelUp = Constants.BASE_XP + this.getLevel() * Constants.XP_MULTIPLIER;
        if (this.getxp() > xpLevelUp) {
            this.level++;
            this.sethp(this.getHp() + this.getHpRise());
        }
    }

    public final void setxp(final Hero hero) {
        int levelDif = this.getLevel() - hero.getLevel();
        xp = xp + Math.max(0, Constants.VALUE - levelDif * Constants.MULTIPLIER);
    }

    public final int getCol() {
        return col;
    }

    public final void setCol(final int col) {
        this.col = col;
    }

    public final int getRow() {
        return row;
    }

    public final void setRow(final int poz1) {
        this.row = row;
    }

    public final LinkedList<String> getHeroMoves() {
        return heroMoves;
    }

    public final void addMove(final String move) {
        heroMoves.add(move);
    }

    public final void moveOnMap(final String move) {
        if (move.equals("_")) {
            setCol(getCol());
            setRow(getRow());
        } else
        if (move.equals("U")) {
            setRow(getRow() - 1);
        } else
        if (move.equals("D")) {
            setRow(getRow() + 1);
        } else

        if (move.equals("L")) {
            setCol(getCol() - 1);
        } else

        if (move.equals("R")) {
            setCol(getCol() + 1);
        }

    }



    public final int getHpRise() {
        return hpRise;
    }

    public final void sethpRise(final int hpRiseValue) {
        this.hpRise = hpRiseValue;
    }


    public final int getHp() {
        return hp;
    }

    public final void sethp(final int hpValue) {
        this.hp = hpValue;
    }

    public final int getFullhp() {
        return fullhp;
    }

    public final void setFullhp(final int fullhp) {
        this.fullhp = fullhp;
    }

    public final boolean isMobility() {
        return mobility;
    }

    public final void setMobility(final boolean mobility) {
        this.mobility = mobility;
    }


    public final int getApplyIgn() {
        return applyIgn;
    }
    public final void setApplyIgn(final int i) {
        this.applyIgn = i;
    }
    public final void applyIgn() {
        applyIgn++;
    }

    public final int getTakenDmg() {
        return takenDmg;
    }
    public final void setTakenDmg(final int dmg) {
        this.takenDmg += dmg;
    }
    public final void setGivenDmg(final int givenDmg) {
        this.givenDmg += givenDmg;
    }

    public final int getGivenDmg() {
        return givenDmg;
    }


    @Override
    public void accept(final Visitor visitor, final int levelNr) {

    }
}

