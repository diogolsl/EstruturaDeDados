import java.util.Scanner;

public class BubbleSort {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    int[] vetor = new int[5];

    for (int i = 0; i < vetor.length; i++) {
      System.out.println("Digite o valor da posição " + i + ": ");
      vetor[i] = leitor.nextInt();
    }

    leitor.close();

    boolean continuar = true;
    while (continuar) {
      continuar = false;
      for (int i = 0; i < (vetor.length - 1); i++) {
        if (vetor[i] > vetor[i + 1]) {
          int temp = vetor[i];
          vetor[i] = vetor[i + 1];
          vetor[i + 1] = temp;
          continuar = true;
        }
      }
    }

    for (int i = 0; i < vetor.length; i++) {
      System.out.println("vetor[" + i + "]: " + vetor[i]);
    }
  }
}
