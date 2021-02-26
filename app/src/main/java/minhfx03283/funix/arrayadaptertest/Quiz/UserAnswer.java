package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;
import java.util.Set;

public class UserAnswer {
    private Quiz quiz;
    private Set<String> userAnswer;
    private boolean result;
    private long correctAnswer = 0;


    public UserAnswer() {

    }

    public UserAnswer(Quiz quiz) {
        this.quiz = quiz;
    }

    public long getCorrectAnswer() {
        return correctAnswer;
    }

    public static void setCorrectAnswer(long correctAnswer) {
        correctAnswer = correctAnswer;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
        if (result == true) correctAnswer++;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<String> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Set<String> userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "USER's ANSWER" + "\n" +
//                "quiz :" + quiz +
                "Answer: " + userAnswer + "\n" +
                "Result: " + result + "\n";
    }
}
