import java.util.Date;
public class ContaCorrente extends Conta{
    private double limCheque;
    private double taxaAdm;
    public ContaCorrente(String nro,Agencia agencia,String senha, double limCheque, double taxaAdm){
        super(nro,agencia,senha);
        this.limCheque = limCheque;
        this.taxaAdm = taxaAdm;
    }

    @Override
    public void depositaValor(String senha, double valor) {
        verificaSenha(senha);
        if (valor <= 0) throw new RuntimeException("Valor de deposito invalido");
        saldo+=valor;
        if(!ativada)
            ativada = true;
        transacoes.add(new Transacao(this,"Deposito","Caixa Eletronico",valor));
    }

    @Override
    public void efetuaPagamento(String senha, double valor) {
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta inativa");
        if(valor > saldo) throw new RuntimeException("Valor de Pagamento Invalido");
        saldo -= valor;
        transacoes.add(new Transacao(this,"Pagamento","Caixa Eletronico",valor));
    }

    @Override
    public void sacaValor(String senha, double valor) {
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta inativa");
        if(valor>saldo) throw new RuntimeException("Valor de saque invalido");
        saldo-=valor;
        if(saldo == 0)
            ativada = false;
        transacoes.add(new Transacao(this,"Saque","Caixa Eletronico",valor));
    }

    public double getLimCheque(String senha) {
        verificaSenha(senha);
        return limCheque;
    }
    public double getTaxaAdm(String senha) {
        verificaSenha(senha);
        return taxaAdm;
    }
    public void setLimCheque(String senha, double limCheque) {
        verificaSenha(senha);
        this.limCheque = limCheque;
    }
    public void setTaxaAdm(String senha, double taxaAdm) {
        verificaSenha(senha);
        this.taxaAdm = taxaAdm;
    }
}
