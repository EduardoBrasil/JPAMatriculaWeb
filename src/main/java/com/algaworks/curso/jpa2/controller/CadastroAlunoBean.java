package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.dao.AlunoDAO;
import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.service.CadastroAlunoService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAlunoBean implements Serializable
{

    private static final long    serialVersionUID = 1L;

    private Aluno                aluno;

    @Inject
    private AlunoDAO             alunoDAO;

    @Inject
    private CadastroAlunoService service;

    @PostConstruct
    public void inicializar()
    {
        this.limpar();

    }

    public void salvar() throws NegocioException
    {
        try
        {
            this.service.salvar(aluno);
            FacesUtil.addSuccessMessage("Aluno Cadastrado Com Sucesso");

        } catch (PersistenceException e)
        {
            FacesUtil.addErrorMessage(e.getMessage());
        }
        this.limpar();
    }

    public void limpar()
    {
        this.aluno = new Aluno();

    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

}
