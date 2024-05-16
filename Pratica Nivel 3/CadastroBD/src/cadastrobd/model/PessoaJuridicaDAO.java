package cadastrobd.model;

import cadastro.model.util.ConectorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    // Método para obter uma pessoa jurídica pelo ID
    public PessoaJuridica getPessoa(int id) {
        PessoaJuridica pessoa = null;
        String sql = "SELECT * FROM Pessoa INNER JOIN PessoaJuridica ON Pessoa.id = PessoaJuridica.id WHERE Pessoa.id = ?";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pessoa = new PessoaJuridica(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getInt("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("cnpj")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    // Método para obter todas as pessoas jurídicas
    public List<PessoaJuridica> getPessoas() {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa INNER JOIN PessoaJuridica ON Pessoa.id = PessoaJuridica.id";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PessoaJuridica pessoa = new PessoaJuridica(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getInt("telefone"),
                        resultSet.getString("email"),
                        resultSet.getString("cnpj")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    // Método para incluir uma nova pessoa jurídica
    public void incluir(PessoaJuridica pessoa) {
        String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (id, cnpj) VALUES (?, ?)";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statementPessoa = connection.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement statementPessoaJuridica = connection.prepareStatement(sqlPessoaJuridica)) {
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

            statementPessoaJuridica.setInt(1, id);
            statementPessoaJuridica.setString(2, pessoa.getCnpj());

            statementPessoaJuridica.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para exibir os dados da tabela Pessoa (para teste)
    public void exibirDadosTabelaPessoa() {
        String sql = "SELECT * FROM Pessoa";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Nome: " + resultSet.getString("nome") +
                        ", Logradouro: " + resultSet.getString("logradouro") +
                        ", Cidade: " + resultSet.getString("cidade") +
                        ", Estado: " + resultSet.getString("estado") +
                        ", Telefone: " + resultSet.getInt("telefone") +
                        ", Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
       String sqlPessoa = "DELETE FROM Pessoa WHERE id = ?";
    String sqlPessoaJuridica = "DELETE FROM PessoaJuridica WHERE id = ?";
    try (Connection connection = ConectorBD.getConnection();
         PreparedStatement statementPessoa = connection.prepareStatement(sqlPessoa);
         PreparedStatement statementPessoaJuridica = connection.prepareStatement(sqlPessoaJuridica)) {
        statementPessoa.setInt(1, id);
        statementPessoa.executeUpdate();
        statementPessoaJuridica.setInt(1, id);
        statementPessoaJuridica.executeUpdate();
        System.out.println("Pessoa jurídica com o ID " + id + " excluída com sucesso.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
