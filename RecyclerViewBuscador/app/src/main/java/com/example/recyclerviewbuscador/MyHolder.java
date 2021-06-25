package com.example.recyclerviewbuscador;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
   ImageView mImageView;
   TextView mTitulo, mDesc;
   ItemClickListener itemClickListener;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imgaIv);
        mTitulo = itemView.findViewById(R.id.txttitulo);
        mDesc = itemView.findViewById(R.id.txtdescripcion);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
    this.itemClickListener.onItemClickListener(view, getLayoutPosition());

    }
    public void setItemClickListener(ItemClickListener ic){
    this.itemClickListener = ic;
    }
}
