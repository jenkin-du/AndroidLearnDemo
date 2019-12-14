package com.uestc.jenkin.androidlearndemo;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/12/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ClipActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);

        View view1 = findViewById(R.id.rect);
        View view2 = findViewById(R.id.circle);

        ViewOutlineProvider provider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20);
            }
        };
        view1.setOutlineProvider(provider1);


        ViewOutlineProvider provider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };
        view2.setOutlineProvider(provider2);
    }
}
