package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Damon on 2017/4/5.
 * Description :
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHoler>{

    private Context mContext;
    private List<Image> imageList;

    public ImageAdapter(Context mContext, List<Image> imageList) {
        this.mContext = mContext;
        this.imageList = imageList;
    }


    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        final ViewHoler viewHoler = new ViewHoler(view);
        viewHoler.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Image image = imageList.get(viewHoler.getAdapterPosition());
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra(DetailsActivity.IMAGE_NAME,image.getName());
                intent.putExtra(DetailsActivity.IMAGE_PATH,image.getPath());
                mContext.startActivity(intent);

            }
        });
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Image image = imageList.get(position);
        holder.name.setText(image.getName());
        Glide.with(mContext).load(image.getPath()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        CardView cardView;

        public ViewHoler(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            image = (ImageView) itemView.findViewById(R.id.iv_image);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
