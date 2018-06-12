package com.converters;


import com.DAO.GrupoFacadeLocal;
import com.entities.Grupo;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Grupo.class, value= "grupoConverter")
public class GrupoConverter  implements Converter{
    
    private GrupoFacadeLocal gfl;
    
    public GrupoConverter() {
        gfl = CDI.current().select(GrupoFacadeLocal.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if(value != null && value.length() > 0){
            return gfl.find(Integer.valueOf(value));
        } 
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Grupo){
            Grupo gr = (Grupo) value;
            return gr.getIdGrupo().toString();
        }
        return null;
    }
}
