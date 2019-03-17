// Name:yifeng wang
// USC NetID:3926260250
// CS 455 PA1
// Fall 2018
import java.util.*;
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

  private int numOfTwoHeads;
  private int numOfTwoTails;
  private int numOfAheadAndAtail;
  private int numTrials;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {

      numOfTwoTails = 0;
      numOfTwoHeads = 0;
      numOfAheadAndAtail = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      this.numTrials = this.numTrials + numTrials;
      for (int i = 1;  i <= numTrials; i++ ) {
          //make two random numbers, 0 stands for tail, 1 stands for head
          Random generator = new Random();
          int firstToss = generator.nextInt(2);
          int secondToss = generator.nextInt(2);
          int result = firstToss + secondToss;

      if (result == 0) {
          numOfTwoTails = numOfTwoTails + 1;
      }
      if (result == 1) {
          numOfAheadAndAtail = numOfAheadAndAtail + 1;
      }
      if (result == 2) {
          numOfTwoHeads = numOfTwoHeads + 1;
      }


    }

   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
      return numTrials; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return numOfTwoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numOfTwoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return numOfAheadAndAtail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      numTrials = 0;
      numOfTwoTails = 0;
      numOfTwoHeads = 0;
      numOfAheadAndAtail = 0;
   }

}
