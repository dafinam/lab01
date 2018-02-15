package com.example.dafin.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class A2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        Intent intent = getIntent(); //creating the intent

        String value = intent.getStringExtra("hello"); //getting the string value from activity 1

        TextView text = findViewById(R.id.a2InputFromA1);
        text.setText("Hello " + value);

    }
    public void task2(View v){

        startActivityForResult(new Intent(A2.this, A3.class), 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String t4 = data.getStringExtra("t4");
        TextView text = findViewById(R.id.a2InputFromA3);
        text.setText("From A3: " + t4);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(A2.this, A1.class));
        finish();
    }


}
