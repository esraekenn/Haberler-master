package com.pordiva.esraeken.haberler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pordiva.esraeken.haberler.model.Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esraeken on 05/09/16.
 */
public class newsadapter extends RecyclerView.Adapter<newsviewholder> {
    private List<Data> newsList=new ArrayList<>();
    private Context c;
    private Picasso picasso;

    public newsadapter(Context context) {
        newsList=new ArrayList<>();
        this.c = context;
        picasso = Picasso.with(context);
    }

    @Override
    public newsviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satir, parent, false);

        newsviewholder newsviewholder = new newsviewholder(view, c);
        return newsviewholder;
    }


    @Override
    public void onBindViewHolder(newsviewholder holder, final int position)

    {
        holder.title.setText(Html.fromHtml(newsList.get(position).getTitle()));
        holder.desc.setText(Html.fromHtml(newsList.get(position).getExcerpt()));
        picasso.load("http:"+newsList.get(position).getImages().getBox())
                .centerCrop()
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, Detail.class);
                i.putExtra("photo","http:"+newsList.get(position).getImages().getPage()) ;
                i.putExtra("title",(newsList.get(position).getTitle()));
                i.putExtra("name",(newsList.get(position).getCategory().name));
                i.putExtra("excerpt",(newsList.get(position).getExcerpt()));
                c.startActivity(i);
            }
        });

    }
    public void updateList(List<Data> list)
    {
        newsList=list;
        notifyDataSetChanged();
    }

    public void clear()
    {
        newsList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
