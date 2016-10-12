package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String instructionText = "Please select a topic on the below drop down box to get started with your quiz's and click \"Proceed\" " +
            "when done. Don't feel daunted should you not get 100%, try until you get it right. Zack wishes you a very good luck... Enjoy!!!";
    int position;
    int p1 = 1;
    int p2 = 2;
    int p3 = 3;
    Button proceedButton;
    Button btnInstructions;
    private String array_spinner[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        array_spinner = new String[4];
        array_spinner[0] = "---Select Topic---";
        array_spinner[1] = "Religion";
        array_spinner[2] = "Politics";
        array_spinner[3] = "Technology";

        btnInstructions = (Button) findViewById(R.id.btn_Instructions);


        final Spinner s = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);


        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                        final Intent intent1 = new Intent(MainActivity.this, Religion.class);
                        final Intent intent2 = new Intent(MainActivity.this, Politics.class);
                        final Intent intent3 = new Intent(MainActivity.this, Tech.class);

                        proceedButton = (Button) findViewById(R.id.proceed_button);
                        proceedButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                //Religion questions
                                if (position == p1)
                                    startActivity(intent1);

                                    //Politics questions
                                else if (position == p2)
                                    startActivity(intent2);

                                    //Technology questions
                                else if (position == p3)
                                    startActivity(intent3);

                            }
                        });

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(MainActivity.this, "Spinner Unselected", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnInstructions.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        instructionClick("Quiz Instructions", instructionText);
                    }
                }
        );

    }

    public void instructionClick(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
