public class Lista {
	// Propriedades da classe
	private No cabeca = null;
	
	// Metodos da classe
	public void inserir(int numero) {
		// Cenario facil - lista vazia
		if (cabeca == null) {
			cabeca = new No(numero,null);
			return;
		}
		
		// Cenario dificil - lista nao ta vazia
		No ultimo = cabeca;
		
		// ir p frente ate o final
		while (ultimo.getProximo() != null) {
			ultimo = ultimo.getProximo();
		}
		// transformar o ultimo em penultimo
		ultimo.setProximo(new No(numero, null));
	}
	
	public void excluir(int numero) {
		// Cenario muito facil - Lista vazia
		if (cabeca == null) {
			return;
		}
		
		// Cenario facil - excluir primeiro nó da lista
		if (cabeca.getNumero() == numero) {
			cabeca = cabeca.getProximo();
			return;
		}
		
		// Procurar o nó a ser excluido, tem que parar no anterior
		No anterior = cabeca;
		while ((anterior.getProximo() != null) && (anterior.getProximo().getNumero() != numero)) {
			anterior = anterior.getProximo();
		}
		
		// Cenario dificil e nao achei o numero
		if (anterior.getProximo() == null) {
			return;
		}
		
		// Cenario dificil mas achei o numero
		anterior.setProximo(anterior.getProximo().getProximo());
	}
	
	public void imprimir() {
		No ponteiro = cabeca;
		
		while (ponteiro != null) {
			System.out.println(ponteiro.getNumero());
			ponteiro = ponteiro.getProximo();
		}
		
	}
}
