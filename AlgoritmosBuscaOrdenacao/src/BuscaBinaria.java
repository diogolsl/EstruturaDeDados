import java.util.Scanner;

public class BuscaBinaria {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    int[] vetor = new int[10000000];
    int valor = 0;

    for (int i = 0; i < vetor.length; i++) {
      vetor[i] = i;
    }

    while (valor != -1) {
      int contador = 0;
      System.out.println("Digite um valor a ser buscado: ");
      valor = leitor.nextInt();
      int inicio = 0;
      int fim = vetor.length - 1;
      
      while (inicio <= fim) {
        int meio = ((inicio + fim) / 2);
        contador++;
        if (vetor[meio] == valor) {
          System.out.println("ACHEI !!! Na posição " + meio + " Na tentativa " + contador);
          break;
        } else if (vetor[meio] > valor) {
          fim = meio - 1;
        } else {
          inicio = meio + 1;
        }
      }
    }
    leitor.close();
  }
}

