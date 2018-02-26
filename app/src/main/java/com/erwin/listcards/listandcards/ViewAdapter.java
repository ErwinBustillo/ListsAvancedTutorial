package com.erwin.listcards.listandcards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by erwin on 2/25/2018.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private int count;
    private String Tag = "recyclerDebug";
    private LayoutInflater inflater;
    private List<Information> data = Collections.emptyList();
    private RecycleClickListener recycleClickListener;

    public ViewAdapter(Context context, List<Information> data){
        inflater=LayoutInflater.from(context);
        this.data=data;
        count=0;
    }
    public void setRecycleClickListener(RecycleClickListener listener){
        recycleClickListener =listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(Tag,"onCreateViewHolder count"+count);
        count++;
        View v = inflater.inflate(R.layout.row,parent,false);
        MyViewHolder holder= new MyViewHolder(v);
        v.setTag(count);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(Tag,"onBindViewHolder"+holder.itemView.getTag());
        Information information = data.get(position);
        holder.tv.setText(information.title);
        holder.bt.setTag(position);
        holder.bt.setText(""+position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv;
        private Button bt;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv =(TextView) itemView.findViewById(R.id.textViewRow);
            bt = (Button) itemView.findViewById(R.id.botonRow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (recycleClickListener !=null){
                recycleClickListener.itemClick(view,getPosition());
            }
        }
    }

    public interface RecycleClickListener {
        public void itemClick(View view, int position);
    }
}
