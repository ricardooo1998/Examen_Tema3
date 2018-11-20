package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MostrarAlumnosProfesores extends AppCompatActivity {
    private MyDBAdapter myDBAdapter;
    Button cancelar;
    TextView resultadoProfesores;
    TextView resultadoAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alumnos_profesores);
        cancelar = findViewById(R.id.cancelarTodo);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });
        resultadoProfesores = findViewById(R.id.resultadoProfesores);
        resultadoAlumnos = findViewById(R.id.resultadoAlumnos);

        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();

        ArrayList<String> alumnos = myDBAdapter.recuperarAlumnos();
        resultadoAlumnos.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            resultadoAlumnos.setText(resultadoAlumnos.getText()+" "+alumnos.get(cont)+"\n");

        }

        ArrayList<String> profesores = myDBAdapter.recuperarProfesores();
        resultadoProfesores.setText("");
        for(int cont=0;cont<profesores.size();cont++){
            resultadoProfesores.setText(resultadoProfesores.getText()+" "+profesores.get(cont)+"\n");
        }
    }
}
