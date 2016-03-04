package com.jap.semanaseis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Comunicacion.*;

public class Registro extends AppCompatActivity {

    TextView nombre, contra, confiContra;
    Button enviarReg;
    Tarea enviar;
    Mensaje msj;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        nombre = (TextView) findViewById(R.id.Txt_Nombre);
        contra = (TextView) findViewById(R.id.Txt_Contrasena);
        confiContra = (TextView) findViewById(R.id.Txt_ConfContrasena);

        enviarReg = (Button) findViewById(R.id.bt_EnviarRegist);

        enviarReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(contra.getText().toString().equals(confiContra.getText().toString())) {
                    msj = new Mensaje("Registro", nombre.getText().toString(), contra.getText().toString());
                    enviar = new Tarea();
                    enviar.execute(msj);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
