import java.util.Scanner;

public class MultiplicacaoMatrizes {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in); 

		int ma[][] = new int[3][2];
		int mb[][] = new int[2][3];
		int mab[][] = new int[3][2];

		for (int i = 0; i < ma.length; i++) {
		    for (int j = 0; j < ma[i].length; j++) {
		        System.out.println("Digite o elemento da linha " + (i + 1) + " e coluna " + (j + 1) + " da matriz 1");
		        ma[i][j] = leitor.nextInt(); 
		    }
		}

		for (int i = 0; i < mb.length; i++) {
		    for (int j = 0; j < mb[i].length; j++) {
		        System.out.println("Digite o elemento da linha " + (i + 1) + " e coluna " + (j + 1) + " da matriz 2");
		        mb[i][j] = leitor.nextInt(); 
		    }
		}

		for (int i = 0; i < mab.length; i++) {
		    for (int j = 0; j < mab[i].length; j++) {
		        for (int k = 0; k < ma[i].length; k++) {
		            mab[i][j] += ma[i][k] * mb[k][j];
		        }
		    }
		}
		
		System.out.println("Matriz resultante");
		for (int i = 0; i <  mab.length; i++) {
			for (int j = 0; j < mab[i].length; j++) {
				System.out.print(mab[i][j] + "\t");
			}
			System.out.println();
		}
		leitor.close();
	}
}
