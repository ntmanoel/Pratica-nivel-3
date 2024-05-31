package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    // Construtor padrão
    public PessoaFisica(String maria, String rua_A, String cidade_A, String estado_A, int par, String mariaexamplecom, String string) {
        super();
    }

    // Construtor completo
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, int telefone, String email, String cpf) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    // Polimorfismo no método exibir
    @Override
    public void exibir() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Logradouro: " + getLogradouro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + cpf);
    }

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos restantes
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getLogradouro() {
        return super.getLogradouro();
    }

    @Override
    public String getCidade() {
        return super.getCidade();
    }

    @Override
    public String getEstado() {
        return super.getEstado();
    }

    @Override
    public int getTelefone() {
        return super.getTelefone();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }
}

    