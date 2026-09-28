class Mecanico {
private String nome, cpf, especialidade, telefone;
private Box boxResponsavel;

public Mecanico(String nome, String cpf, String especialidade, String telefone) {
this.nome = nome; this.cpf = cpf; this.especialidade = especialidade; this.telefone = telefone;
}

public String getNome() { return nome; }
public Box getBoxResponsavel() { return boxResponsavel; }
public void setBoxResponsavel(Box box) { this.boxResponsavel = box; }

public String toString() {
return nome + " (Esp: " + especialidade + ") - Box: " + (boxResponsavel != null ? boxResponsavel.getNumero() : "Nenhum");
}
}