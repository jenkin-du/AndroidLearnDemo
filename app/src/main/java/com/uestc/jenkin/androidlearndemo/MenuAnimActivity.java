package com.uestc.jenkin.androidlearndemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/11/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MenuAnimActivity extends Activity {

    private ImageView add;
    private ImageView answer;
    private ImageView clock;
    private ImageView music;
    private ImageView voice;

    private boolean flag = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_anim);

        init();
    }

    private void init() {

        add = findViewById(R.id.open);
        answer = findViewById(R.id.answer);
        clock = findViewById(R.id.clock);
        music = findViewById(R.id.music);
        voice = findViewById(R.id.voice);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag) {
                    openMenu();
                } else {
                    closeMenu();
                }
            }
        });
    }

    /**
     * 关闭菜单
     */
    private void closeMenu() {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(answer, "translationY", -200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(clock, "translationX", -200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(music, "translationY", 200f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(voice, "translationX", 200f);

        ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(answer, "alpha", 1f, 0);
        ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(clock, "alpha", 1f, 0);
        ObjectAnimator alphaAnimator3 = ObjectAnimator.ofFloat(music, "alpha", 1f, 0);
        ObjectAnimator alphaAnimator4 = ObjectAnimator.ofFloat(voice, "alpha", 1f, 0);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator1, animator2, animator3, animator4, alphaAnimator1, alphaAnimator2, alphaAnimator3, alphaAnimator4);
        set.start();

        flag = !flag;
    }

    /**
     * 打开菜单
     */
    private void openMenu() {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(answer, "translationY", 200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(clock, "translationX", 200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(music, "translationY", -200f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(voice, "translationX", -200f);

        ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(answer, "alpha", 0, 1f);
        ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(clock, "alpha", 0, 1f);
        ObjectAnimator alphaAnimator3 = ObjectAnimator.ofFloat(music, "alpha", 0, 1f);
        ObjectAnimator alphaAnimator4 = ObjectAnimator.ofFloat(voice, "alpha", 0, 1f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator1, animator2, animator3, animator4, alphaAnimator1, alphaAnimator2, alphaAnimator3, alphaAnimator4);
        set.start();

        flag = !flag;
    }
}
