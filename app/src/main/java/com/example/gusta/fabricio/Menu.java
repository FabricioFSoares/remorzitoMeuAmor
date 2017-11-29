package com.example.gusta.fabricio;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Menu extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Cadastrar");
        opcoes.add("Editar");
        opcoes.add("Listar");
        opcoes.add("Excluir");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opcoes);
        setListAdapter(adapter);


    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        switch (position){

            case 0:
                Intent cadastrar = new Intent(this, Cadastrar.class);
                startActivity(cadastrar);

            case 1:
                Intent editar = new Intent(this, Editar.class);
                startActivity(editar);

            case 2:
                Intent listar = new Intent(this, Listar.class);
                startActivity(listar);

            case 3:
                Intent excluir = new Intent(this, Excluir.class);
                startActivity(excluir);
        }
    }
}
