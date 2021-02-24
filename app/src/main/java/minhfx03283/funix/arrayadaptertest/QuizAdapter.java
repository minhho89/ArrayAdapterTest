package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    public Context context;
    public List<Quiz> quizzes;

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

                radioGroup.addView(radioButton);
            }
            linearLayout.addView(radioGroup);
        }

        if (quiz instanceof QuizType1) {
            for (String s : ((QuizType1) quiz).getOptionsList()) {
                CheckBox checkBox = new CheckBox(linearLayout.getContext());
                checkBox.setText(s);

                linearLayout.addView(checkBox);
            }
        }

        if (quiz instanceof QuizType2) {
            EditText editText = new EditText(linearLayout.getContext());

            linearLayout.addView(editText);
        }
//        linearLayout.setHasTransientState(false);
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
