package estore.lacys.com.lacysestore.clothes;

import android.graphics.drawable.Drawable;

/**
 * Created by Shaidi on 4/27/2015.
 */
public class Catalog {
    public String title;
    private Drawable productImage;
    public String description;
    public double price;
    public boolean selected;

    public Catalog(String title, Drawable productImage, String description,
                   double price)
    {
        this.title = title;
        this.setProductImage(productImage);
        this.description = description;
        this.price = price;
    }

    public Drawable getProductImage() {
        return productImage;
    }

    public void setProductImage(Drawable productImage) {
        this.productImage = productImage;
    }
}
