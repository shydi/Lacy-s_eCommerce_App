package estore.lacys.com.lacysestore.clothes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import estore.lacys.com.lacysestore.R;

/**
 * Created by Shaidi on 4/29/2015.
 */
public class CartActivity extends Activity
{
    private List<Catalog> mCartList;
    private List<Catalog> kCartList;
    private List<Catalog> wCartList;
    private int counter = 0;
    private mensAdapter mProductAdapter;
    private Runnable once;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        mCartList = mensHelper.getCart();
        kCartList = kidsHelper.getCart();
        wCartList = womensHelper.getCart();

        kCartList.addAll(wCartList);
        mCartList.addAll(kCartList);

        // Make sure to clear the selections
        for (int i = 0; i < mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }


        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new mensAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Catalog selectedProduct = mCartList.get(position);
                if (selectedProduct.selected == true)
                    selectedProduct.selected = false;
                else
                    selectedProduct.selected = true;

                mProductAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for (int i = mCartList.size() - 1; i >= 0; i--) {

                    if (mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
            }
        });

        Button checkoutButton = (Button) findViewById(R.id.checkoutBtn);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("estore.lacys.com.lacysestore.checkout.checkout");
                startActivity(intent);
            }
        });
    }
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if(mProductAdapter != null) {
            mProductAdapter.notifyDataSetChanged();
        }

        double subTotal = 0;
        for(Catalog p : mCartList) {
            subTotal += p.price;
        }

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText("Subtotal: $" + subTotal);
    }

}

