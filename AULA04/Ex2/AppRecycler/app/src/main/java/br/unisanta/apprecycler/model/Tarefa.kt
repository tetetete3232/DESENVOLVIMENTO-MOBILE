package br.unisanta.apprecycler.model

data class Tarefa(
    var nome: String = "",
    var descricao: String = "",
    var concluida: Boolean = false
)