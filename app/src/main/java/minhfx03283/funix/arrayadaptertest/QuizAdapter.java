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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;
import minhfx03283.funix.arrayadaptertest.Quiz.UserAnswer;

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
//        HashSet<UserAnswerSet> userAnswerHashMap = new HashSet<>();
        HashMap<Long, UserAnswer> userAnswerHashMap = new HashMap<>();
        Set<String> userAnswerSet = new HashSet<>();
        UserAnswer userAnswer = new UserAnswer();

        Quiz quiz = quizzes.get(position);

        LinearLayout linearLayout = holder.linearLayout;

        linearLayout.removeAllViews();

        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(quiz.getQuiz());

        linearLayout.addView(textView);

        if (quiz instanceof QuizType0) {
            RadioGroup radioGroup = new RadioGroup(linearLayout.getContext());
            for (String s : ((QuizType0) quiz).getOptionsList()) {
                RadioButton radioButton = new RadioButton(linearLayout.getContext());
                radioButton.setText(s);
                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String TAG = "onClick RadioButton";
                        if (v instanceof RadioButton) {
                            boolean isChecked = ((RadioButton) v).isChecked();
                            if (isChecked) {
                                userAnswer.setQuiz(quiz);
                                userAnswer.setUserAnswer(new HashSet<>(Arrays.asList(s)));
                                userAnswer.setResult(quiz.checkResult(new HashSet<>(Arrays.asList(s))));
                                userAnswerHashMap.put(quiz.getId(),userAnswer);
                            }
                            Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
                        }
                    }
                });

                radioGroup.addView(radioButton);
            }
            linearLayout.addView(radioGroup);
        }

        if (quiz instanceof QuizType1) {
            for (String s : ((QuizType1) quiz).getOptionsList()) {
                CheckBox checkBox = new CheckBox(linearLayout.getContext());
                checkBox.setText(s);

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        final String TAG = "onCheckedChange Chkbx";

                        userAnswer.setQuiz(quiz);

                        if(isChecked) {
                            userAnswerSet.add(s);
                        } else {
                            //!isChecked
                            if(userAnswerSet.contains(s)) userAnswerSet.remove(s);
                        }
                        userAnswer.setUserAnswer(userAnswerSet);
                        userAnswer.setResult(quiz.checkResult(userAnswerSet));
                        userAnswerHashMap.put(quiz.getId(), userAnswer);
                        Log.d(TAG, "onCheckedChanged: " + userAnswerHashMap.toString());
                    }
                });
                linearLayout.addView(checkBox);
            }
        }

        if (quiz instanceof QuizType2) {
            EditText editText = new EditText(linearLayout.getContext());
            editText.setTag(quiz.getId());

            linearLayout.addView(editText);
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
                    int countCorrect = 0;
                    // Get result from EditText
//                    for (int i = 0; i < holder.linearLayout.getChildCount(); i++)
//                    {
//                        Object childView = holder.linearLayout.getChildAt(i);
//                        if (childView instanceof EditText)
//                        {
//                            long quizId = (Long) ((EditText) childView).getTag();
//
//                            for(Quiz q : quizzes) {
//
//                                if (q instanceof QuizType2) {
//                                    UserAnswer userAnswer = new UserAnswer();
//                                    userAnswer.setQuiz(q);
//                                    userAnswer.setUserAnswer(new HashSet<String>(Arrays.asList(
//                                            ((EditText) childView).getText().toString())));
//                                    userAnswer.setResult(q.checkResult(userAnswer.getUserAnswer()));
//                                    userAnswerHashMap.put(quizId, userAnswer);
//                                    Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
//                                }
//                            }
//                        }
//                    }

//                    Iterator it = userAnswerHashMap.entrySet().iterator()  ;
//                    Log.d(TAG, "onClick: ****************************");
//                    while(it.hasNext()) {
//                        Log.d(TAG, "onClick: " + it.next().toString());
//                    }
//                    Log.d(TAG, "onClick: ****************************");

                    Log.d(TAG, "onClick: " + userAnswerHashMap.toString());
                }
            });
        }
//        linearLayout.setHasTransientState(false);
    }


    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    // Handle listeners
    public static class RadioButtonListener implements View.OnClickListener {
        Quiz quiz;

        public RadioButtonListener(Quiz quiz) {
            this.quiz = quiz;
        }

        @Override
        public void onClick(View v) {
            if (v instanceof RadioButton) {
                boolean isChecked = ((RadioButton) v).isChecked();
                if (isChecked) {
                    //TODO: implement checkCorrect method
                    quiz.addUserAnswer(((RadioButton) v).getText().toString());
                } else {
                    quiz.removeUserAnswer(((RadioButton) v).getText().toString());
                }
            }
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                //TODO: implement checkCorrect method
                Toast.makeText(context, buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

}
