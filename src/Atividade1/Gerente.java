package Atividade1;

public class Gerente extends FuncionariopBase{

    private double bonus;
    private int qtdFuncionarios;

    public Gerente(double salario, String nome, Boolean projeto) {
        super(salario, nome, projeto);
        this.bonus = bonus;
        this.qtdFuncionarios = qtdFuncionarios;
    }


    @Override
    public double CalcularSalario(double salario, double bonus, int qtdFuncionarios, Boolean projeto){

        if(projeto = true){
            return salario * 0.1;
        }
        return salario + (bonus * qtdFuncionarios);
    }
}
