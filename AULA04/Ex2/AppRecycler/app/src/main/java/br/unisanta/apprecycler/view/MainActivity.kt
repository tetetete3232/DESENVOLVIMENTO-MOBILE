package br.unisanta.apprecycler.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.apprecycler.R
import br.unisanta.apprecycler.dao.TarefaDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.jvm.java

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNome = findViewById<EditText>(R.id.edt_nome_tarefa)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao_tarefa)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()

            val retorno = TarefaDao.salvar(nome, descricao)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()

            if (retorno.contains("sucesso")) {
                edtNome.text.clear()
                edtDescricao.text.clear()
            }
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, TarefaActivity::class.java)
            startActivity(intent)
        }
    }
}