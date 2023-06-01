public class InstituicaoFinanceira {
    public static void main(String[] args) {
        Agencia BB = new Agencia("Santa Monica","Uberlandia","MG","Banco do Brasil","5555");
        Gerente cleito = new Gerente("09/11/2001",true,"36536535","Cleiton","564764","6445654","aaa","M","Solteiro","Sei la",2666.666,2001,"15/08/1987",555.55);
        BB.setGerente(cleito);
        cleito.setAgencia(BB);
        System.out.println("Gerente: "+BB.getGerente().getNome()+"\nAgencia: "+cleito.getAgencia().getNomeFicticio());
    }
}