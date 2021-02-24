package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;

public class QuizType0 extends Quiz {
    private List<String> optionsList;
    public QuizType0() {
    }

    public QuizType0(String mQuiz, List<String> mCorrectAnswer, List<String> optionsList) {
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
