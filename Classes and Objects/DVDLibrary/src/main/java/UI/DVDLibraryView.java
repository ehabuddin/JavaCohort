/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.DVD;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class DVDLibraryView {
    UserIO io = new UserIOImpl();
    public void printMenu(){
        io.print("Menu: ");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Update a DVD");
        io.print("4. List all DVDs");
        io.print("5. Search info on a DVD");
        io.print("6. Search for DVD by Title");
        io.print("7. Exit");
    }
    
    public int getSelection(){
        return io.readInt("Please select of the options (1-7)", 1, 7);
    }
    public void endBanner(){
        io.print("------------------------");
    }
    //ADD DVD
    public void printAddBanner(){
        io.print("-----------ADD DVD-------------");
    }
    public DVD addDVD(){
        String name = io.readString("Enter the name of the movie: ");
        String releaseDate = io.readString("Enter the release date (YYYY/MM/DD): ");
        int rating = io.readInt("Enter a rating (1-5): ", 1, 5);
        String director = io.readString("Enter the name of the director: ");
        String studio = io.readString("Enter the name of the studio: ");
        String note = io.readString("Enter the your rating/note: ");
        
        DVD newDVD = new DVD(name);
        newDVD.setDirectorName(director);
        newDVD.setNote(note);
        newDVD.setRating(rating);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setStudio(studio);
        
        return newDVD;
    }
    public void printAdd(){
        io.print("DVD successfully added.");
    }
    //View ALL DVD
    public void printViewAllBanner(){
        io.print("-----------VIEW ALL DVDs-------------");
    }
    public void printAllDvds(List<DVD> myList){
        for(DVD i: myList){
            String DVDInfo = String.format("Title: %s -- Release Date: %s -- MPAA Rating: %d -- Directors Name: %s -- Studio: %s -- User Rating/Note: %s", 
                    i.getTitle(),
                    i.getReleaseDate(),
                    i.getRating(),
                    i.getDirectorName(),
                    i.getStudio(),
                    i.getNote()
                    );
            io.print(DVDInfo);
        }
    }
    //Find ONE DVD
    public String getMovieName(){
        return io.readString("Enter a name of the movie: ");
    }
    public void printSingleDVD(DVD dvdFound){
        if(dvdFound == null){
            io.print("Cannot find DVD with that title!");
            return;
        }
        String DVDInfo = String.format("Title: %s -- Release Date: %s -- MPAA Rating: %d -- Directors Name: %s -- Studio: %s -- User Rating/Note: %s", 
                                        dvdFound.getTitle(),
                                        dvdFound.getReleaseDate(),
                                        dvdFound.getRating(),
                                        dvdFound.getDirectorName(),
                                        dvdFound.getStudio(),
                                        dvdFound.getNote());
        io.print(DVDInfo);
    }
    public boolean DVDFound(DVD dvdFound){
        if(dvdFound == null){
            io.print("No such DVD in the library!");
            return false;
        }
        else{
            io.print(dvdFound.getTitle() + " exists within the libray.");
            return true;
        }
    }
    //Remove DVD
    public void DVDRemove(DVD dvdFound){
        if(dvdFound == null){
            io.print("No such DVD in the library!");
        }
        else{
            io.print(dvdFound.getTitle() + " successfully deleted.");
        }
    }
    
    //Edit Movie
    public void printEditSelection(){
        io.print("Properties to Edit: ");
        io.print("1. Movie Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director's Name");
        io.print("5. Studio");
        io.print("6. User rating/Note");
    }
    public int getSelectionEdit(){
        return io.readInt("Selection one of the above options (1-6)", 1, 6);
    }
    public DVD editTitle(DVD editDVD){
        String newName = io.readString("Enter the new name of the DVD");
        editDVD.setTitle(newName);
        io.print("Successfully Changed!");
        return editDVD;
    }
    public void editReleaseDate(DVD editDVD){
        String newDate = io.readString("Enter the new release date for the DVD (YYYY/MM/DD)");
        editDVD.setReleaseDate(newDate);
        io.print("Successfully Changed!");
    }
    public void editRating(DVD editDVD){
        int newRating = io.readInt("Enter a new rating for the DVD (1-5)", 1, 5);
        editDVD.setRating(newRating);
        io.print("Successfully Changed!");
    }
    public void editDirector(DVD editDVD){
        String newDirector = io.readString("Enter the new director for the DVD");
        editDVD.setDirectorName(newDirector);
        io.print("Successfully Changed!");
    }
    public void editStudio(DVD editDVD){
        String newStudio = io.readString("Enter the new studio for the DVD");
        editDVD.setStudio(newStudio);
        io.print("Successfully Changed!");
    }
    public void editNote(DVD editDVD){
        String newNote = io.readString("Enter the new user rating/note for the DVD");
        editDVD.setNote(newNote);
        io.print("Successfully Changed!");
    }
    public void printMsgNoDVD(){
        io.print("No Such DVD exists!");
    }
}
