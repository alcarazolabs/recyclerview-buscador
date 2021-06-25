package com.example.recyclerviewbuscador;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>  implements Filterable {

    Context c;
    ArrayList<Modelo> models, filterList;
    CustomFilter filter;

    public MyAdapter(Context c, ArrayList<Modelo> models) {
        this.c = c;
        this.models = models;
        this.filterList = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
        myHolder.mTitulo.setText(models.get(position).getTitulo());
        myHolder.mDesc.setText(models.get(position).getDescripcion());
        myHolder.mImageView.setImageResource(models.get(position).getImg());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = models.get(position).getTitulo();
                String gDesc = models.get(position).getDescripcion();
                /*obtener imagen de drawable
                BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();*/
                //obtener datos con el intent
                Intent i = new Intent(c, Detalle.class);
                i.putExtra("ititulo", gTitle);
                i.putExtra("idescr", gDesc);
                //i.putExtra("iImage", bytes);
                c.startActivity(i);
            }
        });
        /*
        //Si queremos abrir otra activity en su lugar al hacer click en un determinado item
        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
            if(models.get(position).getTitulo().equals("Primer Item")){
                //mover a otra activity
            }
            if(models.get(position).getTitulo().equals("Segundo Item")){
                    //mover a otra activity
            }
            //*** etc..
            }
        });
      */
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }
}
