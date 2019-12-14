package com.uestc.jenkin.androidlearndemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listview)
        val items = ArrayList<String>()
        items.add("可伸缩里列表")
        items.add("DrawView 滑动")
        items.add("PorterDuffXfermode")
        items.add("自定义SurfaceView")
        items.add("灵动菜单")
        items.add("图片模糊")
        items.add("Android 5.x 新特性 clip")
        items.add("Activity跳转动画")
        items.add("Ripple效果")


        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter
        //设置监听器
        listView.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent()
            when (position) {
                0 -> {
                    intent.setClass(this@MainActivity, AnimListActivity::class.java)
                    startActivity(intent)
                }

                1 -> {
                    intent.setClass(this@MainActivity, DrawViewActivity::class.java)
                    startActivity(intent)
                }

                2 -> {
                    intent.setClass(this@MainActivity, PorterDuffXfermodeActivity::class.java)
                    startActivity(intent)
                }

                3 -> {
                    intent.setClass(this@MainActivity, SurfaceViewActivity::class.java)
                    startActivity(intent)
                }

                4 -> {
                    intent.setClass(this@MainActivity, MenuAnimActivity::class.java)
                    startActivity(intent)
                }

                5 -> {
                    intent.setClass(this@MainActivity, BlurActivity::class.java)
                    startActivity(intent)
                }

                6 -> {
                    intent.setClass(this@MainActivity, ClipActivity::class.java)
                    startActivity(intent)
                }

                7 -> {
                    intent.setClass(this@MainActivity, TransitionActivity::class.java)
                    startActivity(intent)
                }

                8 -> {
                    intent.setClass(this@MainActivity, RippleActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "A onPause: ")
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "A onStart: ")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "A onRestart: ")
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "A onResume: ")
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "A onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "A onDestroy: ")
    }

    companion object {

        private val TAG = "MainActivity"
    }


}
