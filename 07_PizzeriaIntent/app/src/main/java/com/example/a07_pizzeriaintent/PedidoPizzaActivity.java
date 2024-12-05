package com.example.a07_pizzeriaintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a07_pizzeriaintent.modelo.entidad.Ingrediente;
import com.example.a07_pizzeriaintent.modelo.entidad.Pizza;
import com.example.a07_pizzeriaintent.modelo.entidad.Tamanio;
import com.example.a07_pizzeriaintent.modelo.entidad.Usuario;
import com.example.a07_pizzeriaintent.modelo.negocio.GestorPizza;

import java.util.ArrayList;
import java.util.List;

public class PedidoPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido_pizza);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pedido), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Object o = getIntent().getSerializableExtra("usuario");
        Usuario usuario = (Usuario)o;
        TextView tvNombreUsuario = findViewById(R.id.tvNombreUsuario);
        TextView tvDireccionUsuario = findViewById(R.id.tvDireccionUsuario);

        Log.wtf("PizzaActivity","Usuario: " + usuario);

        tvNombreUsuario.setText(usuario.getNombre());
        tvDireccionUsuario.setText(usuario.getDireccion());

        CheckBox cb1 = findViewById(R.id.Piña);
        CheckBox cb2 = findViewById(R.id.Alcaparras);
        CheckBox cb3 = findViewById(R.id.Pepperoni);

        CheckBox cb4 = findViewById(R.id.Pimiento);
        CheckBox cb5 = findViewById(R.id.Cebolla);
        CheckBox cb6 = findViewById(R.id.Aceitunas);

        CheckBox cb7 = findViewById(R.id.Anchoas);
        CheckBox cb8 = findViewById(R.id.Maiz);
        CheckBox cb9 = findViewById(R.id.Jamon);

        RadioGroup rg = findViewById(R.id.rgTamanio);
        Button boton = findViewById(R.id.hacerPedido);

        GestorPizza gp = new GestorPizza();

        boton.setOnClickListener(view -> {
            int id = rg.getCheckedRadioButtonId();
            Tamanio t = null;
            if(id == R.id.rBtGrande){
                t = Tamanio.GRANDE;
            }else if(id == R.id.rBtMediana){
                t = Tamanio.MEDIANA;
            }else if(id == R.id.rBtPequena){
                t = Tamanio.PEQUENIO;
            }

            List<Ingrediente> listaIngredientes = new ArrayList<>();

            if(cb1.isChecked()){
                listaIngredientes.add(Ingrediente.PINIA);
            }
            if(cb2.isChecked()){
                listaIngredientes.add(Ingrediente.ALCAPARRAS);
            }
            if(cb3.isChecked()) {
                listaIngredientes.add(Ingrediente.PEPPERONI);
            }

            if(cb4.isChecked()){
                listaIngredientes.add(Ingrediente.PIMIENTO);
            }
            if(cb5.isChecked()){
                listaIngredientes.add(Ingrediente.CEBOLLA);
            }
            if(cb6.isChecked()) {
                listaIngredientes.add(Ingrediente.ACEITUNAS);
            }

            if(cb7.isChecked()){
                listaIngredientes.add(Ingrediente.ANCHOAS);
            }
            if(cb8.isChecked()){
                listaIngredientes.add(Ingrediente.MAIZ);
            }
            if(cb9.isChecked()) {
                listaIngredientes.add(Ingrediente.JAMON);
            }


            if(t == null){
                Toast.makeText(PedidoPizzaActivity.this,"Elija un tamaño" +
                        " porfa pls",Toast.LENGTH_LONG).show();
                return;
            }
            if(listaIngredientes.size() < 1){
                Toast.makeText(PedidoPizzaActivity.this,"Elija al menos " +
                        " un ingrediente",Toast.LENGTH_LONG).show();
                return;
            }

            Pizza pizza = new Pizza();
            pizza.setTamanio(t);
            pizza.setListaIngredientes(listaIngredientes);
            gp.calcularPrecio(pizza);

            usuario.setPizza(pizza);

            Intent i = new Intent(PedidoPizzaActivity.this, ResumenPedidoActivity.class);
            i.putExtra("usuario",usuario);
            startActivity(i);
        });
    }
}