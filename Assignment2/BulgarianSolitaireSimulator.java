// Name: yifeng wang
// USC NetID: yifengw
// CSCI455 PA2
// Fall 2018
import java.util.*;
import java.util.ArrayList;
/**
   <add main program comment here>

   command line arguments:
   if adding "-u" behind the java file(eg:java -ea BulgarianSolitaireSimulator -u), 
      it allow user to prompt for the initial configuration, instead of generating a random configuration.
   if adding "-s" behind the java file(eg:java -ea BulgarianSolitaireSimulator -s), 
      the program stops between every round of the game. The game only continues when the user hits enter (a.k.a., return).
   the user can also supply '-u' '-s' at the same time
      it will allow user to prompt for the initial configuration and the program stops between every round of the game
   if nothing added
      the program will generatw a random configuration and there will be no stop during this program's operation.

*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
      
      boolean singleStep = false;
      boolean userConfig = false;
      Scanner in = new Scanner(System.in);
      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      //nothing added, 
      //the program will generatw a random configuration and there will be no stop during this program's operation.
      if ((singleStep == false) && (userConfig == false) ) {
         SolitaireBoard randomInitialConfiguration = new SolitaireBoard();
         System.out.println("Initial configuration:" + randomInitialConfiguration.configString());
         while(!randomInitialConfiguration.isDone()){
            randomInitialConfiguration.playRound();
            randomInitialConfiguration.printOutput();
         }
         System.out.println("Done!");
      }
      
      //adding "-s" behind the java file(eg:java -ea BulgarianSolitaireSimulator -s), 
      //the program stops between every round of the game. The game only continues when the user hits enter (a.k.a., return).
      if ((singleStep == true) && (userConfig == false) ) {
         SolitaireBoard singleStepConfiguration = new SolitaireBoard();
         System.out.println("Initial configuration:" + singleStepConfiguration.configString());
         
         while(!singleStepConfiguration.isDone() ){
            System.out.printf("<Type return to continue>");
            in.nextLine();
            singleStepConfiguration.playRound();
            singleStepConfiguration.printOutput();
         }
         System.out.println("Done!");
      }

      //adding "-u" behind the java file(eg:java -ea BulgarianSolitaireSimulator -u), 
      //it allow user to prompt for the initial configuration, instead of generating a random configuration.
      out:if ((singleStep == false) && (userConfig == true) ) {
         
         System.out.println("Number of total cards is 45");
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline");
         
         ArrayList<Integer> userInput = new ArrayList<Integer>();
         
         String line = in.nextLine();
         
         Scanner lineScanner = new Scanner(line);
         while(lineScanner.hasNextInt()){
            int input = lineScanner.nextInt();
            userInput.add(input);
         }
            
            
         
         SolitaireBoard specifiedInitialConfiguration = new SolitaireBoard(userInput);
         
         if (specifiedInitialConfiguration.isValidInput() == false) {
            System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
            break out;
         }
         
         System.out.println("Initial configuration:" + specifiedInitialConfiguration.configString());
         while(!specifiedInitialConfiguration.isDone()){
            specifiedInitialConfiguration.playRound();
            specifiedInitialConfiguration.printOutput();
         }
         System.out.println("Done!");
      }

      //when user can also supply '-u' '-s' at the same time
      //it will allow user to prompt for the initial configuration and the program stops between every round of the game
      out:if ((singleStep == true) && (userConfig == true) ) {
         System.out.println("Number of total cards is 45");
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
         System.out.println("Please enter a space-separated list of positive integers followed by newline");
         
         ArrayList<Integer> userInput = new ArrayList<Integer>();

         String line = in.nextLine();
         
         Scanner lineScanner = new Scanner(line);
         while(lineScanner.hasNextInt()){
            int input = lineScanner.nextInt();
            userInput.add(input);
         }
         
         
         SolitaireBoard specifiedInitialConfiguration = new SolitaireBoard(userInput);
         if (specifiedInitialConfiguration.isValidInput() == false) {
            System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
            break out;
         }
         System.out.println("Initial configuration:" + specifiedInitialConfiguration.configString());
         while(!specifiedInitialConfiguration.isDone()){
            System.out.printf("<Type return to continue>");
            in.nextLine();

            specifiedInitialConfiguration.playRound();
            specifiedInitialConfiguration.printOutput();
         }
         System.out.println("Done!");
      }



   }
   
   // <add private static methods here>

  
}
