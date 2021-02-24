package minhfx03283.funix.arrayadaptertest.Quiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Quiz {
    private static long count = 0;
    private long id;
    private String mQuiz;
    private Set<String> mCorrectAnswer;
    private Set<String> mUserAnswer;

    public Quiz() {
        this.id = ++count;
    }


    public Quiz(String mQuiz, Set<String> mCorrectAnswer) {
        this.mQuiz = mQuiz;
        this.mCorrectAnswer = mCorrectAnswer;
        id = ++count;
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

    public Set<String> getUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(Set<String> mUserAnswer) {
        this.mUserAnswer = mUserAnswer;
    }

    public Set<String> addUserAnswer(String answer) {
        this.mUserAnswer.add(answer);
        return mUserAnswer;
    }

    public Set<String> removeUserAnswer(String answer) {
        if(this.mUserAnswer.contains(answer)){
            this.mUserAnswer.remove(answer);
        }
        return mUserAnswer;
    }

    public boolean checkResult(Set<String> userAnswer) {
        Set<String> correctAnswerStr = new HashSet<>();
        for (Object o : mCorrectAnswer) {
            correctAnswerStr.add((String) o);
        }
        return correctAnswerStr.equals(userAnswer);
    }

}