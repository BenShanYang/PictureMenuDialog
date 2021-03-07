package com.yk.picturemenudialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yk.picturemenu.PictureDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        new PictureDialog(this) {
            @Override
            public void album(PictureDialog dialog) {
                Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void camera(PictureDialog dialog) {
                Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
            }
        }.show();
    }
}
