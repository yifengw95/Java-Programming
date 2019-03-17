// Name: yifeng wang
// USC NetID: yifengw
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


/**
 * A dictionary of all anagram sets.
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
    //This anagramMap maps each unique word to its anagrams 
    Map<String, ArrayList<String>> anagramMap;

    /**
       Create an anagram dictionary from the file
       @param fileName  the name of the file to read from
       @throws FileNotFoundException  if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        anagramMap = new HashMap<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            String str = scanner.next();
            String word = str;

            word = ScrableWords.sortWord(word);
            if(anagramMap.containsKey(word)){
                anagramMap.get(word).add(str);
            }else{
                ArrayList<String> anagram = new ArrayList<>();
                anagram.add(str);
                anagramMap.put(word, anagram);
            }
        }
    }


}