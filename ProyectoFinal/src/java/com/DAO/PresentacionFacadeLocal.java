package com.DAO;

import com.entities.Presentacion;
import java.util.List;
import javax.ejb.Local;


@Local
public interface PresentacionFacadeLocal {

    void create(Presentacion presentacion);

    void edit(Presentacion presentacion);

    void remove(Presentacion presentacion);

    Presentacion find(Object id);

    List<Presentacion> findAll();

    List<Presentacion> findRange(int[] range);

    int count();
    
    List<Presentacion> presentacionesCerradas();
    
    List<Presentacion> presentacionesDisponibles();
    
    List<Presentacion> presentacionesAgregadas(Long noIdentificacion);
    
    void registrarPresentacion(int idPresentacion, Long noIdentificacion);
    
}
