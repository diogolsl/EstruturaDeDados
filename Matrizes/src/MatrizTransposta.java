import java.util.Scanner;

public class MatrizTransposta {

		public static void main(String[] args) {
			Scanner leitor = new Scanner(System.in);
			int[][] matrizOriginal = new int[2][3];
			int[][] matrizTransposta = new int[3][2];
			
			for (int i = 0; i < matrizOriginal.length; i++) {
				for (int j = 0; j < matrizOriginal[i].length; j++) {
					System.out.print("matrizOriginal[" + i + "][" + j + "] = ");
					matrizOriginal[i][j] = leitor.nextInt();
				}
			}
			leitor.close();
			
			for (int i = 0; i < matrizOriginal.length; i++) {
				for (int j = 0; j < matrizOriginal[i].length; j++) {
					matrizTransposta[j][i] = matrizOriginal[i][j];
				}
			}
			
			System.out.println("Matriz original");
			for (int i = 0; i < matrizOriginal.length; i++) {
				for (int j = 0; j < matrizOriginal[i].length; j++) {
					System.out.print(matrizOriginal[i][j] + "\t");
				}
				System.out.println();
			}
			
			System.out.println("Matriz transposta");
			for (int i = 0; i <  matrizTransposta.length; i++) {
				for (int j = 0; j < matrizTransposta[i].length; j++) {
					System.out.print(matrizTransposta[i][j] + "\t");
				}
				System.out.println();
			}
		}
}
