import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Grafo objGrafo = new Grafo(16);
        int inicio = 0;
        int fim = 0;

        objGrafo.construir(false);

        do {
            System.out.print("Digite o vertice inicial: ");
            inicio = leitor.nextInt();

            System.out.print("Digite o vertice final: ");
            fim = leitor.nextInt();

            objGrafo.procurarPercurso(inicio, fim);
        } while (inicio != fim);
        leitor.close();
    }
}
