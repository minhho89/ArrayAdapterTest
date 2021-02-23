package minhfx03283.funix.arrayadaptertest.Quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import minhfx03283.funix.arrayadaptertest.R;

public class QuizAdapter2 extends RecyclerView.Adapter<QuizAdapter2.ViewHolder>{


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuiz;

        public ViewHolder(View itemView) {
            super(itemView);

            tvQuiz = (TextView)itemView.findViewById(R.id.tvQuiz);
        }

    }

    private List<Quiz> quizzes = new ArrayList<>();

    public QuizAdapter2(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.quiz_recycler, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);

        TextView textView = holder.tvQuiz;
        textView.setText(quiz.getQuiz());

    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }


}
