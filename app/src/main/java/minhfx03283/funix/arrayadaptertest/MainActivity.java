package minhfx03283.funix.arrayadaptertest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Quiz> quizzes = addQuizzesInstance();

        RecyclerView rvQuiz = (RecyclerView) findViewById(R.id.recyclerView);

        addQuizzesInstance();
        QuizAdapter adapter = new QuizAdapter(this, quizzes);
        rvQuiz.setAdapter(adapter);
        rvQuiz.setLayoutManager(new LinearLayoutManager(this));

        // Add divider
        rvQuiz.addItemDecoration(new DividerItemDecoration(rvQuiz.getContext(),
                DividerItemDecoration.VERTICAL));
    }

    private List<Quiz> addQuizzesInstance() {
        List<Quiz> quizzes = new ArrayList<>();

        // 1. What is Deoxyribonucleic acid commonly referred to as? (Correct Answer is #3 (DNA)
        //RNA
        //CIA
        //DNA

        QuizType0 q1 = new QuizType0();
        q1.setQuiz("1. " + getResources().getString(R.string.q1));
        Set<String> q1Option = new HashSet<String>(
                Arrays.asList(
                        getResources().getString(R.string.q1_1),
                        getResources().getString(R.string.q1_2),
                        getResources().getString(R.string.q1_3)));
        Set<String> q1Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q1_3)));

        // 2. What process involves treating rubber with sulfur to harden it? (Correct Answer is "Vulcanizing")
        QuizType2 q2 = new QuizType2();
        q2.setQuiz("2. " + getResources().getString(R.string.q2));
        Set<String> q2Answer = new HashSet<String>(Arrays.asList(getResources().getString(R.string.q2_ans)));
        q2.setCorrectAnswer(q2Answer);

        // 3. Name two different organelles of a eukaryotic cell. (Correct Answers are #1 (Ribosomes) and #3 (Golgi Apparatus))
        //Ribosome
        //Plasmids
        //Golgi apparatus
        //Diploid
        QuizType1 q3 = new QuizType1();
        q3.setQuiz("3. " + getResources().getString(R.string.q3));
        Set<String> q3Option = new HashSet<String>(Arrays.asList(
                getResources().getString(R.string.q3_1),
                getResources().getString(R.string.q3_2),
                getResources().getString(R.string.q3_3),
                getResources().getString(R.string.q3_4)));
        q3.setOptionsList(q3Option);
        Set<String> q3Answer = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q3_1),
                getResources().getString(R.string.q3_3)));
        q3.setCorrectAnswer(q3Answer);

        //4. This word describes the force that pulls objects to the middle of the earth?
        // (Correct Answer is "Gravity")
        Quiz q4 = new QuizType2();
        q4.setQuiz(getResources().getString(R.string.q4));
        List<String> q4Answer = new ArrayList<>();
        q4Answer.add(getResources().getString(R.string.q4_ans));
        q4.setCorrectAnswer(q4Answer);

//        5 What type of trees yield the resin used to produce turpentine?
//        (Correct Answers is #2 "Pine trees")
//        Palm trees
//        Pine trees
//        Oak trees
        QuizType0 q5 = new QuizType0();
        q5.setQuiz("5. " + getResources().getString(R.string.q5));
        List<String> q5Option = new ArrayList<>();
        q5Option.add(getResources().getString(R.string.q5_1));
        q5Option.add(getResources().getString(R.string.q5_2));
        q5Option.add(getResources().getString(R.string.q5_3));
        q5.setOptionsList(q5Option);
        List<String> q5Answer = new ArrayList<>();
        q5Answer.add(getResources().getString(R.string.q5_2));
        q5.setCorrectAnswer(q5Answer);

//        6. Cumulus and Cirrus are types of what? (Correct Answer is "Clouds" or "Cloud")
        QuizType2 q6 = new QuizType2();
        q6.setQuiz("6. " + getResources().getString(R.string.q6));
        List<String> q6Answer = new ArrayList<>();
        q6Answer.add(getResources().getString(R.string.q6_ans1));
        q6Answer.add(getResources().getString(R.string.q6_ans2));
        q6.setCorrectAnswer(q6Answer);
        // 7. Which two planets have one or more moons? (Correct Answers are #3 (Earth) and #4 (Pluto))
        //Ceres
        //Mercury
        //Earth
        //Pluto
        QuizType1 q7 = new QuizType1();
        q7.setQuiz("7. " + getResources().getString(R.string.q7));
        List<String> q7Option = new ArrayList<>();
        q7Option.add(getResources().getString(R.string.q7_1));
        q7Option.add(getResources().getString(R.string.q7_2));
        q7Option.add(getResources().getString(R.string.q7_3));
        q7Option.add(getResources().getString(R.string.q7_4));
        q7.setOptionsList(q7Option);
        List<String> q7Answer = new ArrayList<>();
        q7Answer.add(getResources().getString(R.string.q7_3));
        q7Answer.add(getResources().getString(R.string.q7_4));

        //8. Where in the human body would you find the scaphoid bone? (Correct Answer is "Wrist")
        QuizType2 q8 = new QuizType2();
        q8.setQuiz("8. " + "Where in the human body would you find the scaphoid bone?");
        q8.setCorrectAnswer(new ArrayList<String>(Arrays.asList("Wrist")));

        //9. Which grow upwards Stalactites or Stalagmites? (Correct Answers is #2 "Stalagmites")
        //Stalactites
        //Stalagmites
        QuizType0 q9 = new QuizType0();
        q9.setQuiz("9. " + "Which grow upwards Stalactites or Stalagmites?");
        q9.setOptionsList(new ArrayList<String>(Arrays.asList("Stalactites", "Stalagmites")));
        q9.setCorrectAnswer(new ArrayList<String>(Arrays.asList("Stalagmites")));

        //10. What process involves heating an ore to obtain a metal? (Correct Answer is "Smelting")
        QuizType2 q10 = new QuizType2();
        q10.setQuiz("10. " + "What process involves heating an ore to obtain a metal?");
        q10.setCorrectAnswer(new ArrayList<String>(Arrays.asList("Smelting")));

        quizzes.add(q1);
        quizzes.add(q2);
        quizzes.add(q3);
        quizzes.add(q4);
        quizzes.add(q5);
        quizzes.add(q6);
        quizzes.add(q7);
        quizzes.add(q8);
        quizzes.add(q9);
        quizzes.add(q10);

        return quizzes;
    }

}