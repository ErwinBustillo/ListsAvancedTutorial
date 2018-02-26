package com.erwin.listcards.listandcards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erwin on 2/25/2018.
 */

public class RecyclerActivity extends AppCompatActivity implements ViewAdapter.RecycleClickListener{
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        List<Information> data = new ArrayList<>();
        String[] titulo = getResources().getStringArray(R.array.data);//el array que viene de string.xml

        for (int i=0; i<titulo.length;i++){
            Information info = new Information(titulo[i]);
            data.add(info);
        }

        viewAdapter = new ViewAdapter(this,data);
        viewAdapter.setRecycleClickListener(this);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void itemClick(View view, int position) {
        Log.d("Lalo","click sobre"+position);
    }
    public void onClickButtonRow(View view) {
        Log.d("ITEM", "Click en boton " + view.getTag());
    }
}
