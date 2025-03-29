package br.fecapccp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnT2Calcular;
    private Button btnT2Clear;
    private Button btnT2Close;

    private EditText editTextPeso;
    private EditText editTextAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Log.i("Ciclo de vida", "Tela 2 - onCreate");

        btnT2Calcular = findViewById(R.id.btnCalcular);
        btnT2Clear = findViewById(R.id.btnClear);
        btnT2Close = findViewById(R.id.btnClose);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);

        // Botão Calcular IMC
        btnT2Calcular.setOnClickListener(view -> {
            String pesoStr = editTextPeso.getText().toString();
            String alturaStr = editTextAltura.getText().toString();

            if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);
                double imc = peso / (altura * altura);
                String classificacao = "";
                Class<?> activityDestino = null;

                if (imc < 18.5) {
                    classificacao = "Abaixo do peso";
                    activityDestino = AbaixoDoPesoActivity.class;
                } else if (imc < 25) {
                    classificacao = "Peso normal";
                    activityDestino = PesoNormalActivity.class;
                } else if (imc < 30) {
                    classificacao = "Sobrepeso";
                    activityDestino = SobrepesoActivity.class;
                } else if (imc < 35) {
                    classificacao = "Obesidade grau 1";
                    activityDestino = Obesidade1Activity.class;
                } else if (imc < 40) {
                    classificacao = "Obesidade grau 2";
                    activityDestino = Obesidade2Activity.class;
                } else {
                    classificacao = "Obesidade grau 3";
                    activityDestino = Obesidade3Activity.class;
                }

                Intent intent = new Intent(this, activityDestino);
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", imc);
                intent.putExtra("classificacao", classificacao);
                startActivity(intent);
            } else {
                if (pesoStr.isEmpty()) {
                    editTextPeso.setError("Digite o peso");
                }
                if (alturaStr.isEmpty()) {
                    editTextAltura.setError("Digite a altura");
                }
            }
        });

        // Botão Limpar
        btnT2Clear.setOnClickListener(view -> {
            editTextPeso.setText("");
            editTextAltura.setText("");
            editTextPeso.requestFocus();
        });

        // Botão Fechar
        btnT2Close.setOnClickListener(view -> {
            finish();
        });

        // Ajuste de layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "Tela 2 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Tela 2 - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "Tela 2 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", "Tela 2 - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "Tela 2 - onStart");
    }
}

