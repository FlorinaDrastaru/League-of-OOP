package heros;

import abilities.Visitor;
import constants.Constants;
import java.util.LinkedList;

/**
 * The class contains all fields that are related to a hero and
 * implements the methods that he needs.
 */
public class Hero implements Visitable {
    private int xp;
    private int level;
    private int hp;
    private int hpRise;
    private int row;
    private int col;
    private LinkedList<String> heroMoves;
    private int fullhp;
    private Character terrain;
    private boolean mobility;
    private int applyIgn;
    private int takenDmg;
    private int givenDmg;

    /**
     * The fields used by a hero are initialised.
     */
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


    public final void setTerrain(final Character terrain) {
        this.terrain = terrain;
    }

    public final Character getTerrain() {
        return terrain;
    }

    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    /**
     * Method the level of the hero if his xp reaches a certain number, given by a formula.
     */
    public final void updateLevel() {
        int xpLevelUp = Constants.BASE_XP + this.getLevel() * Constants.XP_MULTIPLIER;
        if (this.getXp() > xpLevelUp) {
            this.level++;
            this.sethp(this.getHp() + this.getHpRise());
        }
    }

    public final void setXp(final Hero hero) {
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

    /**
     * Method modifies the position of the hero on map by changing
     * the number of the row or column.
     * @param move The move a hero has to make
     */
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

    public final int getHp() {
        return hp;
    }

    public final void sethp(final int hpValue) {
        this.hp = hpValue;
    }

    public final int getFullhp() {
        return fullhp;
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
    public void accept(final Visitor visitor, final int levelNr) { }
}

