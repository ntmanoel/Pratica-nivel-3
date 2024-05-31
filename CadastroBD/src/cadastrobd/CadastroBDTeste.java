package cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;

public class CadastroBDTeste {
    public static void main(String[] args) {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        System.out.println("Pessoas Físicas:");
        for (PessoaFisica pessoaFisica : pessoaFisicaDAO.getPessoas()) {
            System.out.println("ID: " + pessoaFisica.getId());
            System.out.println("Nome: " + pessoaFisica.getNome());
            System.out.println("Logradouro: " + pessoaFisica.getLogradouro());
            System.out.println("Cidade: " + pessoaFisica.getCidade());
            System.out.println("Estado: " + pessoaFisica.getEstado());
            System.out.println("Telefone: " + pessoaFisica.getTelefone());
            System.out.println("Email: " + pessoaFisica.getEmail());
            System.out.println("CPF: " + pessoaFisica.getCpf());
        }

        System.out.println("\nPessoas Jurídicas:");
        for (PessoaJuridica pessoaJuridica : pessoaJuridicaDAO.getPessoas()) {
            System.out.println("ID: " + pessoaJuridica.getId());
            System.out.println("Nome: " + pessoaJuridica.getNome());
            System.out.println("Logradouro: " + pessoaJuridica.getLogradouro());
            System.out.println("Cidade: " + pessoaJuridica.getCidade());
            System.out.println("Estado: " + pessoaJuridica.getEstado());
            System.out.println("Telefone: " + pessoaJuridica.getTelefone());
            System.out.println("Email: " + pessoaJuridica.getEmail());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
        }
    }
}
