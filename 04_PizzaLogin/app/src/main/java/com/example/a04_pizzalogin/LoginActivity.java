package com.example.a04_pizzalogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a04_pizzalogin.modelo.entidad.Usuario;
import com.example.a04_pizzalogin.modelo.negocio.GestorUsuario;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etNombre = findViewById(R.id.edTextNombre);
        EditText etPassword = findViewById(R.id.edTextPass);
        Button botonLogin = findViewById(R.id.btDoLogin);
        GestorUsuario gu = new GestorUsuario();

        botonLogin.setOnClickListener(view -> {
            Usuario usuario = new Usuario();
            usuario.setNombre(etNombre.getText().toString());
            usuario.setPassword(etPassword.getText().toString());
            usuario = gu.validar(usuario);
            if(usuario != null){
                //Ir a la siguiente actividad
                Intent i = new Intent(LoginActivity.this,PizzaActivity.class);
                i.putExtra("usuario",usuario);
                startActivity(i);
            }else{
                Toast.makeText(LoginActivity.this,"Usuario o password" +
                        " incorrecto",Toast.LENGTH_LONG).show();
            }
        });


    }
}