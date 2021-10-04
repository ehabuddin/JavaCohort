/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DVD;
import java.util.List;

/**
 *
 * @author mdeha
 */
public interface DVDLibraryDAO {
    DVD addDVD(String movieName, DVD dvd);
    DVD removeDVD(String movieName);
    DVD updateDVD(DVD movie, String oldName);
    List<DVD> getAllDVDs();
    DVD getDVD(String movieName);
    
    //void loadData();
    //void writeData();
}
