package com.example.proyecto.BBDD

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//Documentación básica: https://developer.android.com/training/data-storage/room/defining-data#kotlin
//Documentación relaciones: https://developer.android.com/training/data-storage/room/relationships

//val bd = Room.databaseBuilder(this, AppDatabase::class.java, "habilidades").build()

@Entity(tableName = "habilidades",
    foreignKeys = [ForeignKey(
        entity = Personaje::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_personaje"))]
)
data class Habilidad (
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "nombre") val nombre: String = "Habilidad QM",
    @ColumnInfo(name = "descripcion") val descripcion: String = "Descripción QM QM QM",
    @ColumnInfo(name = "link_imagen") val link_imagen: String = "https://i.gyazo.com/320bf005f2dca2ffde6748cf15798c98.png",
    @ColumnInfo(name = "id_personaje") val id_personaje: Int = 1
)