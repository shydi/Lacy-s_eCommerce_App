package estore.lacys.com.lacysestore;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class womensclothing extends ActionBarActivity {
    private static Button button_wclothesreturn,button_login, button_m1review, button_m2review, button_m3review, button_m4review, button_m5review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womensclothing);
        OnClickButtonListener();
    }

    public void OnClickButtonListener()
    {
        button_wclothesreturn = (Button)findViewById(R.id.wclothesreturn);
        button_wclothesreturn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.mainpage");
                        startActivity(intent);
                    }
                }
        );

        button_login = (Button)findViewById(R.id.mLogin);
        button_login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("estore.lacys.com.lacysestore.LogIn");
                        startActivity(intent);
                    }
                }
        );

        button_m1review = (Button)findViewById(R.id.m1review);
        button_m1review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.wreviews.wdressr");
                        startActivity(intent);
                    }
                }
        );

        button_m2review = (Button)findViewById(R.id.m2review);
        button_m2review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.wreviews.wpantsr");
                        startActivity(intent);
                    }
                }
        );

        button_m3review = (Button)findViewById(R.id.m3review);
        button_m3review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.wreviews.wsummerdressr");
                        startActivity(intent);
                    }
                }
        );

        button_m4review = (Button)findViewById(R.id.m4review);
        button_m4review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.wreviews.wtanktopr");
                        startActivity(intent);
                    }
                }
        );

        button_m5review = (Button)findViewById(R.id.m5review);
        button_m5review.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.wreviews.wtshirtr");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_womensclothing, menu);
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
