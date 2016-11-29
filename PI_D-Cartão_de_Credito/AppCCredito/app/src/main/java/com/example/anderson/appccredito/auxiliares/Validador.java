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

    public boolean validetion(EditText et){

        String valorRecebido = et.getText().toString();

        if (valorRecebido.equals("")){
            Toast.makeText(context, "Preencha todos os campo",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}
