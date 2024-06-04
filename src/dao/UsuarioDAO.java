package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseConnection;
import model.Usuario;

public class UsuarioDAO {
    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setDataCriacao(rs.getTimestamp("DATA_CRIACAO").toLocalDateTime());
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void saveUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS (NOME, SENHA, EMAIL) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsuario(Long id, Usuario usuario) {
        String sql = "UPDATE USUARIOS SET NOME = ?, SENHA = ?, EMAIL = ? WHERE ID_USUARIO = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setLong(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(Long id) {
        String sql = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
