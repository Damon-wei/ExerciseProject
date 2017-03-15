package com.example.damon.fragmentbestproject.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.damon.fragmentbestproject.R;
import com.example.damon.fragmentbestproject.fragment.NewsContentFragment;
import com.example.damon.fragmentbestproject.model.News;

import java.util.List;

/**
 * Created by Damon on 2017/3/14.
 * Description :
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyVH>{
    private List<News> mNewsList;
    private boolean isTwoPane;
    private Context mContext;

    public NewsAdapter(Context context,List<News> mNewsList, boolean isTwoPane) {
        this.mNewsList = mNewsList;
        this.isTwoPane = isTwoPane;
        mContext = context;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        final MyVH myVH = new MyVH(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News news = mNewsList.get(myVH.getAdapterPosition());
                if (isTwoPane) {
                    /*NewsContentFragment newsContentFragment = (NewsContentFragment)((Activity)mContext).getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    (NewsContentFragment)newsContentFragment.refr*/
                }
            }
        });
        return null;
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    class MyVH extends RecyclerView.ViewHolder{

        TextView newsTitleText;
        public MyVH(View itemView) {
            super(itemView);
            newsTitleText = (TextView) itemView.findViewById(R.id.news_title);
        }
    }

}
