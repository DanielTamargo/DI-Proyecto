package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar

class VentanaPrincipal : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_principal)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //supportActionBar?.title = "Valorant" //<- no cambiar esto, he añadido un textView en la toolbar para personalizar la fuente

        supportFragmentManager.beginTransaction().add(R.id.contenedorCeldas, ContenedorCeldasFragment()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
