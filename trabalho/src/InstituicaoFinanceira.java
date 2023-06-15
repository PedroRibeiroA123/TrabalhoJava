import java.util.ArrayList;
import java.util.Scanner;
public class InstituicaoFinanceira {
    public static void main(String[] args) {
        ArrayList <Conta> contas = new ArrayList <Conta>();
        ArrayList <Agencia> agencias = new ArrayList <Agencia>();
        ArrayList <Pessoa> pessoas = new ArrayList <Pessoa>();

        int op = 0;
        String CPF, RG;
        String Nome;
        String endereco;
        String escolaridade;
        String estadoCiv;
        String nascimento, data;
        String cargo;
        String nro, nroC;
        String sexo;
        String senha, senha2;
        Agencia agencia;
        Boolean flag, curso;
        int ano, sn;
        double valor, valorS;
        Conta conta;
        Cliente c1;

        Scanner entrada = new Scanner(System.in);
        Agencia BB = new Agencia("Santa Monica","Uberlandia","MG","Banco do Brasil","5555");
        Gerente cleito = new Gerente("51142005690","Cleiton","564764","6445654","aaa","M","Solteiro","Gerente",2666.666,2001,"15/08/1987",true,"09/11/2001",555.55);
        contas.add(new ContaCorrente("3456",BB,"batata123",1000,100));
        contas.add(new ContaPoupanca("7892",BB,"cenoura123",10));
        contas.add(new ContaSalario("8912",BB,"rabanete123",1000,500));
        Cliente carlos = new Cliente("15018273674","Carlos","Placeholder","Placeholder","Placeholder","Placeholder",BB);
        BB.setGerente(cleito);
        cleito.setAgencia(BB);
        agencias.add(BB);
        pessoas.add(carlos);
        pessoas.add(cleito);

        do{
            System.out.println("=-=-=-=-=Instituição Financeira=-=-=-=-=");
            System.out.println("Menu de Operações:\nVoce é:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Administrador");
            System.out.println("Caso queira encerrar digite 9");
            op = entrada.nextInt();
            entrada.nextLine();
            switch (op){
                case 1: //CLIENTE
                    do{
                        System.out.println("Digite a opção desejada:");
                        System.out.println("1 - Cadastrar Cliente");
                        System.out.println("2 - Cadastrar Contas");
                        System.out.println("3 - Entrar em uma Conta");
                        System.out.println("9 - Voltar");
                        op = entrada.nextInt();
                        entrada.nextLine();
                        switch (op){
                            case 1:
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
                                nro = entrada.nextLine();
                                flag = true;
                                for(int i = 0; i < agencias.size();i++) {
                                    if (agencias.get(i).validaAgencia(nro)) {
                                        agencia = agencias.get(i);
                                        flag = false;
                                        try {
                                            c1 = new Cliente(CPF, Nome, endereco, escolaridade, estadoCiv, nascimento, agencia);
                                            pessoas.add(c1);
                                        } catch (CpfInvalidoException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    }
                                }
                                if(flag)
                                    System.out.println("Agencia nao encontrada");
                                break;
                            case 2: //WIP
                                System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                CPF = entrada.nextLine();
                                flag = true;
                                for(int i = 0; i < pessoas.size();i++) {
                                    if (pessoas.get(i).getCPF().equals(CPF)) {
                                        flag=false;
                                        System.out.println("Digite a opção desejada:");
                                        System.out.println("1 - Cadastrar Conta Corrente");
                                        System.out.println("2 - Cadastrar Conta Poupança");
                                        System.out.println("3 - Cadastrar Conta Salario");
                                        System.out.println("9 - Voltar");
                                        op = entrada.nextInt();
                                        entrada.nextLine();
                                        c1 = (Cliente) pessoas.get(i);
                                        switch (op) {
                                            case 1:
                                                System.out.println("Digite as seguintes informações:");
                                                System.out.println("Numero da conta: ");
                                                nro = entrada.nextLine();
                                                System.out.println("Senha: ");
                                                senha = entrada.nextLine();
                                                System.out.println("Limite de cheque: ");
                                                valor = entrada.nextDouble();
                                                System.out.println("Taxa de administração: ");
                                                valorS = entrada.nextDouble();
                                                conta = new ContaCorrente(nro, c1.getAgencia(), senha, valor, valorS);
                                                conta.c1=c1;
                                                System.out.println("Deseja associar um segundo cliente a essa conta? (S = 1/N = 0)");
                                                sn = entrada.nextInt();
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(i).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(i);
                                                            sn = 0;
                                                            break;
                                                        }
                                                        System.out.println("CPF não cadastrado");
                                                    }
                                                }
                                                contas.add(conta);
                                                break;
                                            case 2:
                                                System.out.println("Digite as seguintes informações:");
                                                System.out.println("Numero da conta: ");
                                                nro = entrada.nextLine();
                                                System.out.println("Senha: ");
                                                senha = entrada.nextLine();
                                                System.out.println("Rendimento: ");
                                                valor = entrada.nextDouble();
                                                conta = new ContaPoupanca(nro, c1.getAgencia(), senha, valor);
                                                conta.c1=c1;
                                                System.out.println("Deseja associar um segundo cliente a essa conta? (S = 1/N = 0)");
                                                sn = entrada.nextInt();
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(i).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(i);
                                                            break;
                                                        }
                                                        System.out.println("CPF não cadastrado");
                                                    }
                                                }
                                                contas.add(conta);
                                                break;
                                            case 3:
                                                System.out.println("Digite as seguintes informações:");
                                                System.out.println("Numero da conta: ");
                                                nro = entrada.nextLine();
                                                System.out.println("Senha: ");
                                                senha = entrada.nextLine();
                                                System.out.println("Limite de saque: ");
                                                valor = entrada.nextDouble();
                                                System.out.println("Limite de transferencia: ");
                                                valorS = entrada.nextDouble();
                                                conta = new ContaSalario(nro, c1.getAgencia(), senha, valor, valorS);
                                                conta.c1=c1;
                                                System.out.println("Deseja associar um segundo cliente a essa conta? (S = 1/N = 0)");
                                                sn = entrada.nextInt();
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(i).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(i);
                                                            break;
                                                        }
                                                        System.out.println("CPF não cadastrado");
                                                    }
                                                }
                                                contas.add(conta);
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                        }
                                    }
                                    if(flag)
                                        System.out.println("CPF não cadastrado");
                                break;
                            case 3:
                                System.out.println("Digite o numero da conta: ");
                                nro = entrada.nextLine();
                                flag = false;
                                for(int i = 0; i < contas.size();i++){
                                    if(contas.get(i).getNro().compareTo(nro) == 0) {
                                        flag = true;
                                        conta = contas.get(i);
                                        System.out.println("Digite sua senha: ");
                                        senha = entrada.nextLine();
                                        try {
                                            conta.verificaSenha(senha);
                                        }catch (SenhaIncorretaException e){
                                            System.out.println(e.getMessage());
                                            break;
                                        }
                                        do{
                                            System.out.println("Bem vindo!");
                                            System.out.println("Saldo: " + conta.getSaldo(senha));
                                            System.out.println("O que deseja fazer: ");
                                            System.out.println("1 - Saque\n2 - Deposito\n3 - Pagamento\n9 - Sair");
                                            op = entrada.nextInt();
                                            entrada.nextLine();
                                            switch(op){
                                                case 1:
                                                    System.out.println("Por questões de segurança digite sua senha novamente: ");
                                                    senha2 = entrada.nextLine();
                                                    System.out.println("Digite o valor de saque: ");
                                                    valor = entrada.nextDouble();
                                                    try{
                                                        conta.sacaValor(senha2,valor);
                                                    }catch(RuntimeException e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Por questões de segurança digite sua senha novamente: ");
                                                    senha2 = entrada.nextLine();
                                                    System.out.println("Digite o valor de deposito: ");
                                                    valor = entrada.nextDouble();
                                                    try{
                                                        conta.depositaValor(senha2,valor);
                                                    }catch(RuntimeException e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Por questões de segurança digite sua senha novamente: ");
                                                    senha2 = entrada.nextLine();
                                                    System.out.println("Digite o valor de pagamento: ");
                                                    valor = entrada.nextDouble();
                                                    try{
                                                        conta.efetuaPagamento(senha2,valor);
                                                    }catch(RuntimeException e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                    break;
                                            }
                                        }while(op != 9);
                                    }
                                    op = 0;
                                    break;
                                }
                                if (!flag)
                                    System.out.println("Conta nao encontrada");
                                break;
                        }
                    }while(op != 9);
                    break;
                case 2: //FUNCIONARIO
                    System.out.println("Digite a opção desejada:");
                    System.out.println("1 - Cadastrar Funcionario");
                    System.out.println("2 - Cadastrar Gerente");
                    System.out.println("9 - Sair");
                    op = entrada.nextInt();
                    entrada.nextLine();
                    switch(op){
                        case 1:
                            System.out.println("Digite as seguintes informações:");
                            System.out.println("CPF: ");
                            CPF = entrada.nextLine();
                            System.out.println("Nome Completo: ");
                            Nome = entrada.nextLine();
                            System.out.println("Numero da Carteira de Trabalho: ");
                            nroC = entrada.nextLine();
                            System.out.println("RG: ");
                            RG = entrada.nextLine();
                            System.out.println("Endereco: ");
                            endereco = entrada.nextLine();
                            System.out.println("Sexo: ");
                            sexo = entrada.nextLine();
                            System.out.println("Estado Civil: ");
                            estadoCiv = entrada.nextLine();
                            System.out.println("Data de nascimento: ");
                            nascimento = entrada.nextLine();
                            System.out.println("Cargo: ");
                            cargo = entrada.nextLine();
                            System.out.println("Salario: ");
                            valor = entrada.nextDouble();
                            System.out.println("Ano de Ingresso: ");
                            ano = entrada.nextInt();
                            pessoas.add(new Funcionario(CPF,Nome,nroC,RG,endereco,sexo,estadoCiv,cargo,valor,ano,nascimento));
                            break;
                        case 2:
                            System.out.println("Digite as seguintes informações:");
                            System.out.println("CPF: ");
                            CPF = entrada.nextLine();
                            System.out.println("Nome Completo: ");
                            Nome = entrada.nextLine();
                            System.out.println("Numero da Carteira de Trabalho: ");
                            nroC = entrada.nextLine();
                            System.out.println("RG: ");
                            RG = entrada.nextLine();
                            System.out.println("Endereco: ");
                            endereco = entrada.nextLine();
                            System.out.println("Sexo: ");
                            sexo = entrada.nextLine();
                            System.out.println("Estado Civil: ");
                            estadoCiv = entrada.nextLine();
                            System.out.println("Data de nascimento: ");
                            nascimento = entrada.nextLine();
                            System.out.println("Cargo: ");
                            cargo = entrada.nextLine();
                            System.out.println("Salario: ");
                            valorS = entrada.nextDouble();
                            System.out.println("Ano de Ingresso: ");
                            ano = entrada.nextInt();
                            System.out.println("O gerente tem curso de administracao? (S = 1/N = 0)");
                            sn = entrada.nextInt();
                            if(sn == 1)
                                curso = true;
                            else
                                curso = false;
                            System.out.println("Data de Ingresso: ");
                            data = entrada.nextLine();
                            System.out.println("Valor de comissaso");
                            valor = entrada.nextDouble();
                            System.out.println("Numero da agencia: ");
                            nro = entrada.nextLine();
                            flag = true;
                            for(int i = 0; i < agencias.size();i++){
                                if(agencias.get(i).validaAgencia(nro)){
                                    agencia = agencias.get(i);
                                    flag = false;
                                    Gerente gerente = new Gerente(CPF,Nome,nroC,RG,endereco,sexo,estadoCiv,cargo,valorS,ano,nascimento,curso,data,valor);
                                    pessoas.add(gerente);
                                    agencia.setGerente(gerente);
                                    break;
                                }
                                if(flag)
                                    System.out.println("Agencia nao encontrada");
                            }

                    }
                    op = 0;
                    break;
                case 3: //ADM
                    System.out.println("Digite as seguintes informações:");
                    System.out.println("Numero de identificação: ");
                    nro = entrada.nextLine();
                    System.out.println("Nome ficticio: ");
                    Nome = entrada.nextLine();
                    System.out.println("Estado: ");
                    nroC = entrada.nextLine();
                    System.out.println("Cidade: ");
                    RG = entrada.nextLine();
                    System.out.println("Bairro: ");
                    endereco = entrada.nextLine();
                    agencias.add(new Agencia(endereco,RG,nroC,Nome,nro));
                    System.out.println("Aviso! Esta agência não possui um gerente, registre-o assim que posspivel no menu de funcionários");
                    break;
            }
        }while(op != 9);
    }
}