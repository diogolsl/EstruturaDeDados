public class Principal extends Thread {
	// propriedades da classe
	private Deque objDeque = new Deque();
	private boolean tipo = false;
	
	// metodo construtor da classe
	public Principal(Deque objDeque, boolean tipo) {
		this.objDeque = objDeque;
		this.tipo = tipo;
	}
	
	// metodo de execucao principal da classe
	public static void main(String[] args) {
		Deque objDeque = new Deque();

		new Principal(objDeque, false).start();
		new Principal(objDeque, true).start();
		
		while (Thread.activeCount() > 0) {
			
		}
	}
	
	// metodo de execucao paralela da classe
	public void run() {
		try {
			int numero = 0;
			while (true) {
				if (tipo) { // Produtor
					boolean normal = (((int) (2 * Math.random())) > 0);
					objDeque.entrar(normal ? numero : 1000 * numero, normal);
					numero++;
				} else { // Consumidor
					objDeque.atender();
				}
				sleep(1000);
			}
		} catch (Exception e) {}
	}
}
