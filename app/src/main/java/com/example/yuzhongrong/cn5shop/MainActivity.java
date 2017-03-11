package com.example.yuzhongrong.cn5shop;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.yuzhongrong.cn5shop.fragment.AroundFragment;
import com.example.yuzhongrong.cn5shop.fragment.MainFragment;
import com.example.yuzhongrong.cn5shop.fragment.MineFragment;
import com.example.yuzhongrong.cn5shop.fragment.MoreFragment;

public class MainActivity extends AppCompatActivity {


    private Class[] fragments=new Class[]{
            MainFragment.class,
            AroundFragment.class,
            MineFragment.class,
            MoreFragment.class


    };

    private int[] selectors=new int[]{

            R.drawable.ic_home_tab_index,
            R.drawable.ic_home_tab_near,
            R.drawable.ic_home_tab_my,
            R.drawable.ic_home_tab_more

    };

    private String[] tabTitles = new String[]{"首页","周边","我的","更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {

        inittabhost();
    }

    private void inittabhost() {

        FragmentTabHost tabhost= (FragmentTabHost) findViewById(R.id.tabhost);
        tabhost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i=0;i<fragments.length;i++){


            View root_item=this.getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView iv= (ImageView) root_item.findViewById(R.id.iv);
            TextView tv= (TextView) root_item.findViewById(R.id.tv);
            iv.setImageResource(selectors[i]);
            tv.setText(tabTitles[i]);
            tabhost.addTab(tabhost.newTabSpec(""+i).setIndicator(root_item),fragments[i],null);

        }


    }
}
