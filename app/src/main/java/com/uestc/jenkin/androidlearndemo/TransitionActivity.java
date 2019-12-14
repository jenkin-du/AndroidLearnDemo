package com.uestc.jenkin.androidlearndemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
public class TransitionActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }


    public void explode(View view) {

        intent = new Intent(this, Transition2Activity.class);
        intent.putExtra("flag", 0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view) {
        intent = new Intent(this, Transition2Activity.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void fade(View view) {
        intent = new Intent(this, Transition2Activity.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void share(View view) {
        intent = new Intent(this, Transition2Activity.class);
        intent.putExtra("flag", 3);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle());
    }
}
