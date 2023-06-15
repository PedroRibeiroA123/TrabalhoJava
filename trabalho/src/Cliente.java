import java.util.ArrayList;
import java.util.Date;
public class Cliente extends Pessoa {
    private String escolaridade;
    private Agencia agencia;
    //Exercicio 3a
    public Cliente(String CPF, String Nome){
        super(CPF,Nome);
    }
    //Exercicio 3b
    public Cliente(){}
    public Cliente(String CPF,String Nome,String endereco,String escolaridade,String estadoCiv,String nascimento,Agencia agencia){
        super(CPF,Nome,endereco,estadoCiv,nascimento);
        this.escolaridade=escolaridade;
        this.agencia=agencia;
    }

    public void ImprimeDados(){
        super.ImprimeDados();
        System.out.println("Escolaridade: " + escolaridade);
    }
    public Agencia getAgencia() {
        return agencia;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
}
