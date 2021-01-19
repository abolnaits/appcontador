package com.example.layoutconstra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
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
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        txtContador = (TextView) findViewById(R.id.txtContador);
        txtContador.setText("0");
        contador = 0;
        //EditText estara a la escucha cuando se cierra el teclado
        EventoTeclado tecladoEv = new EventoTeclado();
        txtNumero.setOnEditorActionListener(tecladoEv);
    }

    //Clase Interna para establecer un Listener
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            //Si se cierra el teclado
            if(i== EditorInfo.IME_ACTION_DONE){
                reset(null);
            }
            return false;
        }
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
                //txtContador.setText(String.valueOf(contador));
            }
        }
        txtContador.setText(String.valueOf(contador));

        //setear();
    }

    public void reset(View Vista){
        contador = 0;
        System.out.println("XXX");
        //Obtengo el valor del input
        try{
            contador = Integer.parseInt(txtNumero.getText().toString());
        }catch (Exception e){
            contador = 0;
        }

        txtContador.setText(String.valueOf(contador));
        //Obtengo el metodo de entrada
        //Teclado
        InputMethodManager teclado = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        teclado.hideSoftInputFromWindow(txtContador.getWindowToken(),0);
    }


}