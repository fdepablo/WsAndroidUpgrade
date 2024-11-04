package com.example.a04_pizzalogin.modelo.negocio;

import com.example.a04_pizzalogin.modelo.entidad.Usuario;
import com.example.a04_pizzalogin.modelo.persistencia.DaoUsuario;

public class GestorUsuario {

   private DaoUsuario du;

    public Usuario validar(Usuario u){
        du = new DaoUsuario();
        Usuario usuarioDao = du.getByName(u.getNombre());
        if(usuarioDao == null){
            return null;
        }
        if(usuarioDao.getPassword().equals(u.getPassword())){
            return usuarioDao;
        }else{
            return null;
        }
    }
}
