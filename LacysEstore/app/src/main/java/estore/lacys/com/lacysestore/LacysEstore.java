package estore.lacys.com.lacysestore;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import estore.lacys.com.lacysestore.clothes.Catalog;


public class LacysEstore extends ActionBarActivity {
    private static ImageButton button_mens, button_women, button_kids, button_login, cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacys_estore);
        //code//
        OnClickButtonListener();
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }

    public void OnClickButtonListener()
    {

        cart = (ImageButton) findViewById(R.id.cart);
        cart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.clothes.CartActivity");
                        startActivity(intent);
                    }
                }
        );

        button_mens = (ImageButton)findViewById(R.id.mensbutton);
        button_mens.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.clothes.mensCatalog");
                        startActivity(intent);
                    }
                }
        );

        button_women = (ImageButton)findViewById(R.id.womensbutton);
        button_women.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.clothes.womensCatalog");
                        startActivity(intent);
                    }
                }
        );

        button_kids = (ImageButton)findViewById(R.id.kidsbutton);
        button_kids.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("estore.lacys.com.lacysestore.clothes.kidsCatalog");
                        startActivity(intent);
                    }
                }
        );

        button_login = (ImageButton)findViewById(R.id.login);
        button_login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("estore.lacys.com.lacysestore.LogIn");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lacys_estore, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_rate)
        {
            AppRater.showRateDialog(this, null);
        }

        if (id == R.id.action_survey)
        {
            Intent intent = new Intent("estore.lacys.com.lacysestore.survey");
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
