package Atividade1;

public abstract class FuncionariopBase{

    private double salario;
    private String nome;
    private Boolean projeto;

    public FuncionariopBase(double salario, String nome, Boolean projeto) {
        this.salario = salario;
        this.nome = nome;
        this.projeto = projeto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public double CalcularSalario(){
        return salario;
    }

    public abstract double CalcularSalario(double salario, double bonus, int qtdFuncionarios, Boolean projeto);

}
