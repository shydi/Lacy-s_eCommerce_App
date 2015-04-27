package estore.lacys.com.lacysestore;

import android.content.res.Resources;
import java.util.List;
import java.util.Vector;

/**
 * Created by Shaidi on 4/17/2015.
 */
public class mensCatalog
{
    public static final String Catalog_INDEX = "Catalog_INDEX";

    private static List<Catalog> mensCatalog;
    private static List<Catalog> cart;

    public static List<Catalog> getMensCatalog (Resources res)
    {
        if (mensCatalog == null)
        {
            mensCatalog = new Vector<Catalog>();
            mensCatalog.add(new Catalog("Men's Hoodie", res.getDrawable(R.drawable.mdesignerhoodie),
                    "Men's Fall Hoodie. Perfect for fashion and comfort.", 39.99));

            mensCatalog.add(new Catalog("Men's Hoodie", res.getDrawable(R.drawable.mdesignerhoodie),
                    "Men's Fall Hoodie. Perfect for fashion and comfort.", 39.99));
        }
        return mensCatalog;
    }

    public static List<Catalog> getCart()
    {
        if (cart == null)
        {
            cart = new Vector<Catalog>();
        }
        return cart;
    }
}
