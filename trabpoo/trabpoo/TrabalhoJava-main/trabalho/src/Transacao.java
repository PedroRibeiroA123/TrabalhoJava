import java.util.Date;
public class Transacao {
    private Date data;
    private double valor;
    private String canal;
    private String tipo;
    private Conta conta;
    //Exercicio 3c
    public Transacao(Conta conta,Date data){
        this.data=data;
        this.conta=conta;
    }
    public Transacao(Conta conta,String tipo,String canal,double valor){
        this.data=new Date();
        this.conta=conta;
        this.canal=canal;
        this.valor=valor;
        this.tipo=tipo;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }
    public Conta getConta() {
        return conta;
    }
    public Date getData() {
        return data;
    }
    public double getValor() {
        return valor;
    }
    public String getCanal() {
        return canal;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}

