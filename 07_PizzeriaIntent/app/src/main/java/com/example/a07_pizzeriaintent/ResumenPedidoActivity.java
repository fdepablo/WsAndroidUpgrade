package com.example.a07_pizzeriaintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a07_pizzeriaintent.modelo.entidad.Usuario;

public class ResumenPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen_pedido);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resumen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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