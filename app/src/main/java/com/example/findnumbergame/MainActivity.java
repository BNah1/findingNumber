package com.example.findnumbergame;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner1);
        String[] items = {"Vie", "EN"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Xử lý khi một mục được chọn
                String selectedItem = (String) parentView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,  "select" + selectedItem, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                // Xử lý khi không có mục nào được chọn
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển Intent sang layout startGame
                Intent intent = new Intent(MainActivity.this, startGame.class);
                startActivity(intent);
            }
        });
    }

}
