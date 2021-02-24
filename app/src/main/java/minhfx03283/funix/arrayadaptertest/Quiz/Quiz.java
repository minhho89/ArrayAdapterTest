package minhfx03283.funix.arrayadaptertest.Quiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Quiz {
    private String mQuiz;
    private Set<String> mCorrectAnswer;

    public Quiz() {
    }

    public Quiz(String mQuiz, Set<String> mCorrectAnswer) {
        this.mQuiz = mQuiz;
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public String getQuiz() {
        return mQuiz;
    }

    public void setQuiz(String mQuiz) {
        this.mQuiz = mQuiz;
    }

    public Set<String> getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(Set<String> mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }


    public boolean checkResult(Set<String> userAnswer) {
        Set<String> correctAnswerStr = new HashSet<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add((String) o);
        }
        return correctAnswerStr.equals(userAnswer);
    }

}