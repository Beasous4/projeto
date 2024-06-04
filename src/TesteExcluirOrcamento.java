import dao.OrcamentoDAO;
import java.util.Scanner;

public class TesteExcluirOrcamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ID do orçamento que você deseja excluir
        System.out.print("Digite o ID do orçamento que deseja excluir: ");
        long idOrcamentoParaExcluir = scanner.nextLong();

        // Criar uma instância do OrcamentoDAO
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

        // Chamar o método para excluir o orçamento do banco de dados
        orcamentoDAO.deleteOrcamento(idOrcamentoParaExcluir);

        // Verificar se o orçamento foi excluído com sucesso
        System.out.println("Orçamento excluído com sucesso!");

        scanner.close();
    }
}
