package com.tema3.ricardo.tema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodosProfesores extends AppCompatActivity {
    private MyDBAdapter myDBAdapter;
    Button cancelar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_profesores);

        cancelar = findViewById(R.id.cancelarTodosProfesores);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });

        resultado = findViewById(R.id.todosLosProfesores);
        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();

        ArrayList<String> profesor = myDBAdapter.recuperarProfesores();
        resultado.setText("");
        for(int cont=0;cont<profesor.size();cont++){
            resultado.setText(resultado.getText()+" "+profesor.get(cont)+"\n");

        }
    }
}
