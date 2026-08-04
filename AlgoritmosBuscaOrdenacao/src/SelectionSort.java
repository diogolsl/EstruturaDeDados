import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {

    Scanner leitor = new Scanner(System.in);
    int[] vetor = new int[5];

    for (int i = 0; i < vetor.length; i++) {
      System.out.println("Digite o valor da posição " + i + ": ");
      vetor[i] = leitor.nextInt();
    }

    leitor.close();

    for (int i = 0; i < (vetor.length - 1); i++) {
      for (int j = (i + 1); j < vetor.length; j++) {
        if (vetor[i] > vetor[j]) {
          int temp = vetor[i];
          vetor[i] = vetor[j];
          vetor[j] = temp;
        }
      }
    }

    for (int i = 0; i < vetor.length; i++) {
      System.out.println("vetor[" + i + "] = " + vetor[i]);
    }
  }
}
