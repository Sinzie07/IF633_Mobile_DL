package umn.ac.a31729_uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btSubmit;
    public static final int REQUEST_CODE = 1;

    public static ArrayList<DitelLagu> ditelLagus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission();
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        URI builder;
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("uasmobile") &&
                        etPassword.getText().toString().equals("uasmobilegenap")) {
                    Intent intentTampilLagu = new Intent(MainActivity.this, TampilLagu.class);
                    startActivity(intentTampilLagu);
                }else{
                    Toast.makeText(MainActivity.this, "Password atau Username salah !!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void permission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , REQUEST_CODE);
        } else {
            ditelLagus = getAllAudio(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                //Do whatever you want permission related;
                ditelLagus = getAllAudio(this);
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , REQUEST_CODE);
        }
    }

    public static ArrayList<DitelLagu> getAllAudio(Context context) {
        ArrayList<DitelLagu> tempAudioList = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ARTIST
        };
        Cursor cursor = context.getContentResolver().query(uri, projection,
                null, null, null);
        if (cursor != null)
        {
            while(cursor.moveToNext())
            {
                String title =  cursor.getString(0);
                String duration =  cursor.getString(1);
                String path =  cursor.getString(2);
                String artist =  cursor.getString(3);

                DitelLagu ditelLagu = new DitelLagu(path, title, artist, duration);
                Log.e("Path : " + path, "title: " + title);
                tempAudioList.add(ditelLagu);
            }
            cursor.close();
        }
        return tempAudioList;
    }
}