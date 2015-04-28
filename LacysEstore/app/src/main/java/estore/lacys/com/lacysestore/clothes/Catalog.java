package estore.lacys.com.lacysestore.clothes;

import android.graphics.drawable.Drawable;

/**
 * Created by Shaidi on 4/27/2015.
 */
public class Catalog {
    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Catalog(String title, Drawable productImage, String description,
                   double price)
    {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }
}
