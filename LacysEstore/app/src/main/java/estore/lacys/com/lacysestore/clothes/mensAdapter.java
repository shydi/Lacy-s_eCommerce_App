package estore.lacys.com.lacysestore.clothes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import estore.lacys.com.lacysestore.LacysEstore;
import estore.lacys.com.lacysestore.R;

/**
 * Created by Shaidi on 4/27/2015.
 */
public class mensAdapter extends BaseAdapter
{
    private LacysEstore context;
    private LayoutInflater mInflater;
    private List<Catalog> products;
    private boolean mShowCheckbox;

    public mensAdapter(List<Catalog>mList, LayoutInflater inflater, boolean showCheckbox)
    {
        products = mList;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Catalog getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView.findViewById(R.id.ImageViewItem);

            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);

            item.mCheckBox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Catalog curProduct = products.get(position);

        item.productImageView.setImageDrawable(curProduct.getProductImage());
        item.productTitle.setText(curProduct.title);

        if(!mShowCheckbox) {
            item.mCheckBox.setVisibility(View.GONE);
        } else {
            if(curProduct.selected == true)
                item.mCheckBox.setChecked(true);
            else
                item.mCheckBox.setChecked(false);
        }


        return convertView;
    }

    private class ViewItem
    {
        ImageView productImageView;
        TextView productTitle;
        TextView productPrice;
        CheckBox mCheckBox;
    }
}
