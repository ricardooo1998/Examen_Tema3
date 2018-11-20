package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodosEstudiantes extends AppCompatActivity {
    Button cancelar;
    TextView alumnos;
    private MyDBAdapter myDBAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_estudiantes);
        myDBAdapter = new MyDBAdapter(this);
        cancelar = findViewById(R.id.cancelarTodos);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });

        myDBAdapter.open();

        TextView alumnos = (TextView) this.findViewById(R.id.alumnos);
        ArrayList<String> arrayAlumnos = myDBAdapter.recuperarAlumnos();
        alumnos.setText("");

        for(int cont=0;cont<arrayAlumnos.size();cont++){
            alumnos.setText(alumnos.getText()+" "+arrayAlumnos.get(cont)+"\n");

        }
    }

}
