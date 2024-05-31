package cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;

import java.util.List;
import java.util.Scanner;

public class CadastroBD {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        do {
            exibirMenu();
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    incluirOpcao();
                    break;
                case 2:
                    alterarOpcao();
                    break;
                case 3:
                    excluirOpcao();
                    break;
                case 4:
                    exibirPorIdOpcao();
                    break;
                case 5:
                    exibirTodosOpcao();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Incluir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Exibir por ID");
        System.out.println("5 - Exibir todos");
        System.out.println("0 - Sair");
        System.out.println("================\n");
    }
    
    private static void incluirOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        if (tipo == 1) {
            // Incluir Pessoa Física
            incluirPessoaFisica(scanner);
        } else if (tipo == 2) {
            // Incluir Pessoa Jurídica
            incluirPessoaJuridica(scanner);
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void incluirPessoaFisica(Scanner scanner) {
        // Implementar a lógica de inclusão de Pessoa Física
    }
    
    private static void incluirPessoaJuridica(Scanner scanner) {
        // Implementar a lógica de inclusão de Pessoa Jurídica
    }
    
    private static void alterarOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        if (tipo == 1) {
            // Alterar Pessoa Física
            alterarPessoaFisica(scanner);
        } else if (tipo == 2) {
            // Alterar Pessoa Jurídica
            alterarPessoaJuridica(scanner);
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void alterarPessoaFisica(Scanner scanner) {
        // Implementar a lógica de alteração de Pessoa Física
    }
    
    private static void alterarPessoaJuridica(Scanner scanner) {
        // Implementar a lógica de alteração de Pessoa Jurídica
    }
    
    private static void excluirOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        System.out.print("Informe o ID da pessoa: ");
        int id = scanner.nextInt();
        
        if (tipo == 1) {
            // Excluir Pessoa Física
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            pessoaFisicaDAO.excluir(id);
        } else if (tipo == 2) {
            // Excluir Pessoa Jurídica
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            pessoaJuridicaDAO.excluir(id);
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private static void exibirPorIdOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        System.out.print("Informe o ID da pessoa: ");
        int id = scanner.nextInt();
        
        switch (tipo) {
            case 1:
                {
                    // Exibir Pessoa Física por ID
                    PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
                    PessoaFisica pessoa = pessoaFisicaDAO.getPessoa(id);
                    if (pessoa != null) {
                        pessoa.exibir();
                    } else {
                        System.out.println("Pessoa física com o ID " + id + " não encontrada.");
                    }       break;
                }
            case 2:
                {
                    // Exibir Pessoa Jurídica por ID
                    PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
                    PessoaJuridica pessoa = pessoaJuridicaDAO.getPessoa(id);
                    if (pessoa != null) {
                        pessoa.exibir();
                    } else {
                        System.out.println("Pessoa jurídica com o ID " + id + " não encontrada.");
                    }       break;
                }
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
    
    private static void exibirTodosOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o tipo de pessoa:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        
        if (tipo == 1) {
            // Exibir todas as Pessoas Físicas
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
            for (PessoaFisica pessoa : pessoasFisicas) {
                pessoa.exibir();
            }
        } else if (tipo == 2) {
            // Exibir todas as Pessoas Jurídicas
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
            for (PessoaJuridica pessoa : pessoasJuridicas) {
                pessoa.exibir();
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
