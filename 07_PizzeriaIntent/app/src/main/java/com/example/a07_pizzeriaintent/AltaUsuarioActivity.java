package com.example.a07_pizzeriaintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a07_pizzeriaintent.modelo.entidad.Usuario;


public class AltaUsuarioActivity extends AppCompatActivity {

    private Button botonVolver;
    private EditText nombre;
    private EditText password;
    private EditText direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alta_usuario);

        botonVolver= findViewById(R.id.btnVueltaLogin);
        nombre = findViewById(R.id.NombreNuevo);
        password = findViewById(R.id.ContraseñaNueva);
        direccion = findViewById(R.id.DireccionNueva);

        botonVolver.setOnClickListener(view -> {
            Intent intent = new Intent();
            String nombreNuevo = nombre.getText().toString();
            String passwordNueva = password.getText().toString();
            String direccionNueva = direccion.getText().toString();

            if (nombreNuevo.matches("")||passwordNueva.matches("")||direccionNueva.matches("")){
                Log.v("CrearseCuentaActivity","Usuario, contraseña o direccion mal introducidos");
                setResult(0);
            }else{
                Log.v("CrearseCuentaActivity", nombre.getText().toString());
                Log.v("CrearseCuentaActivity", password.getText().toString());
                Log.v("CrearseCuentaActivity", direccion.getText().toString());
                Usuario usuario = new Usuario();
                usuario.setNombre(nombreNuevo);
                usuario.setPassword(passwordNueva);
                usuario.setDireccion(direccionNueva);

                intent.putExtra("usuario", usuario);
                setResult(1,intent);
            }
            finish();

        });
    }
}