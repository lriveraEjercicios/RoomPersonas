package com.example.roompersona.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.roompersona.model.Persona;

@Database(entities = {Persona.class}, version = 1)
public abstract class PersonaDatabase extends RoomDatabase {
    public abstract PersonaDao getPersonaDao();
}
