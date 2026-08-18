public class No {
	private int numero = 0;
	private No anterior = null;
	private No proximo = null;
	
	public No() {
		super();
	}

	public No(int numero, No anterior, No proximo) {
		super();
		this.numero = numero;
		this.anterior = anterior;
		this.proximo = proximo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
