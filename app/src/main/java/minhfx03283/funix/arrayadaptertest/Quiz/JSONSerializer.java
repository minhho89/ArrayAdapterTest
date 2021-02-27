package minhfx03283.funix.arrayadaptertest.Quiz;

import android.content.Context;
import android.renderscript.ScriptGroup;

import org.json.JSONArray;
import org.json.JSONException;
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

public class JSONSerializer {
    private String mFilename;
    private Context mContext;

    public JSONSerializer(String fn, Context con){
        mFilename = fn;
        mContext = con;
    }

    public void save(List<UserAnswer> userAnswers) throws IOException, JSONException {

        // Make in array in JSON format
        JSONArray jArray = new JSONArray();

        // Add and load it with the notes
        for (UserAnswer u : userAnswers) {
            jArray.put(u.convertoJSON());
        }

        // Write to private disk space of app
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, mContext.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jArray.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ArrayList<UserAnswer> load() throws IOException, JSONException {
        ArrayList<UserAnswer> userAnswers = new ArrayList<>();
        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while((line = reader.readLine())!= null) {
                jsonString.append(line);
            }

            JSONArray jArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i < jArray.length(); i++) {
                userAnswers.add(new UserAnswer(jArray.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // Ignore
        } finally {
            if (reader != null) {
                reader.close();
            }
            return userAnswers;
        }

    }
}
