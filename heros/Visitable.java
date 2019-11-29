package heros;


public interface Visitable {
    void accept(Visitor visitor, int level);
}

