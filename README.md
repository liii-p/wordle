# Project: Wordle

## MVP
Recreate a simplified version of the game Wordle to be played in a Java console application
The game should be able to randomly select a 5-letter word from the provided word list
The user will be able to enter a guess word that is also 5 characters long
For each letter, the application will tell the user if that letter is correct, right letter in the wrong position, or wrong letter
After the user guesses 6 times incorrectly, the game is over and the user loses
If the user guesses the word correctly, the game is over and the user wins
In addition you must implement one of the following extensions, or an extension of your own design as approved by a coach


## Extensions
Read the word list directly from the file when the application starts
Create a history file that keeps track of user wins/losses and how many letters they guessed it in
When the game finishes and the secret word is shown, also display the dictionary definition for that word
Hint: Use a free API (https://dictionaryapi.dev/)
Generate an output of the word/guesses and copy it to the user's clipboard so they can share it on socials
Bonus: Use emojis

## DESIGN
I decided to use ANSI colours which print the user's word based on each letter's status (correct, incorrect, or incorrect position). 
However, I discovered the Eclipse cannot process these colours as is so a plugin extension is needed. 
Other than that, the program takes user input, scans through each letter and compares it to the chosen letter which is extracted from a txt file and chosen at random.

## TO RUN 
This project must be opened in Eclipse, a Java IDE, in order to run it. Open the Wordle folder, then click into WordleGame.java and click the run button.
You must install the following extension in your Eclipse workspace in order to run the game properly.
https://marketplace.eclipse.org/content/ansi-escape-console
else Eclipse cannot process the ANSI colours.
