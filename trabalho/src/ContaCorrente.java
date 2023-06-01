import java.util.Date;
public class ContaCorrente extends Conta{
    private double limCheque;
    private double taxaAdm;
    public ContaCorrente(String nro,Agencia agencia,String senha, double limCheque, double taxaAdm){
        super(nro,agencia,senha);
        this.limCheque=limCheque;
        this.taxaAdm=taxaAdm;
    }
    public double getLimCheque() {
        return limCheque;
    }
    public double getTaxaAdm() {
        return taxaAdm;
    }
    public void setLimCheque(double limCheque) {
        this.limCheque = limCheque;
    }
    public void setTaxaAdm(double taxaAdm) {
        this.taxaAdm = taxaAdm;
    }
}
