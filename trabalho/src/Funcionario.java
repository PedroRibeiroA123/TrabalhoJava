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
    private String dataNascimento;
    public Funcionario(String CPF,String nome,String nroCT,String RG,String endereco,String sexo,String estadoCivil,String cargo,double salario,int anoIngresso,String dataNascimento){
        if(GeraCpfCnpj.isCPF(CPF))
            this.CPF= CPF;
        else throw new CpfInvalidoException("CPF invalido!");
        this.nome=nome;
        this.nroCT=nroCT;
        this.RG=RG;
        this.endereco=endereco;
        this.sexo=sexo;
        this.estadoCivil=estadoCivil;
        this.cargo=cargo;
        this.salario=salario;
        this.anoIngresso=anoIngresso;
        this.dataNascimento=dataNascimento;
    }
    public double calcSalario(){
        int ano = java.time.Year.now().getValue();
        if(ano - anoIngresso >=15)
            return (salario + salario*0.1);
        else return salario;
    }
    public String getEndereco() {
        return endereco;
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
    public void setDataNascimento(String dataNascimento) {
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
