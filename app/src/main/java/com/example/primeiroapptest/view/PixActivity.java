package com.example.primeiroapptest.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primeiroapptest.R;
import com.example.primeiroapptest.model.Pix;

public class PixActivity extends AppCompatActivity {
    Button btnPagar, btnReceber;
    EditText txtValor;
    TextView lblChave, lblSaldoPix;
    Pix contaPix;
    Context context;
    SharedPreferences sharedPreferences;
    float valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);
        context = PixActivity.this;

        sharedPreferences =
                getSharedPreferences(getString(R.string.pref_key), context.MODE_PRIVATE);

        contaPix = new Pix();
        contaPix.setChave(sharedPreferences.getString("chavePix", ""));
        float saldo = sharedPreferences.getFloat("valor", 0);
        contaPix.setSaldo(saldo);
        contaPix.setCheque_especial(5000);

        btnReceber = findViewById(R.id.btnReceber);
        btnPagar = findViewById(R.id.btnPagar);
        txtValor = findViewById(R.id.txtValor);
        lblChave = findViewById(R.id.lblChavaPix);
        lblSaldoPix = findViewById(R.id.lblSaldoPix);



        if(txtValor.getText().toString().equals("0,00")){

            valor = 0;

        }



        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valor = Float.parseFloat(txtValor.getText().toString());
                float saldo = contaPix.getSaldo() - valor;
                float saldoAntigo = contaPix.getSaldo();
                float cheque = -contaPix.getCheque_especial();


                if((saldoAntigo - valor) >= cheque ){
                contaPix.setSaldo(saldo);
                atualizarDados();
                }else{
                    exibirToast("!!Você não pode ultrapassar o valor do cheque especial (5000)!!");
                }
            }
        });

        btnReceber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                valor = Float.parseFloat(txtValor.getText().toString());
                float saldo = contaPix.getSaldo() + valor;


                    contaPix.setSaldo(saldo);
                    atualizarDados();

                    exibirToast("Valor recebido: R$ "+ saldo);


            }
        });


        atualizarDados();
    }

    private void exibirToast(String texto){
        try{
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        }catch (Exception ex){
            Log.e("ERROR", ex.getMessage());

        }
    }
    private void atualizarDados(){
        try {

            lblSaldoPix.setText(String.valueOf(contaPix.getSaldo()));
            lblChave.setText(contaPix.getChave());

        }catch(Exception ex){



        }

    }


}