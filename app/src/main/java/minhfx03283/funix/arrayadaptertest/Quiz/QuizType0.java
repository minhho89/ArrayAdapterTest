package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.Set;

public class QuizType0 extends Quiz {
    private Set<String> optionsList;

    public QuizType0() {
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
