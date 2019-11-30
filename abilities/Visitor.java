package abilities;

import heros.Knight;
import heros.Pyromancer;
import heros.Rogue;
import heros.Wizard;

public interface Visitor {
    void visit(Knight hero, int level);
    void visit(Wizard hero, int level);
    void visit(Rogue hero, int level);
    void visit(Pyromancer hero, int level);
}

