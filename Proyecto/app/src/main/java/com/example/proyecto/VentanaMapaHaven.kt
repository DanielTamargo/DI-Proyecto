package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_ventana_mapa_haven.*

class VentanaMapaHaven : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_mapa_haven)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Subrayar título
        //Forma 1: Spannable, método correcto
        val titulo: TextView = findViewById(R.id.haven_titulo)
        val contenido = SpannableString("HAVEN")
        contenido.setSpan(UnderlineSpan(), 0, contenido.length, 0)
        titulo.setText(contenido)

        //Forma 2: Html.fromHtml <- está deprecated
        //val titulo: TextView = findViewById(R.id.haven_titulo)
        //titulo.setText(Html.fromHtml(String.format(getString(R.string.haven))))


        //Listener checkbox
        haven_checkBox_defensores.setOnCheckedChangeListener { buttonView, isChecked ->
            if (haven_checkBox_defensores.isChecked) {
                haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven_defenders)
            } else {
                haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
