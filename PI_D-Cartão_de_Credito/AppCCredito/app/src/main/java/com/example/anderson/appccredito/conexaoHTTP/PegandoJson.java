package com.example.anderson.appccredito.conexaoHTTP;

import android.os.AsyncTask;

import com.example.anderson.appccredito.interfaces.RespostaWeb;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by anderson on 21/11/16.
 */
public class PegandoJson extends AsyncTask <String,String,List<Object>> {

    private RespostaWeb rtw;

    public PegandoJson(RespostaWeb context){
        this.rtw = context;
    }

    @Override
    protected List<Object> doInBackground(String... strings) {

        HttpURLConnection connection;



        return null;
    }

    @Override
    protected void onPostExecute(List<Object> o) {
        super.onPostExecute(o);
        rtw.callBack(o);
    }

}
