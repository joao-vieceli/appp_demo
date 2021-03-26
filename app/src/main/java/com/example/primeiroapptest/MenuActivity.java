package com.example.primeiroapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnBotoes, btnToast;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = MenuActivity.this;

        btnBotoes = findViewById(R.id.btnBotoes);
        btnToast = findViewById(R.id.btnToast);

        btnBotoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tela = new Intent(context, BotoesActivity.class);
                startActivity(tela);


            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exibirToast("!!!Bem-Vindo na tela de menu!!!");
            }
        });


    }
    private void exibirToast(String texto){
        try{
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        }catch (Exception ex){

        }
    }

}