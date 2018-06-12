package com.DAO;

import com.entities.Presentacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class PresentacionFacade extends AbstractFacade<Presentacion> implements PresentacionFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresentacionFacade() {
        super(Presentacion.class);
    }

    @Override
    public List<Presentacion> presentacionesCerradas() {
        Query q = em.createNativeQuery("SELECT p.* " +
                                " FROM presentaciones p " +
                                " WHERE p.estadoPresentacion=?", Presentacion.class);
        q.setParameter(1, 3);
        List<Presentacion> presentaciones = q.getResultList();

        for (Presentacion p : presentaciones) {
            System.out.println("Listando presentaciones cerrados");
        }
        System.out.println(presentaciones);
        
        return presentaciones;
    }

    @Override
    public List<Presentacion> presentacionesDisponibles() {
        Query q = em.createNativeQuery("SELECT p.* " +
                                " FROM presentaciones p " +
                                " WHERE p.estadoPresentacion=?", Presentacion.class);
        q.setParameter(1, 1);
        List<Presentacion> presentaciones = q.getResultList();

        for (Presentacion p : presentaciones) {
            System.out.println("Listando presentaciones disponibles");
        }
        System.out.println(presentaciones);
        
        return presentaciones;
    }

    @Override
    public void registrarPresentacion(int idPresentacion, Long noIdentificacion) {
        Query q = em.createNativeQuery("INSERT INTO usuarioswithpresentaciones (noIdentificacion, idPresentacion) VALUES (?, ?)");
        q.setParameter(1, noIdentificacion);
        q.setParameter(2, idPresentacion);
        q.executeUpdate();
    }

   
    
}
