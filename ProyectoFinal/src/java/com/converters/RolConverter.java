package com.converters;

import com.DAO.RolFacadeLocal;
import com.entities.Rol;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Rol.class, value= "rolConverter")
public class RolConverter implements Converter{
    
    private RolFacadeLocal rfl;
    
    public RolConverter() {
        rfl = CDI.current().select(RolFacadeLocal.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return rfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Rol){
            Rol td = (Rol) value;
            return td.getIdRol().toString();
        }
        return null;
    }
    
    
}
