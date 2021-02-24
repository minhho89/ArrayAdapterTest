package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import minhfx03283.funix.arrayadaptertest.Quiz.Quiz;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType0;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType1;
import minhfx03283.funix.arrayadaptertest.Quiz.QuizType2;

public class QuizAdapter extends ArrayAdapter<Quiz> {

    private Context context;
    private List<Quiz> quizzes = new ArrayList<>();

    public QuizAdapter(@NonNull Context context, @NonNull List<Quiz> list) {
        super(context, 0, list);
        this.context = context;
        this.quizzes = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false);
        }

        Quiz currentQuiz = quizzes.get(position);

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View layout =inflater.inflate(R.layout.list_view, null);

        LinearLayout linearLayout = (LinearLayout) listItem.findViewById(R.id.layout_list_view);

        TextView tvQuiz = new TextView(this.context);
        tvQuiz.setText(currentQuiz.getQuiz());
        linearLayout.addView(tvQuiz);

        RadioGroup radioGroup = new RadioGroup(this.context);
        if(currentQuiz instanceof QuizType0) {
            QuizType0 quizType0 = (QuizType0)currentQuiz;
            for (String s: quizType0.getOptionsList()) {
                RadioButton radioButton = new RadioButton(this.context);
                radioButton.setText("" + s);
                radioGroup.addView(radioButton);
            }
        }
        linearLayout.addView(radioGroup);

        if (currentQuiz instanceof QuizType1) {
            QuizType1 quizType1 = (QuizType1)currentQuiz;
            for (String s: quizType1.getOptionsList()) {
                CheckBox checkBox = new CheckBox(this.context);
                checkBox.setText("" + s);
                linearLayout.addView(checkBox);
            }
        }

        if (currentQuiz instanceof QuizType2) {
            EditText editText = new EditText(this.context);
            linearLayout.addView(editText);
        }







        return listItem;
    }
}
