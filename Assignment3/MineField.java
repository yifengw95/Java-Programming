// Name:yifeng wang
// USC NetID:yifengw
// CS 455 PA3
// Fall 2018


/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */

import java.util.Random;      
public class MineField {
   
   // <put instance variables here>
   private boolean[][] initialMineField;
   private int numOfRows;
   private int numOfCols;
   private int numOfMines;
   private int numOfRowsTimesCols;
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
      this.numOfRows = mineData.length;
      this.numOfCols = mineData[0].length;
      this.numOfRowsTimesCols = numOfCols * numOfRows;
      initialMineField = new boolean[this.numOfRows][this.numOfCols];
      for (int i = 0; i < initialMineField.length; i++) {
        for (int j = 0; j < initialMineField[0].length; j++) {
          initialMineField[i][j] = mineData[i][j];
        }
      }
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      initialMineField = new boolean[numRows][numCols];
      this.numOfRows = numRows;
      this.numOfCols = numCols;
      this.numOfMines = numMines;
      this.numOfRowsTimesCols = numCols * numRows;
      for (int i = 0; i < initialMineField.length; i++) {
        for (int j = 0; j < initialMineField[0].length; j++) {
          initialMineField[i][j] = false;
        }
      }
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
      
      boolean flag = false;
      Random generator = new Random();
      int rowOfNewMine = 0;
      int colOfNewMine = 0;
      int count = 0;
      while (count < numOfMines) {
        rowOfNewMine = generator.nextInt(numOfRows) ;
        colOfNewMine = generator.nextInt(numOfCols) ;
        if ((rowOfNewMine == row) && (colOfNewMine == col)) {
          continue;
        }
        else{
          if (initialMineField[rowOfNewMine][colOfNewMine] == true) {
            continue;
          }
          else{
            initialMineField[rowOfNewMine][colOfNewMine] = true;
            count = count + 1;
          }
        }



      }
        
      
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
      for (int i = 0; i < initialMineField.length; i++) {
        for (int j = 0; j < initialMineField[0].length; j++) {
          initialMineField[i][j] = false;
        }
      }
      this.numOfMines = numMines();
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      int count = 0;
      if (inRange((row-1), (col-1)) && (initialMineField[row-1][col-1] == true)) {
        count = count + 1;
      }
      if (inRange((row-1), (col)) && (initialMineField[row-1][col] == true)) {
        count = count + 1;
      }
      if (inRange((row-1), (col+1)) && (initialMineField[row-1][col+1] == true)) {
        count = count + 1;
      }
      if (inRange((row), (col-1)) && (initialMineField[row][col-1] == true)) {
        count = count + 1;
      }
      if (inRange((row), (col+1)) && (initialMineField[row][col+1] == true)) {
        count = count + 1;
      }
      if (inRange((row+1), (col-1)) && (initialMineField[row+1][col-1] == true)) {
        count = count + 1;
      }
      if (inRange((row+1), (col)) && (initialMineField[row+1][col] == true)) {
        count = count + 1;
      }
      if (inRange((row+1), (col+1)) && (initialMineField[row+1][col+1] == true)) {
        count = count + 1;
      }
      return count;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      if ((row >= 0) && (row < numOfRows) && (col >= 0) && (col < numOfCols)) {
        return true;
      }
      else{
        return false;
      }
             // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return this.numOfRows;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */    
   public int numCols() {
      return this.numOfCols;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      if (initialMineField[row][col] == true) {
        return true;
      }
      else{
        return false;
      }
             // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      int temp = 0;
      for (int i = 0; i < initialMineField.length; i++) {
        for (int j = 0; j < initialMineField[0].length; j++) {
          if (initialMineField[i][j] == true) {
            temp = temp + 1;
          }
        }
      }
      return temp;       // DUMMY CODE so skeleton compiles
   }

   
   // <put private methods here>
   
         
}

