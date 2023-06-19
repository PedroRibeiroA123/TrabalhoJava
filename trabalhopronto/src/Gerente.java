import java.util.Date;
public class Gerente extends Funcionario{
    private static double comissao;
    private Agencia agencia;
    private Boolean temCurso;
    private String dataIngresso;
    public Gerente(String CPF,String nome,String nroCT,String RG,String endereco,String sexo,String estadoCivil,double salario,int anoIngresso,String dataNascimento, Boolean temCurso, String dataIngresso, double comissao){
        super(CPF,nome,nroCT,RG,endereco,sexo,estadoCivil,"Gerente",salario,anoIngresso,dataNascimento);
        this.temCurso=temCurso;
        this.dataIngresso=dataIngresso;
        this.comissao=comissao;
    }
    @Override
    public double calcSalario() {
        return (super.calcSalario()+comissao);
    }
    public static double getComissao() {
        return comissao;
    }
    public Agencia getAgencia() {
        return agencia;
    }
    public Boolean getTemCurso() {
        return temCurso;
    }
    public String getDataIngresso() {
        return dataIngresso;
    }
    public static void setComissao(double comissao) {
        Gerente.comissao = comissao;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public void setTemCurso(Boolean temCurso) {
        this.temCurso = temCurso;
    }
    public void Imprimir(){
        super.Imprimir();
        System.out.println("Agencia: " + agencia.getNomeFicticio() + "\nTem Curso: " + temCurso + "\nData Ingresso: " + dataIngresso + "\nComissão: " + comissao);

    }
}
