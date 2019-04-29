package com.example.franky.restaurantapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class viewDishes extends AppCompatActivity {

    ListView list2;
    String [] dishTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dishes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dishes");

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Resources resource = getResources();
        dishTitles = resource.getStringArray(R.array.dishesTitles);
        list2 = (ListView) findViewById(R.id.list2);

        secondAdapter adapter = new secondAdapter(this,dishTitles);

        list2.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    class secondAdapter extends ArrayAdapter<String>{
        Context context;
        String dishes [];

        secondAdapter(Context c,String []dishTitles){
            super(c,R.layout.row2,R.id.text3,dishTitles);
            this.context =c;
            this.dishes = dishTitles;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row2 = layoutInflater.inflate(R.layout.row2,parent,false);
            TextView title = (TextView) row2.findViewById(R.id.text3);

            title.setText(dishTitles[position]);

            return row2;
        }
    }
}
