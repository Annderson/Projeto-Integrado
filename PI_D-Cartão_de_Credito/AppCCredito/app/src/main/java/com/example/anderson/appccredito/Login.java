package com.example.anderson.appccredito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anderson.appccredito.auxiliares.Validador;
import com.example.anderson.appccredito.cliente.Cliente;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class Login extends AppCompatActivity {

    private EditText etCpf;
    private EditText etSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Validador validi;

        obterIds();
        validi = new Validador(this);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validi.validetion(etCpf,etSenha)) {
                    final Cliente c = new Cliente();
                    c.setCpf(etCpf.getText().toString());
                    c.setSenha(etSenha.getText().toString());
                    loadLista(c);
                }
            }
        });

    }

    private void loadLista(Cliente cliente) {

        Bundle b = new Bundle();
        b.putSerializable("cliente",cliente);

        Intent iAbrir = new Intent(this,ListFatura.class);
        iAbrir.putExtras(b);
        startActivity(iAbrir);
        this.finish();
    }

    private void obterIds() {
        etCpf = (EditText)this.findViewById(R.id.etCpf);
        etSenha = (EditText)this.findViewById(R.id.etSenha);
        btnEntrar = (Button)this.findViewById(R.id.btnLogar);
        final MaskEditTextChangedListener mask = new MaskEditTextChangedListener("###.###.###-##",etCpf);
        etCpf.addTextChangedListener(mask);
    }
}
