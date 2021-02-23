package minhfx03283.funix.arrayadaptertest;

import java.util.List;

public class QuizType0 extends Quiz {
    private List<String> optionsList;
    public QuizType0() {
    }

    public QuizType0(String mQuiz, List<Object> mCorrectAnswer, List<String> optionsList) {
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
    boolean checkResult(int userAnswer) {
        return super.checkResult(userAnswer);
    }
}
