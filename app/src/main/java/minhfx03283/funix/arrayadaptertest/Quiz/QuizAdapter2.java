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

    public Context context;
    public List<Quiz> quizzes;

    public QuizAdapter2(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
//            Context context = itemView.getContext();

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
//
//            radioGroup = new RadioGroup(context);
//            radioButton = new RadioButton(context);
//
//            checkbox = new CheckBox(context);
//            editText = new EditText(linearLayout.getContext());
//            editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));

        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context  = parent.getContext();

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
//        TextView extraTextView = new TextView(holder.linearLayout.getContext());

        linearLayout.removeAllViews();
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText(quiz.getQuiz());

//        linearLayout.setHasTransientState(true);
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


}
