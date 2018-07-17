package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AlunoDAO implements Serializable {

    private static final long serialVersionUID = 1L; 
    
    @Inject
    private EntityManager manager;
    
    public Aluno buscarPeloCodigo(Long codigo) {
        return manager.find(Aluno.class, codigo);
    }
    
    public void salvar(Aluno aluno) {
        manager.merge(aluno);
    }
    
    @SuppressWarnings("unchecked")
    public List<Aluno> buscarTodos(){
         return manager.createQuery("from Aluno").getResultList();
    }
    
    @Transactional
    public void excluir(Aluno aluno) throws NegocioException {
        aluno = buscarPeloCodigo(aluno.getCodigo());        
        try {
            manager.remove(aluno);
            manager.flush();
        }catch(PersistenceException e) {
           throw new NegocioException("Aluno pode ser excluido");
        }
    }

}
