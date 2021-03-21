package umn.ac.a31729_uts;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import static umn.ac.a31729_uts.MainActivity.ditelLagus;

public class TampilLagu extends AppCompatActivity {

    RecyclerView recyclerView;
    MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_lagu);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        if(!(ditelLagus.size() < 1)){
            musicAdapter = new MusicAdapter(this, ditelLagus);
            recyclerView.setAdapter(musicAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Profile){
            Intent i = new Intent(TampilLagu.this, profile.class);
            startActivity(i);
            finish();
            return true;
        }else if(id == R.id.Logout){
            Intent i = new Intent(TampilLagu.this, MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showStartDialog() {
        new AlertDialog.Builder(this).setTitle("Selamat Datang").setMessage("Sinzie Winata - 00000031729").setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }




}


