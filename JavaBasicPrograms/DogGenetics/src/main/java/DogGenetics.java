
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
public class DogGenetics {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //Prompt user
        System.out.println("What is your dog's name?: ");
        String name = myScanner.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on "+ name +"'s prestigious background right here.");
        
        System.out.println(name + " is: ");
        
        //Generate random Numbers
        
        Random rng = new Random();
        int max = 100;
        int one = rng.nextInt(100) + 1;
        int temp = max-one;
 
        int two = rng.nextInt(temp);
        temp -= two;

        int three = rng.nextInt(temp);
        temp -= three;

        int four = rng.nextInt(temp);
        temp -= four;
        
        int five = temp;
        
        System.out.println(one+"% St. Bernard");
        System.out.println(two+"% Chihuahua");
        System.out.println(three+"% Dramatic RedNosed Asian Pug");
        System.out.println(four+"% Common Cur");
        System.out.println(five+"% King Doberman");
        
    }
}
