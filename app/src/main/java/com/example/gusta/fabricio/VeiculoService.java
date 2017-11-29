package com.example.gusta.fabricio;

import android.view.View;

import com.example.gusta.fabricio.pojo.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by gusta on 28/11/2017.
 */

public interface VeiculoService {

    @PUT("/veiculo")
    Call<Veiculo>putAtualizar(@Body Veiculo veiculo);

    @POST("/veiculo")
    Call<Veiculo>postCadastrar(@Body Veiculo veiculo);

    @GET("veiculo")
    Call<List<Veiculo>> buscarTodos();

    @GET("veiculo")
    Call<Veiculo> buscarPorPlaca(@Path("placa") int placa);

    @DELETE("veiculo/{placa}")
    Call<Void> deletarPorPlaca(@Path("placa") int placa);


}
