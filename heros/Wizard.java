package heros;


import abilities.Visitor;

/**
 * The class implements the Wizard hero, which extends the Class Hero.
 */
public final class Wizard extends Hero {
    public Wizard(final int hp, final int hpRise) {
        super(hp, hpRise);
    }

    /**
     * The method is part of the Double Dispatch concept.
     * The Wizard hero accepts to be visited by an ability that
     * implements the Visitor interface
     * @param visitor The ability that is applied on the Wizard hero
     * @param level The level of the visited hero
     */
    public void accept(final Visitor visitor, final int level) {
        visitor.visit(this, level);
    }
}

