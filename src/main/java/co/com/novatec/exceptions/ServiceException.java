/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.exceptions;

/**
 *
 * @author Yeison Camilo Rincon
 */
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String string) {
        super(string);
    }

    public ServiceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ServiceException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ServiceException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
