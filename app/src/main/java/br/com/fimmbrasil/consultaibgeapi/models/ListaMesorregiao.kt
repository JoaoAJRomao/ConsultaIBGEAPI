package br.com.fimmbrasil.consultaibgeapi.models

data class ListaMesorregiao(
    val lista:List<Mesorregiao>
)

data class Mesorregiao(
    val id: Int,
    val nome: String,
    val uf: UF
)

data class UF (
    val id: Int,
    val nome: String,
    val sigla: String,
    val regiao: Regiao
)

data class Regiao (
    val id:Int,
    val nome:String,
    val sigla:String
)
