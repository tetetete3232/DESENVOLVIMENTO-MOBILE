package br.unisanta.appalunodao.dao

import br.unisanta.appalunodao.model.Usuario

class UsuarioDao {
    companion object {
        var usuario: Usuario? = null


        fun salvar(peso: String, altura: String) {
            usuario = Usuario(peso = peso, altura = altura)
        }

        fun buscar(): Usuario? {
            return usuario
        }
    }
}