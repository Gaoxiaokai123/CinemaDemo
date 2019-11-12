package com.bawei.cinemademo.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.gengduoAdapter.GengduoReleaseAdapter;
import com.bawei.cinemademo.app.App;
import com.bawei.cinemademo.base.BaseActivity;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.bean.ReleaseMovieListBean;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.MovieByKeywordPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuosouActivity extends BaseActivity {


    @BindView(R.id.suosou_edit)
    EditText suosouEdit;
    @BindView(R.id.suosou_xrecy)
    XRecyclerView suosouXrecy;
    @BindView(R.id.sousuo_null_img)
    ImageView sousuoNullImg;
    @BindView(R.id.sousuo_null_textview)
    TextView sousuoNullTextview;
    @BindView(R.id.suosou_img)
    ImageView suosouImg;
    private GengduoReleaseAdapter gengduoReleaseAdapter;
    private MovieByKeywordPresenter movieByKeywordPresenter;
    int aa = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_suosou;
    }

    @Override
    protected void initView() {

        gengduoReleaseAdapter = new GengduoReleaseAdapter();
        movieByKeywordPresenter = new MovieByKeywordPresenter(new moviebykeyData());
        LinearLayoutManager manager = new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false);
        suosouXrecy.setLayoutManager(manager);
        suosouXrecy.setAdapter(gengduoReleaseAdapter);
        movieByKeywordPresenter.getRequestData("", 1, 6);


        suosouEdit.setOnClickListener(new View.OnClickListener() {

            private ViewGroup.LayoutParams layoutParams;

            @Override
            public void onClick(View v) {

//                if (trim != null) {
//
//                    if (gengduoReleaseAdapter == null) {
//                        //                    //图片文本控件可见
//                        sousuoNullImg.setVisibility(View.VISIBLE);
//                        sousuoNullTextview.setVisibility(View.VISIBLE);
//
//                    } else {
//                        sousuoNullImg.setVisibility(View.INVISIBLE);
//                        sousuoNullTextview.setVisibility(View.INVISIBLE);
//
//                        movieByKeywordPresenter.getRequestData(trim, 1, 6);
//                    }
//                }
                String trim = suosouEdit.getText().toString().trim();
                if (trim != null){
                    gengduoReleaseAdapter = new GengduoReleaseAdapter();
                    movieByKeywordPresenter = new MovieByKeywordPresenter(new moviebykeyData());
                    LinearLayoutManager manager = new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false);
                    suosouXrecy.setLayoutManager(manager);
                    suosouXrecy.setAdapter(gengduoReleaseAdapter);
                    movieByKeywordPresenter.getRequestData(trim, 1, 6);

                    layoutParams = suosouXrecy.getLayoutParams();

                    if (aa == 1) {
                        //隐藏item要把高度宽度设为0；
                        suosouXrecy.setVisibility(View.GONE);
                        layoutParams.height = 0;
                        layoutParams.width = 0;
                        suosouXrecy.setLayoutParams(layoutParams);
                        Toast.makeText(SuosouActivity.this, "数据为空", Toast.LENGTH_SHORT).show();
                    } else {
                        suosouXrecy.setVisibility(View.VISIBLE);
                        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                        suosouXrecy.setLayoutParams(layoutParams);
                        Toast.makeText(SuosouActivity.this, "有数据", Toast.LENGTH_SHORT).show();

                    }



                }



            }
        });

    }

    @OnClick(R.id.suosou_img)
    public void tuichu() {
        finish();
    }


    class moviebykeyData implements CallBackT<List<ReleaseMovieListBean>> {

        @Override
        public void onSuccess(List<ReleaseMovieListBean> releaseMovieListBeans) {
//            if (releaseMovieListBeans == null) {
//                //图片文本控件隐藏
//                sousuoNullImg.setVisibility(View.INVISIBLE);
//                sousuoNullTextview.setVisibility(View.INVISIBLE);
//            } else {
//                sousuoNullImg.setVisibility(View.VISIBLE);
//                sousuoNullTextview.setVisibility(View.VISIBLE);
//            }
            if (releaseMovieListBeans == null){
                aa = 1;
            }else {
                aa = 2;
            }
            gengduoReleaseAdapter.addAll(releaseMovieListBeans);
            gengduoReleaseAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
