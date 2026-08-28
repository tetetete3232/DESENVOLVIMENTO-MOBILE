package br.unisanta.apptelas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity(R.layout.activity_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val txvNomeLivro = findViewById<TextView>(R.id.txv_nome_livro)
        val txvNomeAutor = findViewById<TextView>(R.id.txv_nome_autor)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        val nomeLivro = intent.getStringExtra("nome_livro")
        val nomeAutor = intent.getStringExtra("nome_autor")
        txvNomeLivro.setText("O seu livro é $nomeLivro")
        txvNomeAutor.setText("O seu autor é $nomeAutor")
        fabVolta.setOnClickListener{
            finish()
        }


    }
}