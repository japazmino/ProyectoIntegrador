package com.jap.semanaseis;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button registrar, ingresar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = (Button) findViewById(R.id.bt_Registrar);
        ingresar = (Button) findViewById(R.id.bt_Ingresar);

        registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Ingresar.class);
                startActivity(i);
            }
        });
    }
}
