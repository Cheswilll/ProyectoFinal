package com.converters;


import com.DAO.TipoIdentificacionFacadeLocal;
import com.entities.TipoIdentificacion;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=TipoIdentificacion.class, value="tipoIdentificacionConverter")
public class TipoIdentificacionConverter implements Converter{
    
    private TipoIdentificacionFacadeLocal tifl;

    public TipoIdentificacionConverter() {
        tifl = CDI.current().select(TipoIdentificacionFacadeLocal.class).get();
    }
    
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return tifl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof TipoIdentificacion){
            TipoIdentificacion ti = (TipoIdentificacion) value;
            return ti.getIdTipoIdentificacion().toString();
        }
        return null;
    }
    
}
