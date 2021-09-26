/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
public class House {
    private int houseNum;
    private String streetName;
    private String zipCode;
    private String country;
    private String province;
    
    private int numRooms;
    private int houseArea;
    
    public House(int hNum, String sName, String zip, String country, String province, int area, int rooms){
        this.houseNum = hNum;
        this.streetName = sName;
        this.zipCode = zip;
        this.country = country;
        this.province = province;
        this.numRooms = rooms;
        this.houseArea = area;
    }
    //Getter
    public String getAdress(){
        return Integer.toString(houseNum)+ " " +streetName + ", " +zipCode+ ", "+province + ", " + country;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public int getHouseArea() {
        return houseArea;
    }
    
    //Setters
    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public void setHouseArea(int houseArea) {
        this.houseArea = houseArea;
    }
    
}
