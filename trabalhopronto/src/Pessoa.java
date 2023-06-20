import java.io.Serializable;

public abstract class Pessoa implements Serializable, Comparable<Pessoa>{
    //Exercicio 3g
    private String CPF;
    private String nome;
    private String endereco;
    private String estadoCivil;
    private String dataNascimento;

    /*Nos construtores de Pessoa, na inserção de CPF é verificado caso o CPF é valido, chamando a função isCPF da classe
     GeraCpfCnpj, caso nao seja ele retorna a exception CpfInvalidoException
    */
    public Pessoa(String CPF, String Nome, String endereco, String estadoCivil, String dataNascimento){
        if(GeraCpfCnpj.isCPF(CPF))
            this.CPF = CPF;
        else throw new CpfInvalidoException("CPF invalido!");
        this.nome = Nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
    }
    public Pessoa(String CPF, String Nome){
        if(GeraCpfCnpj.isCPF(CPF))
            this.CPF = CPF;
        else throw new CpfInvalidoException("CPF invalido!");
        this.nome = Nome;
    }
    public Pessoa(){}

    public void Imprimir(){
        System.out.println("Nome: " + nome + "\nCPF: " + CPF + "\nEndereco: " + endereco + "\nEsdao Civil: " + estadoCivil + "\nData de Nascimento: " + dataNascimento);
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    /*comparação de cpf entre duas pessoas*/
    public int compareTo(Pessoa a){
        if(this.CPF.compareTo(a.CPF) < 0)
            return -1;
        if(this.CPF.compareTo(a.CPF) > 0)
            return 1;
        return 0;
    }
}
