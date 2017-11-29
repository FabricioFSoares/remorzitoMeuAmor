package com.example.gusta.fabricio;

import com.example.gusta.fabricio.pojo.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gusta on 28/11/2017.
 */

public class VeiculoConsumer {
    private VeiculoService veiculoService;
    private Retrofit retrofit;

    public VeiculoConsumer() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("www.google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.veiculoService = retrofit.create(VeiculoService.class);
    }

    Call<Veiculo> putAtualizar(Veiculo veiculo) {
        return this.veiculoService.postCadastrar(veiculo);
    }

    Call<Veiculo> postCadastrar(Veiculo veiculo) {
        return this.veiculoService.putAtualizar(veiculo);
    }

    Call<List<Veiculo>> bucarTodos() {
        return this.veiculoService.buscarTodos();
    }

    Call<Veiculo> buscarPorPlaca(int placa) {
        return this.veiculoService.buscarPorPlaca(placa);
    }

    void deletarPorPlaca(int placa) {
        this.veiculoService.deletarPorPlaca(placa);
    }

}
