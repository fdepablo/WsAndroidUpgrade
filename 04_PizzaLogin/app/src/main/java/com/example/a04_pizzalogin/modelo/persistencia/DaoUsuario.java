package com.example.a04_pizzalogin.modelo.persistencia;


import com.example.a04_pizzalogin.modelo.entidad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    private static List<Usuario> listaUsuarios;

    public DaoUsuario(){
        listaUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setNombre("Goku");
        usuario.setDireccion("Planeta Kaito");
        usuario.setPassword("1234");

        listaUsuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("Freezer");
        usuario.setDireccion("Planeta invierno");
        usuario.setPassword("4321");

        listaUsuarios.add(usuario);
        usuario = new Usuario();
        usuario.setNombre("Piccolo");
        usuario.setDireccion("Planeta Namek");
        usuario.setPassword("1111");
        listaUsuarios.add(usuario);
    }

    public Usuario getByName(String nombre){
        for(Usuario u : listaUsuarios){
            if(u.getNombre().equals(nombre)){
                return u;
            }
        }
        return null;
    }

}
