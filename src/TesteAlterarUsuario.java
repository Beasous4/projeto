import dao.UsuarioDAO;
import model.Usuario;
import java.util.Scanner;

public class TesteAlterarUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ID do usuário que você deseja alterar
        System.out.print("Digite o ID do usuário que deseja alterar: ");
        long idUsuarioParaAlterar = scanner.nextLong();

        // Solicitar as novas informações do usuário
        System.out.print("Digite o novo nome do usuário: ");
        String novoNome = scanner.next();
        System.out.print("Digite a nova senha do usuário: ");
        String novaSenha = scanner.next();
        System.out.print("Digite o novo email do usuário: ");
        String novoEmail = scanner.next();

        // Criar um objeto Usuario com as novas informações
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(novoNome);
        novoUsuario.setSenha(novaSenha);
        novoUsuario.setEmail(novoEmail);

        // Criar uma instância do UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Chamar o método para atualizar o usuário no banco de dados
        usuarioDAO.updateUsuario(idUsuarioParaAlterar, novoUsuario);

        // Verificar se o usuário foi atualizado com sucesso
        System.out.println("Usuário atualizado com sucesso!");
        
        scanner.close(); // fechar o scanner após a utilização
    }
}