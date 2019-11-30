package main;

import java.util.LinkedList;

/**
 * The class contains all fields that are related to the game input.
 */
public class GameInput {
    private int n, m;
    private int nrRounds;
    private int nrPlayers;
    private LinkedList<String> race;
    private LinkedList<Integer> pos1;
    private LinkedList<Integer> pos2;
    private LinkedList<String> moves;
    private LinkedList<LinkedList<String>> map;

    public GameInput() {
        nrRounds = -1;
        nrPlayers = -1;
        race = null;
        n = -1;
        m = -1;
        map = null;
        pos1 = null;
        pos2 = null;
    }

    public GameInput(final int nrRounds, final int nrPlayers, final LinkedList<String> race,
                     final int n, final int m, final LinkedList<LinkedList<String>> map,
                     final LinkedList<Integer> pos1, final LinkedList<Integer> pos2,
                     final LinkedList<String> moves) {
        this.nrRounds = nrRounds;
        this.nrPlayers = nrPlayers;
        this.n = n;
        this.m = m;
        this.race = race;
        this.map = map;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.moves = moves;
    }

    public final int getRounds() {
        return nrRounds;
    }
    public final int getNrPlayers() {
        return nrPlayers;
    }
    public final int getFirstDimension() {
        return  n;
    }
    public final int getSecDimension() {
        return m;
    }

    public final LinkedList<String> getRace() {
        return race;
    }
    public final LinkedList<LinkedList<String>> getMap() {
        return map;
    }

    public final LinkedList<Integer> getPos2() {
        return pos2;
    }

    public final void setPos2(final LinkedList<Integer> pos2) {
        this.pos2 = pos2;
    }

    public final LinkedList<Integer> getPos1() {
        return pos1;
    }

    public final void setPos1(final LinkedList<Integer> pos1) {
        this.pos1 = pos1;
    }

    public final LinkedList<String> getMoves() {
        return moves;
    }

    public final void setMoves(final LinkedList<String> moves) {
        this.moves = moves;
    }


}
