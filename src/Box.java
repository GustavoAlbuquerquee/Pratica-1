
public class Box {
private int numero, capacidade;
private String tipoServico, localizacao;
private Mecanico mecanico;

public Box(int numero, String tipoServico, int capacidade, String localizacao) {
this.numero = numero; this.tipoServico = tipoServico; this.capacidade = capacidade; this.localizacao = localizacao;
}

public int getNumero() { return numero; }
public String getTipoServico() { return tipoServico; }
public Mecanico getMecanico() { return mecanico; }
public void setMecanico(Mecanico m) { this.mecanico = m; }

public String toString() {
return "Box " + numero + " [" + tipoServico + "] - Mec: " + (mecanico != null ? mecanico.getNome() : "Nenhum");
}
}