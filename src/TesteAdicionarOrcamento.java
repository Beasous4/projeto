import dao.OrcamentoDAO;
import model.Orcamento;
import model.Usuario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TesteAdicionarOrcamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um objeto Orcamento com os dados a serem inseridos
        Orcamento novoOrcamento = new Orcamento();

        // Solicitar as informações do orçamento ao usuário
        System.out.print("Digite o ID do usuário associado ao orçamento: ");
        long idUsuario = scanner.nextLong();

        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        novoOrcamento.setUsuario(usuario);

        System.out.print("Digite a descrição do orçamento: ");
        novoOrcamento.setDescricao(scanner.next());

        System.out.print("Digite o tipo do orçamento (receita/entrada/saída): ");
        novoOrcamento.setTipo(scanner.next());

        System.out.print("Digite o valor do orçamento: ");
        novoOrcamento.setValor(scanner.nextBigDecimal());

        System.out.print("Digite a data do orçamento (dd/MM/yyyy): ");
        String dataInput = scanner.next();

        // Definir o formato esperado da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Converter a entrada do usuário para o formato esperado
        LocalDate data = LocalDate.parse(dataInput, formatter);
        novoOrcamento.setData(data);

        // Criar uma instância do OrcamentoDAO
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

        // Chamar o método para salvar o orçamento no banco de dados
        orcamentoDAO.saveOrcamento(novoOrcamento);

        // Verificar se o orçamento foi adicionado com sucesso
        System.out.println("Orçamento adicionado com sucesso!");

        scanner.close();
    }
}
