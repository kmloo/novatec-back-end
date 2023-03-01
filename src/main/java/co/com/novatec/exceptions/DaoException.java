/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.exceptions;

/**
 *
 * @author Yeison Camilo Rincon
 */
public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String string) {
        super(string);
    }

    public DaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DaoException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DaoException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
    
}
