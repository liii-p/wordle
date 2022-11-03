package wordle;

import java.io.*;
import java.util.Scanner;

public class WordleGame {
	public static Scanner s = new Scanner(System.in);
	
	 // Declaring the colours
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    
 // IMPORTANT NOTE: Eclipse cannot process ANSI colours, so a plugin is needed to run it correctly
    // https://marketplace.eclipse.org/content/ansi-escape-console
    

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Instructions: a green letter means the letter is in the correct place, red means that letter is not in the word and yellow means it exists in the word but it's current position is incorrect.");
		System.out.println("Wordle: Type a five letter word");

		WordList wordList = new WordList("./wordList.txt");
		
	        String word = wordList.ReturnRandomWord();

	        char[] answer = new char[5];
	        for (int i = 0; i < 5; i++ ) answer[i] = word.charAt(i);
	        char[] input = new char[5];        
	        boolean done = false;
	        int tries = 0;
	        
	        while (!done){
	        	tries++;
	            String R1 = s.nextLine().toLowerCase();
	            while (R1.length() < 5) {
	                R1 = s.nextLine().toLowerCase();
	            }
	            for (int i = 0; i < 5; i++ ) { //puts the inputWord into a char[]
	                answer[i] = word.charAt(i);
	                input[i] = R1.charAt(i);
	            }
				
				if (PrintWordWithColor(input, answer)) {
	            	done = true;
	            	PrintSuccessMessage();
	            } else if (tries > 6){
	            	done = true;
	            	PrintGameoverMessage(word);
	            }
	        }
	    }

		public static void PrintSuccessMessage()
		{
			System.out.println("Congratulations, you got the correct answer! To play again, click run!");
		}

		public static void PrintGameoverMessage(String word)
		{
			System.out.println("Game over :( the word was " + word);
		}

	// Print the word with the required colour (correct, incorrect, incorrect position)
	public static boolean PrintWordWithColor(char[] inputWord, char[] correctWord) {
		
		boolean correct = true;
		char[] answerTemp = correctWord;
		int[] colorForLetter = new int[5]; // 0 is grey, yellow is 1, green is 2
		
		for(int i = 0; i < 5; i++) {
			if(inputWord[i] == answerTemp[i]) {
				answerTemp[i] = '-';
				colorForLetter[i] = 2;
			} else correct = false;
		}
		
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if(inputWord[j] == answerTemp[k] && colorForLetter[j] != 2) {
					colorForLetter[j] = 1;
					answerTemp[k] = '-';
				}
			}
		}
		
		for (int m = 0; m < 5; m++) {
			if (colorForLetter[m] == 0) System.out.print(ANSI_RED + inputWord[m] + ANSI_RESET);
			 if (colorForLetter[m] == 1) System.out.print(ANSI_YELLOW + inputWord[m] + ANSI_RESET);
	         if (colorForLetter[m] == 2) System.out.print(ANSI_GREEN + inputWord[m] + ANSI_RESET);
		}
		System.out.println("");
		return correct;
	}
	

	

	}

