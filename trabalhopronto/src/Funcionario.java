import java.sql.SQLOutput;
import java.util.Date;
import java.io.Serializable;
public class Funcionario extends Pessoa{
    private String nroCT;
    private String RG;
    private String sexo;
    private String cargo;
    private double salario;
    private int anoIngresso;
    public Funcionario(String CPF,String nome,String nroCT,String RG,String endereco,String sexo,String estadoCivil,String cargo,double salario,int anoIngresso,String dataNascimento){
        super(CPF,nome,endereco,estadoCivil,dataNascimento);
        this.nroCT=nroCT;
        this.RG=RG;
        this.sexo=sexo;
        this.cargo=cargo;
        this.salario=salario;
        this.anoIngresso=anoIngresso;
    }
    public void Imprimir(){
        super.Imprimir();
        System.out.println("Status: Funcionario" + "\nNúmero CT: " + nroCT + "\nRG: " + RG + "\nSexo: " + sexo + "\nCargo: " + cargo + "\nSalario: " + salario +  "\nAno de Ingresso: " + anoIngresso);
    }
    public double calcSalario(){
        int ano = java.time.Year.now().getValue();
        if(ano - anoIngresso >=15)
            return (salario + salario*0.1);
        else return salario;
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
    public String getNroCT() {
        return nroCT;
    }
    public String getRG() {
        return RG;
    }
    public String getSexo() {
        return sexo;
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
