package com.example.anderson.appccredito;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.anderson.appccredito.auxiliares.MyAdapterList;
import com.example.anderson.appccredito.cliente.Fatura;
import com.example.anderson.appccredito.conexaoHTTP.PegandoJson;
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

       // povoar();
        obterJson();

        rvLista.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 1);
        rvLista.setLayoutManager(grid);
        adapter = new MyAdapterList(this,faturas);
        adapter.notifyDataSetChanged();
        rvLista.setAdapter(adapter);

    }


    private void povoar() {

        faturas = new ArrayList<>();

        Fatura f1 = new Fatura();
        f1.setLocal("Pizzaria");
        f1.setValor(500.00);

        Fatura f2 = new Fatura();
        f2.setLocal("Padaria");
        f2.setValor(700.00);

        faturas.add(f1);
        faturas.add(f2);
    }

    private void obterJson() {
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
