package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.List;

public class QuizType2 extends Quiz {
    public QuizType2() {
    }

    public QuizType2(String mQuiz, List<String> mCorrectAnswer) {
        super(mQuiz, mCorrectAnswer);
    }

    @Override
    boolean checkResult(List<String> userAnswer) {
        return super.checkResult(userAnswer);
    }


}
