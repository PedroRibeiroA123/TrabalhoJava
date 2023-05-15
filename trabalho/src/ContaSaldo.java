import java.util.Date;
public class ContaSaldo extends Conta{
    private double limSaque;
    private double limTransfe;
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
