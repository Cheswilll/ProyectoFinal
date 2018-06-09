package com.tipoIdentificacionControllers;

import com.DAO.TipoIdentificacionFacadeLocal;
import com.entities.TipoIdentificacion;
import com.util.MessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "listarTipoIdentificacionController")
@ViewScoped
public class ListarTipoIdentificacionController implements Serializable {

    @EJB
    private TipoIdentificacionFacadeLocal tifl;

    private List<TipoIdentificacion> tiposIdentificacion;

    public ListarTipoIdentificacionController() {
    }

    @PostConstruct
    public void init() {
        listarTiposIdentificacion();
    }

    public void listarTiposIdentificacion() {
        tiposIdentificacion=tifl.findAll();
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return MessageUtil.getSelectItems(tifl.findAll(), true);
    }

    public List<TipoIdentificacion> getTiposIdentificacion() {
        return tiposIdentificacion;
    }
    
    

}
