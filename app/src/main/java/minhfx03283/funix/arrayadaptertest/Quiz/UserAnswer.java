package minhfx03283.funix.arrayadaptertest.Quiz;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;

public class UserAnswer {
    private Quiz quiz;
    private Set<String> userAnswer;
    private boolean result;
    private long correctAnswer = 0;

    // For state persistent
    private static final String JSON_QUIZ = "quiz";
    private static final String JSON_USER_ANSWER = "userAnswer";
    private static final String JSON_RESULT = "result";
    private static final String JSON_CORRECT_ANSWER = "correctAnswer";

    public UserAnswer(JSONObject jo) throws JSONException {
        quiz = (Quiz)jo.get(JSON_QUIZ);
        userAnswer = (Set<String>)jo.get(JSON_USER_ANSWER);
        result = jo.getBoolean(JSON_RESULT);
        correctAnswer = jo.getLong(JSON_CORRECT_ANSWER);
    }

    public JSONObject convertoJSON() throws JSONException{
        JSONObject jo = new JSONObject();

        jo.put(JSON_QUIZ, quiz);
        jo.put(JSON_USER_ANSWER, userAnswer);
        jo.put(JSON_RESULT, result);
        jo.put(JSON_CORRECT_ANSWER, correctAnswer);

        return jo;
    }





    public UserAnswer() {

    }

    public UserAnswer(Quiz quiz) {
        this.quiz = quiz;
    }

    public long getCorrectAnswer() {
        return correctAnswer;
    }

    public static void setCorrectAnswer(long correctAnswer) {
        correctAnswer = correctAnswer;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
        if (result == true) correctAnswer++;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<String> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Set<String> userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "USER's ANSWER" + "\n" +
//                "quiz :" + quiz +
                "Answer: " + userAnswer + "\n" +
                "Result: " + result + "\n";
    }
}
