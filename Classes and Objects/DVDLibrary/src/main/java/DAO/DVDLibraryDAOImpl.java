/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mdeha
 */
public class DVDLibraryDAOImpl implements DVDLibraryDAO{
    
    public static final String LIBRARY_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, DVD> dvds = new HashMap<>();
    
    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String movieName) {
        return dvds.get(movieName);
    }

    @Override
    public DVD addDVD(String movieName, DVD dvd) {
        DVD newDvds = dvds.put(movieName, dvd);
        return newDvds;
    }

    @Override
    public DVD removeDVD(String movieName) {
        DVD removedDVD = dvds.remove(movieName);
        return removedDVD;
    }

    @Override
    public DVD updateDVD(DVD movie, String oldName) {
        //Need to update the key, remove then re-add
        removeDVD(oldName);
        addDVD(movie.getTitle(), movie);
        
        return movie;
    }
    
    //WRITTING TO FILE
    //Title::ReleaseDate::Rating::Directors name::Studio::Note
    private DVD unmarshallDVD(String DVDAsText) {
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        String title = DVDTokens[0];
        DVD dvdFromFile = new DVD(title);
        dvdFromFile.setReleaseDate(DVDTokens[1]);
        dvdFromFile.setRating(Integer.parseInt(DVDTokens[2]));
        dvdFromFile.setDirectorName(DVDTokens[3]);
        dvdFromFile.setStudio(DVDTokens[4]);
        dvdFromFile.setNote(DVDTokens[5]);

        return dvdFromFile;
    }

    public void loadLibrary() throws DVDLibraryDAOException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDAOException("-_- Could not load library into memory.", e);
        }

        
        String currentLine;
        
        DVD currentDVD;
        
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDVD(DVD aDvd) {
        //Title::ReleaseDate::Rating::Directors name::Studio::Note
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getNote();

        return dvdAsText;
    }

    public void writeRoster() throws DVDLibraryDAOException, IOException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDAOException(
                    "Could not save data.", e);
        }

        String dvdAsText;
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD i : DVDList) {
            dvdAsText = marshallDVD(i);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
