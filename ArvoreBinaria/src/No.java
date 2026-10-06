public class No {
    // Propriedades da classe
    private int numero;
    private No esquerda = null;
    private No direita = null;

    // Metodos de Acesso da classe
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    // Metodos Construtores da classe
    public No() {
        super();
    }

    public No(int numero, No esquerda, No direita) {
        this.numero = numero;
        this.esquerda = esquerda;
        this.direita = direita;
    }
}
