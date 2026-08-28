package br.unisanta.apptelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val edtNomeLivro = findViewById<EditText>(R.id.edt_nome_livro)
        val edtNomeAutor = findViewById<EditText>(R.id.edt_nome_autor)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)
        var nomeLivro:String? = ""
        var nomeAutor:String? = ""
        btnSalvar.setOnClickListener{
            nomeLivro = edtNomeLivro.text.toString()
            edtNomeLivro.text.toString()
            Toast.makeText(this,"Livro Salvo!",Toast.LENGTH_SHORT).show()
            nomeAutor = edtNomeAutor.text.toString()
            edtNomeAutor.text.toString()
            Toast.makeText(this,"Autor Salvo!",Toast.LENGTH_SHORT).show()
        }
        fabAvanca.setOnClickListener{
            val intent = Intent(this,LivroActivity::class.java)
            intent.putExtra("nome_livro",nomeLivro)
            intent.putExtra("nome_autor",nomeAutor)
            startActivity(intent)
        }

    }
}