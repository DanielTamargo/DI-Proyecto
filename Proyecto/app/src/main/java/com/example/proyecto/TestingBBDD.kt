package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.proyecto.BBDD.AppDatabase
import com.example.proyecto.BBDD.Habilidad
import com.example.proyecto.BBDD.Personaje
import kotlinx.android.synthetic.main.activity_testing_bbdd.*
import java.lang.Exception
import java.lang.StringBuilder

class TestingBBDD : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_bbdd)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        test_b_buscar.setOnClickListener {
            buscar_personaje()
        }

        guardar_personajes_base()

    }

    fun guardar_personajes_base() {

        //val sage = Personaje(2, "Sage", "https://i.gyazo.com/5d4fe9542083e689ec0dd70f9091aadb.png")
        guardar_omen()

    }

    fun guardar_omen() {
        val omen = Personaje(1, "Omen", "https://i.gyazo.com/3d47addf89c6214d1e129e2b603a6db5.png")
        val omen_1 = Habilidad(1,
            "Aparición Tenebrosa",
            "Omen se teleporta a la ubicación cercana indicada. Durante el casteo de esta habilidad Omen podrá sufrir daños. La habilidad emite sonidos, por lo que puede ser detectable o usarse para engañar a los enemigos.",
            "https://i.gyazo.com/2ba55571bf3d369fa5875f6083785d8a.png",
            1)
        val omen_2 = Habilidad(2,
            "Paranoia",
            "Omen lanza un proyectil en línea recta, los jugadores impactados perderán visión y la capacidad de escuchar correctamente, como si estuvieran dentro de una pesadilla",
            "https://i.gyazo.com/ec67e6abd7e7a5db41d0f6c398748c52.png",
            1)
        val omen_3 = Habilidad(3,
            "Velo Tenebroso",
            "Omen lanza una sombra que al llegar a la zona indicada se convierte en un área que bloqueará la visión. Puede colocarlas a largas distancias y denegar puntos estratégicos. También puede calcular la altitud a la que caerá la bola.",
            "https://i.gyazo.com/dc597a3f0e3d9e5e1122820c4ffcc264.png",
            1)
        val omen_4 = Habilidad(4,
            "Desde las Sombras",
            "Omen se teleporta a cualquiera ubicación del mapa. Tras teletransportarse, tendrá que canalizar su aparición durante unos breves segundos. Si durante ese tiempo Omen recibe daño, la canalización se cancela y Omen no se teletransportará.",
            "https://i.gyazo.com/8bd7be4dfb71f0b4894ec7a31494fe4f.png",
            1)

        val habilidades = arrayListOf(omen_1, omen_2, omen_3, omen_4)

        for (habilidad in habilidades) {
            Log.d("Habilidad: ", habilidad.nombre)
        }

        Thread(Runnable {
            try {
                val bd = Room.databaseBuilder(this, AppDatabase::class.java, "personajes").build()
                bd.personajeDao().insertAll(omen)
                bd.close()

                runOnUiThread {
                    Toast.makeText(this, "¡Personaje Omen introducido!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this, "Error con: Omen - Habilidades", Toast.LENGTH_SHORT).show()
                }
            }

            try {
                val bd_habilidades =
                    Room.databaseBuilder(this, AppDatabase::class.java, "habilidades").build()
                for (habilidad in habilidades) {
                    bd_habilidades.habilidadDao().insertAll(habilidad)
                }
                bd_habilidades.close()
                runOnUiThread {
                    Toast.makeText(this, "¡Habilidades de Omen introducidas!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this, "Error con: Omen - Habilidades", Toast.LENGTH_SHORT).show()
                }
            }
        }).start()

    }

    fun buscar_personaje() {
        val id_seleccionado = try { test_et_id.text.toString().toInt() } catch (e: Exception) { -1 }
        if (id_seleccionado >= 0) {
            var personaje: Personaje?
            Thread(Runnable {
                val bd_personajes = Room.databaseBuilder(this, AppDatabase::class.java, "personajes").build()
                personaje = try { bd_personajes.personajeDao().findById(id_seleccionado) } catch (e: Exception) { Personaje(-1, "NoExiste", "SinLink") }
                bd_personajes.close()
                runOnUiThread {
                    if (personaje?.id is Int && personaje?.id != -1) {
                        val habilidades: List<Habilidad>
                        val bd_habilidades = Room.databaseBuilder(this, AppDatabase::class.java, "habilidades").build()
                        habilidades = try { bd_habilidades.habilidadDao().getAllChampAbilities(personaje?.id!!) } catch (e: Exception) { listOf<Habilidad>() }
                        bd_habilidades.close()

                        val datos = StringBuilder()
                        datos.append("ID: ${personaje?.id}\n")
                        datos.append("Nombre: ${personaje?.nombre}\n")
                        datos.append("Link Imagen: ${personaje?.link_imagen}\n\n")

                        try {
                            if (habilidades.size > 0) {
                                var contador = 1
                                for (habilidad in habilidades) {
                                    datos.append("Habilidad nº$contador\n")
                                    datos.append("ID: ${habilidad.id}\n")
                                    datos.append("Nombre: ${habilidad.nombre}\n")
                                    datos.append("Descripción: ${habilidad.descripcion}\n")
                                    datos.append("Link: ${habilidad.link_imagen}\n")
                                    datos.append("ID Personaje: ${habilidad.id_personaje}\n\n")
                                    contador++
                                }
                            } else {
                                datos.append("El personaje no tiene habilidades registradas\n\n")
                            }
                        } catch (e: Exception) {
                            datos.append("Error. El personaje no tiene habilidades registradas\n\n")
                        }

                        test_tv_datosPersonaje.text = datos

                    } else {
                        Toast.makeText(this, "No existe un personaje con el id $id_seleccionado", Toast.LENGTH_SHORT).show()
                    }
                }
            }).start()

        } else {
            Toast.makeText(this, "Error. Introduce un número entero positivo.", Toast.LENGTH_SHORT).show()
        }
    }
}
