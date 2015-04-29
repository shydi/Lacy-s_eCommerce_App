package estore.lacys.com.lacysestore.clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.res.Resources;
import java.util.List;
import java.util.Vector;


import estore.lacys.com.lacysestore.LacysEstore;
import estore.lacys.com.lacysestore.R;
import estore.lacys.com.lacysestore.clothes.Catalog;

public class mensCatalog extends Activity
{
    private List<Catalog> mProductList;
    private static Button button_mclothesreturn,button_login;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        // Obtain a reference to the product catalog
        mProductList = mensHelper.getCatalog(getResources());

        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        listViewCatalog.setAdapter(new mensAdapter(mProductList, getLayoutInflater(), false));

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent("estore.lacys.com.lacysestore.clothes.productDetails");
                productDetailsIntent.putExtra(mensHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent("estore.lacys.com.lacysestore.clothes.CartActivity");
                startActivity(viewShoppingCartIntent);
            }
        });

        OnClickListener();

    }

    public void OnClickListener()
    {
        button_mclothesreturn = (Button)findViewById(R.id.mclothesreturn);
        button_mclothesreturn.setOnClickListener(
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
    }

}