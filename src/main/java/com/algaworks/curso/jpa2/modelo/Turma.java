package com.algaworks.curso.jpa2.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Turma
{

    private long codigo;
    private String descricao;
    private List <Aluno> alunos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCodigo()
    {
        return codigo;
    }
    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    
    @OneToMany
    @JoinColumn(name="codigo_Aluno")
    public List<Aluno> getAlunos()
    {
        return alunos;
    }
    public void setAlunos(List<Aluno> alunos)
    {
        this.alunos = alunos;
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
        Turma other = (Turma) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
    
    

    
}
