package br.com.fimmbrasil.consultaibgeapi.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.*
import br.com.fimmbrasil.consultaibgeapi.R
import br.com.fimmbrasil.consultaibgeapi.adapter.UFAdapter
import br.com.fimmbrasil.consultaibgeapi.models.UF
import br.com.fimmbrasil.consultaibgeapi.service.IBGEService
import br.com.fimmbrasil.consultaibgeapi.service.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){
    private lateinit var ibgeService: IBGEService
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConfiguracaoInicial()

        var unidadesFederativas = arrayOf("Rondônia","Acre","Amazonas","Roraima","Pará","Amapá","Tocantins","Maranhão","Piauí","Ceará","Rio Grande do Norte","Paraíba","Pernambuco","Alagoas","Sergipe","Bahia","Minas Gerais","Espírito Santo","Rio de Janeiro","São Paulo","Paraná","Santa Catarina","Rio Grande do Sul","Mato Grosso do Sul","Mato Grosso","Goiás","Distrito Federal")


        if(spinner!=null){
            val arrayAdapterUnidadeFederativa = ArrayAdapter(this,android.R.layout.simple_spinner_item, unidadesFederativas)
            spinner.adapter = arrayAdapterUnidadeFederativa

            spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Toast.makeText(applicationContext,unidadesFederativas[position],Toast.LENGTH_SHORT).show()
                    var valor = converte(unidadesFederativas[position])
                    var uf = ibgeService.getMesorregiaoById(converte(unidadesFederativas[position]))
                    uf.enqueue(object :Callback<UF?>{
                        override fun onFailure(call: Call<UF?>, t: Throwable) {
                            Log.i("onFailure", "Evento de clique NÃO trouxe resultado =/ " + t.message)
                        }

                        override fun onResponse(call: Call<UF?>, response: Response<UF?>) {
                            recyclerView.adapter = response.body()?.let { UFAdapter(applicationContext, it) }
                        }
                    })
                }

            }
        }
    }

    fun ConfiguracaoInicial() {
        ibgeService = RetrofitConfig.getIBGEService()
        recyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        spinner = findViewById(R.id.main_spinner)
    }

    fun converte(texto:String):Int{

        when(texto){
            "Rondônia" -> return 11
            "Acre" -> return 12
            "Amazonas" -> return 13
            "Roraima" -> return 14
            "Pará" -> return 15
            "Amapá" -> return 16
            "Tocantins" -> return 17
            "Maranhão" -> return 21
            "Piauí" -> return 22
            "Ceará" -> return 23
            "Rio Grande do Norte" -> return 24
            "Paraíba" -> return 25
            "Pernambuco" -> return 26
            "Alagoas" -> return 27
            "Sergipe" -> return 28
            "Bahia" -> return 29
            "Minas Gerais" -> return 31
            "Espírito Santo" -> return 32
            "Rio de Janeiro" -> return 33
            "São Paulo" -> return 35
            "Paraná" -> return 41
            "Santa Catarina" -> return 42
            "Rio Grande do Sul" -> return 43
            "Mato Grosso do Sul" -> return 50
            "Mato Grosso" -> return 51
            "Goiás" -> return 52
            "Distrito Federal" -> return 53
        }

        return 0
    }
}
