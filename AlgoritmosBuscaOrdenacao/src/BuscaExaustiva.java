import java.util.Scanner;

public class BuscaExaustiva {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int[] vetor = new int[10000000];
		int parametroPesquisa = 0;
		
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = ((int) (vetor.length * Math.random()));
		}
		
		do {
			System.out.print("Digite um parametro de pesquisa");
			parametroPesquisa = leitor.nextInt();
			
			for ( int i =0; i < vetor.length; i++) {
				if (parametroPesquisa == vetor[i]) {
					System.out.println("ACHEI !!!! Na posicao:" + i );
					break;
				}
			}
		} while (parametroPesquisa != -1); 
			
		leitor.close();
	}
}
