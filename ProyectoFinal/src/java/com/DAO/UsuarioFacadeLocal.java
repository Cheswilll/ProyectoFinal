package com.DAO;

import com.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario login(Long noidentificacion, String contraseña);
    
    List<Usuario> usuariosInactivos();
    List<Usuario> usuariosEstudiantes();
}
