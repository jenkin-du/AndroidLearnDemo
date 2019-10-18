package com.uestc.jenkin.androidlearndemo

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.*

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class AnimListActivity : Activity() {

    private val TAG: String = "AnimListActivity";
    private var mTouchSlop: Float = 0.toFloat()
    private var mFirst: Float = 0.toFloat()
    private var mCurrent: Float = 0.toFloat()
    private var direction: Int = -1;
    private var mShow: Boolean = false;

    private var animator: Animator? = null
    private var toolbar: androidx.appcompat.widget.Toolbar? = null


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_list)

        val listView = findViewById<ListView>(R.id.listview)
        toolbar = findViewById(R.id.toolbar)

        mTouchSlop = ViewConfiguration.get(this).scaledTouchSlop.toFloat()

        toolbar!!.post {

            val header = View(this@AnimListActivity)
            header.layoutParams = AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, toolbar!!.getHeight())
            listView.addHeaderView(header)

            val items = ArrayList<String>()
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")
            items.add("string")

            val adapter = ArrayAdapter(this@AnimListActivity, android.R.layout.simple_list_item_1, items)
            listView.setAdapter(adapter)

            listView.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> mFirst = event.getY()
                    MotionEvent.ACTION_MOVE -> {
                        mCurrent = event.getY()
                        if (mCurrent - mFirst > mTouchSlop) {
                            direction = 1//up
                        } else if (mFirst - mCurrent > mTouchSlop) {
                            direction = 0//down
                        }

                        if (direction == 1) {
                            if (mShow) {
                                toolbarAnim(0)
                                mShow = !mShow
                            }
                        } else if (direction == 0) {
                            if (!mShow) {
                                toolbarAnim(1);
                                mShow = !mShow
                            }
                        }

                    }

                }

                false
            }
        }

    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun toolbarAnim(direction: Int) {

        if (animator != null && animator!!.isRunning()) {
            animator!!.cancel()
        }

        if (direction == 0) {
            animator = ObjectAnimator.ofFloat(toolbar, "translationY", toolbar!!.translationY, 0.toFloat())
        } else {
            animator = ObjectAnimator.ofFloat(toolbar, "translationY", toolbar!!.translationY, -toolbar!!.height.toFloat())
        }
        animator!!.start()
    }
}