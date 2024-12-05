package com.example.a07_pizzeriaintent.modelo.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String password;
    private String direccion;
    private Pizza pizza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
