package minhfx03283.funix.arrayadaptertest.Quiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Quiz {
    private String mQuiz;
    private List<String> mCorrectAnswer;

    public Quiz() {
    }

    public Quiz(String mQuiz, List<String> mCorrectAnswer) {
        this.mQuiz = mQuiz;
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public String getQuiz() {
        return mQuiz;
    }

    public void setQuiz(String mQuiz) {
        this.mQuiz = mQuiz;
    }

    public List<String> getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(List<String> mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }


    boolean checkResult(List<String> userAnswer) {
        List<String> correctAnswerStr = new ArrayList<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add((String) o);
        }
        Collections.sort(correctAnswerStr);
        Collections.sort(userAnswer);
        return correctAnswerStr.equals(userAnswer);
    }

}