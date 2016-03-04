package com.jap.semanaseis;

import android.os.AsyncTask;

import Comunicacion.Comunicacion;

class Tarea extends AsyncTask<Object, Integer, Object> {

    private Comunicacion com;

    protected Object doInBackground(Object... params) {
        com.getInstance().enviar(params[0]);
        return null;
    }
}
