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
import kotlinx.android.synthetic.main.fragment_haven.*
import kotlinx.android.synthetic.main.fragment_split.*

class VentanaMapaHaven : AppCompatActivity(), OnFragmentActionsListener {

    private lateinit var toolbar: Toolbar
    private var haven_iniciado = false
    private var split_iniciado = false
    private var bind_iniciado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_mapa_haven)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        /*
        //Listener checkbox //<- tendrá que ir en el fragment
        haven_checkBox_defensores.setOnCheckedChangeListener { buttonView, isChecked ->
            if (haven_checkBox_defensores.isChecked) {
                haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven_defenders)
            } else {
                haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven)
            }
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onCLickFragmentButton(nombre_mapa: String) {

        //Log.d("Si", "Si llega fuera")
        //Listener checkboxex
        if (nombre_mapa == "haven") {
            //Log.d("Si", "Si llega dentro")
            //Haven
            if (!haven_iniciado) {
                haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven_defenders)
                haven_iniciado = true
            }
            haven_checkBox_defensores.setOnClickListener {
                if (haven_checkBox_defensores.isChecked) {
                    haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven_defenders)
                } else {
                    haven_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_haven)
                }
            }

        } else if (nombre_mapa == "split") {
            //Split
            if (!split_iniciado) {
                split_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_split_defenders)
                split_iniciado = true
            }
            split_checkBox_defensores.setOnCheckedChangeListener { buttonView, isChecked ->
                if (split_checkBox_defensores.isChecked) {
                    split_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_split_defenders)
                } else {
                    split_minimapa.setImageResource(R.drawable.valorant_mapas_minimapas_split)
                }
            }
        }
        //falta bind
    }
}
