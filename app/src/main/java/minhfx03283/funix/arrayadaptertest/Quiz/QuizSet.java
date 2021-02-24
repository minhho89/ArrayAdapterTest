package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;

public class QuizSet {
    private List<Quiz> mQuizList;

    public QuizSet() {
    }

    public QuizSet(List<Quiz> mQuizList) {
        this.mQuizList = mQuizList;
    }

    public List<Quiz> getQuizList() {
        return mQuizList;
    }

    public void setQuizList(List<Quiz> mQuizList) {
        this.mQuizList = mQuizList;
    }
}
