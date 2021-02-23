package minhfx03283.funix.arrayadaptertest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Quiz {
    private String mQuiz;
    private List<Object> mCorrectAnswer;

    public Quiz() {
    }

    public Quiz(String mQuiz, List<Object> mCorrectAnswer) {
        this.mQuiz = mQuiz;
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public String getQuiz() {
        return mQuiz;
    }

    public void setQuiz(String mQuiz) {
        this.mQuiz = mQuiz;
    }

    public List<Object> getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(List<Object> mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    // For QuizType 0
    boolean checkResult(int userAnswer) {
        String correctAnswer = (String) this.mCorrectAnswer.get(0);
        String userAnswerStr = String.valueOf(userAnswer);
        return correctAnswer.equals(userAnswerStr);
    }

    // For QuizType 1
    boolean checkResult(List<Integer> userAnswer) {
        List<Integer> correctAnswerStr = new ArrayList<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add(Integer.valueOf((String) o));
        }
        Collections.sort(correctAnswerStr);
        Collections.sort(userAnswer);
        return correctAnswerStr.equals(userAnswer);
    }

    // For QuizType 2
    boolean checkResult(ArrayList<String> userAnswer) {
        List<String> correctAnswerStr = new ArrayList<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add(String.valueOf(o));
        }
        Collections.sort(correctAnswerStr);
        Collections.sort(userAnswer);
        return correctAnswerStr.equals(userAnswer);
    }
}