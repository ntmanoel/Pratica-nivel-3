package cadastrobd.model;

import cadastro.model.util.ConectorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    public PessoaFisica getPessoa(int id) {
        PessoaFisica pessoa = null;
        String sql = "SELECT * FROM Pessoa INNER JOIN PessoaFisica ON Pessoa.id = PessoaFisica.id WHERE Pessoa.id = ?";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pessoa = new PessoaFisica(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getInt("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa INNER JOIN PessoaFisica ON Pessoa.id = PessoaFisica.id";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PessoaFisica pessoa = new PessoaFisica(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getInt("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("cpf")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void incluir(PessoaFisica pessoa) {
        String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPessoaFisica = "INSERT INTO PessoaFisica (id, cpf) VALUES (?, ?)";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statementPessoa = connection.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement statementPessoaFisica = connection.prepareStatement(sqlPessoaFisica)) {
            statementPessoa.setString(1, pessoa.getNome());
            statementPessoa.setString(2, pessoa.getLogradouro());
            statementPessoa.setString(3, pessoa.getCidade());
            statementPessoa.setString(4, pessoa.getEstado());
            statementPessoa.setInt(5, pessoa.getTelefone());
            statementPessoa.setString(6, pessoa.getEmail());

            statementPessoa.executeUpdate();

            ResultSet rs = statementPessoa.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            statementPessoaFisica.setInt(1, id);
            statementPessoaFisica.setString(2, pessoa.getCpf());

            statementPessoaFisica.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para exibir os dados da tabela Pessoa
    public void exibirDadosTabelaPessoa() {
        String sql = "SELECT * FROM Pessoa";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Logradouro: " + resultSet.getString("logradouro"));
                System.out.println("Cidade: " + resultSet.getString("cidade"));
                System.out.println("Estado: " + resultSet.getString("estado"));
                System.out.println("Telefone: " + resultSet.getInt("telefone"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlPessoa = "DELETE FROM Pessoa WHERE id = ?";
    String sqlPessoaFisica = "DELETE FROM PessoaFisica WHERE id = ?";
    try (Connection connection = ConectorBD.getConnection();
         PreparedStatement statementPessoa = connection.prepareStatement(sqlPessoa);
         PreparedStatement statementPessoaFisica = connection.prepareStatement(sqlPessoaFisica)) {
        statementPessoa.setInt(1, id);
        statementPessoa.executeUpdate();
        statementPessoaFisica.setInt(1, id);
        statementPessoaFisica.executeUpdate();
        System.out.println("Pessoa física com o ID " + id + " excluída com sucesso.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
