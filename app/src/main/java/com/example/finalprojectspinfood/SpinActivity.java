package com.example.finalprojectspinfood;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SpinActivity extends AppCompatActivity {
    public String[] daftar;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.Output);
        Collections.reverse(Arrays.asList(daftar));
    }

    public void pizzaspin(View view) {
        Random rr = new Random();
        final int degree = rr.nextInt(360);

        RotateAnimation rotateAnimation = new RotateAnimation(0, degree + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5F,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatorPoint(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void CalculatorPoint(int degree) {
        int initialPoint = 0;
        int endPoint = 30;
        int i = 0;
        String res = null;
        do {
            if (degree > initialPoint && degree < endPoint){
                res = daftar[i];
            }
            initialPoint += 30; endPoint +=30;
            i++;
        }while (res == null);

        textView.setText(res);
    }
}