import java.util.*;

public class EscapeRoom {
    List<Puzzle> puzzleBank = new ArrayList<>();
    Player player;

    public EscapeRoom(Player player) {
        this.player = player;
        loadPuzzles();
    }

    public void loadPuzzles() {
        puzzleBank.add(new RiddlePuzzle("What has keys but can't open locks?", "keyboard"));
        puzzleBank.add(new RiddlePuzzle("What runs but never walks?", "water"));
        puzzleBank.add(new RiddlePuzzle("What has hands but can’t clap?", "clock"));

        puzzleBank.add(new MathPuzzle("What is 15 * 3?", "45"));
        puzzleBank.add(new MathPuzzle("What is 100 / 4?", "25"));

        puzzleBank.add(new WordScramblePuzzle("Unscramble: panaj", "japan"));
        puzzleBank.add(new WordScramblePuzzle("Unscramble: ekac", "cake"));
    }

    public List<Puzzle> getRandomPuzzles(int count) {
        Collections.shuffle(puzzleBank);
        return puzzleBank.subList(0, count);
    }

}
