package com.converters;


import com.DAO.ProyectoFacadeLocal;
import com.entities.Proyecto;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Proyecto.class, value= "proyectoConverter")
public class ProyectoConverter implements Converter {

    private ProyectoFacadeLocal pfl;
    
    
    public ProyectoConverter() {
        pfl = CDI.current().select(ProyectoFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if(value != null && value.length() > 0){
            return pfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Proyecto){
            Proyecto pr = (Proyecto) value;
            return pr.getIdProyecto().toString();
        }
        return null;
    }
    
}
