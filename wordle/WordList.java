package wordle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordList {
    List<String> wordData = new ArrayList<>();

    public WordList (String filePath) throws FileNotFoundException {

        Scanner wordList = new Scanner(new File(filePath));

		// reading the file
			while (wordList.hasNext()) {
                String word = wordList.nextLine().replaceAll("[^\\w]", "");
				// Remove and replace excess characters with empty string
                if (word != "")
				wordData.add(word);
				
				// System.out.println(wordList.nextLine()); Yep - it works!
			}
    }

    public String ReturnRandomWord() {
			
			// System.out.println(wordData);	
			
			 // generating random word selector for the new word
	        Random random = new Random();
	        String newWord = wordData.get(random.nextInt(wordData.size())); 
	        
	        // checking random word generator works
            // System.out.println(newWord);
	        return newWord;
	}
}
