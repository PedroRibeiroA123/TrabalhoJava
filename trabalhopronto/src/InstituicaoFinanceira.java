import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class InstituicaoFinanceira {
    public static void main(String[] args) {
        ArrayList <Conta> contas = new ArrayList<>();
        ArrayList <Agencia> agencias = new ArrayList<>();
        ArrayList <Pessoa> pessoas = new ArrayList<>();
        int op;
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
        boolean flag, curso;
        boolean flag2 = true;
        int ano, sn;
        double valor, valorS;
        Conta conta;
        Cliente c1;

        try{
            FileInputStream arqContas = new FileInputStream("Contas");
            ObjectInputStream isc = new ObjectInputStream(arqContas);
            contas = (ArrayList<Conta>) isc.readObject();
            isc.close();
            arqContas.close();
            FileInputStream arqAgencia = new FileInputStream("Agencias");
            ObjectInputStream isa = new ObjectInputStream(arqAgencia);
            agencias = (ArrayList<Agencia>) isa.readObject();
            isa.close();
            arqAgencia.close();
            FileInputStream arqPessoa = new FileInputStream("Pessoas");
            ObjectInputStream isp = new ObjectInputStream(arqPessoa);
            pessoas = (ArrayList<Pessoa>) isp.readObject();
            isp.close();
            arqPessoa.close();
        }catch(IOException erro){
            System.out.println("Ocorreu erro na leitura dos dados" + erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Alguma classe nao foi encontrada" + erro);
        }
        Scanner entrada = new Scanner(System.in);


        /*Agencia BB = new Agencia("Santa Monica","Uberlandia","MG","Banco do Brasil","5555");
        Gerente cleito = new Gerente("51142005690","Cleiton","564764","6445654","aaa","M","Solteiro",2666.666,2001,"15/08/1987",true,"09/11/2001",555.55);
        contas.add(new ContaCorrente("3456",BB,"batata123",1000,100));
        contas.add(new ContaPoupanca("7892",BB,"cenoura123",10));
        contas.add(new ContaSalario("8912",BB,"rabanete123",1000,500));
        Cliente carlos = new Cliente("15018273674","Carlos","Placeholder","Placeholder","Placeholder","Placeholder",BB);
        BB.setGerente(cleito);
        cleito.setAgencia(BB);
        agencias.add(BB);
        pessoas.add(carlos);
        pessoas.add(cleito);*/

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
                                                entrada.nextLine();
                                                flag2 = true;
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(j).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(j);
                                                            sn = 0;
                                                            flag2 = false;
                                                            break;
                                                        }
                                                    }
                                                    if(flag2)
                                                        System.out.println("CPF não cadastrado");
                                                }
                                                contas.add(conta);
                                                System.out.println("ADICIONADO");
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
                                                entrada.nextLine();
                                                flag2 = true;
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(j).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(j);
                                                            sn = 0;
                                                            flag2 = false;
                                                            break;
                                                        }
                                                    }
                                                    if(flag2)
                                                        System.out.println("CPF não cadastrado");
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
                                                entrada.nextLine();
                                                flag2 = true;
                                                while(sn == 1){
                                                    System.out.println("Digite o CPF do cliente que será associado a esta conta: ");
                                                    CPF = entrada.nextLine();
                                                    for(int j = 0; j < pessoas.size();j++) {
                                                        if (pessoas.get(j).getCPF().equals(CPF)) {
                                                            conta.c2 = (Cliente) pessoas.get(j);
                                                            sn = 0;
                                                            flag2 = false;
                                                            break;
                                                        }
                                                    }
                                                    if(flag2)
                                                        System.out.println("CPF não cadastrado");
                                                }
                                                contas.add(conta);
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
                                flag = true;
                                for(int i = 0; i < contas.size();i++){
                                    if(contas.get(i).getNro().equals(nro)) {
                                        flag = false;
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
                                }
                                if (flag)
                                    System.out.println("Conta nao encontrada");
                                break;
                        }
                    }while(op != 9);
                    op = 0;
                    break;
                case 2: //FUNCIONARIO
                    System.out.println("Digite a opção desejada:");
                    System.out.println("1 - Cadastrar Funcionario");
                    System.out.println("2 - Cadastrar Gerente");
                    System.out.println("9 - Voltar");
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
                            try {
                                pessoas.add(new Funcionario(CPF,Nome,nroC,RG,endereco,sexo,estadoCiv,cargo,valor,ano,nascimento));
                            } catch (CpfInvalidoException e) {
                                System.out.println(e.getMessage());
                            }
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
                            System.out.println("Salario: ");
                            valorS = entrada.nextDouble();
                            System.out.println("Ano de Ingresso: ");
                            ano = entrada.nextInt();
                            System.out.println("O gerente tem curso de administracao? (S = 1/N = 0)");
                            sn = entrada.nextInt();
                            entrada.nextLine();
                            if(sn == 1)
                                curso = true;
                            else
                                curso = false;
                            System.out.println("Data de Ingresso: ");
                            data = entrada.nextLine();
                            System.out.println("Valor de comissaso");
                            valor = entrada.nextDouble();
                            entrada.nextLine();
                            System.out.println("Numero da agencia: ");
                            nro = entrada.nextLine();
                            flag = true;
                            for(int i = 0; i < agencias.size();i++){
                                if(agencias.get(i).validaAgencia(nro)){
                                    agencia = agencias.get(i);
                                    flag = false;
                                    try {
                                        Gerente gerente = new Gerente(CPF,Nome,nroC,RG,endereco,sexo,estadoCiv,valorS,ano,nascimento,curso,data,valor);
                                        pessoas.add(gerente);
                                        agencia.setGerente(gerente);
                                        gerente.setAgencia(agencia);
                                    } catch (CpfInvalidoException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                }
                            }
                            if(flag)
                                System.out.println("Agencia nao encontrada");

                    }
                    op = 0;
                    break;
                case 3: //ADM
                    do{
                        System.out.println("Escolha uma opcao: ");
                        System.out.println("1 - Imprimir Contas");
                        System.out.println("2 - Imprimir Agencias");
                        System.out.println("3 - Imprimir Pessoas");
                        System.out.println("4 - Cadastrar Agencia");
                        System.out.println("9 - Voltar");
                        op = entrada.nextInt();
                        entrada.nextLine();
                        switch (op){
                            case 1:
                                for(int i = 0; i < contas.size();i++){
                                    contas.get(i).Imprimir();
                                    System.out.println("\n");
                                }
                                break;
                            case 2:
                                for(int i = 0; i < agencias.size();i++){
                                    try{
                                        agencias.get(i).Imprimir();
                                    }catch(RuntimeException e){
                                        System.out.println(e.getMessage());
                                    }
                                    System.out.println("\n");
                                }
                                break;
                            case 3:
                                for(int i = 0; i < pessoas.size();i++){
                                    pessoas.get(i).Imprimir();
                                    System.out.println("\n");
                                }
                                break;
                            case 4:
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
                    op = 0;
                    break;
            }
        }while(op != 9);
        Collections.sort(contas);
        Collections.sort(agencias);
        Collections.sort(pessoas);
        try{
            FileOutputStream ContasArq = new FileOutputStream("Contas");
            ObjectOutputStream os = new ObjectOutputStream(ContasArq);
            os.writeObject(contas);
            os.close();
            ContasArq.close();
            FileOutputStream AgenciaArq = new FileOutputStream("Agencias");
            ObjectOutputStream osa = new ObjectOutputStream(AgenciaArq);
            osa.writeObject(agencias);
            osa.close();
            AgenciaArq.close();
            FileOutputStream PessoaArq = new FileOutputStream("Pessoas");
            ObjectOutputStream osp = new ObjectOutputStream(PessoaArq);
            osp.writeObject(pessoas);
            osp.close();
            PessoaArq.close();
        }catch(IOException erro){
            System.out.println("Ocorreu erro na escrita dos dados" + erro);
        }
    }
}
//072.522.427-49
//727.195.880-08