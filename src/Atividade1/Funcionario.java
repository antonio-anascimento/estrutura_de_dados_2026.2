package Atividade1;

public class Funcionario extends FuncionariopBase{


    public Funcionario(double salario, String nome, Boolean projeto) {
        super(salario, nome, projeto);
    }

    @Override
    public double CalcularSalario(double salario, double bonus, int qtdFuncionarios, Boolean projeto) {

        double salarioB;

        if(projeto = true){
            salarioB = salario *0.1;
            return salarioB;
        } else {
            return salario;
        }

    }


}
