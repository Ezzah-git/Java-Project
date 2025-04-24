public class Puzzle {
        String description;
        String correctAnswer;

        public Puzzle(String description, String correctAnswer) {
            this.description = description;
            this.correctAnswer = correctAnswer;

        }

        public boolean checkAnswer(String answer) {
            return correctAnswer.equalsIgnoreCase(answer.trim());
        }
    }

