package com.jlj.pmd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.botton)
    Button botton;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
//        GlideApp.with(this).asGif().load(R.drawable.ic).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
        Handler handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到GuideActivity or HomeActivity or LoginActivity
        Runnable runnable = new Runnable() {
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
//                float curTranslationX = image.getTranslationX();
//                // 获得当前按钮的位置
//                ObjectAnimator animator = ObjectAnimator.ofFloat(image, "translationX", 0, curTranslationX);
//                // 表示的是:
//                // 动画作用对象是mButton
//                // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
//                // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
//                animator.setDuration(5000);
//                animator.setRepeatCount(0);
//                animator.start();
            }
        };
        int SPLASH_DISPLAY_LENGHT = 3000;
        handler.postDelayed(runnable, SPLASH_DISPLAY_LENGHT);
        image.setVisibility(View.VISIBLE);

//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ImageActivity.this, VideoActivity.class));
//                Toast.makeText(getApplicationContext(), "就在这", Toast.LENGTH_SHORT).show();
//
//            }
//        });
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        view = LayoutInflater.from(this).inflate(R.layout.view_message_layout,null);
        layoutView(view,width,height);

    }


    @OnClick(R.id.botton)
    public void onViewClicked() {
        viewSaveToImage(view);
    }

    //然后View和其内部的子View都具有了实际大小，也就是完成了布局，相当与添加到了界面上。接着就可以创建位图并在上面绘制了：
    private void layoutView(View v, int width, int height) {
        // 整个View的大小 参数是左上角 和右下角的坐标
        v.layout(0, 0, width, height);
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(width-160, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(240, View.MeasureSpec.EXACTLY);
        /** 当然，measure完后，并不会实际改变View的尺寸，需要调用View.layout方法去进行布局。
         * 按示例调用layout函数后，View的大小将会变成你想要设置成的大小。
         */
        v.measure(measuredWidth, measuredHeight);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    }

    public void viewSaveToImage(View view) {
        Log.e("ssh","a");
        /**
         * View组件显示的内容可以通过cache机制保存为bitmap
         * 我们要获取它的cache先要通过setDrawingCacheEnable方法把cache开启，
         * 然后再调用getDrawingCache方法就可 以获得view的cache图片了
         * 。buildDrawingCache方法可以不用调用，因为调用getDrawingCache方法时，
         * 若果 cache没有建立，系统会自动调用buildDrawingCache方法生成cache。
         * 若果要更新cache, 必须要调用destoryDrawingCache方法把旧的cache销毁，才能建立新的。
         */
        //        view.setDrawingCacheEnabled(true);
        //        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        //设置绘制缓存背景颜色
        //        view.setDrawingCacheBackgroundColor(Color.WHITE);

        // 把一个View转换成图片
        Bitmap cachebmp = loadBitmapFromView(view);

        image.setImageBitmap(cachebmp);//直接展示转化的bitmap

        //保存在本地 产品还没决定要不要保存在本地
        FileOutputStream fos;
        try {
            // 判断手机设备是否有SD卡
            boolean isHasSDCard = Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED);
            if (isHasSDCard) {
                // SD卡根目录
                File sdRoot = Environment.getExternalStorageDirectory();
                Log.e("ssh",sdRoot.toString());
                File file = new File(sdRoot, "test.png");
                fos = new FileOutputStream(file);
            } else
                throw new Exception("创建文件失败!");
            //压缩图片 30 是压缩率，表示压缩70%; 如果不压缩是100，表示压缩率为0
            cachebmp.compress(Bitmap.CompressFormat.PNG, 90, fos);

            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        view.destroyDrawingCache();
    }

    private Bitmap loadBitmapFromView(View v) {
        int w = v.getWidth();
        int h = v.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);

        c.drawColor(Color.GRAY );
        /** 如果不设置canvas画布为白色，则生成透明 */

        v.layout(0, 0, w, h);
        v.draw(c);

        return bmp;
    }
}

