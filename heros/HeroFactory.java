package heros;

public abstract class HeroFactory {

    private static class Hp {
        private static final int PYRO_START = 500;
        private static final int KNIGHT_START = 900;
        private static final int ROGUE_START = 600;
        private static final int WIZARD_START = 400;
        private static final int PYRO_RISE = 50;
        private static final int KNIGHT_RISE = 80;
        private static final int ROGUE_RISE = 40;
        private static final int WIZARD_RISE = 30;
    }
    public static Hero getHero(final String heroName) {
        switch (heroName) {
            case "K":
                return new Knight(Hp.KNIGHT_START, Hp.KNIGHT_RISE);

            case "P":
                return new Pyromancer(Hp.PYRO_START, Hp.PYRO_RISE);

            case "R":
                return new Rogue(Hp.ROGUE_START, Hp.ROGUE_RISE);

            case "W":
                return new Wizard(Hp.WIZARD_START, Hp.WIZARD_RISE);

            default:
                return null;
        }
    }
}

