package estore.lacys.com.lacysestore.clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.app.Activity;

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
    private LacysEstore context;
    private List<Catalog> mProducts;

    /*private List<Catalog> mProductList;
     */
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);
        mProducts = mensHelper.getCatalog(getResources());

        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        listViewCatalog.setAdapter(new mensAdapter(mProducts, getLayoutInflater(), false));
    }



    /*// Construct the data source
    ArrayList<Catalog> arrayOfUsers = new ArrayList<Catalog>();
    // Create the adapter to convert the array to views
    mensAdapter adapter = new mensAdapter(this, arrayOfUsers);
    // Attach the adapter to a ListView
    ListView listView = (ListView) findViewById(R.id.);
    listView.setAdapter(adapter);*/
}