package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.modelo.Matricula;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;


public class MatriculaDAO implements Serializable
{
    @Inject
    private EntityManager manager;

    //Salvando uma Lista de matriculas
    public void salvar(List<Matricula> matriculas)
    {
        for (Matricula matricula : matriculas)
        {
            manager.persist(matricula);
        }
    }
    
    //Editando uma matricula numa lista
    public void atualizar(List<Matricula> matriculas)
    {
        for (Matricula matricula : matriculas)
        {
            manager.merge(matricula);
        }

    }

    //Buscando matriculas Associadas a turma retornando uma lista de matriculas associadas a uma turma
    public List<Matricula> buscarMatriculasAssociadasTurma(Turma turma)
    {
        return manager.createQuery("from Matricula as matricula where matricula.turma=:turma", Matricula.class)
                .setParameter("turma", turma).getResultList();
    }
    
    public List<Matricula> buscarMatriculasAssociadasAluno(Aluno aluno) {
        return manager.createQuery(
                        "from Matricula as matricula where matricula.aluno=:aluno",
                        Matricula.class).setParameter("aluno", aluno).getResultList();
    }
    
    //Retorna a lista de matriculas em turmas de um aluno
    @SuppressWarnings("unchecked")
    public List<Matricula> buscarTurmasMatriculasDeUmAluno(Aluno aluno, List<Turma> turmas)
    {
        return manager.createQuery(
                "select matricula from Matricula as matricula where matricula.aluno=:aluno and matricula.turma in(:turmas)")
                .setParameter("turmas", turmas).setParameter("aluno", aluno).getResultList();
    }

    //lista de todas as matriculas existentes de aluno
    @SuppressWarnings("unchecked")
    public List<Matricula> buscarTodos(Aluno aluno)
    {
        return manager.createQuery(
                "select matricula from Matricula as matricula inner join matricula.aluno as aluno inner join matricula.turma where aluno =:aluno")
                .setParameter("aluno", aluno).getResultList();
    }
    

    @Transactional
    public void excluir(List<Matricula> matriculas) throws NegocioException
    {
        try
        {
            for (Matricula matricula : matriculas)
            {
                matricula = manager.find(Matricula.class, matricula.getCodigo());
                manager.remove(matricula);
                manager.flush();
            }
        } catch (PersistenceException e)
        {
            throw new NegocioException("matricula não pode ser excluida");
        }
    }
}
