package com.jlj.pmd;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        Glide.with(this).asGif().load(R.drawable.ic).into(image);
//        GlideApp.with(this).asGif().load(R.drawable.ic).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
        Handler handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到GuideActivity or HomeActivity or LoginActivity
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
//                DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
//                TranslateAnimation animation=new TranslateAnimation(Animation.ABSOLUTE, 0f,
//                        Animation.ABSOLUTE,displayMetrics.widthPixels/2,
//                        Animation.ABSOLUTE,0f,
//                        Animation.ABSOLUTE,0f);
//                animation.setDuration(3000);
//                animation.setFillAfter(true);
//                image.startAnimation(animation);
                float curTranslationX = image.getTranslationX();
                // 获得当前按钮的位置
                ObjectAnimator animator = ObjectAnimator.ofFloat(image, "translationX", 0, curTranslationX);
                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
                // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
                animator.setDuration(5000);
                animator.setRepeatCount(0);
                animator.start();
            }
        };
        int SPLASH_DISPLAY_LENGHT = 3000;
        handler.postDelayed(runnable, SPLASH_DISPLAY_LENGHT);
        image.setVisibility(View.VISIBLE);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageActivity.this,VideoActivity.class));
                Toast.makeText(getApplicationContext(), "就在这", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
