package com.jlj.pmd;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoplayer)
    VideoView videoplayer;
    @BindView(R.id.act_video_back)
    RelativeLayout actVideoBack;
    @BindView(R.id.act_redvideo_time)
    TextView actRedvideoTime;
    @BindView(R.id.tv_chat)
    ImageView tvChat;
    @BindView(R.id.tv_jiedan)
    TextView tvJiedan;
    @BindView(R.id.textView30)
    TextView textView30;
    @BindView(R.id.gifImg)
    ImageView gifImg;
    @BindView(R.id.act_redvideo_lin_store)
    LinearLayout actRedvideoLinStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
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

                float curTranslationX = actRedvideoLinStore.getLayoutParams().width+30;
                // 获得当前按钮的位置
                ObjectAnimator animator = ObjectAnimator.ofFloat(actRedvideoLinStore, "translationX", 0, curTranslationX);
                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
                // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
                animator.setDuration(1000);
                animator.setRepeatCount(0);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                       //在这里定义 一个当前类的全局值 动画结束给赋值，然后点击屏幕去判断是不是你赋的值 是的话就可以走关闭动画，不是的话略过
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
            }
        };
        int SPLASH_DISPLAY_LENGHT = 3000;
        handler.postDelayed(runnable, SPLASH_DISPLAY_LENGHT);
        actVideoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float curTranslationX = actRedvideoLinStore.getLayoutParams().width+30;
//                TranslateAnimation animation=new TranslateAnimation(Animation.ABSOLUTE, 0,
//                        Animation.ABSOLUTE,-curTranslationX,
//                        Animation.ABSOLUTE,0f,
//                        Animation.ABSOLUTE,0f);
//                animation.setDuration(3000);
//                animation.setFillAfter(true);
//                actRedvideoLinStore.startAnimation(animation);
//                actRedvideoLinStore.setClickable(false );

                // 获得当前按钮的位置
                ObjectAnimator animator = ObjectAnimator.ofFloat(actRedvideoLinStore, "translationX", curTranslationX, 0);
                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
                // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
                animator.setDuration(1000);
                animator.setRepeatCount(0);
                animator.start();
            }
        });
    }
}
