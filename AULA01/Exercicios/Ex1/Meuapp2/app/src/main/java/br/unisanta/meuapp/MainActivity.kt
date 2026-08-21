package br.unisanta.meuapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtIdade = findViewById<EditText>(R.id.edt_idade)
        val btnEnviar = findViewById<Button>(R.id.btn_enviar)
        val txvResultado = findViewById<TextView>(R.id.txv_saudar)

        btnEnviar.setOnClickListener{
            val nome = edtNome.text.toString()
            val idade = edtIdade.text.toString()

            txvResultado.setText("Boa tarde $nome, você tem $idade anos!")
            edtNome.text.clear()
            edtIdade.text.clear()
        }




        }
    }
