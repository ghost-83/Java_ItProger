package com.first_app.itproger.itproger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_next, btn_true, btn_false, btn_restart;
    private TextView txt;
    private int quest_index = 0;
    private int count = 0;

    private TrueFalse[] questions = new TrueFalse[] {
            new TrueFalse(R.string.quest_1, true),
            new TrueFalse(R.string.quest_2, false),
            new TrueFalse(R.string.quest_3, true),
            new TrueFalse(R.string.quest_4, true),
            new TrueFalse(R.string.quest_5, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_false = (Button)findViewById(R.id.btn_false);
        btn_true = (Button)findViewById(R.id.btn_true);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_restart = (Button)findViewById(R.id.btn_restart);
        txt = (TextView)findViewById(R.id.result_txt);

        final int question = questions[quest_index].getQuestion();
        txt.setText(question);

        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        btn_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest_index < questions.length - 1) {
                    quest_index++;
                    final int question = questions[quest_index].getQuestion();
                    txt.setText(question);
                    btn_true.setVisibility(View.VISIBLE);
                    btn_false.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.INVISIBLE);
                } else {
                    txt.setText("Вы все прошли! Результат: " + count + "/" + questions.length);
                    txt.setTextColor(Color.GREEN);
                    btn_next.setVisibility(View.INVISIBLE);
                    btn_restart.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quest_index = 0;
                final int question = questions[quest_index].getQuestion();
                txt.setText(question);
                txt.setTextColor(Color.BLACK);
                btn_true.setVisibility(View.VISIBLE);
                btn_false.setVisibility(View.VISIBLE);
                btn_restart.setVisibility(View.INVISIBLE);
            }
        });


    }

    private void checkAnswer(boolean answer_user) {
        boolean answer = questions[quest_index].isTrueQuestion();
        if(answer_user == answer) {
            Toast.makeText(MainActivity.this, "Вы молодец, все верно", Toast.LENGTH_LONG).show();
            count++;
        } else
            Toast.makeText(MainActivity.this, "Вы ответили не верно", Toast.LENGTH_LONG).show();

        btn_true.setVisibility(View.INVISIBLE);
        btn_false.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);
    }
}
