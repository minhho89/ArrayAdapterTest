package minhfx03283.funix.arrayadaptertest;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.layout_list_view);

        List<Quiz> quizzes = addQuizzesInstance();
        QuizAdapter adapter = new QuizAdapter(this, quizzes);
        listView.setAdapter(adapter);

    }

    private List<Quiz> addQuizzesInstance() {
        List<Quiz> quizzes = new ArrayList<>();

        QuizType0 q1 = new QuizType0();
        q1.setQuiz("1. " + getResources().getString(R.string.q1));
        ArrayList<String> q1Options = new ArrayList<>();
        q1Options.add(getResources().getString(R.string.q1_1));
        q1Options.add(getResources().getString(R.string.q1_2));
        q1Options.add(getResources().getString(R.string.q1_3));
        q1.setOptionsList(q1Options);
        List<Object> q1Answer = new ArrayList<>();
        q1Answer.add(3);
        q1.setCorrectAnswer(q1Answer);

        QuizType2 q2 = new QuizType2();
        q2.setQuiz("2. " + getResources().getString(R.string.q2));
        ArrayList<Object> q2Answer = new ArrayList<>();
        q2Answer.add(getResources().getString(R.string.q2_ans));
        q2.setCorrectAnswer(q2Answer);

        QuizType1 q3 = new QuizType1();
        q3.setQuiz("3. " + getResources().getString(R.string.q3));
        ArrayList<String> q3Option = new ArrayList<>();
        q3Option.add(getResources().getString(R.string.q3_1));
        q3Option.add(getResources().getString(R.string.q3_2));
        q3Option.add(getResources().getString(R.string.q3_3));
        q3Option.add(getResources().getString(R.string.q3_4));
        q3.setOptionsList(q3Option);
        List<Object> q3Answer = new ArrayList<>();
        q3Answer.add(1);
        q3Answer.add(3);
        q3.setCorrectAnswer(q3Answer);

        quizzes.add(q1);
        quizzes.add(q2);
        quizzes.add(q3);

        return quizzes;
    }

}