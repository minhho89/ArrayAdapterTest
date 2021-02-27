package minhfx03283.funix.arrayadaptertest.Quiz;

import java.util.HashSet;
import java.util.Set;

public class QuizType2 extends Quiz {
    private Set<String> mCorrectAnswer;

    public QuizType2() {
    }


    @Override
    public Set<String> getCorrectAnswer() {
        return mCorrectAnswer;
    }

    @Override
    public void setCorrectAnswer(Set<String> mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
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

        return "QUIZ" + "\n" +
                "id: " + super.getId() + "\n" +
                "mQuiz: " + super.getQuiz() + '\n' +
                "mCorrectAnswer: " + mCorrectAnswer + "\n";
    }
}
