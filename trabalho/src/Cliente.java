import java.util.Date;
public class Cliente {
    private String CPF;
    private String Nome;
    private String endereco;
    private String escolaridade;
    private String estadoCiv;
    private Date nascimento;
    private Agencia agencia;
    private Conta conta;
    //alternativa:
    /*private String nroConta;

    public String getNroConta() {
        return nroConta;
    }
    public void setNroConta(String nroConta) {
        this.nroConta = nroConta;
    }*/

    public Agencia getAgencia() {
        return agencia;
    }
    public String getNome() {
        return Nome;
    }
    public Conta getConta() {
        return conta;
    }
    public Date getNascimento() {
        return nascimento;
    }
    public String getCPF() {
        return CPF;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public String getEstadoCiv() {
        return estadoCiv;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    public void setEstadoCiv(String estadoCiv) {
        this.estadoCiv = estadoCiv;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
