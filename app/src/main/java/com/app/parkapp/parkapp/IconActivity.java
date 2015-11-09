package com.app.parkapp.parkapp;

import android.Manifest;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class IconActivity extends Activity {
    Button but;
    AnimationDrawable carAnimation;
    private ValueAnimator mAnimator;
    ImageView mImageView;
    private final Matrix matrix = new Matrix();

    private Thread thread;
    private ProgressBar mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        ImageView carImage = (ImageView) findViewById(R.id.anim);
        carImage.setBackgroundResource(R.drawable.logoanimation);
        carAnimation = (AnimationDrawable) carImage.getBackground();
        carAnimation.start();
        thread = new Thread(runable);
        thread.start();
    }


    public Runnable runable = new Runnable() {
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                startActivity(new Intent(IconActivity.this,MainActivity.class));
                finish();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    };
}

