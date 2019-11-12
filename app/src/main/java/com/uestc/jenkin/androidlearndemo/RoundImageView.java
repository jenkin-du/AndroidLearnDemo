package com.uestc.jenkin.androidlearndemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/11/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@SuppressLint("AppCompatCustomView")
public class RoundImageView extends ImageView {

    private Bitmap mBitmap;
    private Bitmap mOut;
    private Paint mPaint;


    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inti(attrs);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inti(attrs);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        inti(attrs);
    }


    private void inti(AttributeSet attrs) {

        if (attrs != null) {
            int srcId = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
            mBitmap = BitmapFactory.decodeResource(getResources(), srcId);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float ratioX = w * 1f / mBitmap.getWidth();
        float ratioY = h * 1f / mBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(ratioX, ratioY);
        mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, true);

        mOut = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        Canvas c = new Canvas(mOut);
        c.drawRoundRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), 100, 100, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        c.drawBitmap(mBitmap, 0, 0, mPaint);

        canvas.drawBitmap(mOut, 0, 0, null);
    }
}
