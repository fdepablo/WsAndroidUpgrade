package com.example.a04_pizzalogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a04_pizzalogin.modelo.entidad.Usuario;

public class ResumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        Usuario user = (Usuario) getIntent().getSerializableExtra("usuario");

        TextView txVwNombreUsuario = findViewById(R.id.txVwNombreUsuario);
        TextView txVwDireccionUsuario = findViewById(R.id.txVwDireccionUsuario);
        TextView txVwTamanoPizza = findViewById(R.id.txVwTamanoPizza);
        TextView txVwIngredientesLista = findViewById(R.id.txVwIngredientesLista);
        TextView tvPrecio = findViewById(R.id.textViewPrecio);

        txVwNombreUsuario.setText(user.getNombre());
        txVwDireccionUsuario.setText(user.getDireccion());
        txVwTamanoPizza.setText("Pizza " + user.getPizza().getTamanio().toString());
        txVwIngredientesLista.setText(user.getPizza().getListaIngredientes().toString());
        tvPrecio.setText(String.valueOf(user.getPizza().getPrecio()));
    }
}