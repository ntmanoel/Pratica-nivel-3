package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super(); // Chama o construtor padrão da classe Pessoa
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, int telefone, String email, String cnpj) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }

    // Polimorfismo no método exibir
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da classe Pessoa
        System.out.println("CNPJ: " + cnpj);
    }

    // Getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
