package com.example.saishekar.rbnavigation.Adapter;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saishekar.rbnavigation.PlaceList;
import com.example.saishekar.rbnavigation.R;

import java.util.ArrayList;

import model.Menu;
import model.Place;
import util.CommonUtil;


//com.example.saishekar.rbnavigation.Adapter class extends with BaseAdapter and implements with OnClickListener
public class LazyImageLoadAdapter extends BaseAdapter implements OnClickListener {

    private Activity activity;
    private ArrayList<Place> data;
    private static LayoutInflater inflater = null;
    public ImageLoader imageLoader;
    public Menu menu;

    public LazyImageLoadAdapter(Activity a, ArrayList<Place> d, Menu m) {
        activity = a;
        data = d;
        menu = m;
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Create ImageLoader object to download and show image in list
        // Call ImageLoader constructor to initialize FileCache
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder {

        public TextView text;
        public TextView text1;
        public TextView textWide;
        public ImageView image;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.listview_row, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.pname);
            holder.text1 = (TextView) vi.findViewById(R.id.paddress);
            holder.image = (ImageView) vi.findViewById(R.id.pimage);

            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();


        holder.text.setText(data.get(position).getName());
        holder.text1.setText(data.get(position).getAddress());
        ImageView image = holder.image;

        //DisplayImage function from ImageLoader Class
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (data.get(position).getImgurl() != null && !data.get(position).getImgurl().isEmpty()) {
                String url = "https://maps.googleapis.com/maps/api/place/photo?photoreference=" + data.get(position).getImgurl() + "&sensor=false&maxheight=100&maxwidth=100&key=" + CommonUtil.mGoogleKey;
                imageLoader.DisplayImage(url, image);
            }
        }

        /******** Set Item Click Listner for LayoutInflater for each row ***********/
        vi.setOnClickListener(new OnItemClickListener(position));
        return vi;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }


    /********* Called when Item click in ListView ************/
    private class OnItemClickListener implements OnClickListener {
        private int mPosition;

        OnItemClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {
            PlaceList sct = (PlaceList) activity;
            sct.onItemClick(mPosition);
        }
    }
}