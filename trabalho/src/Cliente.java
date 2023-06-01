import java.util.Date;
public class Cliente {
    private String CPF;
    private String Nome;
    private String endereco;
    private String escolaridade;
    private String estadoCiv;
    private String nascimento;
    private Agencia agencia;
    protected Conta conta;
    //Exercicio 3a
    public Cliente(String CPF, String Nome){
        if(GeraCpfCnpj.isCPF(CPF))
            this.CPF= CPF;
        else throw new CpfInvalidoException("CPF invalido!");
        this.Nome = Nome;
    }
    //Exercicio 3b
    public Cliente(){}
    public Cliente(String CPF,String Nome,String endereco,String escolaridade,String estadoCiv,String nascimento,Agencia agencia){
        if(GeraCpfCnpj.isCPF(CPF))
            this.CPF= CPF;
        else throw new CpfInvalidoException("CPF invalido!");
        this.Nome = Nome;
        this.endereco=endereco;
        this.escolaridade=escolaridade;
        this.estadoCiv=estadoCiv;
        this.nascimento=nascimento;
        this.agencia=agencia;
    }
    public Agencia getAgencia() {
        return agencia;
    }
    public String getNome() {
        return Nome;
    }
    public Conta getConta() {
        return conta;
    }
    public String getNascimento() {
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
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
