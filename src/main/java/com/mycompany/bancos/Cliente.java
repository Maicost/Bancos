/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancos;

/**
 *
 * @author maico
 */
public class Cliente {

    Integer id;
    String nome, endereco, telefone, noConta;

    public Cliente(Integer id, String nome, String endereco, String telefone, String noConta) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.noConta = noConta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", noConta=" + noConta + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNoConta() {
        return noConta;
    }

    public void setNoConta(String noConta) {
        this.noConta = noConta;
    }

}
