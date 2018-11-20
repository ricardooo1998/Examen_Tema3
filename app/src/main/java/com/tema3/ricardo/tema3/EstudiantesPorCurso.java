package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EstudiantesPorCurso extends AppCompatActivity {
    Button cancelar;
    Button buscar;
    TextView resultado;
    EditText cursoBuscar;
    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_curso);
        cancelar = findViewById(R.id.cancelarCurso);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });

        resultado = findViewById(R.id.resultadoBuscarCurso);
        cursoBuscar = findViewById(R.id.buscarCurso);
        buscar = findViewById(R.id.buscarAlumnosCurso);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(cursoBuscar.getText().toString());
            }
        });
    }

    private void buscar(String curso){
        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();
        ArrayList<String> alumnos = myDBAdapter.recuperarAlumnosPorCurso(curso);
        this.resultado.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            resultado.setText(resultado.getText()+" "+alumnos.get(cont)+"\n");
        }
    }
}
