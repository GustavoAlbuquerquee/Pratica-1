class OrdemDeServico {
private String codigo, cliente, modelo, placa, data, status;
private double valorEstimado;
private Servico servico;
private Box box;

public OrdemDeServico(String codigo, String cliente, String modelo, String placa, String data, double valor, Servico servico) {
this.codigo = codigo; this.cliente = cliente; this.modelo = modelo; this.placa = placa;
this.data = data; this.valorEstimado = valor; this.servico = servico;
this.status = "aberta";
this.box = null;
}

public String getCodigo() { return codigo; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
public Servico getServico() { return servico; }
public Box getBox() { return box; }
public void setBox(Box box) { this.box = box; }

public String toString() {
return "OS: " + codigo + " | Cliente: " + cliente + " | Status: " + status +
" | Box: " + (box != null ? box.getNumero() : "Nenhum");
}
}