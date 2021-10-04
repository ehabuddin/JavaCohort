/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author mdeha
 */
public class ClassRosterDAOException extends Exception{
    public ClassRosterDAOException(String message) {
        super(message);
    }
    
    public ClassRosterDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
