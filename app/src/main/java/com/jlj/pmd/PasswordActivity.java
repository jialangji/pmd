package com.jlj.pmd;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasswordActivity extends AppCompatActivity {

    @BindView(R.id.botton)
    Button botton;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        ButterKnife.bind(this);

        PayPasswordView payPasswordView = new PayPasswordView(this);
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(payPasswordView);
        bottomSheetDialog.setCanceledOnTouchOutside(true);

        payPasswordView.setNiuweineedListener(password -> Toast.makeText(PasswordActivity.this, "牛伟要的密码" + payPasswordView.getNiuweiNeedPassword(), Toast.LENGTH_SHORT).show());

    }

    @OnClick(R.id.botton)
    public void onViewClicked() {
        if (bottomSheetDialog.isShowing()){
            bottomSheetDialog.dismiss();
        }else{
            bottomSheetDialog.show();
        }

    }
}
