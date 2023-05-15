import java.util.Date;
public class ContaCorrente extends Conta{
    private double limCheque;
    private double taxaAdm;
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
