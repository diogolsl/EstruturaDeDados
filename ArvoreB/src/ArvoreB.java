public class ArvoreB {
    // propriedades da classe
    private No raiz =null;

    // metodo construtor da classe
    public ArvoreB(int tamanho) {
        raiz = new No(tamanho);
    }

    // metodos da classe
    public void inserir(int numero) {
       RetornoRecursao retorno = inserir(raiz, numero, null);
       if (retorno != null) {
           No novaRaiz = new No(raiz.getChaves().length);
           novaRaiz.setFolha(false);
           novaRaiz.setQtdChaves(1);
           novaRaiz.setChave(0, retorno.getChaveDoMeio());
           novaRaiz.setFilho(0, raiz);
           novaRaiz.setFilho(1, retorno.getFilhoDoMeio());
           raiz = novaRaiz;
       }
    }

    private RetornoRecursao inserir(No raiz, int numero, No filho) {
        // nao é uma folha, tem de procurar a folha certa para inserir
        if ((!raiz.isFolha()) && (filho == null)) {
            int indiceFilho = 0;
            boolean encontrei = false;
            for (int i = 0; i < raiz.getQtdChaves(); i++) {
                if (raiz.getChave(i) > numero) {
                    indiceFilho = i;
                    encontrei = true;
                    break;
                }
            }

            if (! encontrei) indiceFilho = raiz.getQtdChaves();

            RetornoRecursao retorno = inserir(raiz.getFilho(indiceFilho), numero, filho);
            if (retorno != null) {
                retorno = inserir(raiz, retorno.getChaveDoMeio(), retorno.getFilhoDoMeio());
            }

            return retorno;
        }

        // é folha e nao ta cheia
        if (! raiz.isCheia()) {
            raiz.inserir(numero, filho);
            return null;
        }

        // é folha e esta cheia
        int indiceMeio = (raiz.getQtdChaves() / 2);
        int chaveMeio = raiz.getChave(indiceMeio);

        No novoNo = new No(raiz.getChaves().length);
        novoNo.setFolha(raiz.isFolha());

        int novoIndice = 0;
        for (int i = (indiceMeio + 1); i < raiz.getQtdChaves(); i++) {
            novoNo.setChave(novoIndice, raiz.getChave(i));
            novoNo.setFilho(novoIndice, raiz.getFilho(i));
            raiz.setChave(i, 0);
            raiz.setFilho(i, null);
            novoIndice++;
        }

        novoNo.setFilho(novoIndice, raiz.getFilho(raiz.getQtdChaves()));
        raiz.setFilho(raiz.getQtdChaves(), null);
        raiz.setChave(indiceMeio, 0);

        novoNo.setQtdChaves(indiceMeio - ((raiz.getQtdChaves() % 2) == 0 ? 1 : 0));
        raiz.setQtdChaves(indiceMeio);

        if (numero < chaveMeio) {
            raiz.inserir(numero, filho);
        } else {
            novoNo.inserir(numero, filho);
        }

        return new RetornoRecursao(chaveMeio, novoNo);
    }
    public void imprimir() {
        System.out.println("Estrutura da Árvore B:");
        imprimir(raiz, 0);
    }

    private void imprimir(No no, int nivel) {
        if (no == null) return;

        StringBuilder indentacao = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            indentacao.append("        ");
        }
        System.out.println(indentacao.toString() + "Nível " + nivel + " : [" + no.imprimirChaves() + "]");

        if (!no.isFolha()) {
            for (int i = 0; i <= no.getQtdChaves(); i++) {
                imprimir(no.getFilho(i), nivel + 1);
            }
        }
    }
}
