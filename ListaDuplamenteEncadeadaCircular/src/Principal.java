
public class Principal {
	    public static void main(String[] args) {
	        Lista lista = new Lista();

	        System.out.println("INSERÇÃO");
	        lista.inserir(10); // lista vazia
	        lista.inserir(20); // lista não vazia
	        lista.inserir(30);
	        lista.inserir(40);
	        lista.imprimir();

	        System.out.println("\nEXCLUSÃO NO MEIO");
	        lista.excluir(20);
	        lista.imprimir(); 

	        System.out.println("\nEXCLUSÃO NO FIM ");
	        lista.excluir(40);
	        lista.imprimir(); 

	        System.out.println("\nEXCLUSÃO NO PRIMEIRO");
	        lista.excluir(10);
	        lista.imprimir(); 

	        System.out.println("\nEXCLUSÃO DO ÚNICO NÓ RESTANTE");
	        lista.excluir(30);
	        lista.imprimir(); 
	    }
}
