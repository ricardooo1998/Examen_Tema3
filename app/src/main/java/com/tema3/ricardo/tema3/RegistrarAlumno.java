package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarAlumno extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    EditText ciclo;
    EditText curso;
    Button cancelar;
    Button registrarAlumno;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);
        cancelar = (Button)findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        nombre = findViewById(R.id.nombreAlumno);
        edad = findViewById(R.id.edadAlumno);
        ciclo = findViewById(R.id.cicloAlumno);
        curso = findViewById(R.id.cursoAlumno);

        registrarAlumno = findViewById(R.id.registrarAlumno);
        dbAdapter = new MyDBAdapter(this);
        registrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insertarAlumno(nombre.getText().toString(), edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString());
            }
        });
    }
}
