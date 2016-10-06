package com.pordiva.esraeken.haberler;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation anim= AnimationUtils.loadAnimation(this, R.anim.move_up);
        ImageView imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setAnimation(anim);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
            startActivity(new Intent(splash_screen.this,MainActivity.class));
                finish();
            }
        },4000);

    }
}
