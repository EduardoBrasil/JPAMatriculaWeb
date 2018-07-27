package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AlunoDAO;
import com.algaworks.curso.jpa2.dao.MatriculaDAO;
import com.algaworks.curso.jpa2.modelo.Aluno;
import com.algaworks.curso.jpa2.modelo.Matricula;
import com.algaworks.curso.jpa2.modelo.Turma;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroAlunoService implements Serializable {

    private static final long SerialVersionUID = 1L;
    
    @Inject
    private AlunoDAO alunoDAO;
    
    @Inject 
    private MatriculaDAO matriculaDAO;
    
    
    @Transactional
    public void salvar(Aluno aluno, String observação, List<Turma> turmaSelecionadas) throws NegocioException{
        
        validarCampos(aluno,observação, turmaSelecionadas);
        
        List<Matricula> matriculas = criarMatriculas(aluno, turmaSelecionadas, observação);
                this.alunoDAO.salvar(aluno);
                this.matriculaDAO.salvar(matriculas);
    }

    private void validarCampos(Aluno aluno, String observação, List<Turma> turmaSelecionadas) throws NegocioException{
        if(aluno.getNome()== null || aluno.getNome().trim().equals("")) {
            throw new NegocioException("O nome é Obrigatório");
        }
        if(observação == null || observação.equals("")) {
            throw new NegocioException("A forma de pagamento é obrigatória");
        }
        if(turmaSelecionadas == null || turmaSelecionadas.isEmpty()) {
            throw new NegocioException("Turma é obrigatória");
        }
    }
    
    public void atualizar(Aluno aluno, String observacao, List<Turma> turmaSelecionadas, List<Turma> turmaAux)throws NegocioException{
        validarCampos(aluno, observacao, turmaSelecionadas);
        List<Matricula> matriculasNovas = matricularEmNovaTurma(aluno, turmaSelecionadas, turmaAux, observacao);
        List<Turma> turmaTrancada = trancarMatricula(turmaSelecionadas,
                turmaAux);
        this.alunoDAO.salvar(aluno);
        this.matriculaDAO.salvar(matriculasNovas);
        
        if(!turmaTrancada.isEmpty()) {
            this.matriculaDAO.excluir(getMatriculasParaTrancar(aluno,turmaTrancada));
        }
        
        List<Matricula> matriculasAtualizar = this.matriculaDAO.buscarMatriculasAssociadasAluno(aluno);
        List<Matricula> atualizar = new ArrayList<Matricula>();
        for(Matricula matricula : matriculasAtualizar) {
            if(!observacao.equals(matricula.getObservacao())){
                matricula.setObservacao(observacao);
                atualizar.add(matricula);
            }
        }
        this.matriculaDAO.atualizar(atualizar);
    }
    
    
    private List<Turma> trancarMatricula(List<Turma> turmaSelecionadas, List<Turma> turmaAux)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private List<Matricula> matricularEmNovaTurma(Aluno aluno, List<Turma> turmaSelecionadas, List<Turma> turmaAux,
            String observação)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private List<Matricula> getMatriculasParaTrancar(Aluno aluno, List<Turma> turmaTrancada)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private List<Matricula> criarMatriculas(Aluno aluno, List<Turma> turmaSelecionadas, String observação)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
