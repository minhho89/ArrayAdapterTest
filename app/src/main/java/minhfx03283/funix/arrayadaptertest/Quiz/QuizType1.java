package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;
import java.util.Set;

public class QuizType1 extends Quiz {
    private Set<String> optionsList;
    public QuizType1() {
    }

    public QuizType1(String mQuiz, Set<String> mCorrectAnswer, Set<String> optionsList) {
        super(mQuiz, mCorrectAnswer);
        this.optionsList = optionsList;
    }

    public Set<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(Set<String> optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    public boolean checkResult(Set<String> userAnswer) {
        return super.checkResult(userAnswer);
    }
}