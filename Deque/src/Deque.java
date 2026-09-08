public class Deque {
	// propriedades da classe
	private No filaNormal = null;
	private No filaPreferencial = null;
	private int contador = 0;
	
	// metodos da classe
	public void entrar(int numero, boolean normal) {
	    if (normal) {
	        filaNormal = new No(numero, filaNormal);
	      } else {
	        filaPreferencial = new No(numero, filaPreferencial);
	      }
	    }
	
	public void atender() {
		// ambas filas vazias
		if ((filaNormal == null) && (filaPreferencial == null)) {
			System.out.println("Va tomar um cafe !");
			contador = 0;
			return;
		}
		
		// fila normal tem gente e fila preferencial vazia
		if (filaPreferencial == null) {
			filaNormal = sair(filaNormal);
			contador = 0;
			return;
		}
		
		// fila normal vazia e fila preferencial tem gente
		if (filaNormal == null) {
			filaPreferencial = sair(filaPreferencial);
			contador = 0;
			return;
		}
		
		// ambas filas tem gente
		if (contador < 3) {
			filaPreferencial = sair(filaPreferencial);
			contador++;
		} else {
			filaNormal = sair(filaNormal);
			contador = 0;
		}
	}
	
	private No sair(No fila) {
		// fila vazia
		if (fila == null) {
			return null; 
		}
		
		// so tem um unico no na fila
		if (fila.getProximo() == null) {
			System.out.println(fila.getNumero());
			return null;
		}
		
		// tem mais de um no na fila
		No penultimo = fila;
		while (penultimo.getProximo().getProximo() != null) {
			penultimo = penultimo.getProximo();
		}
		System.out.println(penultimo.getProximo().getNumero());
		penultimo.setProximo(null);
		return fila;
	}
}
