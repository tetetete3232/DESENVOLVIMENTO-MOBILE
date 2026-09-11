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
import br.unisanta.apprecycler.dao.FilmeDao
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

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo_filme)
        val edtDiretor = findViewById<EditText>(R.id.edt_diretor_filme)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        btnSalvar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val diretor = edtDiretor.text.toString()
                val retorno = FilmeDao.salvar(titulo, diretor)
                Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
                edtTitulo.text.clear()
                edtDiretor.text.clear()

        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, FilmeActivity::class.java)
            startActivity(intent)
        }
    }
}