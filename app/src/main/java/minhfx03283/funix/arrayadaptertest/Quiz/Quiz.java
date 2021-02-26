package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.HashSet;
import java.util.Set;

public abstract class Quiz {
    private static long count = 0;
    private long id;
    private String mQuiz;
    private Set<String> mCorrectAnswer;

    public Quiz() {
        this.id = ++count;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "QUIZ" + "\n" +
                "id: " + id + "\n" +
                "mQuiz: " + mQuiz + '\n' +
                "mCorrectAnswer= " + mCorrectAnswer + "\n";
    }

    public boolean checkResult(Set<String> userAnswer) {
        Set<String> correctAnswerStr = new HashSet<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add((String) o);
        }
        return correctAnswerStr.equals(userAnswer);
    }

}