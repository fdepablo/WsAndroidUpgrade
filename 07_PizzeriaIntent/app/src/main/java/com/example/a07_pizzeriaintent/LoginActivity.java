package com.example.a07_pizzeriaintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a07_pizzeriaintent.modelo.entidad.Usuario;
import com.example.a07_pizzeriaintent.modelo.negocio.GestorUsuario;

public class LoginActivity extends AppCompatActivity {

    private Button botonDoLogin;
    private Button botonGoToNewUser;
    private EditText etUserName;
    private EditText etUserPass;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonDoLogin = findViewById(R.id.botonLogin);
        botonGoToNewUser = findViewById(R.id.botonCrearseCuenta);
        etUserName = findViewById(R.id.Nombre);
        etUserPass = findViewById(R.id.Password);
        tvMessage = findViewById(R.id.Mensaje);

        if(savedInstanceState != null){
            String mensaje = savedInstanceState.getString("mensaje");
            if(mensaje == null){
                tvMessage.setText("");
            }else{
                tvMessage.setText(mensaje);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        botonDoLogin.setOnClickListener(view -> {
            String nombre = etUserName.getText().toString();
            String pass = etUserPass.getText().toString();

            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setPassword(pass);

            GestorUsuario gu = new GestorUsuario();

            Usuario user = gu.validar(u);

            if(user != null){
                Intent i = new Intent(LoginActivity.this,PedidoPizzaActivity.class);
                i.putExtra("usuario",user);
                startActivity(i);
            }else{
                tvMessage.setText("Usuario o contraseña incorrectos");
            }

        });

        final ActivityResultLauncher<Intent> activityForResultLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            //Codigo que se ejecutará al volver de la activity
                            //AltaUsuarioActivity
                            if(result.getResultCode() == 1){
                                GestorUsuario gu = new GestorUsuario();
                                Usuario user = (Usuario) result.getData().getSerializableExtra("usuario");
                                gu.alta(user);

                                etUserName.setText(user.getNombre());
                                etUserPass.setText(user.getPassword());
                            }else{
                                Toast.makeText(LoginActivity.this,
                                        "Error al cargar el usuario",
                                        Toast.LENGTH_SHORT).show();
                                etUserName.setText("");
                                etUserPass.setText("");
                            }
                        }
                );

        botonGoToNewUser.setOnClickListener(view -> {
            Intent intent = new Intent(this,AltaUsuarioActivity.class);
            activityForResultLauncher.launch(intent);
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mensaje",tvMessage.getText().toString());
    }
}