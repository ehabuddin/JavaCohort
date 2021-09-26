/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
public class Calculator {
    public double add(double one, double two){
        return (one+two);
    }
//    public int add(int one, int two){
//        return one+two;
//    }
    
    public double sub(double one, double two){
        return (one-two);
    }
//    public int sub(int one, int two){
//        return one-two;
//    }
    
    public double multiply(double one, double two){
        return (one*two);
    }
//    public int multiply(int one, int two){
//        return one*two;
//    }
    
    public double divide(double one, double two){
        if(two == 0){
            return -1.0;
        }
        return (one/two);
    }
//    public int divide(int one, int two){
//        if(two == 0){
//            return -1;
//        }
//        return one/two;
//    }
}
