package com.example.roompersona.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.roompersona.model.Persona;

import java.util.List;

@Dao
public interface PersonaDao {
    @Query("SELECT * From persona")
    List<Persona> getPersonas();

    @Query("SELECT * FROM persona where id like :uuid")
    Persona getPersona(String uuid);

    @Insert
    void addPersona(Persona n);

    @Delete
    void deletePersona(Persona n);

    @Update
    void updatePersona(Persona n);
}
