// Politica FILO (First In - Last Out)
public class Pilha {
	// propriedades da classe
	private No cabeca = null;
	
	// metodos da classe
	public void push(int numero) {
		cabeca = new No(numero,cabeca);
	}
	
	public void pop(int numero) {
		// caso muito facil : pilha vazia
		if (cabeca == null) {
			return;
		}
		
		// caso facil: excluir ultimo que entrou
		System.out.println(cabeca.getNumero());
		cabeca = cabeca.getProximo();
	}
}
