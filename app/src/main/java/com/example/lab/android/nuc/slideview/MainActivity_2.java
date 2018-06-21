package com.example.lab.android.nuc.slideview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity_2 extends AppCompatActivity {
    private ImageView mImgBg;
    private ImageView mImgGif;
    private TextView mTvTitle;
    private TextView mTvBottom;
    private  int mImgPath;

    public MainActivity_2() {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_2 );
        mImgBg = findViewById(R.id.img_bg);
        mTvTitle = findViewById(R.id.tv_title);
        mImgGif = findViewById(R.id.img_gif);
        mTvBottom = findViewById( R.id.tv_bottom );
        if (getIntent() != null){
            mImgPath = getIntent().getIntExtra("img",R.mipmap.skid_right_3);
            String title = getIntent().getStringExtra("title");
            String detail = getIntent().getStringExtra( "detial" );
            mTvTitle.setText(title);
            mTvBottom.setText( detail);
            Glide.with(this).load(mImgPath).asBitmap().diskCacheStrategy( DiskCacheStrategy.SOURCE ).into(mImgBg);
            new Handler().postDelayed( new Runnable() {
                @Override
                public void run() {
                    Glide.with(MainActivity_2.this).load(mImgPath).asGif().diskCacheStrategy( DiskCacheStrategy.SOURCE ).into(mImgGif);
                }
            },1000);

        }
    }
}
