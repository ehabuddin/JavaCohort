/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ServiceLayer;

/**
 *
 * @author mdeha
 */
public class IncorrectOrderDetailsException extends Exception{

    public IncorrectOrderDetailsException(String message) {
        super(message);
    }

    public IncorrectOrderDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
