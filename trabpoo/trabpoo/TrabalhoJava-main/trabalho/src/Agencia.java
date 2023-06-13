import java.util.Date;
import java.io.Serializable;
public class Agencia implements Serializable{
    private String nroIdenti;
    private String nomeFicticio;
    private String estado;
    private String cidade;
    private String bairro;
    private Gerente gerente;
    public Agencia(String bairro,String cidade,String estado,String nomeFicticio,String nroIdenti){
        this.bairro=bairro;
        this.cidade=cidade;
        this.estado=estado;
        this.nomeFicticio=nomeFicticio;
        this.nroIdenti=nroIdenti;
    }
    public Gerente getGerente() {
        return gerente;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getNomeFicticio() {
        return nomeFicticio;
    }
    public String getNroIdenti() {
        return nroIdenti;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    public void setNomeFicticio(String nomeFicticio) {
        this.nomeFicticio = nomeFicticio;
    }
    public void setNroIdenti(String nroIdenti) {
        this.nroIdenti = nroIdenti;
    }

    public boolean validaAgencia(String nro){
        if(nroIdenti.compareTo(nro) == 0)
            return true;
        return false;
    }
}
