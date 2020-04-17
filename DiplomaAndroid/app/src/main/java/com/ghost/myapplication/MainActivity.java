package com.ghost.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> map;
    private ArrayList<String> arrayList;
    private ListView listView;
    private EditText name, link;
    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        name = findViewById(R.id.editName);
        link = findViewById(R.id.editLink);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        arrayList = new ArrayList<>();
        map = new HashMap<>();
    }

    public void setLinks(View view) {
        if(name.getText().length() > 0) {
            if(link.getText().length() > 0) {
                if(!map.containsKey(name.getText().toString())) {
                    arrayList.add(name.getText().toString());
                    map.put(name.getText().toString(), link.getText().toString());
                    name.setText("");
                    link.setText("");

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, R.id.textView, arrayList);
                    listView.setAdapter(adapter);

                    btn.setText("Готово");
                }else
                    btn.setText("Ссылка существует");
            }else
                btn.setText("Отсутствует ссылка");
        }else
            btn.setText("Отсутствует название");
    }

    public void getLink(View view) {
        TextView linkText = view.findViewById(R.id.textView);
        Intent openLink = new Intent(Intent.ACTION_VIEW, Uri.parse("http:" + map.get(linkText.getText().toString())));
        startActivity(openLink);
    }
}
