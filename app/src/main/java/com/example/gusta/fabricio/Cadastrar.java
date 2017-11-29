package com.example.gusta.fabricio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gusta.fabricio.pojo.Veiculo;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gusta on 28/11/2017.
 */

    public class Cadastrar extends Activity {

    private VeiculoConsumer veiculoConsumer;
    private Veiculo veiculo;
    private TextView placa;
    private TextView cor;
    private Spinner modelo;
    private RadioButton novo;
    private RadioButton semi_novo;
    private Button bt_salvar;
    private RadioGroup rg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);
        inicializaComponentes();

        ArrayList<String> lista_modelos = new ArrayList<>();
        lista_modelos.add("X");
        lista_modelos.add("Y");
        lista_modelos.add("Z");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista_modelos);

        this.modelo.setAdapter(adapter);
    }

    public void cadastrar(View v){

        veiculo = new Veiculo();
        veiculoConsumer = new VeiculoConsumer();
        veiculo.setPlaca(placa.getText().toString());
        veiculo.setCor(cor.getText().toString());
        veiculo.setModelo((String) modelo.getSelectedItem().toString());


        Call<Veiculo> call = veiculoConsumer.postCadastrar(veiculo);
        call.enqueue(new Callback<Veiculo>() {
            @Override
            public void onResponse(Call<Veiculo> call, Response<Veiculo> response) {
                int responseCode = response.code();
                if (responseCode == 201) {
                    Toast.makeText(Cadastrar.this, "Cadastrado", Toast.LENGTH_SHORT).show();
                    Intent goMenu = new Intent(Cadastrar.this, Menu.class);
                    startActivity(goMenu);
                } else {
                    Toast.makeText(Cadastrar.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Veiculo> call, Throwable t) {
                Toast.makeText(Cadastrar.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void inicializaComponentes() {
        this.placa = (TextView) findViewById(R.id.tv_placa_cd);
        this.cor = (TextView) findViewById(R.id.tv_cor_cd);
        this.modelo = (Spinner) findViewById(R.id.sp_modelo_cd);
        this.bt_salvar = (Button) findViewById(R.id.bt_salvar_cd);

        this.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_novo_cd){
                    veiculo.setAno("Novo");
                }else{
                    veiculo.setAno("Semi-Novo");
                }
            }
        });
    }
}