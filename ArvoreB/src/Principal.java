public class Principal {
    public static void main(String[] args) {
        ArvoreB objArvoreB = new ArvoreB(3);

        int[] valores = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int v : valores) {
            objArvoreB.inserir(v);
        }
        objArvoreB.imprimir();
    }
}