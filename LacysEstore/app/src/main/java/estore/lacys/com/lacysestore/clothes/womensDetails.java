package estore.lacys.com.lacysestore.clothes;

/**
 * Created by Shaidi on 4/28/2015.
 */
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import estore.lacys.com.lacysestore.R;

public class womensDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        List<Catalog> catalog = womensHelper.getCatalog(getResources());
        final List<Catalog> cart = womensHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(womensHelper.PRODUCT_INDEX);
        final Catalog selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.itemImageView);
        productImageView.setImageDrawable(selectedProduct.getProductImage());

        TextView productTitleTextView = (TextView) findViewById(R.id.itemTitleView);
        productTitleTextView.setText(selectedProduct.title);

        TextView productDescView = (TextView) findViewById(R.id.itemDescView);
        productDescView.setText(selectedProduct.description);

        TextView productPriceTextView = (TextView) findViewById(R.id.dPriceView);
        productPriceTextView.setText("$" + selectedProduct.price);

        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {


                cart.add(selectedProduct);
                finish();
            }
        });

        // Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedProduct)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item in Cart");
        }
    }

}