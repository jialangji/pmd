package com.jlj.pmd;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * effect :
 * Created by Cattle_Wei on 2019/1/8.
 */
public class PayPasswordView extends LinearLayout implements View.OnClickListener, PasswordEditText.PasswordFullListener {
    private LinearLayout mKeyBoardView;
    private PasswordEditText mPasswordEditText;
    private niuweineedListener niuweineedListener;
    private String niuweiNeedPassword;

    public PayPasswordView(Context context) {
        this(context, null);
    }

    public PayPasswordView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PayPasswordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.pay_password_layout, this);
        mKeyBoardView = findViewById(R.id.keyboard);
        mPasswordEditText = findViewById(R.id.passwordEdt);
        mPasswordEditText.setPasswordFullListener(this);
        setItemClickListener(mKeyBoardView);
    }

    /**
     * 给每一个自定义数字键盘上的View 设置点击事件
     *
     * @param view
     */
    private void setItemClickListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = ( ViewGroup ) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                //不断的给里面所有的View设置setOnClickListener
                View childView = ((ViewGroup) view).getChildAt(i);
                setItemClickListener(childView);
            }
        } else {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            if ((( TextView ) v).getText().toString().trim().equals("删除")){
                mPasswordEditText.deletePassword();
            }else {
                if (mPasswordEditText.length()<6) {
                    String number = ((TextView) v).getText().toString().trim();
                    mPasswordEditText.addPassword(number);
                }
            }

        }
        if (v instanceof ImageView) {
            mPasswordEditText.deletePassword();
        }
    }

    public String getNiuweiNeedPassword() {
        return niuweiNeedPassword;
    }

    @Override
    public void passwordFull(String password) {
        niuweiNeedPassword=password;
        if (null!=niuweineedListener){
            niuweineedListener.niuweineedFull(password);
        }

    }


    //接口回调 牛伟说不要了
    public interface niuweineedListener{
        void niuweineedFull(String password);
    }

    public void setNiuweineedListener(PayPasswordView.niuweineedListener niuweineedListener) {
        this.niuweineedListener = niuweineedListener;
    }
}
