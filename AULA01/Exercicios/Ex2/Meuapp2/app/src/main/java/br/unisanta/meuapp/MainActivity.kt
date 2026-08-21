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
        val edtTemperatura = findViewById<EditText>(R.id.edt_temperatura)
        //val edtIdade = findViewById<EditText>(R.id.edt_idade)
        val btnConverter = findViewById<Button>(R.id.btn_converter)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnConverter.setOnClickListener{
            val temperatura = edtTemperatura.text.toString()
            //val idade = edtIdade.text.toString()
            val fahrenheit = (temperatura.toDouble()*9/5+32).toString()

            txvResultado.setText("Sua temperatura de $temperatura °C convertida a fahrenheit é de $fahrenheit°F.")
            edtTemperatura.text.clear()

        }




        }
    }
