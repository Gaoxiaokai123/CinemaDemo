package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.ComingSoonMovieListBean;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 高晨凯
 * @Date: 2019/11/7 19:54:00
 * @Description:  即将上映
 */
public class ComingSoonMovieListAdapter extends RecyclerView.Adapter<ComingSoonMovieListAdapter.myHolder> {
   List<ComingSoonMovieListBean> list = new ArrayList<>();

    public void addAll(List<ComingSoonMovieListBean> data){
        if (data!=null)
            list.addAll(data);
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_home_comingsoonrecy, viewGroup, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder myHolder, int i) {
        Date date = new Date(list.get(i).releaseTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        myHolder.data.setText(simpleDateFormat.format(date)+"上映");

        myHolder.name.setText(list.get(i).name+"");
        myHolder.xiagnkan.setText(list.get(i).wantSeeNum+"想看");

        Glide.with(myHolder.itemView.getContext()).load(list.get(i).imageUrl)
                   .into(myHolder.img);
//        myHolder.img.setImageURI(list.get(i).imageUrl);
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class myHolder extends RecyclerView.ViewHolder {

//        private final SimpleDraweeView img;
        private final ImageView img;
        private final TextView name;
        private final TextView data;
        private final TextView xiagnkan;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.frag_home_commingsoon_img);
            name = itemView.findViewById(R.id.frag_home_commingsoon_name);
            data = itemView.findViewById(R.id.frag_home_commingsoon_data);
            xiagnkan = itemView.findViewById(R.id.frag_home_commingsoon_xiangkan);

        }
    }
}
