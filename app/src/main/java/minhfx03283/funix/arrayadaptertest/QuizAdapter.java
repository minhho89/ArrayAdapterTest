package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
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
import java.util.Iterator;
import java.util.List;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;

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
                radioButton.setTag("rb" + s); // instead of setID which requires param as int
                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isChecked = ((RadioButton) v).isChecked();
                        if (isChecked) {
                            //TODO: implement checkCorrect method
                            Toast.makeText(context, ((RadioButton) v).getText(), Toast.LENGTH_SHORT).show();
//                            quiz.getUserAnswer().add(s);
                        } else {
//                            if (!quiz.getUserAnswer().isEmpty()) {
//                                quiz.removeUserAnswer(((RadioButton) v).getText().toString());
//                            }
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
                checkBox.setTag("cb" + s);
                checkBox.setOnCheckedChangeListener(new CheckBoxListener());

                linearLayout.addView(checkBox);
            }
        }

        if (quiz instanceof QuizType2) {
            EditText editText = new EditText(linearLayout.getContext());

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
                    Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show();
                    int countCorrect = 0;

                    for (Quiz q: quizzes) {

                    }


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
    class RadioButtonListener implements View.OnClickListener {
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
                    Toast.makeText(context, ((RadioButton) v).getText(), Toast.LENGTH_SHORT).show();
                    quiz.addUserAnswer(((RadioButton) v).getText().toString());
                } else {
                    quiz.removeUserAnswer(((RadioButton) v).getText().toString());
                }
                for (String s : quiz.getUserAnswer()) {
                    Toast.makeText(context, "userAnswer Set: " + s, Toast.LENGTH_SHORT).show();
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
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

}
