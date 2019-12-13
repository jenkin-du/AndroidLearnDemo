package com.uestc.jenkin.androidlearndemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.renderscript.Allocation;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/12/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BlurActivity extends Activity {

    private ImageView imageView;

    private int maxRadius = 20;
    private int minRadius = 1;

    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);


        imageView = findViewById(R.id.img_teeth);
        SeekBar seekBar = findViewById(R.id.seek_bar);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float radius = (float) (minRadius + (maxRadius - minRadius) * (progress * 1.0 / 100));

                Log.i("blur", "radius:" + radius);

                long start = System.nanoTime();

                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.teeth);
                //模糊化
                blurByRenderScript(bitmap, radius, imageView, BlurActivity.this);

                long end = System.nanoTime();
                long time = (end - start) / 1000_000;
                Log.i("blur", "time :" + time + " ms");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public static void blurByRenderScript(Bitmap bitmap, float radius, ImageView view, Context context) {

        RenderScript rs = RenderScript.create(context);
        Allocation allocation = Allocation.createFromBitmap(rs, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, allocation.getElement());
        blur.setInput(allocation);
        blur.setRadius(radius);

        blur.forEach(allocation);

        allocation.copyTo(bitmap);
        view.setImageBitmap(bitmap);

        rs.destroy();
    }

}
