package com.example.recyclerviewbuscador;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    ArrayList<Modelo> filterList;
    MyAdapter adapter;

    public CustomFilter(ArrayList<Modelo> filterList, MyAdapter adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constrain) {
        FilterResults results = new FilterResults();

        if(constrain !=null && constrain.length()>0){

            constrain = constrain.toString().toUpperCase();
            ArrayList<Modelo> modeloFiltrado = new ArrayList<>();

            for(int i =0; i<filterList.size();i++){
                if(filterList.get(i).getTitulo().toUpperCase().contains(constrain)){
                    modeloFiltrado.add(filterList.get(i));
                }
            }

            results.count = modeloFiltrado.size();
            results.values = modeloFiltrado;
        }else{
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
      adapter.models = (ArrayList<Modelo>) filterResults.values;
      adapter.notifyDataSetChanged();
    }

}
