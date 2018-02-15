package com.example.dafin.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class A1 extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES="MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        Spinner spinner = findViewById(R.id.a1Dropdown);// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.week_array, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        int savedPos = sharedpreferences.getInt("selected", 4);
        spinner.setSelection(savedPos);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id)
            {
                Object item = adapterView.getItemAtPosition(position);
                if (item != null)
                {
                    int selected = position;
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putInt("selected", selected); // Storing integer
                    editor.commit(); // commit changes

                    //Testing toast
                    //Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                // TODO Auto-generated method stub
            }
        });


/*
        int selected = spinner.getSelectedItem();
        SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
        editor.putString("selected", selected);
        editor.apply();
        */
    }

    public void task1(View v) {
        //startActivity(new Intent(A1.this, A2.class));
        EditText text = findViewById(R.id.a1Input);
        String hello = text.getText().toString();
        Intent intent = new Intent(A1.this, A2.class);
        intent.putExtra("hello", hello);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
        moveTaskToBack(true);
    }


}
