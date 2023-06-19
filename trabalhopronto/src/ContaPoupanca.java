import java.util.Date;
public class ContaPoupanca extends Conta{
    private double rendimento;
    public ContaPoupanca(String nro,Agencia agencia,String senha, double rendimento){
        super(nro,agencia,senha);
        this.rendimento=rendimento;
    }
    public double getRendimento(String senha) {
        verificaSenha(senha);
        return rendimento;
    }
    public void setRendimento(String senha, double rendimento) {
        verificaSenha(senha);
        this.rendimento = rendimento;
    }

    @Override
    public void depositaValor(String senha, double valor) {
        verificaSenha(senha);
        if(valor<0) throw new RuntimeException("Valor de deposito invalido");
        saldo+=valor;
        if(!ativada)
            ativada = true;
        transacoes.add(new Transacao(this,"Deposito","Caixa Eletronico",valor));
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

    @Override
    public void efetuaPagamento(String senha, double valor) {
        verificaSenha(senha);
        if(!ativada) throw new RuntimeException("Conta inativa");
        if(valor > saldo) throw new RuntimeException("Valor de Pagamento Invalido");
        saldo -= valor;
        transacoes.add(new Transacao(this,"Pagamento","Caixa Eletronico",valor));
    }
}

