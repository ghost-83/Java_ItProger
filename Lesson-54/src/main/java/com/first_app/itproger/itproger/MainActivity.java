package com.first_app.itproger.itproger;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBase dbHelper;
    private ListView all_tasks;
    private ArrayAdapter<String> my_adapter;
    private EditText field_text;
    private SharedPreferences prefs;
    private String name_list;

    private TextView info_app;
    private String text_for_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info_app = (TextView)findViewById(R.id.info_app);
        info_app.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_text));

        dbHelper = new DataBase(this);
        all_tasks = (ListView)findViewById(R.id.tasks_list);
        field_text = (EditText)findViewById(R.id.list_name);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        name_list = prefs.getString("list_name", "");
        field_text.setText(name_list);

        changeTextAction();
        loadAllTasks();
    }

    private void changeTextAction() {
        field_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences.Editor editPrefs = prefs.edit();
                editPrefs.putString("list_name", String.valueOf(field_text.getText()));
                editPrefs.apply();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void loadAllTasks() {
        ArrayList<String> taskList = dbHelper.getAllTasks();
        if(my_adapter == null) {
            my_adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.txt_task, taskList);
            all_tasks.setAdapter(my_adapter);
        } else {
            my_adapter.clear();
            my_adapter.addAll(taskList);
            my_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_new_task) {
            final EditText userTaskGet = new EditText(this);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Добавление нового задания")
                    .setMessage("Чтобы вы хотели добавить?")
                    .setView(userTaskGet)
                    .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String task = String.valueOf(userTaskGet.getText());
                            dbHelper.insertData(task);
                            loadAllTasks();
                        }
                    })
                    .setNegativeButton("Ничего", null)
                    .create();
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View view) {
        View parent = (View)view.getParent();
        TextView txt_task = (TextView)parent.findViewById(R.id.txt_task);
        text_for_delete = String.valueOf(txt_task.getText());

        parent.animate().alpha(0).setDuration(1300).withEndAction(new Runnable() {
            @Override
            public void run() {
                dbHelper.deleteData(text_for_delete);
                loadAllTasks();
            }
        });
    }

}