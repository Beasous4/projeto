import dao.OrcamentoDAO;
import model.Orcamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TesteEditarOrcamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ID do orçamento que você deseja editar
        System.out.print("Digite o ID do orçamento que deseja editar: ");
        long idOrcamentoParaEditar = scanner.nextLong();

        // Criar um objeto Orcamento com os novos dados
        Orcamento novoOrcamento = new Orcamento();

        System.out.print("Digite a nova descrição do orçamento: ");
        novoOrcamento.setDescricao(scanner.next());

        System.out.print("Digite o novo tipo do orçamento (receita/entrada/saída): ");
        novoOrcamento.setTipo(scanner.next());

        System.out.print("Digite o novo valor do orçamento: ");
        novoOrcamento.setValor(scanner.nextBigDecimal());

         System.out.print("Digite a nova data do orçamento (dd/MM/yyyy): ");
        String dataInput = scanner.next();

        // Definir o formato esperado da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converter a entrada do usuário para o formato esperado
        LocalDate data = LocalDate.parse(dataInput, formatter);
        novoOrcamento.setData(data);
        
        // Criar uma instância do OrcamentoDAO
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

        // Chamar o método para atualizar o orçamento no banco de dados
        orcamentoDAO.updateOrcamento(idOrcamentoParaEditar, novoOrcamento);

        // Verificar se o orçamento foi atualizado com sucesso
        System.out.println("Orçamento atualizado com sucesso!");

        scanner.close();
    }
}
