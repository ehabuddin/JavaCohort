
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
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());
        int bpm = 220-age;
        System.out.println("Your maximum heart rate should be "+ bpm +" beats per minute");
        int max = (int)(0.5 * bpm);
        int min = (int)(0.85 * bpm);
        System.out.println("Your target HR Zone is " + max +"-" +min+" beats per minute");
    }
}
