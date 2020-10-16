package com.example.calculadoradegorjetaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBar;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editvalor);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal       = findViewById(R.id.textTotal);
        seekBar         = findViewById(R.id.seekBar);

//        Adicionar listener SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem )+ " %"); //round arredonda %
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public  void  calcular(){

//      Pegando o valor do id editValor
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_SHORT
            ).show();

        }else {

//      Converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

//            Calculo da Gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

//            Exibir a gorjeta e total
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + total);




        }

    }


}
