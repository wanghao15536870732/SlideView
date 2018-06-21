package com.example.lab.android.nuc.slideview;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.IntegerRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

public class MainActivity extends AppCompatActivity {

    private TextView wanghao;
    private ImageView houyue;
    private RecyclerView mRecyclerView;
    private SkidRightLayoutManager mSkidRightLayoutManager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
    }

    private void initView(){
        mRecyclerView = findViewById( R.id.recycler_view );
        houyue = (ImageView) findViewById( R.id.houyue );
        mSkidRightLayoutManager = new SkidRightLayoutManager( 1.5f,0.85f );
        mRecyclerView.setLayoutManager( mSkidRightLayoutManager );
        mRecyclerView.setAdapter( new MyAdapter() );
        houyue.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this,EchelonActivity.class );
                startActivity( intent );
            }
        } );
        wanghao = (TextView) findViewById( R.id.wanghao );
        wanghao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this,SlideActivity.class );
                startActivity( intent );
            }
        } );
    }


    //适配器
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private int [] imgs = {
                R.mipmap.skid_right_1,
                R.mipmap.skid_right_2,
                R.mipmap.skid_right_3,
                R.mipmap.skid_right_4,
                R.mipmap.skid_right_5,
                R.mipmap.skid_right_6,
                R.mipmap.skid_right_7,
        };
        String[] titles = {"Acknowledge", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};

        String[] detials = {"Whatever you go，go with all your heart.                              无论做什么事，一定要全力以赴",
                        "Never a negative acknowledge why it is impossible.                       永远也不要消极地认为什么事是不可能的",
                        "Keep conscience clear，then never fear.                                   问心无愧，永无畏惧。",
                        "Time is the best doctor, but a poor beautician.                           时间是最好的医生，也是最差的美容师",
                        "Don't try so hard， the best things come when you least expect them to。                                                  不要着急，最好的总会在最不经意的时候出现。",
                        "Never a negative acknowledge why it is impossible.                        永远也不要消极地认为什么事是不可能的。",};

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from( MyApplication.sContext ).inflate(R.layout.item_skid_right_1,parent,false );
            return new ViewHolder( view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            Glide.with( MyApplication.sContext ).load( imgs[position % 7] ).asGif().diskCacheStrategy( DiskCacheStrategy.SOURCE ).into( holder.imgBg );
            holder.tvTitle.setText( titles[position % 6] );
            holder.tvBottom.setText( detials[position % 6] );
            holder.imgBg.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( MainActivity.this,MainActivity_2.class );
                    intent.putExtra("img", imgs[position % 7]);
                    intent.putExtra("title", titles[position % 6]);
                    intent.putExtra( "detial",detials[position % 6]);
                    Pair<View, String> p1 = Pair.create((View)holder.imgBg, "img_view_1");
                    Pair<View, String> p2 = Pair.create((View)holder.tvTitle, "title_1");
                    Pair<View, String> p3 = Pair.create((View)holder.tvBottom, "tv_bottom");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, p1,p2,p3);
                    startActivity(intent,options.toBundle());
                }
            } );
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgBg;
            TextView tvTitle;
            TextView tvBottom;

            public ViewHolder(View itemView) {
                super(itemView);
                imgBg = itemView.findViewById(R.id.img_bg);
                tvTitle = itemView.findViewById(R.id.tv_title);
                tvBottom = itemView.findViewById(R.id.tv_bottom);
            }
        }
    }
}
