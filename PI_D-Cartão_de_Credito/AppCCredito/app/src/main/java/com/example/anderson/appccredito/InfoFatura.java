package com.example.anderson.appccredito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.anderson.appccredito.cliente.Fatura;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public class InfoFatura extends AppCompatActivity {

    private TextView tviIdFat;
    private TextView tviNumCartao;
    private TextView tviLocal;
    private TextView tviValor;
    private TextView tviData;
    private TextView tviHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_fatura);

        obterIds();
        final Format format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        final Fatura fat = (Fatura) getIntent().getSerializableExtra("fatura");

        tviIdFat.setText("Numero da fatura: " +fat.getIdFatura());
        tviNumCartao.setText("Numero do cartão: "+ fat.getNumero_cartao());
        tviLocal.setText("Local: " + fat.getLocal());
        tviValor.setText("Valor: " + format.format(fat.getValor()));
        tviData.setText("Data: "+ fat.getData_acao());
        tviHorario.setText("Horario: "+ fat.getHorario());

    }

    private void obterIds() {

        tviIdFat = (TextView)this.findViewById(R.id.tviIdFatura);
        tviNumCartao = (TextView)this.findViewById(R.id.tviNumeroCartao);
        tviLocal = (TextView)this.findViewById(R.id.tviLocal);
        tviValor = (TextView)this.findViewById(R.id.tviValor);
        tviData = (TextView)this.findViewById(R.id.tviData);
        tviHorario = (TextView)this.findViewById(R.id.tviHorario);

    }
}
