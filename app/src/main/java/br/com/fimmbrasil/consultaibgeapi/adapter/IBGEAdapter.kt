package br.com.fimmbrasil.consultaibgeapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.fimmbrasil.consultaibgeapi.R
import br.com.fimmbrasil.consultaibgeapi.models.Mesorregiao

class IBGEAdapter(val contexto:Context, val listaMesorregiao: List<Mesorregiao>): RecyclerView.Adapter<IBGEAdapter.IBGEViewHolder>() {

    private val layoutInflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): IBGEViewHolder {
        val itemView = layoutInflater.inflate(R.layout.ibgemesorregiao_adapter,p0,false)
        return IBGEViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaMesorregiao.size
    }

    override fun onBindViewHolder(p0: IBGEViewHolder, p1: Int) {
        p0.mesorregiaoId.text = listaMesorregiao[p1].id.toString()
        p0.mesorregiaoNome.text=listaMesorregiao[p1].nome
        p0.mesorregiaoUfSigla.text=listaMesorregiao[p1].UF.sigla
        p0.mesorregiaoUfNome.text=listaMesorregiao[p1].UF.nome
        p0.mesorregiaoUfRegiao.text=listaMesorregiao[p1].UF.regiao.nome
    }


    class IBGEViewHolder(item:View):RecyclerView.ViewHolder(item) {

        var mesorregiaoId:TextView
        var mesorregiaoNome:TextView
        var mesorregiaoUfSigla:TextView
        var mesorregiaoUfNome:TextView
        var mesorregiaoUfRegiao:TextView

        init {
            this.mesorregiaoId=item.findViewById(R.id.messoregiao_id)
            this.mesorregiaoNome=item.findViewById(R.id.mesorregiao_nome)
            this.mesorregiaoUfSigla=item.findViewById(R.id.mesorregiao_uf_sigla)
            this.mesorregiaoUfNome=item.findViewById(R.id.mesorregiao_uf_nome)
            this.mesorregiaoUfRegiao=item.findViewById(R.id.mesorregiao_uf_regiao)
        }

    }

}