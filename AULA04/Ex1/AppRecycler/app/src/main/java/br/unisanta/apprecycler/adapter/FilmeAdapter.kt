package br.unisanta.apprecycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apprecycler.R
import br.unisanta.apprecycler.model.Filme

class FilmeAdapter(private val filmes: List<Filme>) : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvTitulo = itemView.findViewById<TextView>(R.id.txv_titulo_filme)
        val txvDiretor = itemView.findViewById<TextView>(R.id.txv_diretor_filme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txvTitulo.text = filme.titulo
        holder.txvDiretor.text = filme.diretor
    }
}