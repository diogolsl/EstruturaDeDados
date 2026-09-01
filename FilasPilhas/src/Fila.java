// Politica FIFO (First In - First Out)
public class Fila {
	// propriedades da classe
	private No cabeca = null;
	
	// metodos da classe
	public void entrar(int numero) {
		cabeca = new No(numero,cabeca);
	}
	
	public void sair() {
		// caso facil: fila vazia
		if (cabeca == null) {
			return;
		}
		
		// caso medio: 1 nó na fila
		if (cabeca.getProximo() == null) {
			System.out.println(cabeca.getNumero());
			cabeca = null;
			return;
		}
		
		// caso dificil: fila nao vazia
		No penultimo = cabeca;
		while (penultimo.getProximo().getProximo() != null) {
			penultimo = penultimo.getProximo();
		}
		System.out.println(penultimo.getProximo().getNumero());
		penultimo.setProximo(null);
	}
}
