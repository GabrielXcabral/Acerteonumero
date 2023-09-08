package com.example.sorte

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var numerosorteado: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultadonumerosorteado = findViewById<TextView>(R.id.numerosorteado);
        val botaochute = findViewById<Button>(R.id.botaochute);
        val chutedonumero = findViewById<EditText>(R.id.chutarnumero);
        val statusdojogo = findViewById<TextView>(R.id.status);
        val menornumero = findViewById<TextView>(R.id.menor);
        val maiornumero = findViewById<TextView>(R.id.maior);

        val radom = Random;
        numerosorteado = radom.nextInt(1,101);


        resultadonumerosorteado.text = "Nº : " + numerosorteado;

         botaochute.setOnClickListener(){
             val numerodigitado = chutedonumero.text.toString().toInt();
             val valorormin = menornumero.text.toString().toInt();
             val valormax =   maiornumero.text.toString().toInt();
             chutedonumero.setText("");

             if(numerodigitado < valorormin || numerodigitado > valormax){
                 statusdojogo.text = "Jogador Perdeu!";
                 botaochute.isEnabled = false;
             } else{
                 when {
                     numerodigitado < valorormin -> {
                         statusdojogo.text = "Jogador Perdeu!";
                     }
                     numerosorteado == numerodigitado -> {
                         statusdojogo.text = "Jogador Ganhou!"
                         statusdojogo.setTextColor(Color.GREEN);
                         botaochute.isEnabled = false;
                         resultadonumerosorteado.visibility = View.VISIBLE;
                     }
                     numerodigitado < numerosorteado ->{
                         val valor = numerodigitado + 1;
                         val valortexto = valor.toString()
                         menornumero.text = valortexto;

                     }
                     numerodigitado > numerosorteado -> {
                         val valor = numerodigitado - 1;
                         maiornumero.text = valor.toString();

                     }
                 }

             }
         }

        statusdojogo.setOnLongClickListener(){
            numerosorteado = radom.nextInt(1,101);
            resultadonumerosorteado.text = "Nº : " + numerosorteado;
            botaochute.isEnabled = true;
            resultadonumerosorteado.visibility = View.GONE;

            menornumero.text = "1";
            maiornumero.text = "100";
            statusdojogo.text = "Em execução..."
            statusdojogo.setTextColor(Color.RED);

            true;
        }


    }
}