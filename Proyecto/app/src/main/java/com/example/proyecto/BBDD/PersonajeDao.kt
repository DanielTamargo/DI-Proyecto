package com.example.proyecto.BBDD

import androidx.room.*

@Dao
interface PersonajeDao {

    @Query("SELECT * FROM personajes")
    fun getAll(): List<Personaje>

    @Query("SELECT * FROM personajes WHERE id = :id")
    fun findById(id: Int): Personaje

    @Update
    fun updateCharacter(vararg personaje: Personaje)

    @Insert
    fun insertAll(vararg personajes: Personaje)

    @Delete
    fun delete(personaje: Personaje)

}