package minhfx03283.funix.arrayadaptertest;

import android.os.Bundle;

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
        q1.setOptionsList(q1Option);
        Set<String> q1Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q1_3)));
        q1.setCorrectAnswer(q1Answer);

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
        QuizType2 q4 = new QuizType2();
        q4.setQuiz(getResources().getString(R.string.q4));
        Set<String> q4Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q4_ans)));
        q4.setCorrectAnswer(q4Answer);

//        5 What type of trees yield the resin used to produce turpentine?
//        (Correct Answers is #2 "Pine trees")
//        Palm trees
//        Pine trees
//        Oak trees
        QuizType0 q5 = new QuizType0();
        q5.setQuiz("5. " + getResources().getString(R.string.q5));
        Set<String> q5Option = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q5_1),
                getResources().getString(R.string.q5_2),
                getResources().getString(R.string.q5_3)));
        q5.setOptionsList(q5Option);
        Set<String> q5Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q5_2)));
        q5.setCorrectAnswer(q5Answer);

//        6. Cumulus and Cirrus are types of what? (Correct Answer is "Clouds" or "Cloud")
        QuizType2 q6 = new QuizType2();
        q6.setQuiz("6. " + getResources().getString(R.string.q6));
        Set<String> q6Answer = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q6_ans1),
                getResources().getString(R.string.q6_ans2)));
        q6.setCorrectAnswer(q6Answer);

        // 7. Which two planets have one or more moons? (Correct Answers are #3 (Earth) and #4 (Pluto))
        //Ceres
        //Mercury
        //Earth
        //Pluto
        QuizType1 q7 = new QuizType1();
        q7.setQuiz("7. " + getResources().getString(R.string.q7));
        Set<String> q7Option = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q7_1),
                getResources().getString(R.string.q7_2),
                getResources().getString(R.string.q7_3),
                getResources().getString(R.string.q7_4)));
        q7.setOptionsList(q7Option);
        Set<String> q7Answer = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q7_3),
                getResources().getString(R.string.q7_4)));
        q7.setCorrectAnswer(q7Answer);

        //8. Where in the human body would you find the scaphoid bone? (Correct Answer is "Wrist")
        QuizType2 q8 = new QuizType2();
        q8.setQuiz("8. " + getResources().getString(R.string.q8));
        q8.setCorrectAnswer(new HashSet<String>(
                Arrays.asList(getResources().getString(R.string.q8_ans))));

        //9. Which grow upwards Stalactites or Stalagmites? (Correct Answers is #2 "Stalagmites")
        //Stalactites
        //Stalagmites
        QuizType0 q9 = new QuizType0();
        q9.setQuiz("9. " + getResources().getString(R.string.q9));
        q9.setOptionsList(new HashSet<String>(Arrays.asList(getResources().getString(R.string.q9_1),
                getResources().getString(R.string.q9_2))));
        q9.setCorrectAnswer(new HashSet<String>(Arrays.asList(getResources().getString(R.string.q9_2))));

        //10. What process involves heating an ore to obtain a metal? (Correct Answer is "Smelting")
        QuizType2 q10 = new QuizType2();
        q10.setQuiz("10. " + "QUESTION 10");
        q10.setCorrectAnswer(new HashSet<String>(Arrays.asList(getResources().getString(R.string.q10_ans))));

        // TODO: delete after test
        // 1. What is Deoxyribonucleic acid commonly referred to as? (Correct Answer is #3 (DNA)
        //RNA
        //CIA
        //DNA
        QuizType0 q11 = new QuizType0();
        q11.setQuiz("11. " + "QUESTION 11");
        Set<String> q11Option = new HashSet<String>(
                Arrays.asList(
                        getResources().getString(R.string.q1_1),
                        getResources().getString(R.string.q1_2),
                        getResources().getString(R.string.q1_3)));
        q11.setOptionsList(q1Option);
        Set<String> q11Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q1_3)));
        q11.setCorrectAnswer(q1Answer);

        // 2. What process involves treating rubber with sulfur to harden it? (Correct Answer is "Vulcanizing")
        QuizType2 q12 = new QuizType2();
        q12.setQuiz("12. " + "QUESTION 12");
        Set<String> q12Answer = new HashSet<String>(Arrays.asList(getResources().getString(R.string.q2_ans)));
        q12.setCorrectAnswer(q2Answer);

        // 3. Name two different organelles of a eukaryotic cell. (Correct Answers are #1 (Ribosomes) and #3 (Golgi Apparatus))
        //Ribosome
        //Plasmids
        //Golgi apparatus
        //Diploid
        QuizType1 q13 = new QuizType1();
        q13.setQuiz("13. " + "QUESTION 13");
        Set<String> q13Option = new HashSet<String>(Arrays.asList(
                getResources().getString(R.string.q3_1),
                getResources().getString(R.string.q3_2),
                getResources().getString(R.string.q3_3),
                getResources().getString(R.string.q3_4)));
        q13.setOptionsList(q3Option);
        Set<String> q13Answer = new HashSet<>(Arrays.asList(
                getResources().getString(R.string.q3_1),
                getResources().getString(R.string.q3_3)));
        q3.setCorrectAnswer(q3Answer);

        //4. This word describes the force that pulls objects to the middle of the earth?
        // (Correct Answer is "Gravity")
        QuizType2 q14 = new QuizType2();
        q14.setQuiz("14. QUESTION 14");
        Set<String> q14Answer = new HashSet<>(Arrays.asList(getResources().getString(R.string.q4_ans)));
        q14.setCorrectAnswer(q4Answer);

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

        // TODO: delete after test
        quizzes.add(q11);
        quizzes.add(q12);
        quizzes.add(q13);
        quizzes.add(q14);

        return quizzes;
    }

}