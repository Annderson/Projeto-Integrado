package com.example.anderson.appccredito.conexaoHTTP;

import android.os.AsyncTask;
import android.util.Log;

import com.example.anderson.appccredito.cliente.Cliente;
import com.example.anderson.appccredito.cliente.Fatura;
import com.example.anderson.appccredito.interfaces.RespostaWeb;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by anderson on 21/11/16.
 */
public class ConexaoHttp extends AsyncTask <String,String,List<Fatura>> {

    private RespostaWeb rtw;
    private Cliente cliente;

    public ConexaoHttp (Cliente cliente, RespostaWeb context){
        this.cliente = cliente;
        this.rtw = context;
    }

    @Override
    protected List<Fatura> doInBackground(String... strings) {

        HttpURLConnection connection;
        BufferedReader buffer = null;
        PrintWriter print = null;
        List<Fatura> faturas = null;

        try {

            final Gson gson = new Gson();

            URL url = new URL(strings[0]);
            connection = (HttpURLConnection)url.openConnection();
            connection.setDefaultUseCaches(false);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.connect();

            final OutputStream output = new BufferedOutputStream(connection.getOutputStream());
            final JsonWriter writer = new JsonWriter(new OutputStreamWriter(output,"UTF-8"));
            writer.setIndent(" ");
            gson.toJson(cliente,Cliente.class,writer);
            writer.flush();
            writer.close();

            int respostaE = connection.getResponseCode();
            Log.d("Erro", "Codigo da resposta: "+respostaE);
            if (respostaE < 200 || respostaE > 299){
                Log.e("Falha","Falha na conexao");
            }
            else if (respostaE == 401){
                Log.e("Erro","Cliente não encontrado");
            }

            buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder dados = new StringBuilder();
            String linha;

            while ((linha = buffer.readLine()) != null){
                dados.append(linha);

            }

            Type type = new TypeToken<List<Fatura>>(){}.getType();
            faturas = gson.fromJson(dados.toString(),type);


        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return faturas;
    }

    @Override
    protected void onPostExecute(List<Fatura> o) {
        super.onPostExecute(o);
        rtw.callBack(o);
    }

}
