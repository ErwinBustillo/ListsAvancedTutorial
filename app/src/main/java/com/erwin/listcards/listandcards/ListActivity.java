package com.erwin.listcards.listandcards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by erwin on 2/25/2018.
 */

public class ListActivity extends AppCompatActivity {

    ListView lista;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(R.id.lista);

        String [] datos =  new String[]{
                "Uno",
                "Dos",
                "Tres",
                "Cuatro",
                "Cinco"
        };

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datos);
        customAdapter = new CustomAdapter(this,datos);

        lista.setAdapter(customAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void onClickButtonRow(View view) {
        Log.d("ITEM","Click en boton "+view.getTag());
        String [] datos =  new String[]{
                "Uno",
                "Dos"

        };
        customAdapter.setData(datos);
        lista.setAdapter(customAdapter);
    }

}
