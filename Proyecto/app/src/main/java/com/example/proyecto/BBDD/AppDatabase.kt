package com.example.proyecto.BBDD

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Personaje::class, Habilidad::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personajeDao(): PersonajeDao
    abstract fun habilidadDao(): HabilidadDao
}