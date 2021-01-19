package com.example.layoutconstra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    public int contador;
    //Vistas
    TextView txtNumero;
    TextView txtContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        txtNumero = (TextView) findViewById(R.id.txtNumero);
        txtContador = (TextView) findViewById(R.id.txtContador);
        txtContador.setText("0");
        contador = 0;
    }

    //Setear el valor del textp
    /*
    public void setear(){
        TextView txtContador = (TextView) findViewById(R.id.txtContador);
        txtContador.setText(String.valueOf(contador));
    }
    */
    public void sumar(View Vista){
        contador = contador + 1;
        txtContador.setText(String.valueOf(contador));
        //setear();
    }

    public void restar(View Vista){
        contador = contador - 1;
        if(contador<0){
            //Obtengo el checkbox
            CheckBox ckNegativo = (CheckBox) findViewById(R.id.ckNegativo);
            if(ckNegativo.isChecked()){
                //txtNumero.setText(String.valueOf(contador));
            }else{
                contador = 0;
                //txtNumero.setText(String.valueOf(contador));
            }
        }
        txtContador.setText(String.valueOf(contador));

        //setear();
    }

    public void reset(View Vista){
        contador = 0;
        //setear();
    }
}