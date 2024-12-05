package com.example.a07_pizzeriaintent.modelo.negocio;

import com.example.a07_pizzeriaintent.modelo.entidad.Ingrediente;
import com.example.a07_pizzeriaintent.modelo.entidad.Pizza;

public class GestorPizza {

    public void calcularPrecio(Pizza pizza){
        double precioTotal = pizza.getTamanio().getPrecio();

        for(Ingrediente i : pizza.getListaIngredientes()){
            precioTotal += i.getPrecio();
        }

        pizza.setPrecio(precioTotal);
    }
}
