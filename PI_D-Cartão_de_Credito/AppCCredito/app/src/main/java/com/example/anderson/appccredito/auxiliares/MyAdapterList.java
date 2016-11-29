package com.example.anderson.appccredito.auxiliares;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anderson.appccredito.Lancamento;
import com.example.anderson.appccredito.R;
import com.example.anderson.appccredito.cliente.Fatura;

import java.text.Format;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by anderson on 06/11/16.
 */
public class MyAdapterList extends RecyclerView.Adapter<MyAdapterList.MyViewHolder> {

    private List<Fatura> faturas;
    private Context context;

    public MyAdapterList (Context context, List<Fatura> faturas){
        this.faturas = faturas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itens_da_lista, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Format formato = NumberFormat.getCurrencyInstance(Locale.PRC);
        holder.fatura = faturas.get(position);

        holder.local.setText("Local: " + holder.fatura.getLocal());
        holder.valor.setText("Valor: " + formato.format(holder.fatura.getValor()));

    }

    @Override
    public int getItemCount() {
        if (faturas == null)
            return 0;

        return faturas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Fatura fatura;
        TextView local;
        TextView valor;
        ImageButton ibnDetalhe;

        public MyViewHolder(View itemView) {
            super(itemView);
            local = (TextView)itemView.findViewById(R.id.tvLocal);
            valor = (TextView)itemView.findViewById(R.id.tvValor);
            ibnDetalhe = (ImageButton)itemView.findViewById(R.id.btnInfo);

            ibnDetalhe.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btnInfo:
                    loadInfo(fatura);
            }
        }

        private void loadInfo(Fatura fatura) {

            Bundle b = new Bundle();
            b.putSerializable("fatura",fatura);

            Intent iAbrirInfo = new Intent(context, Lancamento.class);
            iAbrirInfo.putExtras(b);
            context.startActivity(iAbrirInfo);
        }


    }
}
