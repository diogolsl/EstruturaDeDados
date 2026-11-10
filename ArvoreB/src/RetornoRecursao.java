public class RetornoRecursao {
    // propriedades da classe
    private int chaveDoMeio = 0;
    private No filhoDoMeio = null;

    public RetornoRecursao(int chaveDoMeio,  No filhoDoMeio) {
        this.chaveDoMeio = chaveDoMeio;
        this.filhoDoMeio = filhoDoMeio;
    }

    public RetornoRecursao() {
        super();
    }

    public int getChaveDoMeio() {
        return chaveDoMeio;
    }

    public void setChaveDoMeio(int chaveDoMeio) {
        this.chaveDoMeio = chaveDoMeio;
    }

    public No getFilhoDoMeio() {
        return filhoDoMeio;
    }

    public void setFilhoDoMeio(No filhoDoMeio) {
        this.filhoDoMeio = filhoDoMeio;
    }
}
