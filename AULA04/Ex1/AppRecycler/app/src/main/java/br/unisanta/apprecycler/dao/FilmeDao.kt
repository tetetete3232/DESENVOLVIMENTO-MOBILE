package br.unisanta.apprecycler.dao

import br.unisanta.apprecycler.model.Filme

class FilmeDao {
    companion object {
        private val filmes = mutableListOf<Filme>()

        fun salvar(titulo: String, diretor: String): String {
            filmes.add(Filme(titulo, diretor))
            return "Filme salvo"
        }

        fun buscar(): List<Filme> {
            return filmes
        }
    }
}