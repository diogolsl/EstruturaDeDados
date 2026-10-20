import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Declaracao de Variaveis
        Scanner leitor = new Scanner(System.in);
        Arvore objArvore = new Arvore();
        int numero = 0;
        int tamanho = 10000000;

        // Construcao da arvore
        for (int i = 0; i < tamanho; i++) {
            objArvore.inserir((int) (tamanho * Math.random()));
        }

        // Realizacao de pesquisas
        do {
            System.out.println("Digite um numero: ");
            numero = leitor.nextInt();
            objArvore.procurar(numero);
        } while(numero != -99);
        leitor.close();

        // Impressao em ordem crescente
        objArvore.navegarEmOrdem();
    }
}
