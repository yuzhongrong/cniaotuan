package com.example.yuzhongrong.cn5shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager vp=null;
    private Button btn=null;
    private int[] imgres=new int[]{

           R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3,
            R.mipmap.guide_4,

    };

    private List<View> views=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        initview();



    }

    private void initview() {


        initViewPager();


    }

    private void initViewPager() {
        vp= (ViewPager) findViewById(R.id.viewPager);
        btn= (Button) findViewById(R.id.btn_start);
        views.clear();
        for (int id:imgres) {


           View v= getLayoutInflater().inflate(R.layout.guideitem,null);
            ImageView imv= (ImageView) v.findViewById(R.id.viewpager_item);
            imv.setBackgroundResource(id);
            views.add(v);



        }



        vp.setAdapter(new ViewPagerAdapter(imgres,views));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                if(position==imgres.length-1){

                    btn.setVisibility(View.VISIBLE);

                }else{
                    btn.setVisibility(View.GONE);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void frist_click(View view) {

        startActivity(new Intent().setClass(this,MainActivity.class));
        this.finish();

    }


    class  ViewPagerAdapter extends PagerAdapter{

        int[] imgres;
        List<View> views;

        public ViewPagerAdapter(int[] res,List<View> views){

              this.imgres=res;
              this.views=views;


        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

           View v=views.get(position);
            container.addView(v);

            return v;
        }

        @Override
        public int getCount() {
            return imgres.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           //super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }
    }



}
