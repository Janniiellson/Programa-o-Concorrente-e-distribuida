public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;
    private Banco banco;
    private PagadorSalarios pagadorSalarios;

    public Loja(Conta conta, Funcionario[] funcionarios, Banco banco) {
        this.conta = conta;
        this.funcionarios = funcionarios;
        this.banco = banco;
        this.pagadorSalarios = new PagadorSalarios(this);
        iniciarPagamentoSalarios();
    }

    public synchronized void iniciarPagamentoSalarios() {
        pagadorSalarios.start();
    }

    public synchronized void efetuarPagamentoSalariosSePossivel() {
        if (conta.getSaldo() >= Funcionario.salario * 2) {
            double saldoInicial = conta.getSaldo();
            banco.fazerTransferencia(conta, funcionarios[0].getContaSalario(), Funcionario.salario);
            funcionarios[0].realizarInvestimento();
            banco.fazerTransferencia(conta, funcionarios[0].getContaInvestimentos(), saldoInicial - conta.getSaldo());

            saldoInicial = conta.getSaldo();
            banco.fazerTransferencia(conta, funcionarios[1].getContaSalario(), Funcionario.salario);
            funcionarios[1].realizarInvestimento();
            banco.fazerTransferencia(conta, funcionarios[1].getContaInvestimentos(), saldoInicial - conta.getSaldo());
        }
    }

    public Conta getConta() {
        return conta;
    }
}
