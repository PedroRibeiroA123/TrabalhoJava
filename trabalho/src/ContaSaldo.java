import java.util.Date;
public class ContaSaldo extends Conta{
    private double limSaque;
    private double limTransfe;
    public ContaSaldo(String nro,Agencia agencia,String senha,double limSaque, double limTransfe){
        super(nro,agencia,senha);
        this.limSaque=limSaque;
        this.limTransfe=limTransfe;
    }
    public double getLimSaque() {
        return limSaque;
    }
    public double getLimTransfe() {
        return limTransfe;
    }
    public void setLimSaque(double limSaque) {
        this.limSaque = limSaque;
    }
    public void setLimTransfe(double limTransfe) {
        this.limTransfe = limTransfe;
    }
}
