package br.fecapccp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Obesidade2Activity extends AppCompatActivity {

    private TextView txtFeedback;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade2);

        // Inicializando os componentes
        txtFeedback = findViewById(R.id.textResultado);
        btnFechar = findViewById(R.id.btnFechar);

        // Recebendo os dados da Intent
        Intent intent = getIntent();
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);
        double imc = intent.getDoubleExtra("imc", 0);
        String classificacao = intent.getStringExtra("classificacao");

        // Criando a mensagem com os dados
        String mensagem = "Seu peso: " + peso + " kg\n" +
                "Sua altura: " + altura + " m\n" +
                "Seu IMC: " + String.format("%.2f", imc) + "\n" +
                "Classificação: " + classificacao + "\n\n" +
                "Alerta! Obesidade grau 2. É importante buscar orientação médica!";


        txtFeedback.setText(mensagem);


        btnFechar.setOnClickListener(view -> {
            Intent voltar = new Intent(this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });
    }
}