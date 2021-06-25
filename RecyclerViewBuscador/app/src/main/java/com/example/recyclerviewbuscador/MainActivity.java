package com.example.recyclerviewbuscador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        getMyList();

    }
    private void getMyList(){

        ArrayList<Modelo> models = new ArrayList<>();
        Modelo m = new Modelo();
        m.setTitulo("Primer Item");
        m.setDescripcion("Descripción del primer item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Segundo Item");
        m.setDescripcion("Descripción del segundo item.");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Tercer Item");
        m.setDescripcion("Descripción del tercer item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Cuarto Item");
        m.setDescripcion("Descripción del cuarto item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Quinto Item");
        m.setDescripcion("Descripción del quinto item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Sexto Item");
        m.setDescripcion("Descripción del sexto item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Septimo Item");
        m.setDescripcion("Descripción del septimo item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        m = new Modelo();
        m.setTitulo("Octavo Item");
        m.setDescripcion("Descripción del octavo item");
        m.setImg(R.drawable.ic_launcher_background);
        models.add(m);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, models);
        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        //funcionalidad para el buscador
        MenuItem item = menu.findItem(R.id.buscar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //ir a clase customfilter y en myadaptar luego programar aqui
                myAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.sorting){
            sortDailog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sortDailog() {
        String[] options = {"Acendente","Descendente"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ordenar por:");
        builder.setIcon(R.drawable.ic_action_sort);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    Toast.makeText(MainActivity.this, "Ordenar Ascendentemente", Toast.LENGTH_SHORT).show();
                }
                if(i==1){
                    Toast.makeText(MainActivity.this, "Ordenar Descendentemente", Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.create().show();
    }
}
