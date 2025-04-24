import java.util.Scanner;
import java.util.List;

public class GameEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        Player player = new Player(name);

        String playAgain;
        do {
            EscapeRoom escapeRoom = new EscapeRoom(player);
            player.score = 0; // Reset score for each game

            System.out.println("\n🔒 You are locked in a mysterious room...");
            System.out.println("🗝️ To escape, solve 3 random puzzles from the Puzzle Bank!\n");

            List<Puzzle> puzzles = escapeRoom.getRandomPuzzles(3);
            int puzzleNum = 1;

            for (Puzzle puzzle : puzzles) {
                System.out.println("\n🧩 Puzzle " + puzzleNum++ + ": " + puzzle.description);
                System.out.println("You have 30 seconds!");

                TimerThread timer = new TimerThread();
                timer.start();

                System.out.print("> ");
                String answer = "";

                while (!timer.timeUp && sc.hasNextLine()) {
                    answer = sc.nextLine();
                    break;
                }

                if (timer.timeUp) {
                    System.out.println("❌ Time's up!");
                } else if (puzzle.checkAnswer(answer)) {
                    System.out.println("✅ Correct!");
                    player.incrementScore();
                } else {
                    System.out.println("❌ Wrong! The correct answer was: " + puzzle.correctAnswer);
                }
            }

            System.out.println("\n🎉 Game Over, " + player.name + "!");
            System.out.println("Your Score: " + player.score + "/" + puzzles.size());

            if (player.score == puzzles.size()) {
                System.out.println("🔓 Congratulations! You solved all puzzles and ESCAPED the room!");
            } else {
                System.out.println("🚪 You couldn’t solve all puzzles... You’re still trapped!");
            }

            System.out.print("\n🔁 Want to play another game? (yes/no): ");
            playAgain = sc.nextLine().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("\n👋 Thanks for playing, " + player.name + "! Goodbye!");
        sc.close();
    }
}
