// Name: yifeng wang
// USC NetID: yifengw
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class WordFinder {
    public static void main(String[] args) {
    AnagramDictionary anagramDictionary;
    String inputFile;
        try{
            System.out.println("Type . to quit.");
            if (args.length > 0) {
                inputFile = args[0];
                anagramDictionary = new AnagramDictionary(inputFile);
            } else{
                anagramDictionary = new AnagramDictionary("sowpods.txt");
            }

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            while(true) {

                System.out.print("Rack? ");
                if(input.equals(".")){
                    return;
                }

                int[] multi = ScrableWords.multi(input);
                String sortedAnagram = ScrableWords.sortWord(input);
                String unique = sortedAnagram.charAt(0)+"";
                for(int i = 1; i < sortedAnagram.length(); i++){
                    if(sortedAnagram.charAt(i) != sortedAnagram.charAt(i-1)){
                        unique = unique + sortedAnagram.charAt(i);
                    }
                }

                Rack rack = new Rack();
                ArrayList<String> temp = rack.getAllSubsets(unique, multi, 0);
                ArrayList<String> list = new ArrayList<>();
                for (String str : temp) {
                    String word = ScrableWords.sortWord(str);
                    if (anagramDictionary.anagramMap.containsKey(word)) {
                        list.addAll(anagramDictionary.anagramMap.get(word));
                    }
                }

                HashMap<String, Integer> mapWord = new HashMap<>();
                ScoreTable scoreTable = new ScoreTable();
                for (String str : list) {
                    int sum = 0;
                    for (int i = 0; i < str.length(); i++) {
                        int score = scoreTable.table[str.charAt(i) - 'a'];
                        sum = sum + score;
                    }
                    mapWord.put(str, sum);
                }

                Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                        if (entry2.getValue() == entry1.getValue()) {
                            return entry1.getKey().compareTo(entry2.getKey());
                        }
                        return entry2.getValue() - entry1.getValue();
                    }
                };

                ArrayList<Map.Entry<String, Integer>> arrayWord = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : mapWord.entrySet()) {
                    arrayWord.add(entry);
                }
                Collections.sort(arrayWord, comparator);

                System.out.println("we can make " + arrayWord.size()+" words from " + "\""+sortedAnagram+"\"");
                if(arrayWord.size()>0) {
                    System.out.println("All of the words with their scores (sorted by score):");
                    for (Map.Entry<String, Integer> entry : arrayWord) {
                        System.out.println(entry.getValue() + ": " + entry.getKey());
                    }
                }

                input = scanner.next();

            }

        }catch (FileNotFoundException exp){

            System.out.print(exp.getStackTrace());
        }
    }
}
