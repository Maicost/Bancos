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
public class Emprestimo {

    private int idCliente, id, idConta;
    private String tipo;
    private Double valor;

    public Emprestimo() {
        this.valor = 0.00;
    }

    public void FazerEmprestimo(Double valor) {
        Double valor2 = getValor();
        valor2 = valor;
        setValor(valor2);
    }

    public boolean PagarEmprestimo(Double valor) {
        Double valor2 = getValor();
        if (valor2 > 0) {
            valor2 -= valor;
            if (valor2 >= 0) {
                setValor(valor2);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "idCliente=" + idCliente + ", id=" + id + ", idConta=" + idConta + ", tipo=" + tipo + ", valor=" + valor + '}';
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
