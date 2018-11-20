package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EstudiantesPorCiclo extends AppCompatActivity {
    Button cancelar;
    Button buscar;
    EditText ciclo;
    TextView estudiantesCiclo;
    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_ciclo);
        cancelar = findViewById(R.id.cancelarBuscarCiclo);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });
        ciclo = findViewById(R.id.cicloBuscar);
        myDBAdapter = new MyDBAdapter(this);
        estudiantesCiclo = findViewById(R.id.estudiantesPorCiclo);
        buscar = findViewById(R.id.buscarCiclo);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(ciclo.getText().toString());
            }
        });

    }

    private void buscar(String ciclo){
        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();
        ArrayList<String> alumnos = myDBAdapter.recuperarAlumnosPorCiclo(ciclo);
        this.estudiantesCiclo.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            estudiantesCiclo.setText(estudiantesCiclo.getText()+" "+alumnos.get(cont)+"\n");
        }
    }
}
