package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DatabaseConnection;
import model.Orcamento;
import model.Usuario;

public class OrcamentoDAO {
    public List<Orcamento> getAllOrcamentos() {
        List<Orcamento> orcamentos = new ArrayList<>();
        String sql = "SELECT * FROM ORCAMENTOS";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setId(rs.getLong("ID_ORCAMENTO"));
                orcamento.setDescricao(rs.getString("DESCRICAO"));
                orcamento.setTipo(rs.getString("TIPO"));
                orcamento.setValor(rs.getBigDecimal("VALOR"));
                orcamento.setData(rs.getDate("DATA").toLocalDate());
                orcamento.setDataCriacao(rs.getTimestamp("DATA_CRIACAO").toLocalDateTime());

                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("ID_USUARIO"));
                orcamento.setUsuario(usuario);

                orcamentos.add(orcamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orcamentos;
    }

    public void saveOrcamento(Orcamento orcamento) {
        String sql = "INSERT INTO ORCAMENTOS (ID_USUARIO, DESCRICAO, TIPO, VALOR, DATA) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, orcamento.getUsuario().getId());
            pstmt.setString(2, orcamento.getDescricao());
            pstmt.setString(3, orcamento.getTipo());
            pstmt.setBigDecimal(4, orcamento.getValor());
            pstmt.setDate(5, Date.valueOf(orcamento.getData()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrcamento(Long id, Orcamento orcamento) {
        String sql = "UPDATE ORCAMENTOS SET DESCRICAO = ?, TIPO = ?, VALOR = ?, DATA = ? WHERE ID_ORCAMENTO = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, orcamento.getDescricao());
            pstmt.setString(2, orcamento.getTipo());
            pstmt.setBigDecimal(3, orcamento.getValor());
            pstmt.setDate(4, Date.valueOf(orcamento.getData()));
            pstmt.setLong(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrcamento(Long id) {
        String sql = "DELETE FROM ORCAMENTOS WHERE ID_ORCAMENTO = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
