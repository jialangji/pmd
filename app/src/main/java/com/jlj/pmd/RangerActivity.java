package com.jlj.pmd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jlj.pmd.news.RangBarEvent;
import com.jlj.pmd.news.RangeSeekbar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RangerActivity extends AppCompatActivity {

    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_right)
    TextView tvRight;
    String arrays[] = {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45","50"};
    @BindView(R.id.seekbar)
    RangeSeekbar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranger);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(RangBarEvent event) {
        int mesg = event.getMsg();
        int right=event.getRight();
        int type = event.getType();
        if (type == 1) {
            //左边游标对应值
            tvLeft.setText("左边:" + arrays[mesg]);
            Log.e("TAG", "左边:" + arrays[mesg] );
            Log.e("TAG", "右边:" + arrays[right] );
            tvRight.setText("右边：" + arrays[right]);
        } else if (type == 2) {
            Log.e("TAG", "左边:" + arrays[mesg] );
            Log.e("TAG", "右边:" + arrays[right] );
            //右边游标对应值
            tvLeft.setText("左边：" + arrays[mesg]);
            tvRight.setText("右边：" + arrays[right]);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}
