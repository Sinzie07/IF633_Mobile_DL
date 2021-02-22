package com.example.week04_31729;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse;
    private TextView tvJawaban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIsian = findViewById(R.id.isian);
        etUrl = findViewById(R.id.url);
        btnBrowse = findViewById(R.id.buttonBrowse);
        btnKirim = findViewById(R.id.buttonKirim);
        btnKirim.setOnClickListener(new View.OnClickListener() {



        }
            public void onClick(View v) {
                Intent intentDua = new Intent(MainActivity.this,
                        ActivityDua.class);
                String isian = etIsian.getText().toString();
                intentDua.putExtra("PesanDariMain",isian);
                startActivityForResult(intentDua, 1);
            }
        }
            public void onActivityResult(int requestCode,
                                         int resultCode, Intent android.content.Intent data;
        data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == 1) {
                    if (resultCode == RESULT_OK) {
                        String jawaban = data.getStringExtra("Jawaban");
                        tvJawaban.setText(jawaban);
                        tvJawaban = findViewById(R.id.jawaban);
                    } 
                }
        }
}