package quizsystem;

import java.util.List;

public abstract class Quiz {
    protected final List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public abstract void start();
}
