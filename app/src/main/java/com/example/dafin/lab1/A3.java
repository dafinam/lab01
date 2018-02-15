package com.example.dafin.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

    }
    public void task3(View v){
        EditText text = findViewById(R.id.a3Text);
        String t4 = text.getText().toString();
        Intent intent = new Intent(A3.this, A2.class);
        intent.putExtra("t4", t4);
        setResult(RESULT_OK, intent);
        finish();

    }
    public void onBackPressed() {
        startActivity(new Intent(A3.this, A2.class));
        finish();
    }
}
