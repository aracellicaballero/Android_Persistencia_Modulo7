package com.nextu.sacc.evaluacionfinal_modulo7;

import java.io.Serializable;

/**
 * Created by Sara Caballero C on 2017/11/21.
 */

public class VehiculoParqueo implements Serializable {

    private String placa;
    private String idCliente;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public VehiculoParqueo(String placa, String idCliente) {
        this.placa = placa;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Matrícula: " + placa + "\nID del cliente: " + idCliente + "\n";
    }
}
