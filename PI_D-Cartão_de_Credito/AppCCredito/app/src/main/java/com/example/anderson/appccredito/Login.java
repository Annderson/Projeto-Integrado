package com.example.anderson.appccredito;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anderson.appccredito.auxiliares.Validador;
import com.example.anderson.appccredito.conexaoHTTP.PegandoJson;
import com.example.anderson.appccredito.interfaces.RespostaWeb;

import java.util.List;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Login extends AppCompatActivity {

    private EditText etCpf;
    private EditText etConta;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences shar = getSharedPreferences("Prefr", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = shar.edit();
        final Validador validi;

        if (!shar.getBoolean("logged",false)){

            setContentView(R.layout.login);
            obterIds();
            validi = new Validador(this);
            pegarDadosWeb();

            btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(validi.validetion(etCpf) && validi.validetion(etConta)) {
                        editor.putBoolean("logged", true);
                        editor.apply();
                        loadLista();
                    }
                }
            });

        }else {
            loadLista();
        }

    }

    private void pegarDadosWeb() {
        new PegandoJson(new RespostaWeb() {
            @Override
            public void callBack(List<Object> response) {
                //faturas = response;
            }
        }).execute("http://localhost:8080/SiteCCredito/ObterJsonServlet");
    }

    private void loadLista() {
        Intent iAbrir = new Intent(this,ListFatura.class);
        startActivity(iAbrir);
        this.finish();
    }

    private void obterIds() {
        etCpf = (EditText)this.findViewById(R.id.etCpf);
        etConta = (EditText)this.findViewById(R.id.etConta);
        btnEntrar = (Button)this.findViewById(R.id.btnLogar);
        final MaskEditTextChangedListener mask = new MaskEditTextChangedListener("###.###.###-##",etCpf);
        etCpf.addTextChangedListener(mask);
    }
}
