package com.pordiva.esraeken.haberler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {
    ImageView image;
    private Toolbar toolbar;
    TextView title1,name1, excerpt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Haber Detayı");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        image = (ImageView) findViewById(R.id.big_image);
        String url = getIntent().getExtras().getString("photo");
        String title =getIntent().getExtras().getString("title");
        String name = getIntent().getExtras().getString("name");
        String excerpt=getIntent().getExtras().getString("excerpt");
        Picasso.with(this).load(url)
                .centerCrop()
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(image);

        title1 = (TextView) findViewById(R.id.title);
        name1 = (TextView) findViewById(R.id.name);
        excerpt1= (TextView) findViewById(R.id.excerpt);
        title1.setText((Html.fromHtml(title)));
        name1.setText((Html.fromHtml(name)));
        excerpt1.setText((Html.fromHtml(excerpt)));

    }
}
