package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar

class VentanaCrearEditarPersonaje : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    val lista_links_imagenes_personaje: MutableList<String> = mutableListOf(
        "https://i.gyazo.com/fbb8aa45761f13fb575c97ead5d3177c.png",
        "https://i.gyazo.com/a8587b2548ae73a408db8589523689e1.png",
        "https://i.gyazo.com/a31dfeee45e50b414b55401438fc5fd5.png",
        "https://i.gyazo.com/93a1ccb097bc9b1d6d4ce979aa9c04ba.png",
        "https://i.gyazo.com/ca9311db09cee7be6c311d92b242380a.png",
        "https://i.gyazo.com/c7abbe94c2264f064470274f20394e16.png",
        "https://i.gyazo.com/829513d67619594247694d474f4540a8.png",
        "https://i.gyazo.com/b55ced8d256e4f77d28975cc85b668dd.png",
        "https://i.gyazo.com/5a9fc97b828572b914dfbc42ea90e6b7.png",
        "https://i.gyazo.com/e8b9b5c1675037308be828b27b4b0c1b.png",
        "https://i.gyazo.com/6d3b9c596f0ab82f590d32a5761b3d73.png",
        "https://i.gyazo.com/d56140b266a2a27013b9bb019cb57631.png",
        "https://i.gyazo.com/729bdae62a158553eff878cce3e89541.png",
        "https://i.gyazo.com/dd7abb4a5288a8f9d8753e0be1c09d43.png"
    )

    val lista_links_imagenes_habilidades: MutableList<String> = mutableListOf(
        "https://i.gyazo.com/8beabd1707b5370335c7bc6d43f0ad85.png",
        "https://i.gyazo.com/1f5a5b0e8c4cfebe4855b85ba7121432.png",
        "https://i.gyazo.com/28e0d0a3215eb9f049763cd36fc779f9.png",
        "https://i.gyazo.com/7b3b5065b6d9e54d0df9d5c9495671b6.png",
        "https://i.gyazo.com/e37192bb1a304bd0c2e11653438fbec5.png",
        "https://i.gyazo.com/98d30406226b4631d1e91c07e5a3bbcd.png",
        "https://i.gyazo.com/579ee07f02804c67c8d3b819cac048a0.png",
        "https://i.gyazo.com/87018a8e6279f79e2162d2f7ba732529.png",
        "https://i.gyazo.com/91e4a406b6e7d58cfe3227f5fa526aed.png",
        "https://i.gyazo.com/8ca797a3ad99867af0d8a74efa729175.png",
        "https://i.gyazo.com/ef00c1f35ea81a9aec458223f0b51143.png"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_crear_editar_personaje)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    */

}
