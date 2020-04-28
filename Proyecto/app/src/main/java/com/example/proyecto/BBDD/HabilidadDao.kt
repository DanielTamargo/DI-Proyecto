package com.example.proyecto.BBDD

import androidx.room.*

@Dao
interface HabilidadDao {

    @Query("SELECT * FROM habilidades")
    fun getAll(): List<Habilidad>

    @Query("SELECT * FROM habilidades WHERE id_personaje = :id_personaje")
    fun getAllChampAbilities(id_personaje: Int): List<Habilidad>

    @Query("SELECT * FROM habilidades WHERE id = :id")
    fun findById(id: Int): Habilidad

    @Update
    fun updateAbility(vararg habilidad: Habilidad)

    @Insert
    fun insertAll(vararg habilidades: Habilidad)

    @Delete
    fun delete(habilidad: Habilidad)

}