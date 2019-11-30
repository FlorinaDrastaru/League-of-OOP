package heros;

import abilities.Visitor;

/**
 * This interface is part of Double Dispatch implementation.
 * The classes that represent types of hero implements this interface.
 */
public interface Visitable {
    /**
     * Every class that implements Visitable interface has to overwrite this method.
     * @param visitor The ability that is applied on a hero
     * @param level The level of the attacked hero
     */
    void accept(Visitor visitor, int level);
}

