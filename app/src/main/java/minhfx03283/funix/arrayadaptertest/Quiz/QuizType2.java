package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuizType2 extends Quiz {
    private Set<String> mCorrectAnswer;

    @Override
    public Set<String> getCorrectAnswer() {
        return mCorrectAnswer;
    }

    @Override
    public void setCorrectAnswer(Set<String> mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public QuizType2() {
    }

    public QuizType2(long id) {
        super(id);
    }


    public QuizType2(String mQuiz) {
        super(mQuiz);
    }

    public QuizType2(String mQuiz, Set<String> mCorrectAnswer) {
        super(mQuiz, mCorrectAnswer);
    }

    @Override
    public boolean checkResult(Set<String> userAnswer) {
        Set<String> correctAnswerStr = new HashSet<>();
        for (Object o : this.mCorrectAnswer) {
            correctAnswerStr.add((String) o);
        }

        for (String s : this.mCorrectAnswer) {
            for (String o : userAnswer) {
                if (s.equalsIgnoreCase(o)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + super.getId() +
                ", mQuiz='" + super.getQuiz() + '\'' +
                ", mCorrectAnswer=" + mCorrectAnswer;
    }
}
