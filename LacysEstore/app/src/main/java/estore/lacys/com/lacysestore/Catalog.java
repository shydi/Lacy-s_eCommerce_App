package estore.lacys.com.lacysestore;

/**
 * Created by Shaidi on 4/17/2015.
 */
import android.graphics.drawable.Drawable;

public class Catalog {

    public String title;
    public Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Catalog(String name, Drawable productImage, String description,
                    double price)
    {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
    }

}