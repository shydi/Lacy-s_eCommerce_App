package estore.lacys.com.lacysestore.clothes;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

import estore.lacys.com.lacysestore.R;

/**
 * Created by Shaidi on 4/29/2015.
 */
public class womensHelper
{
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Catalog> wCatalog;
    private static List<Catalog> cart;

    public static List<Catalog> getCatalog(Resources res){
        if(wCatalog == null) {
            wCatalog = new Vector<Catalog>();
            wCatalog.add(new Catalog("Women's Dress", res
                    .getDrawable(R.drawable.wfluffydress),
                    "Fluffy dress fit for Spring", 49.99));
            wCatalog.add(new Catalog("Women's Sequin Pants", res
                    .getDrawable(R.drawable.wsequinpants),
                    "Shine. Black. What more can you want from a pair of pants?", 54.99));
            wCatalog.add(new Catalog("Women's Summer Dress", res
                    .getDrawable(R.drawable.wsummerdress),
                    "Get ready for summer with this light, fashionable dress", 34.99));
            wCatalog.add(new Catalog("Women's Tank Top", res
                    .getDrawable(R.drawable.wtanktop),
                    "Great woman's tank top", 29.99));
            wCatalog.add(new Catalog("Women's T-Shirt", res
                    .getDrawable(R.drawable.wtshirt),
                    "For all you t-shirt needs!", 79.99));
        }

        return wCatalog;
    }

    public static List<Catalog> getCart() {
        if(cart == null) {
            cart = new Vector<Catalog>();
        }
        return cart;
    }
}
