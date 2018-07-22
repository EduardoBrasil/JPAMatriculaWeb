package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.ProfessorDAO;
import com.algaworks.curso.jpa2.modelo.Professor;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroProfessorService implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ProfessorDAO professorDAO;

    @Transactional
    public void salvar(Professor professor)throws NegocioException {
        
        if(professor.getNome() == null || professor.getNome().trim().equals("")) {
           throw new NegocioException("Professor não pode ser salvo"); 
        }
        this.professorDAO.salvar(professor);
    }
}