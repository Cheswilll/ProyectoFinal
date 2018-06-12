package com.DAO;

import com.entities.Grupo;
import com.entities.Proyecto;
import java.security.acl.Group;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GrupoFacadeLocal {

    void create(Grupo grupo);

    void edit(Grupo grupo);

    void remove(Grupo grupo);

    Grupo find(Object id);

    List<Grupo> findAll();

    List<Grupo> findRange(int[] range);

    int count();
    
    List<Grupo> listarGrupos(int idProyecto);
}
