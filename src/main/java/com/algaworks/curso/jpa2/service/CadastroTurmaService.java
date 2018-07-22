package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.TurmaDAO;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroTurmaService implements Serializable
{
    private static final long serialVersionUID = 1;
    
    @Inject
    private TurmaDAO turma;
    
    @Transactional
    public void salvar(Turma turma) throws NegocioException {
        if(turma.getDescricao() == null || turma.getDescricao().trim().equals("") ) {
            throw new NegocioException("Turma não pode ser salva");
        }
        this.turma.salvar(turma);
    }   
}