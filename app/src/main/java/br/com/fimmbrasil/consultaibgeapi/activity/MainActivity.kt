package br.com.fimmbrasil.consultaibgeapi.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import br.com.fimmbrasil.consultaibgeapi.R
import br.com.fimmbrasil.consultaibgeapi.adapter.IBGEAdapter
import br.com.fimmbrasil.consultaibgeapi.adapter.UFAdapter
import br.com.fimmbrasil.consultaibgeapi.models.Mesorregiao
import br.com.fimmbrasil.consultaibgeapi.models.UF
import br.com.fimmbrasil.consultaibgeapi.service.IBGEService
import br.com.fimmbrasil.consultaibgeapi.service.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var ibgeService: IBGEService
    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibgeService = RetrofitConfig.getIBGEService()
        recyclerView = findViewById(R.id.main_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        editText = findViewById(R.id.main_editText)

        val listaibge = ibgeService.getAllMesorregioes()

        listaibge.enqueue(object : Callback<List<Mesorregiao>> {
            override fun onFailure(call: Call<List<Mesorregiao>>, t: Throwable) {
                Log.i("Depuracao", "Failure! We'll get'em next time: " + t.message)
            }

            override fun onResponse(call: Call<List<Mesorregiao>>, response: Response<List<Mesorregiao>>) {
                Log.i("Depuracao", response.body().toString())
                recyclerView.adapter = IBGEAdapter(applicationContext, response.body()!!.toList())
            }
        })


        editText.setOnClickListener(View.OnClickListener {
            if(editText.text.toString().equals("33")){
                ibgeService.getMesorregiaoById(editText.text.toString().toInt()).enqueue(
                    object : Callback<UF> {
                        override fun onFailure(call: Call<UF>, t: Throwable) {
                            Log.i("DepuracaoTexto", "Falhar na pesquisa")
                        }

                        override fun onResponse(call: Call<UF>, response: Response<UF>) {
                            Log.i("DepuracaoTexto", "Chamada realizada")
                            recyclerView.adapter = UFAdapter(applicationContext, response.body() as UF)
                        }
                    })
            }else{
                listaibge.clone().enqueue(object : Callback<List<Mesorregiao>> {
                    override fun onFailure(call: Call<List<Mesorregiao>>, t: Throwable) {
                        Log.i("Depuracao", "Failure! We'll get'em next time: " + t.message)
                    }

                    override fun onResponse(call: Call<List<Mesorregiao>>, response: Response<List<Mesorregiao>>) {
                        Log.i("Depuracao", response.body().toString())
                        recyclerView.adapter = IBGEAdapter(applicationContext, response.body()!!.toList())
                    }
                })
            }
        })
    }
}
