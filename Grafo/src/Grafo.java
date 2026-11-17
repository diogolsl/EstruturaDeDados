import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
    // propriedades da classe
    private boolean[][] matrizAdjacencia = null;

    // metodo construtor
    public Grafo(int tamanho) {
        matrizAdjacencia = new boolean[tamanho][tamanho];
    }

    // metodos da classe
    public void construir(boolean aleatorio) {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        boolean adjacencia = false;

        for (int i = 0; i < (matrizAdjacencia.length - 1); i++) {
            for (int j = (i + 1); j < matrizAdjacencia.length; j++) {
                if (aleatorio) {
                    adjacencia = (((int) (2 *  Math.random()))  == 1);
                } else {
                    try {
                        System.out.print("Digite <S> se " + i + " for vizinho de " + j + ": ");
                        adjacencia = leitor.readLine().equalsIgnoreCase("S");
                    } catch (Exception e) {}
                }
                matrizAdjacencia[i][j] = adjacencia;
                matrizAdjacencia[j][i] = adjacencia;
            }
        }
    }

    public  void imprimir() {
        System.out.println("Vértice \t Vizinhança");
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            System.out.print(i + "\t\t ");
            for (int j = 0; j < matrizAdjacencia.length; j++) {
                if (matrizAdjacencia[i][j]) {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }
    }

    public void procurarVerticeMaiorGrau() {
        int vertice = 0;
        int grau = 0;
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            int contador = 0;
            for (int j = 0; j < matrizAdjacencia.length; j++) {
                if (matrizAdjacencia[i][j]) {
                    contador++;
                }
            }
            if (contador > grau) {
                vertice = i;
                grau = contador;
            }
        }
        System.out.println("O vertice " + vertice + " é o mais popular com " + grau + " amigos");
    }
}
