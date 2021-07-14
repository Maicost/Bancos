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
public class Conta {

    int idCliente, id;
    Double valor;

    public Conta() {
        this.valor = 0.00;
    }

    public void Deposito(Double valor) {
        Double valor2 = getValor();
        valor2 += valor;
        setValor(valor2);
    }

    public boolean Saque(Double valor) {
        Double valor2 = getValor();
        if (valor2 >= valor) {
            valor2 -= valor;
            setValor(valor2);
            return true;
        } else {
            return false;
        }
    }

    public Double ResgatarDinheiro() {
        Double valor2 = getValor();
        setValor(0.00);
        return valor2;
    }

    @Override
    public String toString() {
        return "Conta{" + "idCliente=" + idCliente + ", id=" + id + ", valor=" + valor + '}';
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.idCliente = IdCliente;
    }

    public int getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setId(int Id) {
        this.id = Id;
    }

}
