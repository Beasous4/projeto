import java.util.Scanner;
import dao.UsuarioDAO;

public class TesteApagarUsuario {
    public static void main(String[] args) {
        // Criar um scanner para entrada de dados do console
        Scanner scanner = new Scanner(System.in);

        // Solicitar que o usuário insira o ID do usuário a ser excluído
        System.out.print("Digite o ID do usuário que deseja excluir: ");
        long idUsuarioParaExcluir = scanner.nextLong();

        // Criar uma instância do UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Chamar o método para excluir o usuário do banco de dados
        usuarioDAO.deleteUsuario(idUsuarioParaExcluir);

        // Fechar o scanner
        scanner.close();

        // Verificar se o usuário foi excluído com sucesso
        System.out.println("Usuário excluído com sucesso!");
    }
}