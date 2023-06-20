import java.util.Date;
import java.io.Serializable;
/*A agencia engloba todas as contas, o gerente, e quase todas as operações disponibilizadas no menu pedem o número da agencia. A variável
* mais importante é o número de identificação*/
public class Agencia implements Serializable ,Comparable<Agencia>{
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

    /*Realiza a verificação do número de identificação da agencia, com o número dado*/
    public boolean validaAgencia(String nro){
        if(nroIdenti.compareTo(nro) == 0)
            return true;
        return false;
    }
    /*comparação entre números de identificação, para ordenação*/

    public int compareTo(Agencia a){
        if(this.nroIdenti.compareTo(a.nroIdenti) < 0)
            return -1;
        if(this.nroIdenti.compareTo(a.nroIdenti) > 0)
            return 1;
        return 0;
    }

    public void Imprimir(){
        System.out.println("Nome: " + nomeFicticio + "\nIdentificação: " + nroIdenti);
        if(this.gerente == null){
            throw new RuntimeException("\nEssa agencia nao possui gerente, favor cadastrar");
        }
        else
            System.out.println("\nGerente: " + gerente.getNome());
    }
}
