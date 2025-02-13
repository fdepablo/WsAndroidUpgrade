package com.example.firebase_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView tv = findViewById(R.id.mensaje1);
        final EditText et = findViewById(R.id.editTextMensaje);
        final Button bt = findViewById(R.id.buttonAdd);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        bt.setOnClickListener(v -> {
            String mensaje = et.getText().toString();
            Mensaje m = new Mensaje();
            m.setValor(mensaje);
            db.collection("mensajes").add(m)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(MainActivity.this,
                                "Todo bien",
                                Toast.LENGTH_LONG).show();
                    });
        });



        db.collection("mensajes")
                .document("2JdtOZ8Y0XhisWkK1HNe")
                .get().addOnSuccessListener(documentSnapshot -> {
                    String valor = documentSnapshot.getString("valor");
                    tv.setText(valor);
                });
    }
}