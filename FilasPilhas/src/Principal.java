public class Principal {
	public static void main(String[] args) {
		Fila objFila = new Fila();
		Pilha objPilha = new Pilha();
		
		for (int i = 0; i < 50000; i++) {
			objFila.entrar(i);
		}
		
		for (int i = 0; i < 50000; i++) {
			objFila.sair();
		}
		
		
	    for (int i = 0; i < 1000000; i++) {
	    	objPilha.push(i);
	    }
	    for (int i = 0; i < 1000000; i++) {
	    	objPilha.pop(i);
	    }
	}
}
