package com.example.proyecto

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.example.proyecto.BBDD.AppDatabase
import com.example.proyecto.BBDD.Habilidad
import com.example.proyecto.BBDD.Personaje
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_ventana_personajes.*
import java.lang.Exception

class VentanaPersonajes : AppCompatActivity() {

    lateinit var lista_personajes: List<Personaje>
    lateinit var lista_habilidades: List<Habilidad>
    lateinit var lista_habilidades_personaje: List<Habilidad>
    var index = 0
    var index_habilidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_personajes)

        cargar_datos()

        personajes_b_next.setOnClickListener {
            index++
            if (index >= lista_personajes.size) {
                index = 0
            }
            index_habilidad = 0
            oscurecer_imagenes_habilidades(personajes_ib_ability_1)
            ejecutar_cargar_datos()
        }

        personajes_b_previous.setOnClickListener {
            index--
            if (index <= -1) {
                index = lista_personajes.size - 1
            }
            index_habilidad = 0
            oscurecer_imagenes_habilidades(personajes_ib_ability_1)
            ejecutar_cargar_datos()
        }

        personajes_ib_ability_1.setOnClickListener {
            index_habilidad = 0
            oscurecer_imagenes_habilidades(personajes_ib_ability_1)
            ejecutar_cargar_datos()
        }

        personajes_ib_ability_2.setOnClickListener {
            index_habilidad = 1
            oscurecer_imagenes_habilidades(personajes_ib_ability_2)
            ejecutar_cargar_datos()
        }

        personajes_ib_ability_3.setOnClickListener {
            index_habilidad = 2
            oscurecer_imagenes_habilidades(personajes_ib_ability_3)
            ejecutar_cargar_datos()
        }

        personajes_ib_ability_4.setOnClickListener {
            index_habilidad = 3
            oscurecer_imagenes_habilidades(personajes_ib_ability_4)
            ejecutar_cargar_datos()
        }

    }

    fun oscurecer_imagenes_habilidades(imagenButtonHabilidad: ImageButton) {
        //orange: #b55e12, darkblue: #161b21
        personajes_ib_ability_1.setBackgroundColor(Color.parseColor("#161b21"))
        personajes_ib_ability_2.setBackgroundColor(Color.parseColor("#161b21"))
        personajes_ib_ability_3.setBackgroundColor(Color.parseColor("#161b21"))
        personajes_ib_ability_4.setBackgroundColor(Color.parseColor("#161b21"))
        imagenButtonHabilidad.setBackgroundColor(Color.parseColor("#b55e12"))
    }

    fun ejecutar_cargar_datos() {
        try { cargar_datos_personaje() } catch (e: Exception) {
            //Toast.makeText(this, "Forma segura", Toast.LENGTH_SHORT).show()
            Log.d("Error", e.toString())
            cargar_datos_personaje_secure_mode()
        }
    }

    fun cargar_datos() {
        Thread(Runnable {
            cargar_personajes()
            //cargar_habilidades()
            cargar_datos_personaje()
        }).start()
    }

    fun cargar_datos_personaje_secure_mode() {
        if (lista_personajes.size > 0) {
            Thread(Runnable {
                val personaje = lista_personajes[index]
                cargar_habilidades_personaje(personaje.id)
                runOnUiThread {
                    personajes_tv_titulo.text = personaje.nombre
                    personajes_tv_nombreHabilidad.text = lista_habilidades_personaje[index_habilidad].nombre
                    personajes_tv_descHabilidad.text = lista_habilidades_personaje[index_habilidad].descripcion
                    cargar_fotos()
                }
            }).start()
        }
    }

    @SuppressLint("SetTextI18n")
    fun cargar_datos_personaje() {
        if (lista_personajes.size > 0) {
            val personaje = lista_personajes[index]
            cargar_habilidades_personaje(personaje.id)
            runOnUiThread {
                personajes_tv_numPersonaje.text = "${(index + 1)}/${lista_personajes.size}"
                personajes_tv_titulo.text = personaje.nombre
                personajes_tv_nombreHabilidad.text = lista_habilidades_personaje[index_habilidad].nombre
                personajes_tv_descHabilidad.text = lista_habilidades_personaje[index_habilidad].descripcion
                try { cargar_fotos() } catch (e: Exception) { Log.d("Error", e.toString()) }
            }
        }
    }

    fun cargar_habilidades_personaje(personaje_id: Int) {
        val bd_habilidades = Room.databaseBuilder(this, AppDatabase::class.java, "habilidades").build()
        lista_habilidades_personaje = try { bd_habilidades.habilidadDao().getAllChampAbilities(personaje_id) } catch (e: Exception) { listOf() }
        bd_habilidades.close()
    }

    fun cargar_personajes() {
        val bd_personajes = Room.databaseBuilder(this, AppDatabase::class.java, "personajes").build()
        lista_personajes = try { bd_personajes.personajeDao().getAll() } catch (e: Exception) { listOf() }
        bd_personajes.close()
    }

    fun cargar_fotos() {
        Picasso.with(this).load("https://i.pinimg.com/474x/44/e1/e1/44e1e10e09b6c5d1564b9266da76a463.jpg").into(personajes_i_imgpersonaje)
        Picasso.with(this).load("https://4.bp.blogspot.com/-Qbuk6jFGxPc/UFy6PTRxMrI/AAAAAAAABsg/UXZZeffnUCo/s1600/1453424.jpg").into(personajes_ib_ability_1)
        Picasso.with(this).load("https://i.pinimg.com/564x/b8/c1/e3/b8c1e36f90d68bb8b489f84cb67c41fa.jpg").into(personajes_ib_ability_2)
        Picasso.with(this).load("https://todosignificados.com/wp-content/uploads/2019/06/0c6a3ba5a4d68f0c09a1498ef85b16e5-1.jpg").into(personajes_ib_ability_3)
        Picasso.with(this).load("https://a.wattpad.com/cover/124675895-288-k3882.jpg").into(personajes_ib_ability_4)

    }

    fun cargar_fotos_backup() {
        Picasso.with(this).load(lista_personajes[index].link_imagen).into(personajes_i_imgpersonaje)
        Picasso.with(this).load(lista_habilidades_personaje[0].link_imagen).into(personajes_ib_ability_1)
        Picasso.with(this).load(lista_habilidades_personaje[1].link_imagen).into(personajes_ib_ability_2)
        Picasso.with(this).load(lista_habilidades_personaje[2].link_imagen).into(personajes_ib_ability_3)
        Picasso.with(this).load(lista_habilidades_personaje[3].link_imagen).into(personajes_ib_ability_4)
    }

    fun cargar_habilidades() {
        val bd_habilidades = Room.databaseBuilder(this, AppDatabase::class.java, "habilidades").build()
        lista_habilidades = try { bd_habilidades.habilidadDao().getAll() } catch (e: Exception) { listOf() }
        bd_habilidades.close()
    }

}
