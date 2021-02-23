package minhfx03283.funix.arrayadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        TextView tvName = (TextView)listItem.findViewById(R.id.tv_name);
        TextView tvAge = (TextView)listItem.findViewById(R.id.tv_age);

        tvName.setText(currentPerson.getName());
        tvAge.setText("" + currentPerson.getAge());


        return listItem;
    }
}
