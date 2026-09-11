package br.unisanta.apprecycler.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apprecycler.R
import br.unisanta.apprecycler.dao.TarefaDao
import br.unisanta.apprecycler.model.Tarefa

class TarefaAdapter(private val tarefas: List<Tarefa>) : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome = itemView.findViewById<TextView>(R.id.txv_nome_tarefa)
        val txvDescricao = itemView.findViewById<TextView>(R.id.txv_descricao_tarefa)
        val btnConcluir = itemView.findViewById<Button>(R.id.btn_concluir_tarefa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDescricao.text = tarefa.descricao


        if (tarefa.concluida) {
            holder.btnConcluir.text = "Concluido"
        } else {
            holder.btnConcluir.text = "Marcar Feito"
        }


        holder.btnConcluir.setOnClickListener {
            TarefaDao.alternarStatus(position)
            notifyItemChanged(position)
        }
    }
    }
