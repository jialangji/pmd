package com.jlj.pmd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> data;
    private com.jlj.pmd.news.MarqueeView mVstv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        data = new ArrayList<>();

        for (int i = 0; i <4 ; i++) {
            data.add("窗前明月光"+i);
        }
//        mMv.setMarqueeData(data);
//        mMv.setListener(new MarqueeView.onClickPositionListener() {
//            @Override
//            public void onClick(int position) {
//                Toast.makeText(MainActivity.this,data.get(position),Toast.LENGTH_SHORT).show();
//            }
//        });
         mVstv.startWithList(data);
        mVstv.setOnItemClickListener(new com.jlj.pmd.news.MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                startActivity(new Intent(MainActivity.this,ImageActivity.class));
                Toast.makeText(getApplicationContext(), String.valueOf(mVstv.getPosition()) + ". " + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mVstv.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        mVstv.stopFlipping();
    }

    private void initView() {
        mVstv = (com.jlj.pmd.news.MarqueeView) findViewById(R.id.mv);
    }

}
