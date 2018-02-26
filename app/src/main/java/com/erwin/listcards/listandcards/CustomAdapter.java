package com.erwin.listcards.listandcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by erwin on 2/25/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] data;

    public CustomAdapter(Context context, String[] values){
        this.context=context;
        this.data=values;
    }
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String text = data[i];

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row,null); // seteamos el view customizado row
        }

        TextView tv= (TextView) view.findViewById(R.id.textViewRow);
        tv.setText(text);
        Button bt = (Button) view.findViewById(R.id.botonRow);
        bt.setFocusable(false);
        bt.setFocusableInTouchMode(false);
        bt.setTag(i);
        return view;
    }

    public void setData(String[] datos) {
        this.data = datos;
    }
}
