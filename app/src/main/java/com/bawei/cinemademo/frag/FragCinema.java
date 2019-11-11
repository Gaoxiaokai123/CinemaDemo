package com.bawei.cinemademo.frag;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.FragAdapter;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.frag.tab.TabNearby;
import com.bawei.cinemademo.frag.tab.TabRecommend;
import com.bawei.cinemademo.frag.tab.TabSelect;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Auther: 高晨凯
 * @Date: 2019/11/7 17:29:45
 * @Description:  影院模块
 */
public class FragCinema extends BaseFragment {

    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.head_text)
    ImageView headText;
    @BindView(R.id.frag_cinema_tab)
    TabLayout fragTab;
    @BindView(R.id.frag_cinema_pager)
    ViewPager fragPager;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_cinema;
    }

    @Override
    protected void initView() {

        TabNearby tabNearby = new TabNearby();
        TabRecommend tabRecommend = new TabRecommend();
        TabSelect tabSelect = new TabSelect();
        List<Fragment> frag = new ArrayList<>();
        frag.add(tabRecommend);
        frag.add(tabNearby);
        frag.add(tabSelect);

        FragAdapter fragAdapter = new FragAdapter(getChildFragmentManager(),frag);
        fragPager.setAdapter(fragAdapter);

        for (int i = 0; i < 3; i++) {
            fragTab.addTab(fragTab.newTab());
        }

        fragTab.setupWithViewPager(fragPager);

        fragTab.getTabAt(0).setText("推荐影院");
        fragTab.getTabAt(1).setText("附近影院");
        fragTab.getTabAt(2).setText("海淀区");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
