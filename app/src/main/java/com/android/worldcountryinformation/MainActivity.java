package com.android.worldcountryinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView listView;
    private SearchView searchView;
    private  String [] countryNames;
    ArrayAdapter<String> adapter1;
    int[] flags = {R.drawable.afghanistan,R.drawable.albania,R.drawable.algeria,R.drawable.andorra,
    R.drawable.angola,R.drawable.antigua_and_barbuda,R.drawable.argentina,R.drawable.armenia,R.drawable.austria,
    R.drawable.azerbaijan,R.drawable.bangladesh};
    //private String[] countryDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchViewId);

        String [] countryNames = getResources().getStringArray(R.array.country_names);
        //String [] countryDescrip = getResources().getStringArray(R.array.country_descrip);

       CustomAdapter adapter = new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(adapter);

        // For Search View
        adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_text_view,R.id.countryNameId, countryNames);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String value =adapter1.getItem(position);

                //String value1 =countryDescrip[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);
                return false;
            }
        });



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }
}