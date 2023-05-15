import java.util.Date;
public class Funcionario {
    private String CPF;
    private String nome;
    private String nroCT;
    private String RG;
    private String endereco;
    private String sexo;
    private String estadoCivil;
    private String cargo;
    private double salario;
    private int anoIngresso;
    private Date dataNascimento;
    public String getEndereco() {
        return endereco;
    }
    public String getCPF() {
        return CPF;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public double getSalario() {
        return salario;
    }
    public int getAnoIngresso() {
        return anoIngresso;
    }
    public String getCargo() {
        return cargo;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public String getNroCT() {
        return nroCT;
    }
    public String getRG() {
        return RG;
    }
    public String getSexo() {
        return sexo;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public void setNroCT(String nroCT) {
        this.nroCT = nroCT;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
