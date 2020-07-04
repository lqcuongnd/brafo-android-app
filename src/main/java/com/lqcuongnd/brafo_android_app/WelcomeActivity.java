package com.lqcuongnd.brafo_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Intent intent;
    Animation animation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animtion);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.startAnimation(animation);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                    Intent intent;
                    if (isLogged()) {
                        intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }

        };
        timer.start();
    }

    public boolean isLogged() {
        return false;
    }

}