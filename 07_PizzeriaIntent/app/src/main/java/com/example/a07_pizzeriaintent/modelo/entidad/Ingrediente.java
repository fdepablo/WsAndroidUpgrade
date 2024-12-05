package com.example.a07_pizzeriaintent.modelo.entidad;

public enum Ingrediente {
    PEPPERONI("Pepperoni",2),
    ALCAPARRAS("Alcaparras", 1),
    ANCHOAS("Anchoas",3),
    PINIA("Piña", 1.5),
    MAIZ("Maiz",1.0),
    CEBOLLA("Cebolla",1.5),
    PIMIENTO("Pimiento",2.0),
    JAMON("Jamon",3.0),
    ACEITUNAS("Aceitunas",1.25)
    ;

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
