public class Diretor {
  // Propriedades da classe
  private int resto = 0;
  private No proximoNo = null; // aponta para linhas
  private Diretor proximoDiretor = null; // aponta para colunas

  // Métodos construtores da classe
  public Diretor() {}

  public Diretor(int resto, No proximoNo, Diretor proximoDiretor) {
    this.resto = resto;
    this.proximoNo = proximoNo;
    this.proximoDiretor = proximoDiretor;
  }

  // Métodos de acesso da classe
  public int getResto() {
    return resto;
  }

  public void setResto(int resto) {
    this.resto = resto;
  }

  public No getProximoNo() {
    return proximoNo;
  }

  public void setProximoNo(No proximoNo) {
    this.proximoNo = proximoNo;
  }

  public Diretor getProximoDiretor() {
    return proximoDiretor;
  }

  public void setProximoDiretor(Diretor proximoDiretor) {
    this.proximoDiretor = proximoDiretor;
  }
}
