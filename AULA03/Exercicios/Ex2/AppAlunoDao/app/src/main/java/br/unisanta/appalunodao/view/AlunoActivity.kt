package br.unisanta.appalunodao.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appalunodao.R
import br.unisanta.appalunodao.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvNomeAluno = findViewById<TextView>(R.id.txv_nome_aluno)
        val btnGerarMatricula = findViewById<Button>(R.id.btn_gerar_matricula)
        val fabVoltaTelaCadastro = findViewById<FloatingActionButton>(R.id.fab_volta_tela_cadastro)
        val txvMatriculaAluno = findViewById<TextView>(R.id.txv_matricula_aluno)
        val aluno = AlunoDao.buscar()

        txvNomeAluno.setText("Nome: ${aluno?.nome}")

        btnGerarMatricula.setOnClickListener {
            val codigoSeisDigitos = Random.nextInt(0, 1000000).toString().padStart(6, '0')
            txvMatriculaAluno.text = "Matricula: $codigoSeisDigitos"
            AlunoDao.salvar("", codigoSeisDigitos)
        }




        fabVoltaTelaCadastro.setOnClickListener {
            finish()
        }
    }
}