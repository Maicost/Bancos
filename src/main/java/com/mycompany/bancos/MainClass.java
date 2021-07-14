/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maico
 */
public class MainClass {

    Caixa caixa;

    public MainClass() {
        this.caixa = new Caixa(1, "Caixa 24hrs");
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Scanner lerTeclado = new Scanner(System.in);
        int opcaoMenu;
        Banco banco;

        boolean escolhaBanco = true, escolhaEntrada = true, entrada = true, escolhaMovimentacao = true;

        while (escolhaBanco) {
            ///////////////////////////
            //ESCOLHA DO BANCO E VALIDAÇÃO
            ///////////////////////////
            mainClass.MenuBancos();
            opcaoMenu = lerTeclado.nextInt();
            if (mainClass.ValidaBanco(opcaoMenu)) {
                if (opcaoMenu == 123) {
                    mainClass.caixa.DebugFunc();
                    opcaoMenu = 1;
                }
                ///////////////////////////
                //ESCOLHA DA FORMA DE ENTRADA E VALIDAÇÃO
                ///////////////////////////
                banco = mainClass.caixa.listaBanco.get(opcaoMenu - 1);
                while (escolhaEntrada) {
                    mainClass.MenuFormasEntrada(banco.nome);
                    opcaoMenu = lerTeclado.nextInt();
                    if (mainClass.ValidaFormasEntrada(opcaoMenu)) {
                        if (opcaoMenu == 0) {
                            break;
                        }
                        if (opcaoMenu == 1) {
                            int tentativas = 3;
                            entrada = true;
                            while (tentativas > 0 && entrada) {
                                System.out.println("Tentativas restantes: " + tentativas);
                                System.out.println("Insira seu usuario: ");
                                String usuario = lerTeclado.next();
                                System.out.println("Insira sua senha:");
                                String senha = lerTeclado.next();
                                if (mainClass.caixa.ValidaUsuarioSenha(banco.getIdBanco(), usuario, senha)) {
                                    System.out.println(banco.nome + ": Logado com sucesso");
                                    ///////////////////////////
                                    //PRECEDIMENTOS DE MOVIMENTAÇÃO BANCARIA
                                    ///////////////////////////
                                    while (escolhaMovimentacao) {
                                        double valor = 0.00;
                                        mainClass.MenuMovimentacaoBancaria();
                                        opcaoMenu = lerTeclado.nextInt();
                                        if (mainClass.ValidaMovimentacaoBancaria(opcaoMenu)) {
                                            if (opcaoMenu == 0) {
                                                entrada = false;
                                                break;
                                            }
                                            ///////////////////////////
                                            //DEPOSITO
                                            ///////////////////////////
                                            if (opcaoMenu == 1) {
                                                System.out.println("===" + banco.nome + "===");
                                                System.out.println("valor para deposito: ");
                                                valor = Double.parseDouble(lerTeclado.next());
                                                mainClass.caixa.Deposito(banco.getIdBanco(), usuario, senha, valor);
                                                System.out.println("Deposito realizado com sucesso");

                                            }
                                            ///////////////////////////
                                            //VERIFICA SALDO
                                            ///////////////////////////
                                            if (opcaoMenu == 2) {
                                                System.out.println("Saldo atual: " + mainClass.caixa.VerificaSaldo(banco.getIdBanco(), usuario, senha));
                                            }
                                            ///////////////////////////
                                            //SAQUE
                                            ///////////////////////////
                                            if (opcaoMenu == 3) {
                                                try {
                                                    System.out.println("===" + banco.nome + "===");
                                                    System.out.println("valor para saque: ");
                                                    valor = Double.parseDouble(lerTeclado.next());
                                                    if (mainClass.caixa.Saque(banco.getIdBanco(), usuario, senha, valor)) {
                                                        System.out.println("Valor sacado com sucesso");
                                                    } else {
                                                        System.out.println("Valor invalido");
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Formato errado");
                                                }
                                            }
                                            ///////////////////////////
                                            //RESGATAR DINHEIRO
                                            ///////////////////////////
                                            if (opcaoMenu == 4) {
                                                System.out.println("Valor resgatado: " + mainClass.caixa.ResgatarDinheiro(banco.getIdBanco(), usuario, senha));
                                            }
                                            ///////////////////////////
                                            //Emprestimo
                                            ///////////////////////////
                                            if (opcaoMenu == 5) {
                                                while (true) {
                                                    System.out.println(banco.getNome() + " Emprestimos");
                                                    mainClass.MenuEmprestimo();
                                                    opcaoMenu = lerTeclado.nextInt();
                                                    if (mainClass.ValidaEmprestimo(opcaoMenu)) {
                                                        if (opcaoMenu == 0) {
                                                            break;
                                                        }
                                                        ///////////////////////////
                                                        //FAZER
                                                        ///////////////////////////
                                                        if (opcaoMenu == 1) {
                                                            System.out.println("===" + banco.nome + "===");
                                                            System.out.println("valor para Emprestimo: ");
                                                            try {
                                                                valor = Double.parseDouble(lerTeclado.next());
                                                                mainClass.caixa.FazerEmprestimo(banco.getIdBanco(), usuario, senha, valor);
                                                                System.out.println("Emprestimo realizado com sucesso");
                                                            } catch (Exception e) {
                                                                System.out.println("Formato errado");
                                                            }
                                                        }
                                                        ///////////////////////////
                                                        //PAGAR
                                                        ///////////////////////////
                                                        if (opcaoMenu == 2) {
                                                            System.out.println("===" + banco.nome + "===");
                                                            System.out.println("valor para pagamento do Emprestimo: ");
                                                            try {
                                                                valor = Double.parseDouble(lerTeclado.next());
                                                                if (mainClass.caixa.PagarEmprestimo(banco.getIdBanco(), usuario, senha, valor)) {
                                                                    System.out.println("Realizado com sucesso");
                                                                } else {
                                                                    System.out.println("Necessário saldo para pagamento do emprestimo");
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Formato errado");
                                                            }
                                                        }
                                                        ///////////////////////////
                                                        //VERIFICAR EMPRESTIMO
                                                        ///////////////////////////
                                                        if (opcaoMenu == 3) {
                                                            System.out.println("" + mainClass.caixa.VerificarEmprestimo(banco.getIdBanco(), usuario, senha));
                                                        }
                                                    } else {
                                                        System.out.println("Opção invalida!");
                                                    }
                                                }
                                            }
                                            ///////////////////////////
                                            //ENCERRAR CONTA
                                            ///////////////////////////
                                            if (opcaoMenu == 6) {
                                                String msg = mainClass.caixa.EncerrarConta(banco.getIdBanco(), usuario, senha);
                                                if (msg.equals("true")) {
                                                    System.out.println("Conta Encerrada com sucesso!");
                                                    entrada = false;
                                                    break;
                                                }
                                                if (msg.equals("saldo")) {
                                                    System.out.println("Não foi possivel encerrar a conta pois existe saldo na conta");
                                                }
                                                if (msg.equals("emprestimo")) {
                                                    System.out.println("Não foi possivel encerrar a conta pois existe emprestimo ativo na conta");
                                                }
                                            }
                                        } else {
                                            System.out.println("Opção invalida");
                                        }
                                    }
                                } else {
                                    System.out.println("Usuario/Senha não encontrado");
                                    tentativas--;
                                }
                            }
                        }
                        if (opcaoMenu == 2) {
                            mainClass.caixa.AbrirConta(banco.idBanco, mainClass.FormCriarConta());
                            break;
                        }

                    } else {
                        System.out.println("Opção invalida!");
                    }
                }
            } else {
                System.out.println("Opção invalida!");
                mainClass.MenuBancos();
            }
        }
    }

    public void MenuBancos() {
        List<Banco> listaBancos = caixa.getListaBanco();
        System.out.println("===========================");
        System.out.println("ESCOLHA O SEU BANCO");
        System.out.println("===========================");
        if (!listaBancos.isEmpty()) {
            for (int i = 0; i < listaBancos.size(); i++) {
                System.out.println(1 + i + " : " + listaBancos.get(i).nome);
            }
        } else {
            System.out.println("Sistema está inoperante."
                    + "Tente novamente mais tarde");
        }
    }

    public boolean ValidaBanco(int opcaoMenu) {
        if (opcaoMenu <= caixa.getListaBanco().size() && opcaoMenu != 0 || opcaoMenu == 123) {
            return true;
        } else {
            System.out.println("Opção invalida!");
            return false;
        }
    }

    public void MenuFormasEntrada(String banco) {
        boolean valida = true;
        System.out.println("Bem Vindo ao " + banco);
        System.out.println("0: VOLTAR");
        System.out.println("1: ENTRAR");
        System.out.println("2: ABRIR CONTA");
    }

    public boolean ValidaFormasEntrada(int opcaoMenu) {
        if (opcaoMenu <= 2 && opcaoMenu >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cliente FormCriarConta() {
        Scanner lerTeclado = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = lerTeclado.nextLine();
        System.out.println("Endereco: ");
        String endereco = lerTeclado.nextLine();
        System.out.println("Telefone: ");
        String telefone = lerTeclado.nextLine();
        System.out.println("Senha");
        String noConta = lerTeclado.nextLine();

        Cliente cliente = new Cliente(0, nome, endereco, telefone, noConta);
        return cliente;
    }

    public void MenuMovimentacaoBancaria() {
        System.out.println("0: VOLTAR");
        System.out.println("1: DEPOSITO");
        System.out.println("2: VERIFICAR SALDO");
        System.out.println("3: SAQUE");
        System.out.println("4: RESGATAR DINHEIRO");
        System.out.println("5: EMPRESTIMO");
        System.out.println("6: ENCERRAR CONTA");
    }

    public boolean ValidaMovimentacaoBancaria(int opcaoMenu) {
        if (opcaoMenu >= 0 && opcaoMenu < 7) {
            return true;
        }
        return false;
    }

    public void MenuEmprestimo() {
        System.out.println("0: VOLTAR");
        System.out.println("1: FAZER EMPRESTIMO");
        System.out.println("2: PAGAR EMPRESTIMO");
        System.out.println("3: VERIFICAR EMPRESTIMO");
    }

    public boolean ValidaEmprestimo(int opcaoMenu) {
        if (opcaoMenu >= 0 && opcaoMenu < 4) {
            return true;
        }
        return false;
    }
}
