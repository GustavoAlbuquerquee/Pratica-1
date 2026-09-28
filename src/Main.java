import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
static List<Mecanico> mecs = new ArrayList<>();
static List<Box> boxes = new ArrayList<>();
static List<OrdemDeServico> ordens = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
mecs.add(new Mecanico("Carlos", "111", "Motor", "9999-1"));
mecs.add(new Mecanico("Ana", "222", "Suspensão", "9999-2"));
mecs.add(new Mecanico("Marcos", "333", "Elétrica", "9999-3"));

boxes.add(new Box(1, "Motor", 2, "Galpão A"));
boxes.add(new Box(2, "Suspensão", 1, "Galpão A"));
boxes.add(new Box(3, "Elétrica", 2, "Galpão B"));

int op;
do {
System.out.println("\n--- MENU OFICINA ---");
System.out.println("1. Cadastrar OS | 2. Associar Mecânico/Box | 3. Atribuir OS ao Box");
System.out.println("4. Listar OS por Box | 5. Total Finalizadas por Box | 6. Buscar por Status | 7. Detalhes OS | 0. Sair");
System.out.print("Opção: ");
op = sc.nextInt(); sc.nextLine();

if (op == 1) {
System.out.print("Código: "); String cod = sc.nextLine();
System.out.print("Cliente: "); String cli = sc.nextLine();
System.out.print("Veículo/Placa: "); String mod = sc.nextLine(); String placa = sc.nextLine();
System.out.print("Serviço (Nome, Categoria(Motor/Suspensão/Elétrica), Tempo, Valor): ");
Servico s = new Servico(sc.next(), sc.nextDouble(), sc.nextDouble(), sc.next()); sc.nextLine();
ordens.add(new OrdemDeServico(cod, cli, mod, placa, "Hoje", 0, s));
System.out.println("OS cadastrada com status 'aberta'.");
}
else if (op == 2) {
System.out.print("Índice do mecânico (0-2): "); int m = sc.nextInt();
System.out.print("Índice do box (0-2): "); int b = sc.nextInt();
mecs.get(m).setBoxResponsavel(boxes.get(b));
boxes.get(b).setMecanico(mecs.get(m));
System.out.println("Associado com sucesso!");
}
else if (op == 3) {
System.out.print("Código da OS: "); String cod = sc.next();
System.out.print("Número do Box: "); int numB = sc.nextInt();
System.out.print("Novo Status (1-Em execução, 2-Finalizada): "); int st = sc.nextInt();

for (OrdemDeServico o : ordens) {
if (o.getCodigo().equals(cod)) {
for (Box bx : boxes) {
if (bx.getNumero() == numB && bx.getTipoServico().equalsIgnoreCase(o.getServico().getCategoria())) {
o.setBox(bx);
o.setStatus(st == 2 ? "finalizada" : "em execução");
System.out.println("Atualizado!");
                }
            }
        }
    }
}
else if (op == 4) {
System.out.print("Número do Box: "); int num = sc.nextInt();
int total = 0;
for (OrdemDeServico o : ordens) {
if (o.getBox() != null && o.getBox().getNumero() == num) {
System.out.println(o); total++;
        }
    }

System.out.println("Total de ordens: " + total);
}
else if (op == 5) {
for (Box b : boxes) {
long count = ordens.stream().filter(o -> o.getStatus().equals("finalizada") && o.getBox() != null && o.getBox().getNumero() == b.getNumero()).count();
System.out.println("Box " + b.getNumero() + " finalizadas: " + count);
}
}
else if (op == 6) {
System.out.print("Status desejado: "); String s = sc.next();
ordens.stream().filter(o -> o.getStatus().equalsIgnoreCase(s)).forEach(System.out::println);
}
else if (op == 7) {
System.out.print("Código da OS: "); String cod = sc.next();
ordens.stream().filter(o -> o.getCodigo().equals(cod)).forEach(o ->
System.out.println(o + " | Serviço: " + o.getServico() + " | Mecânico: " + (o.getBox() != null && o.getBox().getMecanico() != null ? o.getBox().getMecanico().getNome() : "Nenhum"))
);
}
} while (op != 0);
}
}
