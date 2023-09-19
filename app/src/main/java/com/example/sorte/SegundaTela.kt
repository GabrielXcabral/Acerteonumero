package com.example.sorte

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val nomedigitado = findViewById<EditText>(R.id.inputnome);
        val bntenviar = findViewById<Button>(R.id.bntEnviar);
        val bntvoltar = findViewById<Button>(R.id.bntVoltar);
        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView);

        backgroundImageView.setImageResource(R.drawable.vitoria);



        bntvoltar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java);
            startActivity(intent);
        }

        bntenviar.setOnClickListener(){
            val nomedoganhador = nomedigitado.text.toString();
            nomedigitado.setText("");
            val sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
            val editor = sharedPreferences.edit();
            editor.putString("nomeganhador", nomedoganhador);
            editor.apply();
        }

    }

    /*fun voltar(view: View){
        val intent = Intent(this,MainActivity::class.java);
        startActivity(intent);
    }*/
}