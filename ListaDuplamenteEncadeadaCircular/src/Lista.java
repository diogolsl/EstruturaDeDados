public class Lista {
	private No cabeca;
	
	// inserindo pela cabeca
	public void inserir(int numero) {
		// lista vazia
		if (cabeca == null) {
			No novo = new No(numero, null, null);
			novo.setProximo(novo);
			novo.setAnterior(novo);
			cabeca = novo;
			return;
		}
		
		// lista nao vazia e inserindo no final
		No ultimo = cabeca.getAnterior(); // estrutura circular: anterior da cabeca é a cauda
		No novo = new No(numero, cabeca, ultimo);
		
		// ajusta ponteiros dos nós que ja existiam
		ultimo.setProximo(novo);
		cabeca.setAnterior(novo);
	}
	
	public boolean excluir(int numero) {
        if (cabeca == null) {
            return false; // Lista vazia
        }

        No atual = cabeca;

        do {
            if (atual.getNumero() == numero) {
                // ÚNICO
                if (atual.getProximo() == atual) {
                    cabeca = null;
                    return true;
                }

                No anteriorNo = atual.getAnterior();
                No proximoNo = atual.getProximo();
                
                // reencaminha ponteiros dos vizinhos
                anteriorNo.setProximo(proximoNo);
                proximoNo.setAnterior(anteriorNo);

                //PRIMEIRO
                if (atual == cabeca) {
                    cabeca = proximoNo; // cabeça passa a ser o próximo nó
                }
                return true;
            }
            atual = atual.getProximo();
        } while (atual != cabeca);

        return false; // nao encontrei elemento
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
