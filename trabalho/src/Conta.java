import java.util.Date;
public class Conta {
    private Boolean ativada;
    private String nro;
    private double saldo;
    private Date dataAbertura;
    private Date dataMov;
    private Agencia agencia;
    private Cliente c1;
    private Cliente c2;
    public Agencia getAgencia() {
        return agencia;
    }
    public Boolean getAtivada() {
        return ativada;
    }
    public Cliente getC1() {
        return c1;
    }
    public Cliente getC2() {
        return c2;
    }
    public Date getDataAbertura() {
        return dataAbertura;
    }
    public Date getDataMov() {
        return dataMov;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getNro() {
        return nro;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public void setAtivada(Boolean ativada) {
        this.ativada = ativada;
    }
    public void setC1(Cliente c1) {
        this.c1 = c1;
    }
    public void setC2(Cliente c2) {
        this.c2 = c2;
    }
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }
    public void setNro(String nro) {
        this.nro = nro;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
