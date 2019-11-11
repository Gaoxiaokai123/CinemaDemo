package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.ReleaseMovieListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 高晨凯
 * @Date: 2019/11/7 19:54:00
 * @Description:  正在热映
 */
public class ReleaseMovieListAdapter extends RecyclerView.Adapter<ReleaseMovieListAdapter.myHolder> {
   List<ReleaseMovieListBean> list = new ArrayList<>();

    public void addAll(List<ReleaseMovieListBean> data){
        if (data!=null)
            list.addAll(data);
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_home_releaserecy, viewGroup, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder myHolder, int i) {
        myHolder.name.setText(list.get(i).name+"");
        myHolder.price.setText(list.get(i).score+"分");
//        Glide.with(myHolder.itemView.getContext()).load(list.get(i).imageUrl)
//                .into(myHolder.img);
//        myHolder.img.setImageBitmap(list.get(i).imageUrl);
        myHolder.img.setImageURI(list.get(i).imageUrl);
//        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView)findViewById(R.id.sdv_2);
//        simpleDraweeView2.setImageURI(url);

    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class myHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView name;
        private final TextView price;
//        private final TextView xiagnkan;

        public myHolder(@NonNull View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.frag_home_release_img);
//            name = itemView.findViewById(R.id.frag_home_release_name);
//            price = itemView.findViewById(R.id.frag_home_release_data);
//            xiagnkan = itemView.findViewById(R.id.frag_home_release_xiangkan);
            img = itemView.findViewById(R.id.frag_home_release_img);
            name = itemView.findViewById(R.id.frag_home_release_name);
            price = itemView.findViewById(R.id.frag_home_release_price);


        }
    }
}
