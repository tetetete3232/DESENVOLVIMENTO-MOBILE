package br.unisanta.appalunodao.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appalunodao.R
import br.unisanta.appalunodao.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtPesoUsuario = findViewById<EditText>(R.id.edt_peso)
        val edtAlturaUsuario = findViewById<EditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val fabAvancaTelaAluno = findViewById<FloatingActionButton>(R.id.fab_avanca_tela_aluno)

        btnCalcular.setOnClickListener{
            val pesoUsuario = edtPesoUsuario.text.toString()
            val alturaUsuario = edtAlturaUsuario.text.toString()
            UsuarioDao.salvar(pesoUsuario,alturaUsuario)
            Log.i("ESTADO","SALVO")
        }


        fabAvancaTelaAluno.setOnClickListener{
            val intent = Intent(this,AlunoActivity::class.java)
            startActivity(intent)
        }
    }
}