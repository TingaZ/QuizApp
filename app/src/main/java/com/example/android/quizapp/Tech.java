package com.example.android.quizapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tech extends AppCompatActivity {
    private static RadioGroup radio_first_Q;
    private static RadioButton radio_b;

    private static RadioGroup radio_second_Q;
    private static RadioButton radio_b2;

    private static RadioGroup radio_third_Q;
    private static RadioButton radio_b3;

    private static RadioGroup radio_fourth_Q;
    private static RadioButton radio_b4;

    private static RadioGroup radio_fifth_Q;
    private static RadioButton radio_b5;

    private static Button button_sbm;

    int x, y, u, z, w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        submitTechnologyButton();
    }

    //This method nests every submit button activity
    public void submitTechnologyButton() {
        radio_first_Q = (RadioGroup) findViewById(R.id.rg_first_q);
        radio_second_Q = (RadioGroup) findViewById(R.id.rg_second_g);
        radio_third_Q = (RadioGroup) findViewById(R.id.rg_third_q);
        radio_fourth_Q = (RadioGroup) findViewById(R.id.rg_fourth_q);
        radio_fifth_Q = (RadioGroup) findViewById(R.id.rg_fifth_q);
        button_sbm = (Button) findViewById(R.id.submit_button);

        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            int selected_id = radio_first_Q.getCheckedRadioButtonId();
                            radio_b = (RadioButton) findViewById(selected_id);

                            int selected_Id = radio_second_Q.getCheckedRadioButtonId();
                            radio_b2 = (RadioButton) findViewById(selected_Id);

                            int selected_ID = radio_third_Q.getCheckedRadioButtonId();
                            radio_b3 = (RadioButton) findViewById(selected_ID);

                            int selectedId = radio_fourth_Q.getCheckedRadioButtonId();
                            radio_b4 = (RadioButton) findViewById(selectedId);

                            int selectedID = radio_fifth_Q.getCheckedRadioButtonId();
                            radio_b5 = (RadioButton) findViewById(selectedID);

                            //FIRST QUESTION
                            if (radio_b.getText().equals("Programma 101")) {
                                x = 1;
                            } else {
                                x = 0;
                            }

                            //SECOND QUESTION
                            if (radio_b2.getText().equals("HMD")) {
                                y = 1;
                            } else {
                                y = 0;
                            }

                            //THIRD QUESTION
                            if (radio_b3.getText().equals("Nougat")) {
                                z = 1;
                            } else {
                                z = 0;
                            }

                            //FOURTH QUESTION
                            if (radio_b4.getText().equals("1976")) {
                                w = 1;
                            } else {
                                w = 0;
                            }

                            //FIFTH QUESTION
                            if (radio_b5.getText().equals("Telkom")) {
                                u = 1;
                            } else {
                                u = 0;
                            }

                            int e = x + y + z + w + u;
                            int results = (int) (e * 100.0f) / 5;
                            if (results >= 100) {
                                showMessage("Congratulations!!!!", "You are an Intermediate Master In Technology." + " \nResults: " + results + "%");
                                radio_first_Q.clearCheck();
                                radio_second_Q.clearCheck();
                                radio_third_Q.clearCheck();
                                radio_fourth_Q.clearCheck();
                                radio_fifth_Q.clearCheck();
                            } else {
                                showMessage("Sorry, you did not make it!", "You can try again.." + " \nResults: " + results + "%");
                                radio_first_Q.clearCheck();
                                radio_second_Q.clearCheck();
                                radio_third_Q.clearCheck();
                                radio_fourth_Q.clearCheck();
                                radio_fifth_Q.clearCheck();
                            }
                        } catch (Exception e) {
                            Toast.makeText(Tech.this, "Please Complete  All Questions.", Toast.LENGTH_SHORT).show();
                            radio_first_Q.clearCheck();
                            radio_second_Q.clearCheck();
                            radio_third_Q.clearCheck();
                            radio_fourth_Q.clearCheck();
                            radio_fifth_Q.clearCheck();
                        }
                    }
                }
        );
    }

    public void showMessage(String name1, String name2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(name1);
        builder.setMessage(name2);
        builder.show();
    }

}
