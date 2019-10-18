package com.uestc.jenkin.androidlearndemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SecondActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_list);

        Log.i(TAG, "B onCreate: ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "B onPause: ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "B onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "B onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "B onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "B onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "B onDestroy: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "B onSaveInstanceState: ");

        outState.putString("save","this is a save data");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "B onRestoreInstanceState: ");

        Log.i(TAG, "onRestoreInstanceState: data:"+savedInstanceState.getString("save"));
    }
}
