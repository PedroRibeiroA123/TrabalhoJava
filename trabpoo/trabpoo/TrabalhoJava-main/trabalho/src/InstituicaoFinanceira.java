import java.util.ArrayList;
import java.util.Scanner;
public class InstituicaoFinanceira {
    public static void main(String[] args) {
        ArrayList <Conta> contas = new ArrayList <Conta>();
        ArrayList <Agencia> agencias = new ArrayList <Agencia>();
        ArrayList <Pessoa> pessoas = new ArrayList <Pessoa>();
        int op = 0;
        String CPF;
        String Nome;
        String endereco;
        String escolaridade;
        String estadoCiv;
        String nascimento;
        String nroAgencia;
        Agencia agencia;
        int flag = 0;

        Scanner entrada = new Scanner(System.in);
        Agencia BB = new Agencia("Santa Monica","Uberlandia","MG","Banco do Brasil","5555");
        Gerente cleito = new Gerente("09/11/2001",true,"51142005690","Cleiton","564764","6445654","aaa","M","Solteiro","Sei la",2666.666,2001,"15/08/1987",555.55);
        BB.setGerente(cleito);
        cleito.setAgencia(BB);
        agencias.add(BB);
        Conta teste = new ContaCorrente("123",BB,"123",1,1);
        contas.add(teste);
        System.out.println("Gerente: "+BB.getGerente().getNome()+"\nAgencia: "+cleito.getAgencia().getNomeFicticio());
        do{
            System.out.println("=-=-=-=-=Instituição Financeira=-=-=-=-=");
            System.out.println("Menu de Operações:\nVoce é:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Administrador");
            op = entrada.nextInt();
            switch (op){
                case 1:
                    do{
                        System.out.println("Digite a opção desejada:");
                        System.out.println("1 - Cadastrar Cliente");
                        System.out.println("2 - Cadastrar Contas");
                        System.out.println("3 - Entrar em uma Conta");
                        System.out.println("9 - Voltar");
                        op = entrada.nextInt();
                        switch (op){
                            case 1:
                                entrada.nextLine();
                                System.out.println("Digite as seguintes informações:");
                                System.out.println("CPF: ");
                                CPF = entrada.nextLine();
                                System.out.println("Nome Completo: ");
                                Nome = entrada.nextLine();
                                System.out.println("Endereço: ");
                                endereco = entrada.nextLine();
                                System.out.println("Escolaridade: ");
                                escolaridade = entrada.nextLine();
                                System.out.println("Estado Civil: ");
                                estadoCiv = entrada.nextLine();
                                System.out.println("Data de Nascimento: ");
                                nascimento = entrada.nextLine();
                                System.out.println("Numero da agencia: ");
                                nroAgencia = entrada.nextLine();
                                flag = 0;
                                for(int i = 0; i < agencias.size();i++){
                                    if(agencias.get(i).validaAgencia(nroAgencia)){
                                        agencia = agencias.get(i);
                                        try{
                                            pessoas.add(new Cliente(CPF,Nome,endereco,escolaridade,estadoCiv,nascimento,agencia));
                                        }catch(CpfInvalidoException e){
                                            System.out.println(e.getMessage());
                                        }
                                        flag = 1;
                                        break;
                                    }
                                if(flag == 0)
                                    System.out.println("Agencia nao encontrada");
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 9:
                                break;
                            default:
                        }
                    }while(op != 9);
                    break;
                case 2:
                    System.out.println("Digite a opção desejada:");
                    System.out.println("Cadastrar Funcionario");
                    System.out.println("Cadastrar Gerente");
                    break;
                case 3:
                    System.out.println("Cadastrar Agencia");
                default:
            }
            op = entrada.nextInt();
        }while(op != 10);
    }
}
/*LEMBRETES---------------------------------------------*/
//Perguntar sobre efetuarPagamento()(Como funciona?)