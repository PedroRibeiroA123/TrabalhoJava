import java.util.Date;
public class ContaPoupanca extends Conta{
    private double rendimento;
    public ContaPoupanca(String nro,Agencia agencia,String senha, double rendimento){
        super(nro,agencia,senha);
        this.rendimento=rendimento;
    }
    public double getRendimento() {
        return rendimento;
    }
    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
