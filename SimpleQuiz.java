package quizsystem;

import java.util.List;
import java.util.Scanner;

public class SimpleQuiz extends Quiz {

    public SimpleQuiz(List<Question> questions) {
        super(questions);
    }

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ") " + options[j]);
            }

            try {
                System.out.print("Your answer: ");
                int choice = Integer.parseInt(sc.nextLine()) - 1;

                if (choice < 0 || choice >= options.length) {
                    throw new IllegalArgumentException("Invalid option selected.");
                }

                if (q.isCorrect(choice)) {
                    score++;
                }

            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }

        System.out.println("\n✅ Final Score: " + score + " out of " + questions.size());
        sc.close();
    }
}
