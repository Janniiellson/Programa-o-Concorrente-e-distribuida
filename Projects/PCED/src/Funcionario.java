public class Funcionario extends Thread {
    public static final double salario = 1400.0;
    private Conta contaSalario;
    Conta contaInvestimentos;

    public Funcionario(Conta contaSalario, Conta contaInvestimentos) {
        this.contaSalario = contaSalario;
        this.contaInvestimentos = contaInvestimentos;
    }

    public void realizarInvestimento() {
        double valorInvestimento = salario * 0.2;
        contaSalario.transferir(contaInvestimentos, valorInvestimento);
        System.out.println(Thread.currentThread().getName() + " realizou um investimento de R$" + valorInvestimento + " na conta de investimentos.");
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimentos() {
        return contaInvestimentos;
    }

    public void run() {
        realizarInvestimento();
    }
}
