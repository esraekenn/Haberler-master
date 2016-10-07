package com.pordiva.esraeken.haberler;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pordiva.esraeken.haberler.constans.constans;
import com.pordiva.esraeken.haberler.model.Data;
import com.pordiva.esraeken.haberler.model.Response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener{
    private Toolbar toolbar;
    RecyclerView recyclerView;
    TextView title, desc;
    ImageView image;
    private newsinterface restInterface;
    private Context context;
    newsadapter newsadapter;
    private Picasso picasso;
    private SliderLayout mDemoSlider;
    private List<Data> newsList = new ArrayList<>();
    private ImageView ivCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        ivCategory = (ImageView) findViewById(R.id.ivCategory);
        toolbar.setTitle("Haberler");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        newsadapter = new newsadapter(this);
        recyclerView.setAdapter(newsadapter);
        title = (TextView) findViewById(R.id.textView);
        desc = (TextView) findViewById(R.id.textView2);
        image = (ImageView) findViewById(R.id.imageView2);
        picasso = Picasso.with(MainActivity.this);

        ivCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title(R.string.title)
                        .items(R.array.select_dialog_items)
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                switch (which){
                                    case 0:{
                                        toolbar.setTitle("Gündem");
                                        gethaberler(1,25);
                                        break;
                                    }
                                    case 1:{
                                        toolbar.setTitle("Politika");
                                        gethaberler(1,24);
                                        break;
                                    }
                                    case 2:{
                                        toolbar.setTitle("Magazin");
                                        gethaberler(1,29);
                                        break;
                                    }
                                    case 3:{
                                        toolbar.setTitle("15 Temmuz Darbe Girişimi");
                                        gethaberler(1,255);
                                        break;
                                    }
                                    case 4:{
                                        toolbar.setTitle("Dünya");
                                        gethaberler(1,27);
                                        break;
                                    }
                                    case 5:{
                                        toolbar.setTitle("Ekonomi");
                                        gethaberler(1,28);
                                        break;
                                    }
                                    case 6:{
                                        toolbar.setTitle("Spor");
                                        gethaberler(1,23);
                                        break;
                                    }
                                    case 7:{
                                        toolbar.setTitle("Eğitim");
                                        gethaberler(1,256);
                                        break;
                                    }
                                    case 8:{
                                        toolbar.setTitle("Kültür-Sanat");
                                        gethaberler(1,19);
                                        break;
                                    }

                                }
                                return true;
                            }
                        })
                        .positiveText("Devamke")
                        .show();
            }
        });


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                newsList=NewsSingleton.getInstance().getGetData();
                HashMap<String, String> url_maps = new HashMap<String, String>();
                for (Data data : newsList)
                {
                    url_maps.put(String.valueOf(Html.fromHtml(data.getTitle())), "http:"+data.getImages().getPage());
                }


                for (String name : url_maps.keySet()) {
                    TextSliderView textSliderView = new TextSliderView(MainActivity.this);
                    // initialize a SliderLayout
                    textSliderView
                            .description(name)
                            .image(url_maps.get(name))
                            .setScaleType(BaseSliderView.ScaleType.Fit)
                            .setOnSliderClickListener(MainActivity.this);

                    //add your extra information
                    textSliderView.bundle(new Bundle());
                    textSliderView.getBundle()
                            .putString("extra", name);

                    mDemoSlider.addSlider(textSliderView);
                }
            }
        },3000);



        Gson gson = new GsonBuilder()
                .create();


        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(constans.URL).setConverter(new GsonConverter(gson)).setLogLevel(RestAdapter.LogLevel.FULL).build();
        restInterface = restAdapter.create(newsinterface.class);

        gethaberler(1,47);

    }

    private void gethaberler(int page,int category){
        restInterface.getNewsList(page,category,new Callback<Response>() {
            @Override
            public void success(Response jsonObject, retrofit.client.Response response) {
                jsonObject.getData();
                NewsSingleton.getInstance().setGetData(jsonObject.getData());
                newsadapter.clear();
                newsadapter.updateList(jsonObject.getData());
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Gelen Veri Yok");
                builder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setMessage(merror);

                builder.create().show();
            }


        });
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}