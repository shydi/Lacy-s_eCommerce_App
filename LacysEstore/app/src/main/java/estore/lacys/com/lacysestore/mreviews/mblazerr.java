package estore.lacys.com.lacysestore.mreviews;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import estore.lacys.com.lacysestore.R;


public class mblazerr extends ActionBarActivity {
    private EditText txtEditor;
    private String output, txtbox;
    private Button button_save;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mblazerr);
        OnClickButtonListener();
        readFromFile("");
        /*txtEditor.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,int arg3)
            {

            }
            @Override
            public void afterTextChanged(Editable s)
            {
                output = txtEditor.getText().toString();
                writeToFile(output);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after)
            {
            }
        });*/




    }

    public void OnStartListviewWriter(String slist)
    {
        ListView reviewList = (ListView) findViewById(R.id.reviewlist);

        String lines[] = slist.split("-");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lines);

        reviewList.setAdapter(adapter);

    }

    public void OnClickButtonListener()
    {
        button_save = (Button)findViewById(R.id.submit_button);
        button_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtEditor=(EditText)findViewById(R.id.edittextfield);
                        output = txtEditor.getText().toString();
                        writeToFile(output);
                        readFromFile("");
                    }
                }
        );
    }

    public void writeToFile(String data)
    {
        try {
            OutputStreamWriter MyOutputStreamWriter = new OutputStreamWriter(openFileOutput("mdblazerreviews.txt",MODE_APPEND | MODE_PRIVATE));
            MyOutputStreamWriter.append("-" + data);
            MyOutputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public String readFromFile(String path) {
        String ret = "";
        if(path==""){
            try {
                InputStream inputStream = openFileInput("mdblazerreviews.txt");

                if ( inputStream != null ) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ( (receiveString = bufferedReader.readLine()) != null ) {
                        stringBuilder.append(receiveString).append("\\-");
                    }

                    inputStream.close();
                    ret = stringBuilder.toString();
                    OnStartListviewWriter(ret);
                }
            }
            catch (FileNotFoundException e) {
                Log.e("login activity", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("login activity", "Can not read file: " + e.toString());
            }
        }
        else
        {
            File file = new File(path);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();
            try {
                BufferedReader buf = new BufferedReader(new FileReader(file));
                while ( (receiveString = buf.readLine()) != null ) {
                    stringBuilder.append(receiveString).append("\\-");
                }
                buf.close();
                ret = stringBuilder.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mblazerr, menu);
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
