package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;
import java.util.Set;

public class QuizType2 extends Quiz {
    public QuizType2() {
    }

    public QuizType2(long id) {
        super(id);
    }

    public QuizType2(String mQuiz, Set<String> mCorrectAnswer) {
        super(mQuiz, mCorrectAnswer);
    }

    @Override
    public boolean checkResult(Set<String> userAnswer) {
        return super.checkResult(userAnswer);
    }


}
