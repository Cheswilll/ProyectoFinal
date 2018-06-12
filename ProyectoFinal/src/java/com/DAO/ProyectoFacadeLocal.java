package com.DAO;

import com.entities.Grupo;
import com.entities.Proyecto;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProyectoFacadeLocal {

    void create(Proyecto proyecto);

    void edit(Proyecto proyecto);

    void remove(Proyecto proyecto);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int[] range);

    int count();
    
    List<Proyecto> proyectosCerrados();
    
    List<Proyecto> proyectosDisponibles();
    
    
}
