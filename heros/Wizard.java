package heros;


public final class Wizard extends Hero {

    public Wizard(final int hp, final int hpRise) {
        super(hp, hpRise);

    }

    public void accept(final Visitor visitor, final int level) {
        visitor.visit(this, level);
    }



}

