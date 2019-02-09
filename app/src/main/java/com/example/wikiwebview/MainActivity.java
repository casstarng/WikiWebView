package com.example.wikiwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String animals[] = { "Dog", "Cat", "Hamster", "Sloth", "Turtle", "Rabbit", "Bird", "Fish", "Snake" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Set array onto list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animals);
        listView.setAdapter(arrayAdapter);

        // Listen for click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                Log.i("test", index + "");
                // Send to WikiPage with animal data
                Intent myIntent = new Intent(getApplicationContext(),WikiPage.class);
                myIntent.putExtra("animal", animals[index]);
                startActivity(myIntent);
            }
        });
    }
}
