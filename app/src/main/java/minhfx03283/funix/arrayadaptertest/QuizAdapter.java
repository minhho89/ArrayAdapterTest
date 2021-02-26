package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;
import minhfx03283.funix.arrayadaptertest.Quiz.UserAnswer;

import static android.content.ContentValues.TAG;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    public Context context;
    public List<Quiz> quizzes;
    HashMap<Long, UserAnswer> userAnswerHashMap = new HashMap<>();
    HashMap<Long, String> radioButtonSelectedHashMap = new HashMap<>();

    public long final_result;


    // Constructor
    public QuizAdapter(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;
    }

    public QuizAdapter(Context context) {
        this.context = context;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public HashMap<Long, UserAnswer> getUserAnswerHashMap() {
        return userAnswerHashMap;
    }

    public void setUserAnswerHashMap(HashMap<Long, UserAnswer> userAnswerHashMap) {
        this.userAnswerHashMap = userAnswerHashMap;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        // Inflate the custom layout
        View quizView = LayoutInflater.from(context).inflate(R.layout.quiz_recycler, null);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(quizView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Log.d(TAG, "onBindViewHolder: ****** START *******");
//        Log.d(TAG, "onBindViewHolder: " + userAnswerHashMap.toString());
//        Log.d(TAG, "onBindViewHolder: *********************\n");

        Quiz quiz = quizzes.get(position);
        LinearLayout linearLayout = holder.linearLayout;

        linearLayout.removeAllViews();

        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(quiz.getQuiz());

//        Log.d(TAG, "onBindViewHolder: " + "in" + userAnswerHashMap.toString());
        linearLayout.addView(textView);


        if (quiz instanceof QuizType0) {
//            Log.d(TAG, "onBindViewHolder | QuizType0: 0_0_0_0_0_0_0");
//            Log.d(TAG, "onBindViewHolder | QuizType0: IN");
//            Log.d(TAG, "onBindViewHolder: Quiz ID = " + quiz.getId() + " ADDED!");

            RadioGroup radioGroup = new RadioGroup(linearLayout.getContext());
            for (String s : ((QuizType0) quiz).getOptionsList()) {
                RadioButton radioButton = new RadioButton(linearLayout.getContext());
                radioButton.setText(s);
                radioButton.setTag(quiz.getId() + " " + s);

                // Reset radioButton
                if (radioButtonSelectedHashMap.get(quiz.getId()) == radioButton.getText().toString()) {
                    // Check the proper button
                    radioButton.setChecked(true);
                }

                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String TAG = "onClick RadioButton";
                        if (v instanceof RadioButton) {

                            boolean isChecked = ((RadioButton) v).isChecked();
                            Set<String> userAnswerSet = new HashSet<>();
                            UserAnswer userAnswer = new UserAnswer();
                            if (isChecked) {
                                userAnswer.setQuiz(quiz);
                                userAnswer.setUserAnswer(new HashSet<>(Arrays.asList(s)));
                                userAnswer.setResult(quiz.checkResult(new HashSet<>(Arrays.asList(s))));
                                userAnswerHashMap.put(quiz.getId(), userAnswer);

                                radioButtonSelectedHashMap.put(quiz.getId(), radioButton.getText().toString());
                                Log.d(TAG, "onClick: RadioButton checked: "
                                        + radioButtonSelectedHashMap.get(quiz.getId()));

                                // Uncheck the other buttons
                                int count = radioGroup.getChildCount();
                                Log.d(TAG, "onBindViewHolder: Radio Button children: " + count);
                                ArrayList<RadioButton> listOfButtons = new ArrayList<>();
                                for (int i = 0; i < count; i++) {
                                    View o = radioGroup.getChildAt(i);
                                    if (o instanceof RadioButton &&
                                            (((RadioButton) o).getText() != radioButton.getText())
                                    ) {

                                        ((RadioButton) o).setChecked(false);
                                        Log.d(TAG, "onClick: radiobutton iterator uncheck: " + ((RadioButton) o).getText());
                                    }
                                }
                            }
                            radioButton.setChecked(true);
                            Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
                        }
                    }
                });

                radioGroup.addView(radioButton);
            }
            linearLayout.addView(radioGroup);
//            Log.d(TAG, "onBindViewHolder | QuizType0: 0_0_0_0_0_0_0");
//            Log.d(TAG, "onBindViewHolder | QuizType0: OUT\n");
        }

        if (quiz instanceof QuizType1) {
            Log.d(TAG, "onBindViewHolder | QuizType1: 1_1_1_1_1_1_1");
            Log.d(TAG, "onBindViewHolder | QuizType1: IN");
            Log.d(TAG, "onBindViewHolder: Quiz ID = " + quiz.getId() + " ADDED!");
            Log.d(TAG, "User answer changed ? "
                    + userAnswerHashMap.get(quiz.getId()));
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setQuiz(quiz);
            if(userAnswerHashMap.get(quiz.getId())== null) {
                    userAnswer.setUserAnswer(new HashSet<String>(Arrays.asList()));
                    userAnswerHashMap.put(quiz.getId(), userAnswer);
            }

            for (String s : ((QuizType1) quiz).getOptionsList()) {
                CheckBox checkBox = new CheckBox(linearLayout.getContext());
                checkBox.setText(s);
                if (userAnswerHashMap.get(quiz.getId()).getUserAnswer()!=null) {
                    // ReCheck Checkbox
                    for (String o : userAnswerHashMap.get(quiz.getId()).getUserAnswer()) {
                        Log.d(TAG, "############################");
                        Log.d(TAG, "onBindViewHolder: checkBox handling recheck in");
                        if (o.equalsIgnoreCase(checkBox.getText().toString())) {
                            checkBox.setChecked(true);
                        }
                    }
                }

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            userAnswerHashMap.get(quiz.getId()).getUserAnswer().add(s);

                        } else {
                            //!isChecked
                            String name = checkBox.getText().toString();
                            if (userAnswerHashMap.get(quiz.getId()).getUserAnswer().contains(name)) {
                                userAnswerHashMap.get(quiz.getId()).getUserAnswer().remove(name);
                            }
                        }

                        // set result
                        userAnswerHashMap.get(quiz.getId()).setResult(
                                quiz.checkResult(userAnswerHashMap.get(quiz.getId()).getUserAnswer()));

                        Log.d(TAG, "onCheckedChanged: " + userAnswerHashMap.toString());

                    }
                });
                linearLayout.addView(checkBox);
            }
            Log.d(TAG, "onBindViewHolder | QuizType1: 1_1_1_1_1_1_1");
            Log.d(TAG, "onBindViewHolder | QuizType1: OUT\n");
        }

        if (quiz instanceof QuizType2) {
//            Log.d(TAG, "onBindViewHolder | QuizType2: 2_2_2_2_2_2_2");
//            Log.d(TAG, "onBindViewHolder | QuizType2: IN");
//            Log.d(TAG, "onBindViewHolder: Quiz ID = " + quiz.getId() + " ADDED!");
            EditText editText = new EditText(linearLayout.getContext());
            editText.setTag(quiz.getId());

            linearLayout.addView(editText);

            // Reset EditText
//            if(userAnswerHashMap.get(quiz.getId())!=null)
            if (userAnswerHashMap.get(quiz.getId())!=null
            && (userAnswerHashMap.get(quiz.getId()).getUserAnswer()!=null)){
                if (!userAnswerHashMap.get(quiz.getId()).getUserAnswer().isEmpty()) {
                    Iterator it = userAnswerHashMap.get(quiz.getId()).getUserAnswer().iterator();
                    editText.setText(it.next().toString());
                }
            }

            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    Set<String> userAnswerSet = new HashSet<>();
                    UserAnswer userAnswer = new UserAnswer();
                    userAnswer.setQuiz(quiz);
                    if (!hasFocus) {
                        userAnswerSet.add(editText.getText().toString().toLowerCase());
                    } else {
                        userAnswerSet.clear();
                    }

                    userAnswer.setUserAnswer(userAnswerSet);
                    userAnswer.setResult(quiz.checkResult(userAnswerSet));
                    userAnswerHashMap.put(quiz.getId(), userAnswer);
                }
            });
