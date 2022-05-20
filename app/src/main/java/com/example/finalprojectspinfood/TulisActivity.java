package com.example.finalprojectspinfood;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TulisActivity extends AppCompatActivity {
    Button button;
    EditText ET1;
    protected Cursor cursor;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulis);
        dataBase = new DataBase(this);
        ET1 = findViewById(R.id.mkn);
        button = findViewById(R.id.BtnSAVE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBase.getWritableDatabase();
                db.execSQL("insert into makanan(mkn) values('" +
                        ET1.getText().toString()+ "')");
                Toast.makeText(TulisActivity.this, "Makanan Telah Di Tambahkan",
                        Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}