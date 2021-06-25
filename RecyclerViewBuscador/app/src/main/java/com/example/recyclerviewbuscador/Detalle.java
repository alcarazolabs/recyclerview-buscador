package com.example.recyclerviewbuscador;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    TextView mTitulo, mDesc;
    ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();

        setContentView(R.layout.activity_detalle);
        mTitulo = findViewById(R.id.titulo);
        mDesc = findViewById(R.id.descripcion);
        mImage = findViewById(R.id.imageView);

        //obtener datos desde el intent
        Intent intent =getIntent();
        String titulo = intent.getStringExtra("ititulo");
        String descr = intent.getStringExtra("idescr");
        /*
        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        //decodificar la imagegn
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);
        */
        actionBar.setTitle(titulo);
        mTitulo.setText(titulo);
        mDesc.setText(descr);

        //mImage.setImageBitmap(bitmap);

    }
}
