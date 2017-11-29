package com.example.gusta.fabricio;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.gusta.fabricio.pojo.Veiculo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by gusta on 28/11/2017.
 */

    public class Listar extends ListActivity {

    private List<Veiculo> veiculos;
    private VeiculoConsumer veiculoConsumer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        veiculoConsumer = new VeiculoConsumer();

        Call<List<Veiculo>> call = veiculoConsumer.bucarTodos();
        call.enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                int responseCode = response.code();
                if(responseCode == 200){
                    veiculos = response.body();
                    ArrayAdapter<Veiculo> adapter = new ArrayAdapter(Listar.this, android.R.layout.simple_list_item_1, veiculos);
                    setListAdapter(adapter);
                }else{
                    Toast.makeText(Listar.this, "Nao buscou com sucesso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                Toast.makeText(Listar.this, "Erro com o servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
