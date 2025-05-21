package quizsystem;

public class Question {
    private final String text;
    private final String[] options;
    private final int correctOption;

    public Question(String text, String[] options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctOption;
    }
}
