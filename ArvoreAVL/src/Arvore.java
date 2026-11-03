public class Arvore {
    // Propriedades da classe
    private No raiz = null;

    // Metodos da classe
    private int getAlturaDoNo(No raiz) {
        if (raiz == null) return 0;
        return raiz.getAltura();
    }

    private int getMaximoEntreDoisNumeros(int a, int b) {
        return (a >b) ? a : b;
    }

    private int getBalanco(No raiz) {
        if (raiz == null) return 0;
        return (getAlturaDoNo(raiz.getEsquerda()) - getAlturaDoNo(raiz.getDireita()));
    }

    private No rotacionarEsquerda(No raizVelha) {
        // correcao dos ponteiros
        No raizNova = raizVelha.getDireita();
        raizVelha.setDireita(raizNova.getEsquerda());
        raizNova.setEsquerda(raizVelha);
        // correcao das alturas
        raizVelha.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raizVelha.getEsquerda()),getAlturaDoNo(raizVelha.getDireita())) + 1);
        raizNova.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raizNova.getEsquerda()),getAlturaDoNo(raizNova.getDireita())) + 1);

        return raizNova;
    }

    private No rotacionarDireita(No raizVelha) {
        // correcao dos ponteiros
        No raizNova = raizVelha.getEsquerda();
        raizVelha.setEsquerda(raizNova.getDireita());
        raizNova.setDireita(raizVelha);
        // correcao das alturas
        raizVelha.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raizVelha.getEsquerda()),getAlturaDoNo(raizVelha.getDireita())) + 1);
        raizNova.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raizNova.getEsquerda()),getAlturaDoNo(raizNova.getDireita())) + 1);

        return raizNova;
    }

    public void inserir(int numero) {
        raiz = inserir(raiz, numero);
    }

    private No inserir(No raiz, int numero) {
        //arvore vazia
        if (raiz == null) {
            return new No(numero, null, null, 1);
        }

        // arovre NAO vazia
        if (numero  < raiz.getNumero()) {
            raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
        } else {
            raiz.setDireita(inserir(raiz.getDireita(), numero));
        }

        // correcoes de balanceamento
        raiz.setAltura(1 + getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerda()),getAlturaDoNo(raiz.getDireita())));

        int balanco = getBalanco(raiz);
        // inclinacao a esquerda, numero menor que o numero da esquerda
        if ((balanco > 1) && (numero < raiz.getEsquerda().getNumero())) {
            raiz = rotacionarDireita(raiz);
        }
        // inclinacao a direita, numero maior que o numero da direita
        if ((balanco < -1) && (numero > raiz.getDireita().getNumero())) {
            raiz = rotacionarEsquerda(raiz);
        }
        // inclinacao a esquerda e numero maior que o numero da esquerda
        if ((balanco > 1) && (numero > raiz.getEsquerda().getNumero())) {
            raiz.setEsquerda(rotacionarEsquerda(raiz.getEsquerda()));
            raiz = rotacionarDireita(raiz);
        }
        // inclinacao a direita, numero menor que o numero da direita
        if ((balanco < -1) && (numero < raiz.getDireita().getNumero())) {
            raiz.setDireita(rotacionarDireita(raiz.getDireita()));
            raiz = rotacionarEsquerda(raiz);
        }

        return raiz;
    }

    public void imprimir() {
        imprimir(raiz, "");
    }

    private void imprimir(No raiz, String indentacao) {
        if (raiz == null) return;

        System.out.println(indentacao + raiz.getNumero());
        imprimir(raiz.getEsquerda(), indentacao + "---");
        imprimir(raiz.getDireita(), indentacao + "---");
    }
}
