package br.com.fimmbrasil.consultaibgeapi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitConfig {

    private val retrofit:Retrofit

    init {
        this.retrofit = Retrofit.Builder().baseUrl("https://servicodados.ibge.gov.br/api/v1/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getIBGEService() :IBGEService{
        return this.retrofit.create(IBGEService::class.java)
    }
}