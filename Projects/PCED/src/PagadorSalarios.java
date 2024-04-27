public class PagadorSalarios extends Thread {
    private Loja loja;

    public PagadorSalarios(Loja loja) {
        this.loja = loja;
    }

    public void run() {
        while (true) {
            loja.efetuarPagamentoSalariosSePossivel();
        }
    }
}
