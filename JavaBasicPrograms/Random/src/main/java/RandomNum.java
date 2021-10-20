
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Generate random numbers 0-9(BOTH INCLUSIVE)
 * @author mdeha
 */
public class RandomNum {
    public static void main(String[] args) {
        Random rng = new Random();
        // generate 10 numbers, each between 0 and 9
        for (int i=0; i<= 10; i++) {
            int randomNumber = rng.nextInt(10);
            System.out.println(randomNumber);
        }
    }
}
