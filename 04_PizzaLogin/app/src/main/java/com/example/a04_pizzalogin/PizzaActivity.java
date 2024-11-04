package com.example.a04_pizzalogin;

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

import com.example.a04_pizzalogin.modelo.entidad.Ingrediente;
import com.example.a04_pizzalogin.modelo.entidad.Pizza;
import com.example.a04_pizzalogin.modelo.entidad.Tamanio;
import com.example.a04_pizzalogin.modelo.entidad.Usuario;
import com.example.a04_pizzalogin.modelo.negocio.GestorPizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pizza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Object o = getIntent().getSerializableExtra("usuario");
        Usuario usuario = (Usuario)o;
        TextView tvNombreUsuario = findViewById(R.id.txVwNombreUsuario);
        TextView tvDireccionUsuario = findViewById(R.id.txVwDireccionUsuario);

        Log.wtf("PizzaActivity","Usuario: " + usuario);

        tvNombreUsuario.setText(usuario.getNombre());
        tvDireccionUsuario.setText(usuario.getDireccion());

        CheckBox cb1 = findViewById(R.id.chBxPepperoni);
        CheckBox cb2 = findViewById(R.id.chBxAlcaparras);
        CheckBox cb3 = findViewById(R.id.chBxPinia);
        CheckBox cb4 = findViewById(R.id.chBxAnchoas);

        RadioGroup rg = findViewById(R.id.radioGroupTamanosPizza);
        Button boton = findViewById(R.id.btHacerPedido);

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
                listaIngredientes.add(Ingrediente.PEPPERONI);
            }
            if(cb2.isChecked()){
                listaIngredientes.add(Ingrediente.ALCAPARRAS);
            }
            if(cb3.isChecked()) {
                listaIngredientes.add(Ingrediente.PINIA);
            }
            if(cb4.isChecked()){
                listaIngredientes.add(Ingrediente.ANCHOAS);
            }

            if(t == null){
                Toast.makeText(PizzaActivity.this,"Elija un tamaño" +
                        " porfa pls",Toast.LENGTH_LONG).show();
                return;
            }
            if(listaIngredientes.size() < 1){
                Toast.makeText(PizzaActivity.this,"Elija al menos " +
                        " un ingrediente",Toast.LENGTH_LONG).show();
                return;
            }

            Pizza pizza = new Pizza();
            pizza.setTamanio(t);
            pizza.setListaIngredientes(listaIngredientes);
            gp.calcularPrecio(pizza);

            usuario.setPizza(pizza);

            Intent i = new Intent(PizzaActivity.this, ResumenActivity.class);
            i.putExtra("usuario",usuario);
            startActivity(i);
        });

    }
}