package br.unisanta.apprecycler.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apprecycler.R
import br.unisanta.apprecycler.adapter.FilmeAdapter
import br.unisanta.apprecycler.dao.FilmeDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilmeActivity : AppCompatActivity(R.layout.activity_filme) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvFilmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        rvFilmes.adapter = FilmeAdapter(FilmeDao.buscar())

        rvFilmes.layoutManager = GridLayoutManager(this, 2)

        fabVolta.setOnClickListener {
            finish()
        }
    }
}