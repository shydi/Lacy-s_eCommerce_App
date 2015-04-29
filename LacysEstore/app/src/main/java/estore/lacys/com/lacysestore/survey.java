package estore.lacys.com.lacysestore;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;


public class survey extends ActionBarActivity {
    private RatingBar ratingBar;
    private EditText txtEditor;
    private String output, ratingvalue;
    private TextView txtRatingValue;
    private Button button_save;
    private RadioGroup group1;
    private RadioButton radiobutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_survey);
        addListenerOnRatingBar();
        OnClickButtonListener();
    }

    public void OnClickButtonListener()
    {
        button_save = (Button)findViewById(R.id.save);
        button_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        group1 = (RadioGroup) findViewById(R.id.radiogroup1);
                        int selectedId = group1.getCheckedRadioButtonId();
                        radiobutton1 = (RadioButton) findViewById(selectedId);

                        txtEditor=(EditText)findViewById(R.id.editText);
                        output = txtEditor.getText().toString();
                        writeToFile("Comments: " + output);
                        writeToFile("Radio Choice: " + radiobutton1.getText());
                        writeToFile(ratingvalue);
                        Intent intent = new Intent("estore.lacys.com.lacysestore.mainpage");
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Thank you! We will use this to " +
                                        "better your experience in the future.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void writeToFile(String data)
    {
        try {
            OutputStreamWriter MyOutputStreamWriter = new OutputStreamWriter(openFileOutput("userstats.txt",MODE_APPEND | MODE_PRIVATE));
            MyOutputStreamWriter.append("-" + data);
            MyOutputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                ratingvalue= ("Rating: " + String.valueOf(rating));

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_survey, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
