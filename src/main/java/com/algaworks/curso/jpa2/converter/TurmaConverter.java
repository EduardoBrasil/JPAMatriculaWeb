package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.TurmaDAO;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Turma.class)
public class TurmaConverter implements Converter
{

    private TurmaDAO turmaDao;
    
    public TurmaConverter()
    {
       this.turmaDao = CDIServiceLocator.getBean(TurmaDAO.class);
    }
  
 @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        Turma retorno = null;
        
        if(value != null) {
           retorno = this.turmaDao.buscarpelocodigo(new Long(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
       if(value != null) {
           Long codigo = ((Turma)value).getCodigo();
           return codigo == null ? null : codigo.toString();
       }
        return "";
    }

}
