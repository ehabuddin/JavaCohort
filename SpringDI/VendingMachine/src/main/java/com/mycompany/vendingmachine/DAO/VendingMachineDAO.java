/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.DAO;


import com.mycompany.vendingmachine.DTO.VendingMachineItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class VendingMachineDAO {
    /*DVD addDVD(String movieName, DVD dvd);
    DVD removeDVD(String movieName);
    DVD updateDVD(DVD movie, String oldName);
    List<DVD> getAllDVDs();
    DVD getDVD(String movieName);*/
    
    
    public static final String VENDING_FILE = "VendingMachine.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, VendingMachineItem> items = new HashMap<>();
    
    private VendingMachineItem unmarshallItem(String ItemAsText) {
        String[] ItemTokens = ItemAsText.split(DELIMITER);
        String itemName = ItemTokens[0];
        VendingMachineItem itemFromFile = new VendingMachineItem(itemName);
        itemFromFile.setItemCost(new BigDecimal(ItemTokens[1]).setScale(2, RoundingMode.HALF_UP));
        itemFromFile.setNumItems(Integer.parseInt(ItemTokens[2]));

        return itemFromFile;
    }

    public void loadVendingItems() throws VendingMachineDAOException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDING_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDAOException("-_- Could not load Items into Vending Machine.", e);
        }

        
        String currentLine;
        
        VendingMachineItem currentItem;
        
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentItem = unmarshallItem(currentLine);

            items.put(currentItem.getItemName(), currentItem);
        }
        // close scanner
        scanner.close();
    }
    public List<VendingMachineItem> getAllItems(){
        return new ArrayList<VendingMachineItem>(items.values());
    }
    
    public VendingMachineItem getItem(String itemName){
        return items.get(itemName);
    }
    
    public void removeItem(String itemName){
        //Remove 1 Quantity
        VendingMachineItem item = getItem(itemName);
        if(item.getNumItems() > 0){
            item.setNumItems(item.getNumItems() - 1);
        }
    }
    
    public void writeData() throws VendingMachineDAOException, IOException{
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
        } catch (IOException e) {
            throw new VendingMachineDAOException(
                    "Could not save data.", e);
        }
        String itemAsText;
        List<VendingMachineItem> itemList = this.getAllItems();
        for(VendingMachineItem i: itemList){
            itemAsText = marshallItem(i);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }
    private String marshallItem(VendingMachineItem aItem) {
        String itemAsText = aItem.getItemName()+ DELIMITER;
        itemAsText += aItem.getItemCost() + DELIMITER;
        itemAsText += aItem.getNumItems();
        return itemAsText;
    }
    
    public void addItem(String itemName, VendingMachineItem item){
        items.put(itemName, item);
    }
}
