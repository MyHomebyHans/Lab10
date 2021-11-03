package com.androidhans.lab10

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與 XML 元件綁定
        val img_frame = findViewById<ImageView>(R.id.img_frame)
        val img_tween = findViewById<ImageView>(R.id.img_tween)
        val btn_start = findViewById<Button>(R.id.btn_start)
        val btn_stop = findViewById<Button>(R.id.btn_stop)
        val btn_alpha = findViewById<Button>(R.id.btn_alpha)
        val btn_scale = findViewById<Button>(R.id.btn_scale)
        val btn_translate = findViewById<Button>(R.id.btn_translate)
        val btn_rotate = findViewById<Button>(R.id.btn_rotate)

        //逐格動畫 Frame Animation
        //將動畫的 drawable(可繪製) 指定為 ImageView 的背景資源
        img_frame.setBackgroundResource(R.drawable.loading_animation)

        //將圖片背景轉為 AnimationDrawable (可繪製動畫)並執行
        btn_start.setOnClickListener {
                        val animation = img_frame.background as AnimationDrawable
            animation.start()
        }
        //將圖片背景轉為 AnimationDrawable 並停止
        btn_stop.setOnClickListener {
                       val animation = img_frame.background as AnimationDrawable
            animation.stop()
        }
        //補間動畫 Tween Animation
        //透明度 Alpha
        btn_alpha.setOnClickListener {
            val anim = AlphaAnimation(
                1.0f, //起始透明度
                0.2f //結束透明度
            )
            anim.duration = 1000 //動畫持續一秒
            img_tween.startAnimation(anim) //執行動畫
        }
        //縮放Scale
        btn_scale.setOnClickListener {
            val anim = ScaleAnimation(
                1.0f, //X 起始比例
                1.5f, //X 結束比例
                1.0f, //Y 起始比例
                1.5f //Y 結束比例
            )
            anim.duration = 1000 //動畫持續一秒
            img_tween.startAnimation(anim) //執行動畫
        }
        //位移Translate
        btn_translate.setOnClickListener {
            val anim = TranslateAnimation(
                0f, //X 起點
                100f, //X 終點
                0f, //Y 起點
                -100f //Y 終點
            )
            anim.duration = 1000 //動畫持續一秒
            img_tween.startAnimation(anim) //執行動畫
        }
        //旋轉Rotate
        btn_rotate.setOnClickListener {
            val anim = RotateAnimation(
                0f, //起始角度
                360f, //結束角度
                RotateAnimation.RELATIVE_TO_SELF, //X 以自身位置旋轉
                0.5f, //X 旋轉中心點
                RotateAnimation.RELATIVE_TO_SELF, //Y 以自身位置旋轉
                0.5f //Y 旋轉中心點
            )
            anim.duration = 1000 //動畫持續一秒
            img_tween.startAnimation(anim) //執行動畫
        }
    }
}