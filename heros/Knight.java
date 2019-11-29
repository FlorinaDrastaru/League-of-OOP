package heros;


import abilities.Visitor;

public final class Knight extends Hero {
    public Knight(final int hp, final int hpRise) {
        super(hp, hpRise);
    }
    public void accept(final Visitor visitor, final int level) {
        visitor.visit(this, level);
    }
}

