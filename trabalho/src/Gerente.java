import java.util.Date;
public class Gerente extends Funcionario{
    private Agencia agencia;
    //alternativa
    //private int nroAgencia;
    private Boolean temCurso;
    private Date dataIngresso;

    /*public int getNroAgencia() {
        return nroAgencia;
    }

    public void setNroAgencia(int nroAgencia) {
        this.nroAgencia = nroAgencia;
    }*/

    public Agencia getAgencia() {
        return agencia;
    }
    public Boolean getTemCurso() {
        return temCurso;
    }
    public Date getDataIngresso() {
        return dataIngresso;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public void setTemCurso(Boolean temCurso) {
        this.temCurso = temCurso;
    }
}
