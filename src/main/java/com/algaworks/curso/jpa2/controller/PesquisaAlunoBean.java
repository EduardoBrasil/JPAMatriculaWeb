package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AlunoDAO;
import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable
{   
    private static final long serialVersionUID = 1L;
 
    @Inject
    AlunoDAO alunoDAO;
    
    private List<Aluno> alunos;
    
    private Aluno alunoSelecionado;
    
    public List<Aluno> getAlunos(){
        return alunos;
    }
    
    @PostConstruct
    public void inicializar() {
       alunos = alunoDAO.buscarTodos();
    }
    
    public void excluir() {
        try {
            alunoDAO.excluir(alunoSelecionado);
            this.alunos.remove(alunoSelecionado);
            FacesUtil.addSuccessMessage("Aluno" + alunoSelecionado.getNome()+ "Excluido com sucesso.");
        }catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }

    public Aluno getAlunoSelecionado()
    {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado)
    {
        this.alunoSelecionado = alunoSelecionado;
    } 
}
