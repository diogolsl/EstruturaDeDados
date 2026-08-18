import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Lista objLista = new Lista();
		int opcao = 0;
		
		while (opcao != 5) {
			System.out.println("Menu de Opcoes");
			System.out.println("1 - Inserir");
			System.out.println("2 - Excluir");
			System.out.println("3 - Imprimir");
			System.out.println("4 - Cem Milhoes");
			System.out.println("5 - Sair");
			
			System.out.print("Digite sua opcao: ");
			opcao = leitor.nextInt();
			
			if (opcao == 1) {
				System.out.print("Digite um numero para incluir: ");
				objLista.inserir(leitor.nextInt());
			} else if (opcao == 2) {
				System.out.print("Digite um numero para excluir: ");
				objLista.excluir(leitor.nextInt());
			} else if (opcao == 3) {
				objLista.imprimir();
			} else if (opcao == 4) {
				for ( int i = 0; i < 100000000; i++) {
					objLista.inserir(i);
				}
			}
		}
		leitor.close();
	}
}
