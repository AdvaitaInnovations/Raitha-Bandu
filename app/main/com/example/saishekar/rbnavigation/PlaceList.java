package com.example.saishekar.rbnavigation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.saishekar.rbnavigation.Adapter.LazyImageLoadAdapter;
import cz.msebera.android.httpclient.Header;
import model.Menu;
import model.Place;
import util.CommonUtil;
import util.DBHelper;

public class PlaceList extends AppCompatActivity {
    public static String Key = "MenuData";
    Menu menu;
    ListView place_listview;
    LazyImageLoadAdapter adapter;
    ArrayList<Place> placelist;
    ProgressDialog dialog;
    DBHelper dbHelper;
    String lat="0",lon="0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        menu = (Menu) getIntent().getSerializableExtra(Key);
        String mtitle = getText(R.string.app_name) + " near by " + menu.getName() + "'s";
        setTitle(mtitle);
        setContentView(R.layout.placeslist);
        place_listview = (ListView) findViewById(R.id.place_listview);
        dbHelper = new DBHelper(getApplicationContext());

        HashMap<String, String> locationdata = new HashMap<>();
        locationdata = dbHelper.getData();


        //if(!locationdata.isEmpty()||locationdata!=null){
        if(locationdata!=null){
            System.out.println("location :"+locationdata);

            lat = locationdata.get("lat");
            lon = locationdata.get("lon");
            System.out.println("dbdata :" + lat + " " + lon);
            GetPlacesData(lat,lon);

        }
        else {

            Toast.makeText(getApplicationContext(),"Can't Get your Loction", Toast.LENGTH_SHORT).show();

        }




    }

    private void GetPlacesData(String latt, String lonn) {

        /*Double lat = 13.0178668;
        Double lon = 77.5905968;*/
        Double lat = Double.valueOf(latt);
        Double lon = Double.valueOf(lonn);
        String murl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=" + lat + "," + lon + "" +
                "&radius=1500&type=" + menu.getCode() +
                "&key=" + CommonUtil.mGoogleKey;
        dialog = new ProgressDialog(PlaceList.this);
        dialog.setMessage("Please wait");
        dialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(murl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] res) {
                dialog.cancel();
                try {

                    JSONObject jsonObj = new JSONObject(new String(res));
                    if (!jsonObj.isNull("results")) {
                        JSONArray results = jsonObj.getJSONArray("results");

                        placelist = new ArrayList<Place>();

                        for (int i = 0; i < results.length(); i++) {
                            Place pl = new Place();
                            JSONObject result = results.getJSONObject(i);
                            if (!result.isNull("id")) {
                                pl.setId(result.getString("id"));
                            }
                            if (!result.isNull("name")) {
                                pl.setName(result.getString("name"));
                            }
                            if (!result.isNull("rating")) {
                                pl.setRating(result.getString("rating"));
                            }
                            if (!result.isNull("vicinity")) {
                                pl.setAddress(result.getString("vicinity"));
                            }
                            if (!result.isNull("geometry")) {
                                JSONObject gobj = new JSONObject(result.getString("geometry"));
                                JSONObject lobj = new JSONObject(gobj.getJSONObject("location").toString());
                                pl.setLat(lobj.getString("lat"));
                                pl.setLon(lobj.getString("lng"));
                            }
                            if (result.has("photos")) {
                                JSONArray parr = new JSONArray(result.getString("photos"));
                                JSONObject pobj = new JSONObject(parr.getJSONObject(0).toString());
                                String purl = pobj.getString("photo_reference");
                                pl.setImgurl(purl);
                            }
                            placelist.add(pl);
                        }

                        adapter = new LazyImageLoadAdapter(PlaceList.this, placelist, menu);
                        place_listview.setAdapter(adapter);


                    }
                } catch (Exception e) {
                    //Something went wrong
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                dialog.cancel();
                CommonUtil.ShowToast(PlaceList.this, "Something went wrong");
            }


        });
    }



    public void onItemClick(int mPosition) {
        String tempValues = placelist.get(mPosition).getName();
        Toast.makeText(PlaceList.this, "Image URL : " + tempValues, Toast.LENGTH_LONG).show();
    }

}
