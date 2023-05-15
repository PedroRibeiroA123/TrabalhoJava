import java.util.Date;
public class Agencia {
    private String nroIdenti;
    private String nomeFicticio;
    private String estado;
    private String cidade;
    private String bairro;
    private Gerente gerente;
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
}