import java.util.Scanner;
import dao.UsuarioDAO;
import model.Usuario;

public class TesteAdicionarUsuario {
    public static void main(String[] args) {
        // Criar um scanner para entrada de dados do console
        Scanner scanner = new Scanner(System.in);

        // Solicitar que o usuário insira os dados do novo usuário
        System.out.println("Digite os dados do novo usuário:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Criar um objeto Usuario com os dados fornecidos pelo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setSenha(senha);
        novoUsuario.setEmail(email);

        // Criar uma instância do UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Chamar o método para salvar o usuário no banco de dados
        usuarioDAO.saveUsuario(novoUsuario);

        // Fechar o scanner
        scanner.close();

        // Verificar se o usuário foi adicionado com sucesso
        System.out.println("Usuário adicionado com sucesso!");
    }
}