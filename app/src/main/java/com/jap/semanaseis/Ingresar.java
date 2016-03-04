package com.jap.semanaseis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Comunicacion.*;

public class Ingresar extends AppCompatActivity {

    TextView nombre, contra;
    Button enviarIng;
    Tarea enviar;
    Mensaje msj;
    private Comunicacion com;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar);
        nombre = (TextView) findViewById(R.id.Txt_NombreUsuario);
        contra = (TextView) findViewById(R.id.Txt_Contra);

        enviarIng = (Button) findViewById(R.id.bt_EnviarIngreso);
        enviarIng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                msj = new Mensaje("Ingreso", nombre.getText().toString(), contra.getText().toString());
                enviar = new Tarea();
                enviar.execute(msj);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
