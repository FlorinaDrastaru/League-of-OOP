package abilities;

import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

/**
 * The interface is part of Double Dispatch implementation.
 * The classes that represent abilities implements this interface.
 * Every class that implements this interface has to overwrite method 'visit',
 * in which the ability is applied to a type of hero of a certain level.
 */
public interface Visitor {

    void visit(Knight hero, int level);
    void visit(Wizard hero, int level);
    void visit(Rogue hero, int level);
    void visit(Pyromancer hero, int level);
}

