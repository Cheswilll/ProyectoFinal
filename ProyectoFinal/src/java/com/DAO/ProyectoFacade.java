package com.DAO;

import com.entities.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> implements ProyectoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    @Override
    public List<Proyecto> proyectosCerrados() {
        Query q = em.createNativeQuery("SELECT p.* " +
                                " FROM proyectos p " +
                                " WHERE p.estadoProyecto=?", Proyecto.class);
        q.setParameter(1, 3);
        List<Proyecto> proyectos = q.getResultList();

        for (Proyecto p : proyectos) {
            System.out.println("Listando proyectos cerrados");
        }
        System.out.println(proyectos);
        
        return proyectos;
    }

    @Override
    public List<Proyecto> proyectosDisponibles() {
        Query q = em.createNativeQuery("SELECT p.* " +
                                " FROM proyectos p " +
                                " WHERE p.estadoProyecto=?", Proyecto.class);
        q.setParameter(1, 1);
        List<Proyecto> proyectos = q.getResultList();

        for (Proyecto p : proyectos) {
            System.out.println("Listando proyectos disponibles");
        }
        System.out.println(proyectos);
        
        return proyectos;
    }
    
}
