package com.tema3.ricardo.tema3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AlumnosPorNombreEdad extends AppCompatActivity {
    TextView resultado;
    EditText nombre;
    EditText edad;
    Button buscar;
    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_por_nombre_edad);

        myDBAdapter = new MyDBAdapter(this);
        buscar = findViewById(R.id.buttonBuscar);
        nombre = findViewById(R.id.editNombreAlumno);
        edad = findViewById(R.id.editEdadAlumno);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(nombre.getText().toString(), edad.getText().toString());
            }
        });
    }

    private void buscar(String nombre, String edad){
        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();
        ArrayList<String> alumnos = myDBAdapter.recuperarAlumnosNombreEdad(nombre, edad);
        this.resultado.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            resultado.setText(resultado.getText()+" "+alumnos.get(cont)+"\n");
        }
    }
}
