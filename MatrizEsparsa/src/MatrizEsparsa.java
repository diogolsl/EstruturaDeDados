public class MatrizEsparsa {
	// Propriedades da classe
	private Diretor cabeca = null;
	private int modulo = 0;
	
	// Metodo construtor da classe
	public MatrizEsparsa(int modulo) {
		this.modulo = modulo;
	}
	
	// Metodos da classe
	private Diretor procurarDiretor(int numero) { // se n encontrar, cria
		int resto = (numero % modulo);
		
		// procurar o diretor correto
		Diretor ponteiro = cabeca;
		while ((ponteiro != null) && (ponteiro.getResto() != resto)) {
			ponteiro = ponteiro.getProximoDiretor();
		}
		
		// diretor encontrado
		if (ponteiro != null) {
			return ponteiro;
		}
		
		// diretor NAO encontrado
		cabeca = new Diretor(resto, null, cabeca);
		return cabeca;
	}
	
	public void inserir(int numero) {
		Diretor ponteiro = procurarDiretor(numero);
		ponteiro.setProximoNo(new No(numero, ponteiro.getProximoNo()));
	}
	
	public void excluir(int numero) {
		Diretor ponteiro = procurarDiretor(numero);
		// lista horizontal vazia
		if (ponteiro.getProximoNo() == null) {
			return;
		}
		
		// excluir o primeiro
		if (ponteiro.getProximoNo().getNumero() == numero) {
			ponteiro.setProximoNo(ponteiro.getProximoNo().getProximoNo());
			return;
		}
		
		// excluir no meio ou fim, parar no anterior
		No ponteiroNo = ponteiro.getProximoNo();
		while ((ponteiroNo.getProximoNo().getProximoNo() != null) && 
				(ponteiroNo.getProximoNo().getNumero() != numero)) {
			ponteiroNo = ponteiroNo.getProximoNo();
		}
		
		// nao achei
		if (ponteiroNo.getProximoNo() == null) {
			return;
		}
		// achei
		ponteiroNo.setProximoNo(ponteiroNo.getProximoNo().getProximoNo());
	}
	
	public void imprimir() {
		Diretor ponteiro = cabeca;
		
		System.out.println("Resto \t Números");
		while (ponteiro != null) {
			System.out.print(ponteiro.getResto() + " \t ");
			No ponteiroNo = ponteiro.getProximoNo();
			while (ponteiroNo != null) {
				System.out.print(ponteiroNo.getNumero() + ", ");
				ponteiroNo = ponteiroNo.getProximoNo();
			}
			System.out.println();
			ponteiro = ponteiro.getProximoDiretor();
		}
	}
}
