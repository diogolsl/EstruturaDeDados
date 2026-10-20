public class Arvore {
    // Propriedades da classe
    private No raiz = null;
    private int contador = 0;

    // Metodos da classe
    public void inserir(int numero) {
        raiz = inserir(raiz, numero);
    }

    private No inserir(No raiz, int numero) {
        // Arvore vazia
        if (raiz == null) {
            return new No(numero, null, null);
        }
        // Arvore nao vazia
        if (numero < raiz.getNumero()) {
            raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
        } else {
            raiz.setDireita(inserir(raiz.getDireita(), numero));
        }

        return raiz;
    }

    public void procurar(int numero) {
        procurar(raiz, numero);
    }

    private void procurar(No raiz, int numero) {
        // Arvore vazia
        if (raiz == null) {
            System.out.println("Nao achei !!! Tentei " + contador + " vezes");
            contador = 0;
            return;
        }
        // Numero esta na raiz
        if (numero == raiz.getNumero()) {
            System.out.println("Achei em " + contador + " tentativas!!!");
            contador = 0;
            return;
        }
        // Numero nao é a raiz
        contador++;
        if (numero < raiz.getNumero()) {
            procurar(raiz.getEsquerda(), numero);
        } else  {
            procurar(raiz.getDireita(), numero);
        }
    }

    public void navegarEmOrdem() {
        System.out.println("Navegando em ordem: ");
        navegarEmOrdem(raiz);
        System.out.println();
    }

    private void navegarEmOrdem(No raiz) {
        if (raiz == null) return;

        navegarEmOrdem(raiz.getEsquerda());
        System.out.println(raiz.getNumero() + " ");
        navegarEmOrdem(raiz.getDireita());
    }
}
