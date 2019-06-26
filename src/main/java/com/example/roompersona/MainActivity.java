package com.example.roompersona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.roompersona.controller.PersonaController;
import com.example.roompersona.model.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    PersonaAdapter adapter;
    ArrayList<Persona> personas;
    PersonaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        personas = new ArrayList<Persona>();
        adapter = new PersonaAdapter(this, R.layout.row, personas);
        listView.setAdapter(adapter);
        controller = PersonaController.get(this);

        /*Click a una fila del ListView*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Obrir pantalla de detall*/
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                /*Passem com a EXTRA l'id de la persona seleccionada*/
                intent.putExtra("idPersona", personas.get(position).getId());
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        showPersonas();
        /*Ho possem al onResume per a que s'actualitzi cada cop que
        * tornem a la pantalla.*/

    }

    private void showPersonas() {
        personas.clear(); //Buidar arraylist.
        personas.addAll(controller.getPersonas()); //afegir persones.
        adapter.notifyDataSetChanged(); //Avisar al adapter que refresqui la listview.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                //Obrir formulari de creació:
                Intent intent = new Intent(MainActivity.this, CreatePersonaActivity.class);
                startActivity(intent);
                return (true);

        }
            return (super.onOptionsItemSelected(item));



    }
}
