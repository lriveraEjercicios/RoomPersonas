package com.example.roompersona;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roompersona.model.Persona;

import java.util.ArrayList;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    int layoutResourceId;
    Context context;
    ArrayList<Persona> data;

    public PersonaAdapter(Context context, int layoutResourceId, ArrayList<Persona> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_text = row.findViewById(R.id.text);
        String name = data.get(position).getName() + " " + data.get(position).getSurname();
        tv_text.setText(name);

        return row;
    }
}
