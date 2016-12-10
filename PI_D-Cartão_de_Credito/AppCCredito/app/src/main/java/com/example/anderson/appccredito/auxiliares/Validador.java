package com.example.anderson.appccredito.auxiliares;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anderson on 09/11/16.
 */
public class Validador {

    private Context context;

    public Validador(Context context){
        this.context = context;
    }

    public boolean validetion(EditText etC, EditText etS){

        String vlCpf = etC.getText().toString();
        String vlS = etS.getText().toString();

        if (vlCpf.equals("") && vlS.equals("")){
            Toast.makeText(context, "Preencha todos os campo",Toast.LENGTH_LONG).show();
            return false;
        }
        else if (vlCpf.equals("")){
            Toast.makeText(context, "Campo CPF vazio",Toast.LENGTH_LONG).show();
            return false;
        }
        else if (vlS.equals("")){
            Toast.makeText(context, "Campo Senha vazio",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}
