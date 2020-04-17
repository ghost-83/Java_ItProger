package com.first_app.itproger.itprogerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int count = 1;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imgFood);
    }

    public void OnClickBtn(View view) {
        count++;
        if(count > 4)
            count = 1;
        switch(count) {
            case 1:
                img.setImageResource(R.drawable.food_1);
                break;
            case 2:
                img.setImageResource(R.drawable.food_2);
                break;
            case 3:
                img.setImageResource(R.drawable.food_3);
                break;
            case 4:
                img.setImageResource(R.drawable.food_4);
                break;
        }
    }


}
