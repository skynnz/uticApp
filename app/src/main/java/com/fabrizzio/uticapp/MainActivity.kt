package com.fabrizzio.uticapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fabrizzio.uticapp.ui.theme.UticAppTheme
import com.fabrizzio.uticapp.*

class MainActivity : AppCompatActivity() {

    private lateinit var lblTitulo: TextView

    private lateinit var txtNro: EditText

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button

    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMultiplicacion: Button
    private lateinit var btnDivision: Button

    private lateinit var btnLimpiar: Button
    private lateinit var btnCalcular: Button

    // valor inicial, valor final
    // 1- concatenar el valor inicial (txtNro)
    // 2- seleccionar la operacion
    // 3- concatenar el valor final (txtNro)
    // 4- calcular

    var valorInicial: String = ""
    var valorFinal: String = ""
    var operacion: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblTitulo = findViewById(R.id.lblTitulo)

        txtNro = findViewById(R.id.txtNro)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)

        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion)
        btnDivision = findViewById(R.id.btnDivision)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)

        lblTitulo.text = "Mi calculadora"

        // numeros
        btn1.setOnClickListener { agregarNro("1") }
        btn2.setOnClickListener { agregarNro("2") }
        btn3.setOnClickListener { agregarNro("3") }
        btn4.setOnClickListener { agregarNro("4") }
        btn5.setOnClickListener { agregarNro("5") }
        btn6.setOnClickListener { agregarNro("6") }
        btn7.setOnClickListener { agregarNro("7") }
        btn8.setOnClickListener { agregarNro("8") }
        btn9.setOnClickListener { agregarNro("9") }
        btn0.setOnClickListener { agregarNro("0") }

        // operaciones
        btnSuma.setOnClickListener { operar("+") }
        btnResta.setOnClickListener { operar("-") }
        btnMultiplicacion.setOnClickListener { operar("*") }
        btnDivision.setOnClickListener { operar("/") }

        // resultados / limpieza de campo
        btnCalcular.setOnClickListener { calcular() }

        btnLimpiar.setOnClickListener {
            limpiarVariablesAux()
            txtNro.setText("")
        }


        mostrarAlerta("Bienvenido a la calculadora")

    }

    fun calcular() {
        // 1- valor inicial
        // 2- valor final
        // 3- verificar la operacion
        // 4- calcular
        when(operacion) {
            "+" -> {
                var resultado = valorInicial.toInt() + valorFinal.toInt()
                txtNro.setText("$resultado")
            }
            "-" -> {
                var resultado = valorInicial.toInt() - valorFinal.toInt()
                txtNro.setText("$resultado")
            }
            "*" -> {
                var resultado = valorInicial.toInt() * valorFinal.toInt()
                txtNro.setText("$resultado")
            }
            "/" -> {
                var resultado = valorInicial.toDouble() / valorFinal.toDouble()
                txtNro.setText("$resultado")
            }
        }

        limpiarVariablesAux()

    }

    fun operar(op: String) {
        operacion = op
        valorInicial = txtNro.text.toString() //1-  10
        valorFinal = ""
        txtNro.setText("")
    }

    fun agregarNro(valor: String) {
        valorFinal+= valor //2- 5
        txtNro.setText(valorFinal)
    }

    fun limpiarVariablesAux() {
        valorInicial = ""
        valorFinal = ""
        operacion = ""
    }

    fun mostrarAlerta(mensaje: String) {
        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }

}