package com.example.smsma.proyecto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class exampleActivity extends AppCompatActivity {


    EditText textEmail;
    EditText textPass;
    Toast alert;
    HashMap<String, usuario> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        //Controles
        setTitle("DominicanStack");
        Button btnButton = (Button) findViewById(R.id.btnLogin);
        this.textEmail = findViewById(R.id.nombreText);
        this.textPass = findViewById(R.id.passText);

        crearNuevoUsuario(); //Se crea Kevin Hernandez

        //al iniciar sesion...
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = "";
                String pass = "";

                if (textEmail != null) {
                    email = textEmail.getText().toString().toLowerCase();
                }

                if (textPass != null) {
                    pass = textPass.getText().toString();
                }


                //se toma el correo de la persona creada:
                usuario usuarioActual = data.get(email);


                if (usuarioActual != null && pass.equals("123456")) {
                   try{
                       Intent login = new Intent(getApplicationContext(), ProfileActivity.class);
                       login.putExtra("PERFIL_USUARIO", usuarioActual);
                       startActivity(login);
                   }
                   catch (Exception e){
                       alert = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
                       alert.show();
                   }
                } else {
                    alert = Toast.makeText(getApplicationContext(), "Debe introducir sus credenciales", Toast.LENGTH_SHORT);
                    alert.show();
                }
            }
        });
    }

    //Crear nuevo usuario!
    private void crearNuevoUsuario() {

        usuario nuevoUsuario = new usuario();

        nuevoUsuario.setNombre("Kevin Hernandez Avelino");
        nuevoUsuario.setAcercaDe("I'm a Videogame Developer, C# with Unity, C++ for Unreal Engine.");
        nuevoUsuario.setEstrellas(50);
        nuevoUsuario.setProyectos(62);
        nuevoUsuario.setRepositorios(20);

        data = new HashMap<>();
        data.put("kevin.hdez6@gmail.com", nuevoUsuario);
    }
}
