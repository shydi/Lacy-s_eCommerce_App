package estore.lacys.com.lacysestore.clothes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import estore.lacys.com.lacysestore.LacysEstore;
import estore.lacys.com.lacysestore.R;

/**
 * Created by Shaidi on 4/27/2015.
 */
public class mensAdapter extends ArrayAdapter<Catalog>
{
    private LacysEstore context;
    private List<Catalog> products;
    private ListView list;

    // View lookup cache
    private static class ViewHolder {
        ImageView tbn;
        TextView name;
        TextView desc;
        TextView price;
    }

    public mensAdapter(LacysEstore context, List<Catalog> products) {
        super(context, R.layout.item, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Catalog item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.itemTitleView);
            viewHolder.price = (TextView) convertView.findViewById(R.id.priceView);
            viewHolder.tbn = (ImageView) convertView.findViewById(R.id.itemImageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        String textPrice = Double.toString(item.price);
        viewHolder.name.setText(item.title);
        viewHolder.price.setText(textPrice);
        viewHolder.tbn.setImageDrawable(item.productImage);

        // Return the completed view to render on screen
        return convertView;
    }
}
