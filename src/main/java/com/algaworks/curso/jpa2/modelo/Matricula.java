package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Matricula 
{
    private long codigo;
    private String observacao;
    private Aluno aluno;
    private Turma turma;
    private String pagamento;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public long getCodigo()
    {
        return codigo;
    }
    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }
    
    public String getObservacao()
    {
        return observacao;
    }
    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }
    @ManyToOne
    public Aluno getAluno()
    {
        return aluno;
    }
    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }
    
    @ManyToOne
    public Turma getTurma()
    {
        return turma;
    }
    public void setTurma(Turma turma)
    {
        this.turma = turma;
    }
    public String getPagamento()
    {
        return pagamento;
    }
    public void setPagamento(String pagamento)
    {
        this.pagamento = pagamento;
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
        Matricula other = (Matricula) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
    
    
    
    
    

}
