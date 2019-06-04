package br.com.fimmbrasil.consultaibgeapi.service

import br.com.fimmbrasil.consultaibgeapi.models.Mesorregiao
import retrofit2.Call
import retrofit2.http.GET

interface IBGEService {

    @GET("localidades/mesorregioes")
    fun getAllMesorregioes(): Call<Mesorregiao>

}
