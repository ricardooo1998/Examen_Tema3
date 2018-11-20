package com.tema3.ricardo.tema3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    EditText nombreUsuario;
    EditText fechaNacimiento;
    Button guardar;
    Button mostrar;
    Button registrarAlumno;
    Button registrarProfesor;
    Button consultas;
    RadioButton hombre;
    RadioButton mujer;
    private static final String prefs="Mis Preferencias";




    Button consultarAlumnoNombreEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        fechaNacimiento = findViewById(R.id.fechaNacimineto);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);

        guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sexo;
                if (hombre.isChecked())
                {
                    sexo="Hombre";
                }
                else
                {
                    if (mujer.isChecked())
                    {
                        sexo="Mujer";
                    }
                    else {
                        sexo="Ningún sexo seleccionado";
                    }
                }
                SharedPreferences misPrefs = getSharedPreferences(prefs, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = misPrefs.edit();
                editor.putString("nombre", nombre.getText().toString());
                editor.putString("nombreUsuario", nombreUsuario.getText().toString());
                editor.putString("fechaNacimiento", fechaNacimiento.getText().toString());
                editor.putString("sexo", sexo);
                editor.commit();
            }
        });
        mostrar = findViewById(R.id.mostrar);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences misPrefs = getSharedPreferences(prefs, Activity.MODE_PRIVATE);
                String nombre = misPrefs.getString("nombre","");
                String nombreUsuario = misPrefs.getString("nombreUsuario","");
                String fecha = misPrefs.getString("fechaNacimiento","");
                String sexo = misPrefs.getString("sexo","");
                Toast.makeText(getApplicationContext(), "Nombre: "+nombre+" Nombre de Usuario: "+nombreUsuario+" Fecha de Nacimiento: "+fecha+" Sexo: "+sexo, Toast.LENGTH_LONG).show();

            }
        });

        registrarAlumno = findViewById(R.id.registrarAlumno);
        registrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrarAlumno.class);
                startActivity(i);
            }
        });


        consultas = findViewById(R.id.consultas);
        consultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivity(i);
            }
        });

        registrarProfesor = findViewById(R.id.registrarProfesor);
        registrarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistrarProfesor.class);
                startActivity(i);
            }
        });

        consultarAlumnoNombreEdad = findViewById(R.id.consultarAlumnosEdad);
        consultarAlumnoNombreEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AlumnosPorNombreEdad.class);
                startActivity(i);
            }
        });
    }
}
