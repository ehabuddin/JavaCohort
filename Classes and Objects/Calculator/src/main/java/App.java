
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
public class App {
    public static void main(String[] args) {
        boolean playAgain = true;
        while(playAgain){
            System.out.println("Welcome to my Calculator!");
            System.out.println("Select one of the options: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("------------------");

            //Lets create an intance of the calculator
            Calculator c = new Calculator();

            Scanner myScanner = new Scanner(System.in);
            int option = Integer.parseInt(myScanner.nextLine());
            double num1;
            double num2;
            double result;

            switch(option){
                case 1:
                    System.out.println("Enter the First number: ");
                    num1 = Double.parseDouble(myScanner.nextLine());
                    System.out.println("Enter the Second number: ");
                    num2 = Double.parseDouble(myScanner.nextLine());
                    result = c.add(num1, num2);

                    System.out.println("Result of " + num1 + " + " + num2 + " = " + result);                
                    break;
                case 2:
                    System.out.println("Enter the First number: ");
                    num1 = Double.parseDouble(myScanner.nextLine());
                    System.out.println("Enter the Second number: ");
                    num2 = Double.parseDouble(myScanner.nextLine());
                    result = c.sub(num1, num2);

                    System.out.println("Result of " + num1 + " - " + num2 + " = " + result);
                    break;
                case 3:
                    System.out.println("Enter the First number: ");
                    num1 = Double.parseDouble(myScanner.nextLine());
                    System.out.println("Enter the Second number: ");
                    num2 = Double.parseDouble(myScanner.nextLine());
                    result = c.multiply(num1, num2);

                    System.out.println("Result of " + num1 + " * " + num2 + " = " + result);
                    break;
                case 4:
                    System.out.println("Enter the First number: ");
                    num1 = Double.parseDouble(myScanner.nextLine());
                    System.out.println("Enter the Second number: ");
                    num2 = Double.parseDouble(myScanner.nextLine());
                    result = c.divide(num1, num2);

                    System.out.println("Result of " + num1 + " / " + num2 + " = " + result);
                    break;
                default:
                    System.out.println("Incorrect Option!");
                    break;
            }
            System.out.println("Would you like to keep calculating? Y(1)/N(2)");
            int choice = Integer.parseInt(myScanner.nextLine());
            if(choice  == 1){
                playAgain = true;
            }
            else{
                System.out.println("Thank you for using!");
                playAgain = false;
            }
        }
    }
}
