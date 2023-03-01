/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.novatec.constantes;

/**
 *
 * @author Yeison Camilo Rincon (camiloo45@gmail.com)
 */
public enum EnumCodificacion {

    CONTENT_TYPE_UTF_8("Content-Type"),
    CONTENT_TYPE_UTF_8_DESCRIBE("application/json;charset=UTF-8");

    private final String valor;

    private EnumCodificacion(final String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
