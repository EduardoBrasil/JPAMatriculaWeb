package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.TurmaDAO;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTurmaBean implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    private Turma turmaSelecionada;
    
    private List<Turma> turmas;
    
    @Inject
    TurmaDAO turmadao;
   
    public List<Turma> getTurma(){
        return turmas;
    }
    
    @PostConstruct
    public void inicializar() {
        turmas = turmadao.buscarTodos();
    }
    
    public void excluir() throws NegocioException{
       try {
        turmadao.excluir(turmaSelecionada);
        this.turmas.remove(turmaSelecionada);
        FacesUtil.addSuccessMessage("turma" + turmaSelecionada.getDescricao() + "foi adicionadas com sucesso");
       }catch(NegocioException e){
           FacesUtil.addErrorMessage(e.getMessage());
       }
    }

    public Turma getTurmaSelecionada()
    {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(Turma turmaSelecionada)
    {
        this.turmaSelecionada = turmaSelecionada;
    }

    public List<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas)
    {
        this.turmas = turmas;
    }
    
}
