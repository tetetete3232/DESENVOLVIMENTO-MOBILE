package br.unisanta.appalunodao.dao
import br.unisanta.appalunodao.model.Aluno

class AlunoDao {
    companion object {
        var aluno:Aluno? = null
        fun salvar(nome:String, matricula:String){
            aluno = Aluno(nome,matricula)
        }
        fun buscar():Aluno?{
            return aluno
        }
    }

}