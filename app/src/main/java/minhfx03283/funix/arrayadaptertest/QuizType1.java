package minhfx03283.funix.arrayadaptertest;

import java.util.List;

public class QuizType1 extends Quiz {
    private List<String> optionsList;
    public QuizType1() {
    }

    public QuizType1(String mQuiz, List<String> mCorrectAnswer, List<String> optionsList) {
        super(mQuiz, mCorrectAnswer);
        this.optionsList = optionsList;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    boolean checkResult(List<String> userAnswer) {
        return super.checkResult(userAnswer);
    }
}