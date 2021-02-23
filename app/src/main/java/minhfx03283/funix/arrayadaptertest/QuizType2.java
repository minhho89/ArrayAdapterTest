package minhfx03283.funix.arrayadaptertest;

import java.util.ArrayList;
import java.util.List;

public class QuizType2 extends Quiz {
    public QuizType2() {
    }

    public QuizType2(String mQuiz, List<Object> mCorrectAnswer) {
        super(mQuiz, mCorrectAnswer);
    }

    @Override
    boolean checkResult(ArrayList<String> userAnswer) {
        return super.checkResult(userAnswer);
    }


}
