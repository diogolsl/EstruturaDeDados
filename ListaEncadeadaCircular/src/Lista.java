public class Lista {
	// propriedade da classe
	private No cabeca = null;
	
	// metodos da classe
	public void inserir(int numero) {
		// lista vazia
		if (cabeca == null) {
			cabeca = new No(numero, null);
			cabeca.setProximo(cabeca); // evita que ponteiro aponte pra nulo (em lista circular não pode)
			return;
		}
		
		// lista nao vazia
		No ultimo = cabeca;
		while (ultimo.getProximo() != cabeca) {
			ultimo = ultimo.getProximo();
		}
		ultimo.setProximo(new No(numero,cabeca));
	}
	
	public void excluir(int numero) {
		// lista vazia
		if (cabeca == null) {
			return;
			}
		
		// excluir unico 
		if ((cabeca.getNumero() == numero) && (cabeca.getProximo() == cabeca)) {
			cabeca = null;
			return;
		}
		
		// excluir o primeiro
		if (cabeca.getNumero() == numero) {
			No ultimo = cabeca;
			while (ultimo.getProximo() != cabeca) {
				ultimo = ultimo.getProximo();
			}
			cabeca = cabeca.getProximo();
			ultimo.setProximo(cabeca);
			return;
		}
		
		// excluir no meio ou no fim
		No anterior = cabeca;
		while ((anterior.getProximo() != null) && 
			  (anterior.getProximo().getNumero() != numero)) {
			anterior = anterior.getProximo();
		}
		if (anterior.getProximo() == cabeca) { // nao encontrei o numero
			return;
		}
		anterior.setProximo(anterior.getProximo().getProximo());
	}
	
	public void imprimir() {
		if (cabeca == null) {
			return;
		}
		
		No ponteiro = cabeca;
		do {
			System.out.println(ponteiro.getNumero());
			ponteiro = ponteiro.getProximo();
		} while (ponteiro != cabeca); 
	}
}
