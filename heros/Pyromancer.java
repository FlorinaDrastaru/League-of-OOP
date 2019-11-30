package heros;


import abilities.Visitor;

/**
 * The class implements the Pyromancer hero, which extends the Class Hero.
 */
public final class Pyromancer extends Hero {

    public Pyromancer(final int hp, final int hpRise) {
        super(hp, hpRise);
    }

    /**
     * The method is part of the Double Dispatch concept.
     * The Pyromancer hero accepts to be visited by an ability that
     * implements the Visitor interface
     * @param visitor The ability that is applied on the Pyromancer hero
     * @param level The level of the visited hero
     */
    public void accept(final Visitor visitor, final int level) {
        visitor.visit(this, level);
    }
}

