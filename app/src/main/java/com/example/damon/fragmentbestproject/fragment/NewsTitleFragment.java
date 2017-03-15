package com.example.damon.fragmentbestproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.damon.fragmentbestproject.R;
import com.example.damon.fragmentbestproject.activity.NewsContentActivity;
import com.example.damon.fragmentbestproject.model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Damon on 2017/3/14.
 * Description :
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NewsAdapter mAdapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.visible_layout) != null) {
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }

    public List<News> getNews() {
        List<News> list = new ArrayList<>();
        for (int i = 0; i <= 50; i++){
            News news = new News();
            news.setTitle("这是新闻标题"+ i);
            news.setContent(getRandomLengthContent("这是新闻内容"+ i +"。"));
            list.add(news);
        }
        return list;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++){
            builder.append(content);
        }
        return builder.toString();
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterVH>{
        private List<News> mNewsList;

        public NewsAdapter(List<News> mNewsList) {
            this.mNewsList = mNewsList;
        }

        @Override
        public NewsAdapterVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final NewsAdapterVH vh = new NewsAdapterVH(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(vh.getAdapterPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else {
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(NewsAdapterVH holder, int position) {
            holder.tvNewsTitle.setText(mNewsList.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class NewsAdapterVH extends RecyclerView.ViewHolder{

            TextView tvNewsTitle;
            public NewsAdapterVH(View itemView) {
                super(itemView);
                tvNewsTitle = (TextView) itemView.findViewById(R.id.news_title);
            }
        }
    }
}
