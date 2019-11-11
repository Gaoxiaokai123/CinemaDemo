package com.bawei.cinemademo.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.FragAdapter;
import com.bawei.cinemademo.base.BaseActivity;
import com.bawei.cinemademo.frag.tab.TabSelect;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GengDuoActivity extends BaseActivity {

    @BindView(R.id.tab_gengduo_tab)
    TabLayout tabGdTab;
    @BindView(R.id.tab_gengduo_frag)
    ViewPager tabGdPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_geng_duo;
    }

    @Override
    protected void initView() {
        TabSelect tabSelect = new TabSelect();
        List<Fragment> frag = new ArrayList<>();
//        frag.add(tabRecommend);
//        frag.add(tabNearby);
//        frag.add(tabSelect);
//
//        FragAdapter fragAdapter = new FragAdapter(getChildFragmentManager(),frag);
//        fragPager.setAdapter(fragAdapter);
//
//        for (int i = 0; i < 3; i++) {
//            fragTab.addTab(fragTab.newTab());
//        }
//
//        fragTab.setupWithViewPager(fragPager);
//
//        fragTab.getTabAt(0).setText("推荐影院");
//        fragTab.getTabAt(1).setText("附近影院");
//        fragTab.getTabAt(2).setText("海淀区");
//

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
