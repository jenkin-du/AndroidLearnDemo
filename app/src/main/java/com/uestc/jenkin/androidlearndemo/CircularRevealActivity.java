package com.uestc.jenkin.androidlearndemo;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/12/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CircularRevealActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        final ImageView circle = findViewById(R.id.circle);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ViewAnimationUtils.createCircularReveal(circle, circle.getWidth() / 2, circle.getHeight() / 2, circle.getWidth() / 4, circle.getWidth() / 2);
                animator.setDuration(2000);
                animator.start();
            }
        });

        final ImageView rect = findViewById(R.id.rect);
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ViewAnimationUtils.createCircularReveal(rect, 0, 0, (float) Math.hypot(rect.getWidth(), rect.getHeight()), rect.getHeight());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
