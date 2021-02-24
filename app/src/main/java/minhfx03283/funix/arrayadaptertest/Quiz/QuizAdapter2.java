package minhfx03283.funix.arrayadaptertest.Quiz;

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


import minhfx03283.funix.arrayadaptertest.R;

public class QuizAdapter2 extends RecyclerView.Adapter<QuizAdapter2.ViewHolder>{
    public TextView tvQuiz;
    public Context context;
    public List<Quiz> quizzes;

    public QuizAdapter2(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuiz;
        LinearLayout linearLayout;
        RadioGroup radioGroup;
        RadioButton radioButton;
        CheckBox checkbox;
        EditText editText;
        

        public ViewHolder(View itemView) {
            super(itemView);
            Context context = itemView.getContext();

            tvQuiz = (TextView) itemView.findViewById(R.id.txtQuiz);
            linearLayout = (LinearLayout) LayoutInflater.from(context).
                    inflate(R.layout.quiz_recycler, null);

            radioGroup = new RadioGroup(context);
            radioButton = new RadioButton(context);

            checkbox = new CheckBox(context);
            editText = new EditText(context);
        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context  = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View quizView = inflater.inflate(R.layout.quiz_recycler, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(quizView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);

        LinearLayout linearLayout = holder.linearLayout;

        TextView textView = holder.tvQuiz;
        textView.setText(quiz.getQuiz());

        EditText editText = holder.editText;
        linearLayout.addView(editText);



    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }


}
