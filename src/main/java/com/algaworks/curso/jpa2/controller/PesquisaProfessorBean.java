package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ProfessorDAO;
import com.algaworks.curso.jpa2.modelo.Professor;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProfessorBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    ProfessorDAO professorDAO;
    
    private List<Professor> professores;
    
    private Professor professorSelecionado;
    
    public List<Professor> getProfessor(){
        return professores;
    }
    
    @PostConstruct
    public void inicializar() {
        professores = professorDAO.buscarTodos();
    }
    
    public void excluir() throws NegocioException{
       try {
           professorDAO.excluir(professorSelecionado);
           this.professores.remove(professorSelecionado);
           FacesUtil.addSuccessMessage("Professor" + professorSelecionado.getNome() + " Excluido com sucesso");
       }catch(NegocioException e) {
        FacesUtil.addErrorMessage(e.getMessage());
       }
    }
 
    public Professor getProfessorSelecionado()
    {
        return professorSelecionado;
    }

    public void setProfessorSelecionado(Professor professorSelecionado)
    {
        this.professorSelecionado = professorSelecionado;
    }

    public List<Professor> getProfessores()
    {
        return professores;
    }

    public void setProfessores(List<Professor> professores)
    {
        this.professores = professores;
    }
    
    
       
}
