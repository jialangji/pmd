package com.jlj.pmd;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadFileActivity extends AppCompatActivity {

    @BindView(R.id.file_reader)
    FileReaderView fileReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);
        ButterKnife.bind(this);

        fileReader.show("file:///android_asset/test.pdf");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (null!=fileReader) {
            fileReader.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
