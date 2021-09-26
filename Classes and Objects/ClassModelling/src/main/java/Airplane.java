/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
public class Airplane {
    private enum states {
        Waiting,
        Arriving,
        Departing
    }
    private String planeID;
    private states status;

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public states getStatus() {
        return status;
    }

    public void setStatus(int state) {
        switch(state){
            case 1:
                this.status = states.Waiting;
                break;
            case 2:
                this.status = states.Arriving;
                break;
            case 3: 
                this.status = states.Departing;
                break;
        }
        
    }
    
}
