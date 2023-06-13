public class ContaSalario extends Conta{
    private double limSaque;
    private double limTransfe;
    public ContaSalario(String nro,Agencia agencia,String senha,double limSaque, double limTransfe){
        super(nro,agencia,senha);
        this.limSaque=limSaque;
        this.limTransfe=limTransfe;
    }

    public void sacaValor(String senha, double valor){
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta inativa");
        if((valor > limSaque) || (valor > saldo)) throw new RuntimeException("Valor de saque invalido");
        saldo -= valor;
    }
    public void depositaValor(String senha, double valor){
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta Inativa");
        if(valor <= 0) throw new RuntimeException("Valor de deposito invalido");
        saldo += valor;
    }
    public void efetuaPagamento(String senha, double valor){
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta inativa");
    }
    public double getLimSaque(String senha) {
        verificaSenha(senha);
        return limSaque;
    }
    public double getLimTransfe(String senha) {
        verificaSenha(senha);
        return limTransfe;
    }
    public void setLimSaque(String senha, double limSaque) {
        verificaSenha(senha);
        this.limSaque = limSaque;
    }
    public void setLimTransfe(String senha, double limTransfe) {
        verificaSenha(senha);
        this.limTransfe = limTransfe;
    }
}
