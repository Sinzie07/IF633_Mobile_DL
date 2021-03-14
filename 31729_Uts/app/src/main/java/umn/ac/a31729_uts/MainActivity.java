package umn.ac.a31729_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        URI builder;
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin") &&
                        etPassword.getText().toString().equals("admin")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_ceklis);
                    builder.setTitle("Login Berhasil!");
                    builder.setMessage("Welcome")

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener())
                    @Override
                    public void onClick (DialogInterface Timer dialog;
                    dialog,int which){
                        dialog.cancel();
                    }
                }
            }

            ;
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else {
            Toast.makeText(getApplicationContext(),
                    "Invalid Username & Password",Toast.LENGTH_SHORT).show();
        }};
    }
}