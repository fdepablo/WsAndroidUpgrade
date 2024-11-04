package com.example.a04_pizzalogin.modelo.entidad;

public enum Tamanio {

    PEQUENIO(5),MEDIANA(10),GRANDE(15);

    private int precio;

    Tamanio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }
}
