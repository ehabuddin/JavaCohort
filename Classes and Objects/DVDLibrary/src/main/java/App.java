
import DAO.DVDLibraryDAO;
import DAO.DVDLibraryDAOException;
import DAO.DVDLibraryDAOImpl;
import UI.DVDLibraryView;
import controllers.DVDLibraryController;
import java.io.IOException;

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
    public static void main(String[] args) throws DVDLibraryDAOException, IOException {
        DVDLibraryDAOImpl dao = new DVDLibraryDAOImpl();
        DVDLibraryView view = new DVDLibraryView();
        DVDLibraryController control =  new DVDLibraryController(view, dao);
        
        
        control.runApp();
    }
}
