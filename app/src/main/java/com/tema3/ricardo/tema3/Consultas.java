package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Consultas extends AppCompatActivity {
    Button todosEstudiantes;
    Button cancelar;
    Button estudiantesCiclo;
    Button estudiantesCurso;
    Button todosProfesores;
    Button todo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        todosEstudiantes = findViewById(R.id.todosEstudiantes);
        todosEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodosEstudiantes.class);
                startActivity(i);
            }
        });

        cancelar = findViewById(R.id.cancelarConsultas);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        estudiantesCiclo = findViewById(R.id.estudiantesCiclo);
        estudiantesCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EstudiantesPorCiclo.class);
                startActivity(i);
            }
        });

        estudiantesCurso = findViewById(R.id.estudiantesCurso);
        estudiantesCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EstudiantesPorCurso.class);
                startActivity(i);
            }
        });

        todosProfesores = findViewById(R.id.todosProfesores);
        todosProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodosProfesores.class);
                startActivity(i);
            }
        });

        todo = findViewById(R.id.todosLosAlumnosProfesores);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MostrarAlumnosProfesores.class);
                startActivity(i);
            }
        });
    }
}
