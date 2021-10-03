
import Controllers.ClassRosterController;
import DAO.ClassRosterDAO;
import DAO.ClassRosterDAOFileImpl;
import UI.ClassRosterView;
import UI.UserIO;
import UI.UserIOImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDAO dao = new ClassRosterDAOFileImpl();
        
        
        ClassRosterController cont = new ClassRosterController(dao,view);
        
        cont.run();
    }
}
