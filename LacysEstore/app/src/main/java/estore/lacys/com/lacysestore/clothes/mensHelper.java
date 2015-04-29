package estore.lacys.com.lacysestore.clothes;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

import estore.lacys.com.lacysestore.R;
import estore.lacys.com.lacysestore.clothing;

/**
 * Created by Shaidi on 4/27/2015.
 */
public class mensHelper
{
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Catalog> catalog;
    private static List<Catalog> cart;

    public static List<Catalog> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Catalog>();
            catalog.add(new Catalog("Men's Designer Hoodie", res
                    .getDrawable(R.drawable.mdesignerhoodie),
                    "Men's Designer Hoodie fit for fashion and comfort", 49.99));
            catalog.add(new Catalog("Men's Designer Jeans", res
                    .getDrawable(R.drawable.mdesignerjeans),
                    "Men's Designer Jeans great for any outdoor activity", 24.99));
            catalog.add(new Catalog("Men's Slim Blazer", res
                    .getDrawable(R.drawable.mslimblazer),
                    "Men's Slim Blazers now on sale", 34.99));
            catalog.add(new Catalog("Men's Striped Shirt", res
                    .getDrawable(R.drawable.mstrippedshirt),
                    "Men's Striped Shirt: Perfect for formal and informal occasions", 29.99));
            catalog.add(new Catalog("Men's Formal Suit", res
                    .getDrawable(R.drawable.mslimblazer),
                    "Perfect for any business meeting", 79.99));
        }

        return catalog;
    }

    public static List<Catalog> getCart() {
        if(cart == null) {
            cart = new Vector<Catalog>();
        }

        return cart;
    }
}
