package br.com.fimmbrasil.consultaibgeapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.fimmbrasil.consultaibgeapi.R
import br.com.fimmbrasil.consultaibgeapi.models.UF

class UFAdapter(val contexto: Context, val uf: UF) : RecyclerView.Adapter<UFAdapter.UfViewHolder>(){
    private val layoutInflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UfViewHolder {
        val itemView = layoutInflater.inflate(R.layout.cardview,p0,false)
        return UfViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(p0: UfViewHolder, p1: Int) {
        p0.mesorregiaoId.text = uf.id.toString()
        p0.mesorregiaoNome.text=uf.nome
        p0.mesorregiaoUfSigla.text=uf.sigla

        p0.mesorregiaoUfRegiao.text=uf.regiao.nome
    }

    class UfViewHolder(item: View):RecyclerView.ViewHolder(item) {
        var mesorregiaoId: TextView
        var mesorregiaoNome: TextView
        var mesorregiaoUfSigla: TextView

        var mesorregiaoUfRegiao: TextView

        init {
            this.mesorregiaoId=item.findViewById(R.id.messoregiao_id)
            this.mesorregiaoNome=item.findViewById(R.id.mesorregiao_nome)
            this.mesorregiaoUfSigla=item.findViewById(R.id.mesorregiao_uf_sigla)

            this.mesorregiaoUfRegiao=item.findViewById(R.id.mesorregiao_uf_regiao)
        }

    }
}