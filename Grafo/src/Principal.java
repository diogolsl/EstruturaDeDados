public class Principal {
    public static void main(String[] args) {
        Grafo objGrafo = new Grafo(20000);

        objGrafo.construir(true);

        // objGrafo.imprimir();

        objGrafo.procurarVerticeMaiorGrau();
    }
}
