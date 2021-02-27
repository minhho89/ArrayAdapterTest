package minhfx03283.funix.arrayadaptertest.Quiz;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import minhfx03283.funix.arrayadaptertest.InputNameFragment;

public class JSONSerializer {
    private final String mFilename;
    private final Context mContext;

    public JSONSerializer(String fn, Context con) {
        mFilename = fn;
        mContext = con;
    }

    public void save(InputNameFragment fragment)
            throws IOException, JSONException {
// Make an array in JSON format
        JSONObject jsonObject = fragment.convertToJSON();

        // Now write it to the private disk space of our app
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename,
                    mContext.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonObject.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public InputNameFragment load() throws IOException, JSONException{
        InputNameFragment inputNameFragment = new InputNameFragment();

        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            if ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONObject jsonObject = (JSONObject) new
                    JSONTokener(jsonString.toString()).nextValue();

            inputNameFragment = new InputNameFragment(jsonObject);

//            inputNameFragment = new InputNameFragment(jObject.getJSONObject(String.valueOf(0)));

        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens
            // when we start fresh. You could add a log here.
        } finally {// This will always run
            if (reader != null)
                reader.close();
        }
        return inputNameFragment;
    }


}
