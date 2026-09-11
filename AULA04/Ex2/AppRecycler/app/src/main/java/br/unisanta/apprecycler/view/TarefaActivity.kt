package br.unisanta.apprecycler.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.apprecycler.R
import br.unisanta.apprecycler.adapter.TarefaAdapter
import br.unisanta.apprecycler.dao.TarefaDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TarefaActivity : AppCompatActivity(R.layout.activity_tarefa) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvTarefas = findViewById<RecyclerView>(R.id.rv_tarefas)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        rvTarefas.adapter = TarefaAdapter(TarefaDao.buscar())
        rvTarefas.layoutManager = LinearLayoutManager(this)

        fabVolta.setOnClickListener {
            finish()
        }
    }
}