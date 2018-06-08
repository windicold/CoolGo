package com.zzwq.coolgo.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzwq.coolgo.R;
import com.zzwq.coolgo.model.User;
import com.zzwq.coolgo.ui.base.BaseActivity;
import com.zzwq.coolgo.ui.fragment.AroundFragment;
import com.zzwq.coolgo.ui.fragment.HomeFragment;
import com.zzwq.coolgo.ui.fragment.MeFragment;
import com.zzwq.coolgo.ui.fragment.MoreFragment;

public class MainActivity extends BaseActivity {

    private FragmentTabHost tabhost;

    private Class[] fragments = new Class[]{
            HomeFragment.class,AroundFragment.class,
            MeFragment.class,MoreFragment.class};
    private int[] resTitles = new int[] {
            R.string.tab_title_home,R.string.tab_title_around,
            R.string.tab_title_me,R.string.tab_title_more};
    private int[] icons = new int[]{
            R.drawable.tab_home_selector,R.drawable.tab_around_selector,
            R.drawable.tab_me_selector,R.drawable.tab_more_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setViewWithIntentData();
    }

    private void setViewWithIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            User user = (User) intent.getSerializableExtra(RegisterActivity.INTENT_USER);
            if (user != null) {
                tabhost.setCurrentTab(2);
            }
        }
    }

    private void initViews() {
        tabhost = (FragmentTabHost) findViewById(R.id.main_tabHost);
        tabhost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i = 0; i < fragments.length; i++) {
            View view = getLayoutInflater().inflate(R.layout.item_tab,null);
            ImageView tabIcon = (ImageView) view.findViewById(R.id.item_tab_iv);
            TextView tabTitle = (TextView) view.findViewById(R.id.item_tab_tv);
            tabIcon.setImageResource(icons[i]);
            tabTitle.setText(resTitles[i]);
            tabhost.addTab(tabhost.newTabSpec(""+i).setIndicator(view),fragments[i],null);
        }
    }


}
