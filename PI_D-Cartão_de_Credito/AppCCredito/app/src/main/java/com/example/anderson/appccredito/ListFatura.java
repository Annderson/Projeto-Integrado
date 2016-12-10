package com.example.anderson.appccredito;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.anderson.appccredito.auxiliares.MyAdapterList;
import com.example.anderson.appccredito.cliente.Cliente;
import com.example.anderson.appccredito.cliente.Fatura;
import com.example.anderson.appccredito.conexaoHTTP.ConexaoHttp;
import com.example.anderson.appccredito.interfaces.RespostaWeb;

import java.util.ArrayList;
import java.util.List;

public class ListFatura extends AppCompatActivity {

    private RecyclerView rvLista;
    private List<Fatura> faturas;
    private MyAdapterList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fatura);

        Cliente cliente = (Cliente) getIntent().getSerializableExtra("cliente");

        faturas = new ArrayList<>();

        obterIds();

        rvLista.setHasFixedSize(true);
        LinearLayoutManager grid = new LinearLayoutManager(this);
        rvLista.setLayoutManager(grid);
        adapter = new MyAdapterList(this,faturas);
        adapter.notifyDataSetChanged();
        rvLista.setAdapter(adapter);
        pegarDadosWeb(cliente);

    }

    private void pegarDadosWeb(Cliente cliente) {

        ConexaoHttp cnx = (ConexaoHttp) new ConexaoHttp(cliente, new RespostaWeb() {
            @Override
            public void callBack(List<Fatura> response) {
                //faturas.clear();
                faturas.addAll(response);
                adapter.notifyDataSetChanged();
            }
        }).execute("http://192.168.15.2:8080/SiteCCredito/ObterJsonServlet");

    }

    private void obterIds() {
        rvLista = (RecyclerView)this.findViewById(R.id.rvListFatura);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnFechar:
                loadFechar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void loadFechar() {
        SharedPreferences sharedPr = getSharedPreferences("Prefr", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPr.edit();
        editor.putBoolean("logged",false);
        editor.commit();
        this.finish();
    }
}
