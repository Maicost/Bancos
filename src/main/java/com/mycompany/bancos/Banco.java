/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maico
 */
public class Banco {

    Integer idBanco;
    String nome, endereco;

    List<Cliente> listaCliente;
    List<Conta> listaConta;
    List<Emprestimo> listaEmprestimo;

    public Banco(Integer idBanco, String nome, String endereco) {
        this.idBanco = idBanco;
        this.nome = nome;
        this.endereco = endereco;
        this.listaCliente = new ArrayList<>();
        this.listaConta = new ArrayList<>();
        this.listaEmprestimo = new ArrayList<>();
    }

    public Banco() {
    }

    public void AbrirConta(Cliente clinte) {

        Conta conta = new Conta();
        Emprestimo emprestimo = new Emprestimo();
        int i;
        //ADICIONA USUARIO
        if (!listaCliente.isEmpty()) {
            i = listaCliente.get(listaCliente.size() - 1).getId();
            clinte.setId(i + 1);
            this.listaCliente.add(clinte);
        } else {
            clinte.setId(1000);
            this.listaCliente.add(clinte);
        }
        //ADICIONA CONTA
        conta.setIdCliente(clinte.getId());
        if (!listaConta.isEmpty()) {
            i = listaConta.get(listaConta.size() - 1).getId();
            conta.setId(i + 1);
            this.listaConta.add(conta);
        } else {
            conta.setId(1000);
            this.listaConta.add(conta);
        }
        //ADICIONA EMPRESTIMO
        emprestimo.setIdCliente(clinte.getId());
        emprestimo.setIdConta(conta.getId());
        if (!listaEmprestimo.isEmpty()) {
            i = listaEmprestimo.get(listaEmprestimo.size() - 1).getId();
            emprestimo.setId(i + 1);
            this.listaEmprestimo.add(emprestimo);
        } else {
            emprestimo.setId(1000);
            this.listaEmprestimo.add(emprestimo);
        }
    }

    public boolean ValidaUsuarioSenha(String usuario, String senha) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).nome.equals(usuario) && listaCliente.get(i).noConta.equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Cliente GetCliente(String usuario, String senha) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).nome.equals(usuario) && listaCliente.get(i).noConta.equals(senha)) {
                return listaCliente.get(i);
            }
        }
        return null;
    }

    public boolean Deposito(Cliente cliente, Double valor) {
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                listaConta.get(i).Deposito(valor);
                return true;
            }
        }
        return false;
    }

    public double VerificaSaldo(Cliente cliente) {
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                return listaConta.get(i).getValor();
            }
        }
        return -1;
    }

    public boolean Saque(Cliente cliente, Double valor) {
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                return listaConta.get(i).Saque(valor);
            }
        }
        return false;
    }

    public double ResgatarDinheiro(Cliente cliente) {
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                return listaConta.get(i).ResgatarDinheiro();
            }
        }
        return -1;
    }

    public boolean FazerEmprestimo(Cliente cliente, Double valor) {
        for (int i = 0; i < listaEmprestimo.size(); i++) {
            if (listaEmprestimo.get(i).getIdCliente() == cliente.getId()) {
                listaEmprestimo.get(i).FazerEmprestimo(valor);
                return true;
            }
        }
        return false;
    }

    public boolean PagarEmprestimo(Cliente cliente, Double valor) {
        //VERIFICA SE EXISTE SALDO SUFICIENTE PARA PAGAMENTO DO EMPRESTIMO
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                if (listaConta.get(i).getValor() < valor) {
                    return false;
                }
            }
        }
        for (int i = 0; i < listaEmprestimo.size(); i++) {
            if (listaEmprestimo.get(i).getIdCliente() == cliente.getId()) {
                return listaEmprestimo.get(i).PagarEmprestimo(valor);
            }
        }
        return false;
    }

    public double VerificarEmprestimo(Cliente cliente) {
        for (int i = 0; i < listaEmprestimo.size(); i++) {
            if (listaEmprestimo.get(i).getIdCliente() == cliente.getId()) {
                return listaEmprestimo.get(i).getValor();
            }
        }
        return -1;
    }

    public String EncerrarConta(Cliente cliente) {
        if (VerificaSaldo(cliente) != 0) {
            return "saldo";
        }
        if (VerificarEmprestimo(cliente) != 0) {
            return "emprestimo";
        }
        for (int i = 0; i < listaEmprestimo.size(); i++) {
            if (listaEmprestimo.get(i).getIdCliente() == cliente.getId()) {
                listaEmprestimo.remove(i);
            }
        }
        for (int i = 0; i < listaConta.size(); i++) {
            if (listaConta.get(i).getIdCliente() == cliente.getId()) {
                listaConta.remove(i);
            }
        }
        return "true";
    }

    @Override
    public String toString() {
        return "Banco{" + "idBanco=" + idBanco + ", nome=" + nome + ", endereco=" + endereco + '}';
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
