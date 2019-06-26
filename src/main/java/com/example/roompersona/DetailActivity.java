package com.example.roompersona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.roompersona.controller.PersonaController;
import com.example.roompersona.model.Persona;

public class DetailActivity extends AppCompatActivity {

    PersonaController controller;
    Persona persona;

    TextView tv_id, tv_name, tv_surname, tv_age, tv_mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        /*Recollir l'id de la persona seleccionada a la llista*/
        String id = getIntent().getStringExtra("idPersona");

        /*Agafem la persona de la base de dades SQLite per ID*/
        controller = PersonaController.get(this);
        persona = controller.getPersona(id);

        /*Inicialitzar els TextView*/
        tv_id = findViewById(R.id.tv_id);
        tv_name = findViewById(R.id.tv_name);
        tv_surname = findViewById(R.id.tv_surname);
        tv_age = findViewById(R.id.tv_age);
        tv_mail = findViewById(R.id.tv_mail);

        showPersona();
    }

    /*Mostrar les dades de persona als TextView*/
    private void showPersona()
    {
        tv_id.setText(persona.getId());
        tv_name.setText(persona.getName());
        tv_surname.setText(persona.getSurname());
        tv_mail.setText(persona.getMail());
        tv_age.setText(String.valueOf(persona.getAge()));
    }

    public void deletePressed(View view) {
        controller.deletePersona(persona);
        finish();
    }

    public void editPressed(View view) {
        Intent intent = new Intent(DetailActivity.this, CreatePersonaActivity.class);
        intent.putExtra("idPersona",persona.getId());
        startActivity(intent);
        finish();
    }
}
