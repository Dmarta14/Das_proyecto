package com.example.proyecto_das_defintivo;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListaElementos> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListaElementos lista);
    }


    public ListAdapter(List<ListaElementos> lista, Context context, ListAdapter.OnItemClickListener listener){
        this.mInflater=LayoutInflater.from (context);
        this.mData= lista;
        this.context=context;
        this.listener= listener;
    }

    public int getItemCount(){
        return mData.size ();
    }

    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.from(parent.getContext ()).inflate(R.layout.activity_lista_elementos,parent ,false);
        return new ListAdapter.ViewHolder (view);
    }

    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.name.setText (mData.get(position).getName ());
        holder.imagen.setImageResource (mData.get (position).foId);
        holder.bindData (mData.get (position));
    }

    public void setItems (List<ListaElementos> items){
        mData=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView name;


        ViewHolder(View itemView){
            super(itemView);
            imagen=itemView.findViewById (R.id.imagen1);
            name=itemView.findViewById (R.id.nombreDelAspecto);

        }

        void bindData(final ListaElementos lista){
            itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    listener.onItemClick (lista);
                }
            });
        }
    }
}