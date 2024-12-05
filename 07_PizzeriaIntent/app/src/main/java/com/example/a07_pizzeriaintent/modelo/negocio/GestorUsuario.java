package com.example.a07_pizzeriaintent.modelo.negocio;

import com.example.a07_pizzeriaintent.modelo.entidad.Usuario;
import com.example.a07_pizzeriaintent.modelo.persistencia.DaoUsuario;

public class GestorUsuario {

   private DaoUsuario du;

    public Usuario validar(Usuario u){
        du = DaoUsuario.getInstance();
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

    public boolean alta(Usuario user){
        return DaoUsuario.getInstance().alta(user);
    }
}
