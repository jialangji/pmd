package com.jlj.pmd;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsReaderView;

public class FileReaderView extends FrameLayout implements TbsReaderView.ReaderCallback {
    private TbsReaderView mTbsReaderView;
    private Context context;

    public FileReaderView(Context context) {
        this(context, (AttributeSet)null, 0);
    }

    public FileReaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FileReaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTbsReaderView = this.getTbsReaderView(context);
        this.addView(this.mTbsReaderView, new LayoutParams(-1, -1));
        this.context = context;
    }

    private TbsReaderView getTbsReaderView(Context context) {
        return new TbsReaderView(context, this);
    }

    public void show(String filePath) {
        if(!TextUtils.isEmpty(filePath)) {
            Bundle localBundle = new Bundle();
            localBundle.putString("filePath", filePath);
            localBundle.putString("tempPath", Environment.getExternalStorageDirectory() + "/TbsReaderTemp");
            if(this.mTbsReaderView == null) {
                this.mTbsReaderView = this.getTbsReaderView(this.context);
            }

            boolean bool = this.mTbsReaderView.preOpen(this.getFileType(filePath), false);
            if(bool) {
                this.mTbsReaderView.openFile(localBundle);
            }
        } else {
            Log.e("TAG", "文件路径无效！");
        }

    }

    public void onCallBackAction(Integer integer, Object o, Object o1) {
    }

    public void stop() {
        if(this.mTbsReaderView != null) {
            this.mTbsReaderView.onStop();
        }

    }

    private String getFileType(String paramString) {
        String str = "";
        if(TextUtils.isEmpty(paramString)) {
            return str;
        } else {
            int i = paramString.lastIndexOf(46);
            if(i <= -1) {
                return str;
            } else {
                str = paramString.substring(i + 1);
                return str;
            }
        }
    }
}
