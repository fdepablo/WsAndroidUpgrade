package com.example.a04_pizzalogin.modelo.entidad;

public enum Ingrediente {
    PEPPERONI("Pepperoni",2),
    ALCAPARRAS("Alcaparras", 1),
    ANCHOAS("Anchoas",3),
    PINIA("Piña", 1.5);

    private String nombre;
    private double precio;

    private Ingrediente(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
