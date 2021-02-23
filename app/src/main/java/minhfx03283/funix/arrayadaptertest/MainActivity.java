package minhfx03283.funix.arrayadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> personList = addPersonInstance();
//
//        ArrayAdapter<Person> adapter = new ArrayAdapter<>(
//                this, android.R.layout.simple_list_item_1, personList);
//
        ListView listView = (ListView)findViewById(R.id.layout_list_view);
        PersonAdapter adapter = new PersonAdapter(this, personList);
        listView.setAdapter(adapter);

    }

    private List<Person> addPersonInstance() {
        Person p1 = new Person("Tam", 18, new String[] {"a", "b", "c"});
        Person p2 = new Person("An", 20, new String[] {"f", "e", "g", "j"});
        Person p3 = new Person("Nam", 30, new String[] {"K"});
        Person p4 = new Person("Toan", 50, new String[] {"123", "sdasfd"});

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        return personList;
    }
}