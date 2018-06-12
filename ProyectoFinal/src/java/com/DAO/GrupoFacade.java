package com.DAO;

import com.entities.Grupo;
import com.entities.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class GrupoFacade extends AbstractFacade<Grupo> implements GrupoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoFacade() {
        super(Grupo.class);
    }

    
    @Override
    public List<Grupo> listarGrupos(int idProyecto) {
        Query q = em.createNativeQuery("SELECT g.* FROM grupos g WHERE g.noIdentificacion IS NULL AND g.idProyecto=?", Grupo.class);
   
        q.setParameter(1, idProyecto);
        List<Grupo> grupos = q.getResultList();

        for (Grupo g : grupos) {
            System.out.println("Listando grupos");
        }
        System.out.println(grupos);
        
        return grupos;
    }
    
}
