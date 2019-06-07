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
        val itemView = layoutInflater.inflate(R.layout.ufmesorregiao_adapter,p0,false)
        return UfViewHolder(itemView)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return 1
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: UfViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class UfViewHolder(item: View):RecyclerView.ViewHolder(item) {
        var mesorregiaoId: TextView
        var mesorregiaoNome: TextView
        var mesorregiaoUfSigla: TextView
        var mesorregiaoUfNome: TextView
        var mesorregiaoUfRegiao: TextView

        init {
            this.mesorregiaoId=item.findViewById(R.id.messoregiao_id)
            this.mesorregiaoNome=item.findViewById(R.id.mesorregiao_nome)
            this.mesorregiaoUfSigla=item.findViewById(R.id.mesorregiao_uf_sigla)
            this.mesorregiaoUfNome=item.findViewById(R.id.mesorregiao_uf_nome)
            this.mesorregiaoUfRegiao=item.findViewById(R.id.mesorregiao_uf_regiao)
        }

    }
}