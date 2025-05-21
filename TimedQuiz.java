package quizsystem;

import java.util.List;
import java.util.Scanner;

public class TimedQuiz extends Quiz {

    private final int timeLimitSeconds;

    public TimedQuiz(List<Question> questions, int timeLimitSeconds) {
        super(questions);
        this.timeLimitSeconds = timeLimitSeconds;
    }

    @Override
    public void start() {
        Thread timerThread = new Thread(() -> {
            try {
                for (int i = timeLimitSeconds; i >= 0; i--) {
                    System.out.print("\r⏳ Time left: " + i + " seconds");
                    Thread.sleep(1000);
                }
                System.out.println("\n🛑 Time's up! Quiz ended.");
                System.exit(0); // Force end program
            } catch (InterruptedException e) {
                // Timer interrupted, quiz ended normally
            }
        });

        timerThread.start();

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

        timerThread.interrupt(); // Stop timer if quiz ended early
        System.out.println("\n✅ Final Score: " + score + " out of " + questions.size());
        sc.close();
    }
}
