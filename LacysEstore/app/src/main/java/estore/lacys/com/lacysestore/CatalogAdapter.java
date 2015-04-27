package estore.lacys.com.lacysestore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import estore.lacys.com.lacysestore.R;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Gary on 3/23/2015.
 */
public class CatalogAdapter extends ArrayAdapter<Catalog> {


    public CatalogAdapter(LacysEstore context, int resource, Catalog[] objects) {
        super(context, resource, objects);
    }
}