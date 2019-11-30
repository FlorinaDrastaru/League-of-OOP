package main;

import fileio.FileSystem;

import java.util.LinkedList;

/**
 * The class implements methods that help at reading
 * from a file and storing the read elements.
 */
public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int nrRounds = 0;
        int nrPlayers = 0;
        int n = 0;
        int m = 0;
        LinkedList<String> race = new LinkedList<String>();
        LinkedList<Integer> pos1 = new LinkedList<Integer>();
        LinkedList<Integer> pos2 = new LinkedList<Integer>();
        LinkedList<String> moves = new LinkedList<String>();
        LinkedList<LinkedList<String>> map = new LinkedList<LinkedList<String>>();
        LinkedList<String> insideMap = new LinkedList<String>();
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            n = fs.nextInt();
            m = fs.nextInt();


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    insideMap.add(fs.nextWord());
                }
                map.add(insideMap);
            }

            nrPlayers = fs.nextInt();


            for (int i = 0; i < nrPlayers; i++) {
                race.add(fs.nextWord());
                pos1.add(fs.nextInt());
                pos2.add(fs.nextInt());
            }

            nrRounds = fs.nextInt();

            for (int i = 0; i < nrPlayers; i++) {
                String str = fs.nextWord();
                for (int j = 0; j < str.length(); j++) {
                    moves.add(str.substring(j, j + 1));
                }
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(nrRounds, nrPlayers, race, n,  m, map, pos1, pos2, moves);
    }
}
