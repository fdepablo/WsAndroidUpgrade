package com.example.a07_pizzeriaintent.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {
    private Tamanio tamanio;
    private List<Ingrediente> listaIngredientes;
    private double precio;

    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
