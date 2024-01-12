package com.example.calculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculadoraimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView resultado2 = findViewById(R.id.resultado2);
        TextView resultado = findViewById(R.id.resultado);
        TextView classificacao = findViewById(R.id.classificacao);
        Button botaoCalcular = findViewById(R.id.button);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }

            private void calcular(){
                EditText pesoValor = findViewById(R.id.pesoValor);
                EditText alturaValor = findViewById(R.id.alturaValor);


                double pesoValor2 = Double.parseDouble(pesoValor.getText().toString());
                double alturaValor2 = Double.parseDouble(alturaValor.getText().toString());
                double calculo = pesoValor2 / (alturaValor2 * alturaValor2);

                if (calculo < 18.5){
                    classificacao.setText("Baixo peso");
                } else if (calculo < 24.9) {
                    classificacao.setText("Peso normal");
                } else if (calculo < 29.9) {
                    classificacao.setText("Sobrepeso");
                } else if (calculo < 34.9) {
                    classificacao.setText("Obesidade grau I");
                } else if (calculo < 39.9) {
                    classificacao.setText("Obesidade grau II");
                }else {
                    classificacao.setText("Obesidade grau III");
                }
                resultado.setText(String.valueOf(calculo));
                resultado2.setVisibility(View.VISIBLE);
                classificacao.setVisibility(View.VISIBLE);
                resultado.setVisibility(View.VISIBLE);
            }
        });
    }
}