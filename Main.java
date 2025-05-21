package quizsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of Germany?", new String[]{"Berlin", "Paris", "Madrid"}, 0));
        questions.add(new Question("2 * 3 = ?", new String[]{"5", "6", "7"}, 1));
        questions.add(new Question("Java runs on?", new String[]{"Compiler", "JVM", "Assembler"}, 1));

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose quiz type: 1) Simple  2) Timed");
        int choice = sc.nextInt();

        Quiz quiz;
        if (choice == 2) {
            quiz = new TimedQuiz(questions, 15);  // 15 seconds timer
        } else {
            quiz = new SimpleQuiz(questions);
        }

        quiz.start();

        Result<Integer> result = new Result<>(questions.size());
        System.out.println("📘 Total Questions: " + result.get());
        sc.close();
    }
}

// Result class remains same
class Result<T> {
    private final T value;

    public Result(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
