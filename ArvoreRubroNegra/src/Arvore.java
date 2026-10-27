public class Arvore {
    // Propriedades da classe
    private No raiz = null;

    // Metodos da classe
    private No rotacionarEsquerda(No raizVelha) {
        // Correcao dos ponteiros
        No raizNova = raizVelha.getDireita();
        raizVelha.setDireita(raizNova.getEsquerda());
        raizNova.setEsquerda(raizVelha);
        // Correcao das cores
        raizNova.setVermelho(raizVelha.isVermelho());
        raizVelha.setVermelho(true);
        return raizNova;
    }

    private No rotacionarDireita(No raizVelha) {
        // Correcao dos ponteiros
        No raizNova = raizVelha.getEsquerda();
        raizVelha.setEsquerda(raizNova.getDireita());
        raizNova.setDireita(raizVelha);
        // Correcao das cores
        raizNova.setVermelho(raizVelha.isVermelho());
        raizVelha.setVermelho(true);
        return raizNova;
    }

    private void subirVermelho(No raiz) {
        raiz.setVermelho(true);
        raiz.getEsquerda().setVermelho(false);
        raiz.getDireita().setVermelho(false);
    }

    private boolean isVermelho(No raiz) {
        if (raiz == null) return false;
        return raiz.isVermelho();
    }

    public void inserir(int numero) {
        raiz = inserir(raiz, numero);
        raiz.setVermelho(false);
    }

    private No inserir(No raiz, int numero) {
        // Arvore vazia
        if (raiz == null) return new No(numero, null, null, true);
        // Arvore nao vazia
        if (numero < raiz.getNumero()) {
            raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
        } else {
            raiz.setDireita(inserir(raiz.getDireita(), numero));
        }

        // Correcoes de Balanceamento
        if ((!isVermelho(raiz.getEsquerda()) && isVermelho(raiz.getDireita()))) {
            raiz = rotacionarEsquerda(raiz);
        }
        if ((isVermelho(raiz.getEsquerda()) && isVermelho(raiz.getEsquerda().getEsquerda()))) {
            raiz = rotacionarDireita(raiz);
        }
        if ((isVermelho(raiz.getEsquerda()) && isVermelho(raiz.getDireita()))) {
            subirVermelho(raiz);
        }
        return raiz;
    }

    public void imprimir() {
        imprimir(raiz, "");
    }

    private void imprimir(No raiz, String identacao) {
        if (raiz == null) return;

        System.out.println(identacao + raiz.getNumero() + " (" + (raiz.isVermelho() ? "V" : "P") + ")");
        imprimir(raiz.getEsquerda(), identacao + "---");
        imprimir(raiz.getDireita(), identacao + "---");
    }
}
