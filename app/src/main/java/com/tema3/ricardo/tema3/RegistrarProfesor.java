package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarProfesor extends AppCompatActivity {
    Button cancelar;
    Button registrarProfesor;
    EditText nombre;
    EditText edad;
    EditText ciclo;
    EditText curso;
    EditText despacho;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);
        cancelar = findViewById(R.id.cancelarProfesor);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        dbAdapter = new MyDBAdapter(this);
        nombre = findViewById(R.id.nombreProfesor);
        edad = findViewById(R.id.edadProfesor);
        ciclo = findViewById(R.id.cicloProfesor);
        curso = findViewById(R.id.cursoProfesor);
        despacho = findViewById(R.id.despachoProfesor);


        registrarProfesor = findViewById(R.id.registrarProfesor);
        registrarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insertarProfesor(nombre.getText().toString(),edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString(), despacho.getText().toString());
            }
        });
    }
}
