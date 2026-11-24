import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grafo {
    // propriedades da classe
    private boolean[][] matriz = null;

    // metodo construtor cheio
    public Grafo(int qtdVertices) {
        matriz = new boolean[qtdVertices][qtdVertices];
    }

    // metodos da classe
    public void construir(boolean aleatorio) {
        boolean adjacencia = false;

        for (int i = 0; i < (matriz.length - 1); i++) {
            for (int j = (i + 1); j < matriz.length; j++) {
                if (aleatorio) {
                    adjacencia = (((int) (10 * Math.random())) == 0);
                } else {
                    BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        System.out.print("Digite <S> se " + i + " for adjacente a " + j + ": ");
                        adjacencia = leitor.readLine().equalsIgnoreCase("s");
                    } catch (Exception e) {}
                }
                matriz[i][j] = adjacencia;
                matriz[j][i] = adjacencia;
            }
        }
    }

    private boolean procurarPercursoRecursivo(boolean visitado[], int inicio, int fim) {
        if (inicio == fim) return true;

        visitado[inicio] = true;
        for (int vizinho = 0; vizinho < matriz.length; vizinho++) {
            if ((matriz[inicio][vizinho]) && (!visitado[vizinho])) {
                if (procurarPercursoRecursivo(visitado, vizinho, fim)) {
                    System.out.print(vizinho + " <-- ");
                    return true;
                }
            }
        }
        return false;
    }

    public void procurarPercurso(int inicio, int fim) {
        boolean encontrei = false;

        if (procurarPercursoRecursivo(new boolean[matriz.length], inicio, fim)) {
            System.out.println(inicio);
        } else {
            System.out.println("Nao ha caminho entre esses vertices !");
        }
    }
}
