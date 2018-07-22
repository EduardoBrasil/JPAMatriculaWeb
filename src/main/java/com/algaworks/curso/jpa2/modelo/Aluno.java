package com.algaworks.curso.jpa2.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
    
    private long codigo;
    private String nome;
    private String matricula;
    private List<Turma> turmas;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    @OneToMany
    @JoinColumn(name="codigo_Turma")
    public List<Turma> getTurmas()
    {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas)
    {
        this.turmas = turmas;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (codigo ^ (codigo >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
    
    
    
}