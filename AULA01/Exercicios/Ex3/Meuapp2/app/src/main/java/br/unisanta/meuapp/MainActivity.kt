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
        val edtTensao = findViewById<EditText>(R.id.edt_tensao)
        val edtResistencia = findViewById<EditText>(R.id.edt_resistencia)
        val edtCorrente = findViewById<EditText>(R.id.edt_corrente)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener{
            val tensao = edtTensao.text.toString().toDoubleOrNull()
            val resistencia = edtResistencia.text.toString().toDoubleOrNull()
            val corrente = edtCorrente.text.toString().toDoubleOrNull()

            //3 inputs > calc tensao > calc resistencia > calc corrente > input insuficiente

            if (tensao != null && resistencia != null && corrente != null) {
                txvResultado.text = "Tensão = ${tensao.toString()}\nResistencia = ${resistencia.toString()}\nCorrente = ${corrente.toString()}"
            }
            //calc tensao
            else if (resistencia != null && corrente != null) {
                val resultado = resistencia * corrente
                txvResultado.text = "Tensão = ${resultado.toString()}\nResistencia = ${resistencia.toString()}\nCorrente = ${corrente.toString()}"
            }

            //calc resistencia
            else if (tensao != null && corrente != null) {
                if (corrente != 0.0) {
                    val resultado = tensao / corrente
                    txvResultado.text = "Tensão = ${tensao.toString()}\nResistencia = ${resultado.toString()}\nCorrente = ${corrente.toString()}"
                } else {
                    txvResultado.text = "A corrente não pode ser zero."
                }
            }

            //calc corrente
            else if (tensao != null && resistencia != null) {
                if (resistencia != 0.0) {
                    val resultado = tensao / resistencia
                    txvResultado.text = "Tensão = ${tensao.toString()}\nResistencia = ${resistencia.toString()}\nCorrente = ${resultado.toString()}"
                } else {
                    txvResultado.text = "A resistência não pode ser zero."
                }
            }
            //input insuficiente
            else {
                txvResultado.text = "Numero de valores insuficientes."
            }



            edtTensao.text.clear()
            edtResistencia.text.clear()
            edtCorrente.text.clear()

        }




        }
    }
