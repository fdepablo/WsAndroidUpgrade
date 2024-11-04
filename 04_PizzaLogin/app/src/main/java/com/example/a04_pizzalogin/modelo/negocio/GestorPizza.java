package com.example.a04_pizzalogin.modelo.negocio;


import com.example.a04_pizzalogin.modelo.entidad.Ingrediente;
import com.example.a04_pizzalogin.modelo.entidad.Pizza;

public class GestorPizza {

    public void calcularPrecio(Pizza pizza){
        double precioTotal = pizza.getTamanio().getPrecio();

        for(Ingrediente i : pizza.getListaIngredientes()){
            precioTotal += i.getPrecio();
        }

        pizza.setPrecio(precioTotal);
    }
}
