package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AlunoDAO;
import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroAlunoService implements Serializable {

    private static final long SerialVersionUID = 1L;
    
    @Inject
    private AlunoDAO alunoDAO;

    @Transactional
    public void salvar(Aluno aluno) throws NegocioException{
        
        if(aluno.getNome() == null || aluno.getNome().trim().equals("")){
            throw new NegocioException("Aluno não pode conter espaços ou ser nulo");
        }
        this.alunoDAO.salvar(aluno);
    }
}
