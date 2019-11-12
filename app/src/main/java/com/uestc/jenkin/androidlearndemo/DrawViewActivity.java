package com.uestc.jenkin.androidlearndemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DrawViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view);
    }
}
