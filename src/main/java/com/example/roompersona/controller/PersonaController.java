package com.example.roompersona.controller;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.roompersona.database.PersonaDao;
import com.example.roompersona.database.PersonaDatabase;
import com.example.roompersona.model.Persona;

import java.util.List;

public class PersonaController {

    private static PersonaController controller;

    private PersonaDao personaDao;

    private PersonaController(Context context){
        Context appContext = context.getApplicationContext();
        PersonaDatabase database = Room.databaseBuilder(appContext, PersonaDatabase.class, "nota")
                .allowMainThreadQueries().build();
        personaDao= database.getPersonaDao();
    }

    public static PersonaController get (Context context)
    {
        if (controller == null){
            controller = new PersonaController(context);
        }
        return controller;
    }

    public List<Persona> getPersonas()
    {
        return personaDao.getPersonas();
    }

    public Persona getPersona(String id)
    {
        return personaDao.getPersona(id);
    }

    public void createPersona(Persona p)
    {
        personaDao.addPersona(p);
    }

    public void deletePersona(Persona p)
    {
        personaDao.deletePersona(p);
    }

    public void updatePersona(Persona p)
    {
        personaDao.updatePersona(p);
    }
}
