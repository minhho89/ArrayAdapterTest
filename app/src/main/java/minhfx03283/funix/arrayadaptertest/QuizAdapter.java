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
import java.util.List;
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

    // Define listener member variable
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    HashMap<Long, UserAnswer> userAnswerHashMap = new HashMap<>();

    HashMap<Long, String> radioButtonSelectedHashMap = new HashMap<>();
    HashMap<Long, Set<String>> checkBoxSelectedHashMap = new HashMap<>();
    HashMap<Long, String> editTextHashMap = new HashMap<>();


    // Constructor
    public QuizAdapter(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;
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
        Quiz quiz = quizzes.get(position);
        LinearLayout linearLayout = holder.linearLayout;

        linearLayout.removeAllViews();

        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(quiz.getQuiz());

        Log.d(TAG, "onBindViewHolder: " + "in" + radioButtonSelectedHashMap.toString());
        linearLayout.addView(textView);


        if (quiz instanceof QuizType0) {
            RadioGroup radioGroup = new RadioGroup(linearLayout.getContext());
            for (String s : ((QuizType0) quiz).getOptionsList()) {
                RadioButton radioButton = new RadioButton(linearLayout.getContext());
                radioButton.setText(s);
                radioButton.setTag(quiz.getId() + " " + s);

                // Reset radioButton
                if(radioButtonSelectedHashMap.get(quiz.getId()) == radioButton.getText().toString()) {
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
                                userAnswerHashMap.put(quiz.getId(),userAnswer);

                                radioButtonSelectedHashMap.put(quiz.getId(), radioButton.getText().toString());
                                Log.d(TAG, "onClick: RadioButton checked: " + radioButtonSelectedHashMap.toString());

                                // Uncheck the other buttons
                                int count = radioGroup.getChildCount();
                                Log.d(TAG, "onBindViewHolder: Radio Button children: " + count);
                                ArrayList<RadioButton> listOfButtons = new ArrayList<>();
                                for (int i = 0; i < count; i++) {
                                    View o = radioGroup.getChildAt(i);
                                    if (o instanceof RadioButton &&
                                            (((RadioButton) o).getText()!=radioButton.getText())
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
        }

        if (quiz instanceof QuizType1) {
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setQuiz(quiz);
            Set<String> userAnswerSet = new HashSet<>();

            for (String s : ((QuizType1) quiz).getOptionsList()) {
                CheckBox checkBox = new CheckBox(linearLayout.getContext());
                checkBox.setText(s);
                checkBox.setTag(quiz.getId() + "_" + s);

                // Recheck Checkbox
                if (checkBoxSelectedHashMap.get(quiz.getId())!= null){
                    for (String o : checkBoxSelectedHashMap.get(quiz.getId())) {
                        if (checkBox.getText().toString().equalsIgnoreCase(o)) {
                            checkBox.setChecked(true);
                        }
                    }
                }

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        final String TAG = "onCheckedChange Chkbx";

                        if (isChecked) {
                            userAnswerSet.add(s);
                            checkBoxSelectedHashMap.put(quiz.getId(), userAnswerSet);
                        } else {
                            //!isChecked
                            String name = checkBox.getText().toString();
                            if (userAnswerSet.contains(name)) userAnswerSet.remove(name);
                        }
                        userAnswer.setUserAnswer(userAnswerSet);
                        if (userAnswer!=null) {
                        userAnswer.setResult(quiz.checkResult(userAnswerSet));
                        userAnswerHashMap.put(quiz.getId(), userAnswer);
                        Log.d(TAG, "onCheckedChanged: " + userAnswerHashMap.toString());
                        }
                    }
                });
                linearLayout.addView(checkBox);
            }
        }

        if (quiz instanceof QuizType2) {

            EditText editText = new EditText(linearLayout.getContext());
            editText.setTag(quiz.getId());

            linearLayout.addView(editText);

            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    Set<String> userAnswerSet = new HashSet<>();
                    UserAnswer userAnswer = new UserAnswer();
                    userAnswer.setQuiz(quiz);
                    if(!hasFocus) {
                        userAnswerSet.add(editText.getText().toString().toLowerCase());
                    } else {
                        userAnswerSet.clear();
                    }

                    userAnswer.setUserAnswer(userAnswerSet);
                    userAnswer.setResult(quiz.checkResult(userAnswerSet));
                    userAnswerHashMap.put(quiz.getId(), userAnswer);
                }
            });
        }

        // Add a button at the end of the RecyclerView
        if (position == quizzes.size() - 1) {
            Button button = new Button(linearLayout.getContext());
            button.setText("Submit");

            linearLayout.addView(button);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    final String TAG = "Button onClick";
                    long countCorrect = 0;
                    long totalPoint = 10;
                    String message = "";
                    String compliment = "";

                    // Handle last editView
                    for(int i = 0; i < holder.linearLayout.getChildCount(); i++) {
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


                    for (Long key: userAnswerHashMap.keySet()) {
                        if(userAnswerHashMap.get(key).isResult() == true) countCorrect++;
                    }

                    //[Perfect!]|[Try again!]+" "+[You scored] + " " + %d + " " + [out of] + " " + %d
                    if (countCorrect == 10) {
                        compliment = context.getResources().getString(R.string.perfect);
                    } else {
                        compliment = context.getResources().getString(R.string.try_again);
                    }
                    message = String.format("%s %s %s %s %s.",
                            compliment,
                            context.getResources().getString(R.string.scored_1),
                            String.valueOf(countCorrect),
                            context.getResources().getString(R.string.scored_2),
                            String.valueOf(totalPoint));

                    Log.d(TAG, "onClick: " + message);
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                    Log.d(TAG, "onClick: ****************************");
                    Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
                    Log.d(TAG, "onClick: " + userAnswerHashMap.size());
                    Log.d(TAG, "onClick: correct count: " + countCorrect);
                    Log.d(TAG, "onClick: ****************************");
                }
            });
        }
//        linearLayout.setHasTransientState(false);
    }


    @Override
    public int getItemCount() {
        return quizzes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

}
