package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;
import java.util.Set;

public class QuizType0 extends Quiz {
    private Set<String> optionsList;
    public QuizType0() {
    }

    public QuizType0(long id) {
        super(id);
    }

    public QuizType0(String mQuiz, Set<String> mCorrectAnswer, Set<String> optionsList) {
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

    @Override
    public Set<String> addUserAnswer(String answer) {
        return super.addUserAnswer(answer);
    }

    @Override
    public Set<String> removeUserAnswer(String answer) {
        return super.removeUserAnswer(answer);
    }
}
