package br.unisanta.apprecycler.dao

import br.unisanta.apprecycler.model.Tarefa

class TarefaDao {
    companion object {
        private val tarefas = mutableListOf<Tarefa>()

        fun salvar(nome: String, descricao: String): String {
            tarefas.add(Tarefa(nome, descricao, false))
            return "Tarefa salva"
        }

        fun buscar(): List<Tarefa> {
            return tarefas
        }

        fun alternarStatus(position: Int) {
            if (position in tarefas.indices) {
                val tarefa = tarefas[position]
                tarefa.concluida = !tarefa.concluida
            }
        }
    }
}