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
public class Caixa {

    int id;
    String nome;

    List<Banco> listaBanco;

    public Caixa(int id, String nome) {
        this.id = id;
        this.nome = nome;
        IniciaBancos();
        DebugUsers();
    }

    public void IniciaBancos() {
        List<Banco> listaBanco = new ArrayList<>();
        Banco bancoBrasil = new Banco(1, "Banco do Brasil", "Santa Maria, Rua 2");
        Banco bancoSantander = new Banco(2, "Banco Santander", "Santa Maria, Rua 3");
        Banco bancoInter = new Banco(3, "Banco Inter", "Santa Maria, Rua 4");
        Banco bancoNubank = new Banco(4, "Banco Nubanl", "Santa Maria, Rua 5");
        listaBanco.add(bancoBrasil);
        listaBanco.add(bancoSantander);
        listaBanco.add(bancoInter);
        listaBanco.add(bancoNubank);
        this.listaBanco = listaBanco;
    }

    public void AbrirConta(int idBanco, Cliente cliente) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                listaBanco.get(i).AbrirConta(cliente);
            }
        }
    }

    public boolean ValidaUsuarioSenha(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                if (listaBanco.get(i).ValidaUsuarioSenha(usuario, senha)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Deposito(int idBanco, String usuario, String senha, Double valor) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                listaBanco.get(i).Deposito(GetCliente(idBanco, usuario, senha), valor);
            }
        }
        return false;
    }

    private Cliente GetCliente(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).GetCliente(usuario, senha);
            }
        }
        return null;
    }

    public double VerificaSaldo(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).VerificaSaldo(GetCliente(idBanco, usuario, senha));
            }
        }
        return -1;
    }

    public boolean Saque(int idBanco, String usuario, String senha, Double valor) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).Saque(GetCliente(idBanco, usuario, senha), valor);
            }
        }
        return false;
    }

    public double ResgatarDinheiro(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).ResgatarDinheiro(GetCliente(idBanco, usuario, senha));
            }
        }
        return -1;
    }

    public boolean FazerEmprestimo(int idBanco, String usuario, String senha, Double valor) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).FazerEmprestimo(GetCliente(idBanco, usuario, senha), valor);
            }
        }
        return false;
    }

    public boolean PagarEmprestimo(int idBanco, String usuario, String senha, Double valor) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).PagarEmprestimo(GetCliente(idBanco, usuario, senha), valor);
            }
        }
        return false;
    }

    public double VerificarEmprestimo(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).VerificarEmprestimo(GetCliente(idBanco, usuario, senha));
            }
        }
        return -1;
    }

    public String EncerrarConta(int idBanco, String usuario, String senha) {
        for (int i = 0; i < listaBanco.size(); i++) {
            if (idBanco == listaBanco.get(i).getIdBanco()) {
                return listaBanco.get(i).EncerrarConta(GetCliente(idBanco, usuario, senha));
            }
        }
        return "Problema desconhecido";
    }

    public void DebugFunc() {
        for (int i = 0; i < listaBanco.size(); i++) {
            System.out.println("===Banco " + listaBanco.get(i).getNome() + "===");
            System.out.println(listaBanco.get(i).listaCliente.toString());
            System.out.println(listaBanco.get(i).listaConta.toString());
            System.out.println(listaBanco.get(i).listaEmprestimo.toString());
        }
    }

    public void DebugUsers() {
        for (int i = 0; i < listaBanco.size(); i++) {
            Cliente cliente = new Cliente(0, "adm", "rua dos adm", "55-999999999", "adm");
            AbrirConta(listaBanco.get(i).getIdBanco(), cliente);
        }
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", nome=" + nome + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Banco> getListaBanco() {
        return listaBanco;
    }

    public void setListaBanco(List<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }
}
