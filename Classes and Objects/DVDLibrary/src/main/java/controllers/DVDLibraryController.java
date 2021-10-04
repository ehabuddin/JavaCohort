/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.DVDLibraryDAO;
import DAO.DVDLibraryDAOException;
import DAO.DVDLibraryDAOImpl;
import DTO.DVD;
import UI.DVDLibraryView;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class DVDLibraryController {
    
    DVDLibraryView view;
    DVDLibraryDAOImpl dao;
    
    public DVDLibraryController(DVDLibraryView view,DVDLibraryDAOImpl dao) throws DVDLibraryDAOException{
        this.view = view;
        this.dao = dao;
        //LOAD DATA FROM FILE
        dao.loadLibrary();
    }
    
    public void runApp() throws DVDLibraryDAOException, IOException{
               
        boolean keepGoing = true;
        
        while(keepGoing){
            //print Menu
            view.printMenu();
            int userSelection = view.getSelection();
            
            switch(userSelection){
                case 1:
                    //Add
                    view.printAddBanner();
                    DVD newDVD = view.addDVD();
                    dao.addDVD(newDVD.getTitle(), newDVD);
                    //PRINT SUCCESS MSG
                    view.printAdd();
                    view.endBanner();
                    break;
                case 2:
                    //Remove
                    String DVDName = view.getMovieName();
                    DVD removedDVD = dao.removeDVD(DVDName);
                    view.DVDRemove(removedDVD);
                    view.endBanner();
                    break;
                case 3:
                    //Update
                    String editMovieName = view.getMovieName();
                    DVD editMovie = dao.getDVD(editMovieName);
                    view.printEditSelection();
                    int selection = view.getSelectionEdit();
                    switch(selection){
                        case 1:
                            //Title
                            String temp = editMovie.getTitle();
                            DVD changeKey = view.editTitle(editMovie);
                            dao.updateDVD(changeKey, temp);
                            break;
                        case 2:
                            //Release Date
                            view.editReleaseDate(editMovie);
                            break;
                        case 3:
                            //Rating
                            view.editRating(editMovie);
                            break;
                        case 4:
                            view.editDirector(editMovie);
                            //Director
                            break;
                        case 5:
                            view.editStudio(editMovie);
                            //Studio
                            break;
                        case 6:
                            //User rating/note
                            view.editNote(editMovie);
                            break;
                    }
                    view.endBanner();
                    break;
                case 4:
                    //ListAll
                    view.printViewAllBanner();
                    List<DVD> myDVDs = dao.getAllDVDs();
                    view.printAllDvds(myDVDs);
                    view.endBanner();
                    break;
                case 5:
                    //print info
                    String movieName = view.getMovieName();
                    DVD dvdFound = dao.getDVD(movieName);
                    view.printSingleDVD(dvdFound);
                    view.endBanner();
                    break;
                case 6:
                    //Search for a DVD by title
                    String movie = view.getMovieName();
                    DVD movieDVD = dao.getDVD(movie);
                    view.DVDFound(movieDVD);
                    break;
                case 7:
                    //Exit
                    keepGoing = false;
                    //WRITE DATA TO FILE
                    dao.writeRoster();
                    
                    break;
            }
        }
    }
}
