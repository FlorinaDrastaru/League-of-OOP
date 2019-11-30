package heros;


import abilities.Visitor;

public interface Visitable {
    void accept(Visitor visitor, int level);
}

