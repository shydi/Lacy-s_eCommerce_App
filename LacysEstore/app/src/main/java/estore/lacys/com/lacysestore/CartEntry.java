package estore.lacys.com.lacysestore;

/**
 * Created by Shaidi on 4/20/2015.
 */
public class CartEntry {

    private Catalog mProduct;
    private int mQuantity;

    public CartEntry(Catalog product, int quantity) {
        mProduct = product;
        mQuantity = quantity;
    }

    public Catalog getProduct() {
        return mProduct;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

}