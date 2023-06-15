import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentMap;

public abstract class Conta implements Serializable, Comparable<Conta> {
    protected String senha;
    protected Boolean ativada;
    protected String nro;
    protected double saldo;
    protected Date dataAbertura;
    protected String dataMov;
    protected Agencia agencia;
    protected Cliente c1;
    protected Cliente c2;
    protected ArrayList <Transacao> transacoes;
    public Conta(){
        ativada = true;
        saldo = 0;
        dataAbertura = new Date();
        this.transacoes = new ArrayList<Transacao>();
    }
    public Conta(String nro,Agencia agencia,String senha){
        ativada = true;
        saldo = 0;
        dataAbertura=new Date();
        this.senha=senha;
        this.nro=nro;
        this.agencia=agencia;
        this.transacoes = new ArrayList<Transacao>();
    }
    public String getSenha() {
        return senha;
    }
    public Boolean verificaSenha(String senha){
        if(this.senha.compareTo(senha) == 0)
            return true;
        throw new SenhaIncorretaException("Senha Incorreta!");
    }
    public abstract void sacaValor(String senha, double valor);
    public abstract void depositaValor(String senha, double valor);
    public abstract void efetuaPagamento(String senha, double valor);
    public void consultaSaldo(String senha){
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta Inativa");
        System.out.println("O saldo eh: R$" + saldo);
    }
    public Agencia getAgencia(String senha) {
        verificaSenha(senha);
        return agencia;
    }
    public Boolean getAtivada(String senha) {
        verificaSenha(senha);
        return ativada;
    }
    public Cliente getC1(String senha) {
        verificaSenha(senha);
        return c1;
    }
    public Cliente getC2(String senha) {
        verificaSenha(senha);
        return c2;
    }
    public Date getDataAbertura(String senha) {
        verificaSenha(senha);
        return dataAbertura;
    }
    public String getDataMov(String senha) {
        verificaSenha(senha);
        return dataMov;
    }
    public double getSaldo(String senha) {
        verificaSenha(senha);
        return saldo;
    }
    public String getNro() {
        return nro;
    }
    public void setSenha(String senha, String novasenha) {
        verificaSenha(senha);
        this.senha = novasenha;
    }
    public void setAgencia(String senha, Agencia agencia) {
        verificaSenha(senha);
        this.agencia = agencia;
    }
    public void setAtivada(String senha, Boolean ativada) {
        verificaSenha(senha);
        this.ativada = ativada;
    }
    public void setC1(String senha, Cliente c1) {
        verificaSenha(senha);
        this.c1 = c1;
    }
    public void setC2(String senha, Cliente c2) {
        verificaSenha(senha);
        this.c2 = c2;
    }
    public void setDataAbertura(String senha, Date dataAbertura) {
        verificaSenha(senha);
        this.dataAbertura = dataAbertura;
    }
    public void setDataMov(String senha, String dataMov) {
        verificaSenha(senha);
        this.dataMov = dataMov;
    }

    public void setNro(String senha,String nro) {
        verificaSenha(senha);
        this.nro = nro;
    }
    public void setSaldo(String senha, double saldo) {
        verificaSenha(senha);
        if(saldo < 0)
            throw new RuntimeException("Valor invalido!");
        this.saldo = saldo;
        ativada = this.saldo != 0;
    }
    public int compareTo(Conta a){
        if(this.saldo < a.saldo)
            return -1;
        if(this.saldo > a.saldo)
            return 1;
        return 0;
    }
}
