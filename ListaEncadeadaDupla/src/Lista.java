public class Lista {
	private No cabeca = null;
	
	public void inserir(int numero) {
		/* cabeca ao lado esquerdo: futuro
		   cabeca ao lado direito: passado */
		cabeca = new No(numero, null, cabeca);
		
		// redefinir referencia do ponteiro anterior em caso de lista nao vazia
		if (cabeca.getProximo() != null) {
			cabeca.getProximo().setAnterior(cabeca);
		}
	}
	public void excluir(int numero) {
		// caso muito facil:; lista vazia
		if (cabeca == null) {
			return;
		}
		
		// caso facil: excluir o primeiro
		if (cabeca.getNumero() == numero) {
			cabeca = cabeca.getProximo();
			if (cabeca != null ) { // caso de nao ser o unico
				cabeca.setAnterior(null);
			}
		}
		// procura para excluir nó
		No ponteiro = cabeca;
		while ((ponteiro != null) && (ponteiro.getNumero() != numero)) {
			ponteiro.getProximo();
		}
		
		// nao achei
		if (ponteiro == null) {
			return;
		}
		
		// excluir no fim
		ponteiro.getAnterior().setProximo(ponteiro.getProximo());
		if (ponteiro.getProximo() != null) { // caso de não estar no fim (meio)
			ponteiro.getProximo().setAnterior(ponteiro.getAnterior());
		}
	}
	public void imprimir() {
		No ponteiro = cabeca;
		while (ponteiro != null) {
			System.out.println(ponteiro.getNumero());
			ponteiro = ponteiro.getProximo();
		}
	}
}
