package com.ghost.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jgabrielfreitas.core.BlurImageView;

import static java.lang.Float.*;

public class MainActivity extends AppCompatActivity {

    private TextView viewTon, viewKg, viewGr;
    private EditText editText;
    private Spinner spinner;
    private String selected;
    float intUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        guiAction();
    }

    public void guiAction(){
        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        viewTon = findViewById(R.id.textView_ton);
        viewKg = findViewById(R.id.textView_kg);
        viewGr = findViewById(R.id.textView_gr);
        BlurImageView blurImageView = findViewById(R.id.dogBlurImageView);
        blurImageView.setBlur(2);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                intUser = parseFloat(editText.getText().toString());
                guiMath();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selected = spinner.getSelectedItem().toString();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор: " + selected, Toast.LENGTH_SHORT);
                toast.show();
                guiMath();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void guiMath(){

        switch (selected){

            case "Тонны":
                viewTon.setText(String.valueOf(intUser));
                viewKg.setText(String.valueOf(intUser * 1000));
                viewGr.setText(String.valueOf(intUser * 1000000));
                break;

            case "Киллограммы":
                viewTon.setText(String.valueOf(intUser / 1000));
                viewKg.setText(String.valueOf(intUser));
                viewGr.setText(String.valueOf(intUser * 1000));
                break;

            case "Граммы":
                viewTon.setText(String.valueOf(intUser / 1000000));
                viewKg.setText(String.valueOf(intUser / 1000));
                viewGr.setText(String.valueOf(intUser));
                break;
        }
    }
}
