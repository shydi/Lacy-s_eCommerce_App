package estore.lacys.com.lacysestore.clothes;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

import estore.lacys.com.lacysestore.R;

/**
 * Created by Shaidi on 4/29/2015.
 */
public class kidsHelper
{
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Catalog> kCatalog;
    private static List<Catalog> cart;

    public static List<Catalog> getCatalog(Resources res){
        if(kCatalog == null) {
            kCatalog = new Vector<Catalog>();
            kCatalog.add(new Catalog("Kid's Kitty Dress", res
                    .getDrawable(R.drawable.kittydress),
                    "Adorable Kid's Dress for your little one", 19.99));
            kCatalog.add(new Catalog("Kid's Kitty Hoodie", res
                    .getDrawable(R.drawable.kittyhoodie),
                    "Kid's Kitty Hoodie for those cold days", 25.99));
            kCatalog.add(new Catalog("Kid's Onesie", res
                    .getDrawable(R.drawable.konesie),
                    "Fit for all ages!", 14.99));
            kCatalog.add(new Catalog("Boy's Plaid Shirt", res
                    .getDrawable(R.drawable.kplaidboysshirt),
                    "Boy's plaid shirt fit for all occasions (for kids!)", 29.99));
            kCatalog.add(new Catalog("Kid's Turtle Pajamas", res
                    .getDrawable(R.drawable.kturtlespajamaset),
                    "For the slow sleepers", 19.99));
        }

        return kCatalog;
    }

    public static List<Catalog> getCart() {
        if(cart == null) {
            cart = new Vector<Catalog>();
        }

        return cart;
    }
}
