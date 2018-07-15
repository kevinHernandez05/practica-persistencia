package com.example.smsma.proyecto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView nombre,
            acercaDe,
            proyectos,
            repositorios,
            estrellas;

    Button share;

    usuario usuarioActual;

    private final String USUARIO_DATA = "PERFIL_USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nombre = findViewById(R.id.nombreText);
        acercaDe = findViewById(R.id.acercaDeText); //el texto esta seleccionado
        proyectos = findViewById(R.id.proyectosText);
        repositorios = findViewById(R.id.repositoriosText);
        estrellas = findViewById(R.id.estrellasText);
        share = findViewById(R.id.shareData);

        if (getIntent() != null & getIntent().getExtras() != null) {
            usuarioActual = getIntent().getParcelableExtra(USUARIO_DATA);
            setTitle("Perfil de " + usuarioActual.getNombre());

            usuarioActual.setAcercaDe("I'm a Videogame Developer, C# with Unity, C++ for Unreal Engine."); //poniendolo otra vez en caso de

            if(usuarioActual != null){
                nombre.setText(String.valueOf(usuarioActual.getNombre()));
                acercaDe.setText(String.valueOf(usuarioActual.getAcercaDe()));// se supone que el texto se esta pasando
                proyectos.setText(String.valueOf(usuarioActual.getProyectos()));
                repositorios.setText(String.valueOf(usuarioActual.getRepositorios()));
                estrellas.setText(String.valueOf(usuarioActual.getEstrellas()));
            }
        }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareUserData(usuarioActual);
            }
        });

    }

    private void shareUserData(usuario i){
        Intent enviar = new Intent();

        String usuarioEnviado = "Usuario: "+ usuarioActual.getNombre() + "\nEste usuario es experto en: " + usuarioActual.getAcercaDe();
        enviar.setAction(Intent.ACTION_SEND);
        enviar.putExtra(Intent.EXTRA_TEXT, usuarioEnviado);
        enviar.setType("text/plain");

        startActivity(enviar);
    }
}
