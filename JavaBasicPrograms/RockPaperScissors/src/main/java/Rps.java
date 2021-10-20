
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
public class Rps {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean playAgain = true;
        //Prompt user
        while(playAgain){
           System.out.println("Enter the number of rounds you want to play: ");
           int rounds = Integer.parseInt(myScanner.nextLine());
           int counter = 0;
           //variables to calculate for user
           int wins = 0;
           int loss = 0;
           int draw = 0;

           while(counter < rounds){
               //Prompt user
               System.out.println("Enter an integer between 1-3  (1 = Rock, 2 = Paper, 3 = Scissors): ");
               int input = Integer.parseInt(myScanner.nextLine());

               //Generate Random Number (1-3 inclusive)
               Random rng = new Random();
               int random_num = rng.nextInt(3) + 1;

               //Evaluate a winner
               switch(input){
                   case 1:
                       //Rock
                       if(random_num == 1){
                           //ROCK
                           draw++;
                       }
                       else if(random_num == 2){
                           //Paper
                           loss++;
                       }
                       else{
                           //Scissors
                           wins++;
                       }
                       break;
                   case 2:
                       //Paper
                       if(random_num == 1){
                           //ROCK
                           wins++;
                       }
                       else if(random_num == 2){
                           //Paper
                           draw++;
                       }
                       else{
                           //Scissors
                           loss++;
                       }
                       break;
                   case 3:
                       //Scissors
                       if(random_num == 1){
                           //ROCK
                           loss++;
                       }
                       else if(random_num == 2){
                           //Paper
                           wins++;
                       }
                       else{
                           //Scissors
                           draw++;
                       }
                       break;
               }
               
               counter++;
           }
           //End of all rounds
           //Display results
           if(wins > loss){
               //User Won
               System.out.println("Congrats on the WIN, you won: "+wins+" rounds and the computer won: "+ loss+" rounds.");
           }
           else if (wins < loss){
               //Computer Won
               System.out.println("Tough Luck COMPTUER WINS, you won: "+wins+" rounds and the computer won: "+ loss+" rounds.");
           }
           else{
               //Tie
               System.out.println("GAME DRAWN, you won: "+wins+" rounds and the computer won: "+ loss+" rounds.");
           }
           //prompt user to play again
           System.out.println("Would you like to play again (1=Yes/2=No): ");
           int temp = Integer.parseInt(myScanner.nextLine());
           if(temp == 1){
               playAgain = true;
           }
           else{
               playAgain = false;
           }   
        }
        System.out.println("Thank you for Playing! GOODBYE! :)");
    }
}
