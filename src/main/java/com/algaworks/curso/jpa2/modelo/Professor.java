package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor
{
    private long codigo;
    private String nome;
    private String especialidade;
    
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
    public String getEspecialidade()
    {
        return especialidade;
    }
    public void setEspecialidade(String especialidade)
    {
        this.especialidade = especialidade;
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
        Professor other = (Professor) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
    
    
    
}
