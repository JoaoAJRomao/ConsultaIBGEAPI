package br.com.fimmbrasil.consultaibgeapi.service

import br.com.fimmbrasil.consultaibgeapi.models.Mesorregiao
import br.com.fimmbrasil.consultaibgeapi.models.UF
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IBGEService {

    @GET("localidades/mesorregioes")
    fun getAllMesorregioes(): Call<List<Mesorregiao>>

    @GET("localidades/estados/{UF}")
    fun getMesorregiaoById(@Path("UF") uf: Int): Call<UF>

    @GET("localidades/estados/")
    fun getAllEstados(): Call<List<UF>>

}
