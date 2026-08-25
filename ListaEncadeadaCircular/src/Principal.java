import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Lista objLista = new Lista();
		int opcao = 0;
		
		while (opcao != 5) {
			System.out.println("Opcoes");
			System.out.println("1 - Inserir");
			System.out.println("2 - excluir");
			System.out.println("3 - Imprimir");
			System.out.println("4 - Cem mil");
			System.out.println("5 - Sair");
			System.out.println("Digite sua opcao:  ");
			opcao = leitor.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Digite um numero: ");
					objLista.inserir(leitor.nextInt());
					break;
				case 2:
					System.out.println("Digite um numero: ");
					objLista.excluir(leitor.nextInt());
					break;
				case 3:
					objLista.imprimir();
					break;
				case 4:
					for (int i = 0; i < 100000; i++) {
						objLista.inserir(i);
						System.out.println(i);
					}
					break;
				case 5:
					System.out.println("Saindo do programa");
					break;
			}
			
		}
		leitor.close();
	}
}
