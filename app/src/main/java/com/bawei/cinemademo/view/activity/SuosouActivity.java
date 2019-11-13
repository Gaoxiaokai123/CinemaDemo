package com.bawei.cinemademo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.HotMovieListAdapter;
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

        gengduoReleaseAdapter.setOnClickTopItemListener(new HotMovieListAdapter.OnClickTopItemListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(SuosouActivity.this,MoiveDetailActivity.class);
                intent.putExtra("movieId",movieId);
                Log.e("aa", "接口传值: "+ movieId);
                startActivity(intent);
            }
        });

        suosouEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = suosouEdit.getText().toString().trim();
                    if (TextUtils.isEmpty(key)) {
//                        PromptBoxUtils.showCustomMsg("请输入您想要搜索的地址");
                        return true;
                    }
                    //  下面就是大家的业务逻辑
//                    searchPoi(key);
                    //  这里记得一定要将键盘隐藏了
//                    hideKeyBoard();
                    return true;
                }
                return true;
            }
        });





        suosouEdit.setOnClickListener(new View.OnClickListener() {

            private ViewGroup.LayoutParams layoutParams;

            @Override
            public void onClick(View v) {

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
