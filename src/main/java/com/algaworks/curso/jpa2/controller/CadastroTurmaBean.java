package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.TurmaDAO;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.service.CadastroTurmaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTurmaBean implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    private Turma turma;
    
    @Inject
    private TurmaDAO turmaDAO;
    
    @Inject
    private CadastroTurmaService cadastroTurma;
    
    @PostConstruct
    public void inicializar() {
       this.limpar();
    }
    
    public void limpar() {
        this.turma = new Turma();
    }
    
    public void salvar() throws NegocioException {
       try {
        this.cadastroTurma.salvar(turma);
        FacesUtil.addSuccessMessage("turma salva com sucesso");
       }catch(NegocioException e) {
           FacesUtil.addErrorMessage(e.getMessage());
       }
       this.limpar();
    }

    public Turma getTurma()
    {
        return turma;
    }

    public void setTurma(Turma turma)
    {
        this.turma = turma;
    }
    
    
    
}
