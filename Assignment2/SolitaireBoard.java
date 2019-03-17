// Name: yifeng wang
// USC NetID: yifengw
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.*;
/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   private static final int MIN_CARD_PER_PILE = 1;
   private static final int MAX_CARD_PER_PILE = CARD_TOTAL;
   private static final int MAX_PILE = CARD_TOTAL;
   private static final int MIN_PILE = 1;
   
   /**
      Representation invariant:

      <put rep. invar. comment here>
      the size of cardPile is not less than MIN_PILE and not greater than MAX_PILE
      the sizeOfCardPile is not less than MIN_PILE and not greater than MAX_PILE
      the sum of elements in cardPile is always euqal to CARD_TOTAL.
      all the elements in cardPile should be positive
   */
   
   // <add instance variables here>
  
   public int[] cardPile ;
   private Random generator = new Random();
   private int sizeOfCardPile;
   private int numOfPlayRound = 0;
   public String currentString;
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      cardPile = new int [MAX_PILE];
      sizeOfCardPile = 0;

      for (int i = 0; i < piles.size(); i++) {
         cardPile[i] = piles.get(i);
      }
      sizeOfCardPile = piles.size();
      assert isValidSolitaireBoard() == true;   // sample assert statement (you will be adding more of these calls)
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      cardPile = new int [MAX_PILE];
      sizeOfCardPile = 0;

      int currentCardTotal = 0;
      int pileId = 0;
      int currentCardLeft = CARD_TOTAL - currentCardTotal;
      
      while(currentCardLeft >= MIN_CARD_PER_PILE ){
         cardPile[pileId] = 1 + generator.nextInt(currentCardLeft);
         currentCardTotal = currentCardTotal + cardPile[pileId];
         currentCardLeft = CARD_TOTAL - currentCardTotal;
         pileId = pileId + 1;
         sizeOfCardPile = pileId;
      }
      assert isValidSolitaireBoard() == true;
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {
      int tempId = 0;
      int tempCard = sizeOfCardPile;
      for (int i = 0; i < sizeOfCardPile; i++) {
        cardPile[i] = cardPile[i] - 1;
      }
      sizeOfCardPile =sizeOfCardPile + 1;
      cardPile[sizeOfCardPile-1] = tempCard;
      for (int i = 0; i < tempCard; i++) {
         if (cardPile[i] == 0) {
            sizeOfCardPile = sizeOfCardPile - 1;
         }
      }
      for (int i = 0; i < tempCard+1; i++) {
         if (cardPile[i] > 0) {
            cardPile[tempId] = cardPile[i];
            tempId = tempId + 1;
         }
         else{
            
         }
      }
      assert isValidSolitaireBoard() == true;
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
   */
   
   public boolean isDone() {
      
      if (sizeOfCardPile == NUM_FINAL_PILES) 
      {  
         for (int i = 0; i < NUM_FINAL_PILES; i++) {
            for (int j = i+1; j < NUM_FINAL_PILES; j++) {
               if (cardPile[i] == cardPile[j]) {
                  return false;
               }
            }
         }
         assert isValidSolitaireBoard() == true;
         return true;
      }
      else{
         assert isValidSolitaireBoard() == true;
         return false;
      }
       // dummy code to get stub to compile

      
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
      
   public String configString() {
      currentString = cardPile[0] + " ";
      for (int i = 1; i < sizeOfCardPile-1 ; i++) {
          currentString = currentString + cardPile[i] + " ";
       } 
       currentString = currentString + cardPile[sizeOfCardPile-1];
      assert isValidSolitaireBoard() == true;
      return currentString;   // dummy code to get stub to compile
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      int tempSum = 0;
      for (int i = 0; i < sizeOfCardPile; i++) {
         if (cardPile[i] <= 0) {
            return false;
         }
         tempSum = tempSum + cardPile[i];
      }
      if ((sizeOfCardPile >= MIN_PILE) && (sizeOfCardPile <= MAX_PILE) && (tempSum == CARD_TOTAL)) {
         return true;
      }
      else{
         return false;  
      }
      // dummy code to get stub to compile

   }

   /**
      Returns true iff the solitaire board input data is in valid
   */
   public boolean isValidInput() {
      int tempSum = 0;
      for (int i = 0; i < sizeOfCardPile; i++) {
         if (cardPile[i] <= 0) {
            return false;
         }
         tempSum = tempSum + cardPile[i];
      }
      if ((sizeOfCardPile >= MIN_PILE) && (sizeOfCardPile <= MAX_PILE) && (tempSum == CARD_TOTAL)) {
         return true;
      }
      else{
         return false;  
      }
      // dummy code to get stub to compile

   }
   

   // <add any additional private methods here>
   //print the  current board configuration 
   public void printOutput(){
      int sumCurrentCard = 0;
      numOfPlayRound = numOfPlayRound + 1;
      System.out.printf("[" + numOfPlayRound + "]"  + "Current configuration: ");
      for (int i = 0; i < sizeOfCardPile; i++) {
         //System.out.printf("[" + (i+1) + "]");
         System.out.printf(cardPile[i] + " ");

         sumCurrentCard = sumCurrentCard + cardPile[i];
      }
      /*
      System.out.println();
      currentString = currentString + "123";
      System.out.println(currentString);
      */

      System.out.println();
      assert isValidSolitaireBoard() == true;
    //  System.out.println("sizeOfCardPile:   " + sizeOfCardPile);
    //  System.out.println("sumCurrentCard:   " + sumCurrentCard);
   }

}
