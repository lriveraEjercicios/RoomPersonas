package com.example.roompersona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roompersona.controller.PersonaController;
import com.example.roompersona.model.Persona;

public class CreatePersonaActivity extends AppCompatActivity {

    EditText et_name, et_surname, et_age, et_mail;
    PersonaController controller;
    Persona persona;
    String id;
    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_persona);

        et_name = findViewById(R.id.et_name);
        et_surname = findViewById(R.id.et_surname);
        et_age = findViewById(R.id.et_age);
        et_mail = findViewById(R.id.et_mail);
        btn_create = findViewById(R.id.btn_create);

        controller = PersonaController.get(this);

        /*Recollim l'extra ID per veure si estem editant*/
        id = getIntent().getStringExtra("idPersona");
        if (id != null) //si no es null, recollir dades de la persona
        {
            persona = controller.getPersona(id);
            //Mostrar les dades per pantalla
            showPersona();
        }
    }

    private void showPersona() {
        et_name.setText(persona.getName());
        et_surname.setText(persona.getSurname());
        et_mail.setText(persona.getMail());
        et_age.setText(String.valueOf(persona.getAge()));

        btn_create.setText("Modificar"); //Modificar el text del botó
    }

    public void createPressed(View view) {
        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String mail = et_mail.getText().toString();
        String age = et_age.getText().toString();

        //comprovar buits
        if (checkFields(name, surname, age, mail)) {
            if (id != null) {
                //Si tenim ID, estem editant, fem SETS
                persona.setName(name);
                persona.setSurname(surname);
                persona.setAge(Integer.parseInt(age));
                persona.setMail(mail);
                //Cridem al update a la bbdd:
                controller.updatePersona(persona);

            } else {
                Persona p = new Persona(name, surname, Integer.parseInt(age), mail);
                controller.createPersona(p); //crear persona al sqlite

            }
            finish(); //Tancar pantalla
        }
    }

    private boolean checkFields(String name, String surname, String age, String mail) {
        boolean valid = true;
        if ("".equals(name)) {
            et_name.setError("Nombre no puede ser vacío");
            valid = false;
        }
        if ("".equals(surname)) {
            et_surname.setError("Apellido no puede ser vacío");
            valid = false;
        }
        if ("".equals(age)) {
            et_age.setError("Edad no puede ser vacío");
            valid = false;
        }
        if ("".equals(mail)) {
            et_mail.setError("E-mail no puede ser vacío");
            valid = false;
        }
        return valid;
    }
}
