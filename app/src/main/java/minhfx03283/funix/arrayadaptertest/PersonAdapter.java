package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private List<Person> personList = new ArrayList<>();

    public PersonAdapter(@NonNull Context context, @NonNull List<Person> list) {
        super(context, 0, list);
        this.context = context;
        this.personList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false);
        }

        Person currentPerson = personList.get(position);

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View layout =inflater.inflate(R.layout.list_view, null);

        LinearLayout linearLayout = (LinearLayout) listItem.findViewById(R.id.layout_list_view);

        TextView tvName = new TextView(this.context);
        tvName.setText(currentPerson.getName());

        TextView tvAge = new TextView(this.context);
        tvAge.setText("" + currentPerson.getAge());


        RadioGroup radioGroup = new RadioGroup(this.context);
        for (String s : currentPerson.getFoo()) {
            RadioButton radioButton = new RadioButton(this.context);
            radioButton.setText("" + s);
            radioGroup.addView(radioButton);
        }

        linearLayout.addView(tvName);
        linearLayout.addView(tvAge);
        linearLayout.addView(radioGroup);

//        TextView tvName = (TextView)listItem.findViewById(R.id.tv_name);
//        TextView tvAge = (TextView)listItem.findViewById(R.id.tv_age);
//
//        tvName.setText(currentPerson.getName());
//        tvAge.setText("" + currentPerson.getAge());


        return listItem;
    }
}
