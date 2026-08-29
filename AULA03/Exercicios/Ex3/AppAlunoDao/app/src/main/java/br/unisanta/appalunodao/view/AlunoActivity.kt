package br.unisanta.appalunodao.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.appalunodao.R
import br.unisanta.appalunodao.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno)

        val txvAlturaUsuario = findViewById<TextView>(R.id.txv_altura_usuario)
        val txvPesoUsuario = findViewById<TextView>(R.id.txv_peso_usuario)
        val txvImc = findViewById<TextView>(R.id.txv_imc)
        val fabVoltaTelaCadastro = findViewById<FloatingActionButton>(R.id.fab_volta_tela_cadastro)

        val usuario = UsuarioDao.buscar()

        // Pega os valores e troca vírgula por ponto
        val peso = usuario?.peso?.replace(",", ".")?.toDoubleOrNull() ?: 0.0
        var altura = usuario?.altura?.replace(",", ".")?.toDoubleOrNull() ?: 0.0

        // Se a altura for em centímetros (ex: 170), converte para metros (1.70)
        if (altura > 3.0) {
            altura = altura / 100.0
        }


        val imc = if (altura > 0) peso / (altura * altura) else 0.0
         var mensagem = ""
        if (imc < 18.5) {
            mensagem = "Abaixo do Peso"
        } else if (imc < 24.9) {
            mensagem = "Peso Normal"
        } else if (imc < 29.9) {
            mensagem = "Acima do Peso"
        } else {
            mensagem = "Obesidade"
        }

        // Exibe na tela
        txvPesoUsuario.text = "Peso: ${usuario?.peso} kg"
        txvAlturaUsuario.text = "Altura: ${usuario?.altura}"
        txvImc.text = "IMC: ${String.format("%.2f", imc)} - ${mensagem}"

        fabVoltaTelaCadastro.setOnClickListener {
            finish()
        }
    }
}