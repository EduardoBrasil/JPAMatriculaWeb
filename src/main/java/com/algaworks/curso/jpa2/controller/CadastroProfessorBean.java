package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ProfessorDAO;
import com.algaworks.curso.jpa2.modelo.Professor;
import com.algaworks.curso.jpa2.service.CadastroProfessorService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Professor professor;
    
    @Inject
    private ProfessorDAO professorDAO;
    
    @Inject
    private CadastroProfessorService cadastroProfessor;
    
    @PostConstruct
    public void inicializar() {
       this.limpar();
    }
    
    public void salvar() throws NegocioException {
        try {
            this.cadastroProfessor.salvar(professor);
            FacesUtil.addSuccessMessage("Professor cadastrado com sucesso");
        }catch(NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
        
        this.limpar();
    }

    public void limpar() {
     this.professor = new Professor();
    }

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }
    
    
    
}