//            Log.d(TAG, "onBindViewHolder | QuizType2: 2_2_2_2_2_2_2");
//            Log.d(TAG, "onBindViewHolder | QuizType2: OUT\n");
        }

        // Add a button at the end of the RecyclerView
        if (position == quizzes.size() - 1) {
//            Log.d(TAG, "onBindViewHolder | =================");
//            Log.d(TAG, "onBindViewHolder | ADD BUTTON IN");
            Button button = new Button(linearLayout.getContext());
            button.setText("Submit");

            linearLayout.addView(button);
//            Log.d(TAG, "onBindViewHolder | =================");
//            Log.d(TAG, "onBindViewHolder | ADD BUTTON OUT\n");

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    final String TAG = "Button onClick";
                    long countCorrect = 0;
                    long totalPoint = 10;


                    // Handle last editView
                    for (int i = 0; i < holder.linearLayout.getChildCount(); i++) {
                        Object childView = holder.linearLayout.getChildAt(i);
                        if (childView instanceof EditText) {
                            Set<String> userAnswerSet = new HashSet<>();
                            UserAnswer userAnswer = new UserAnswer();
                            userAnswer.setQuiz(quiz);
                            if (quiz instanceof QuizType2) {
                                userAnswerSet.add(((EditText) childView).getText().toString());
                                quiz.setUserAnswer(userAnswerSet);
                            }

                            userAnswer.setResult(quiz.checkResult(userAnswerSet));
                            userAnswerHashMap.put(quiz.getId(), userAnswer);
                        }
                    }


                    for (Long key : userAnswerHashMap.keySet()) {
                        if (userAnswerHashMap.get(key).isResult() == true) countCorrect++;
                    }

                    // Print Toast
                    bringToast(countCorrect);


                    Log.d(TAG, "onClick: ****************************");
                    Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
                    Log.d(TAG, "onClick: " + userAnswerHashMap.size());
                    Log.d(TAG, "onClick: correct count: " + countCorrect);
                    Log.d(TAG, "onClick: ****************************\n");
                }
            });
        }

//        linearLayout.setHasTransientState(false);
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public void bringToast(long countCorrect) {
        String message = "";
        String compliment = "";

        //[Perfect!]|[Try again!]+" "+[You scored] + " " + %d + " " + [out of] + " " + %d
        if (countCorrect == quizzes.size()) {
            compliment = context.getResources().getString(R.string.perfect);
        } else {
            compliment = context.getResources().getString(R.string.try_again);
        }
        message = String.format("%s %s %s %s %s.",
                compliment,
                context.getResources().getString(R.string.scored_1),
                String.valueOf(countCorrect),
                context.getResources().getString(R.string.scored_2),
                String.valueOf(quizzes.size()));

        Log.d(TAG, "onClick: " + message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public long getFinal_result() {
        long count = 0;

        for (Map.Entry m: this.userAnswerHashMap.entrySet()) {
            UserAnswer userAnswer = (UserAnswer) m.getValue();
            count += userAnswer.getCorrectAnswer();
        }
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

}
