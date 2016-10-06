package com.pordiva.esraeken.haberler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by esraeken on 05/09/16.
 */
public class newsviewholder extends RecyclerView.ViewHolder
{

    public ImageView image;
    public TextView title;
    public TextView desc;
    private Context context;
    public newsviewholder(View itemView, Context c)
    {
        super(itemView);
        context=c;
       image= (ImageView) itemView.findViewById(R.id.imageView2);
        title=(TextView)itemView.findViewById(R.id.textView);
        desc=(TextView)itemView.findViewById(R.id.textView2);
    }
}
