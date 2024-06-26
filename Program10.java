import java.util.Scanner;
public class Program10 {

	//initialize words array list and set max capacity to 100 elements
	static String[] words = new String[100];
	//initialize numWords variable and set to 0 to start
	static int numWords = 0;
	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);


		//initialize menuChoice variable for account of do loop
		int menuChoice;

		System.out.println("Welcome to wordlist!");
		System.out.println("--------------------");
		System.out.println();

		do {
			System.out.println("1. \t Add Word");
			System.out.println("2. \t Remove Word");
			System.out.println("3. \t Print Words");
			System.out.println("4. \t Quit");

			//call getMenuChoice method to see what user would like to do
			menuChoice = getMenuChoice(stdIn);

			if (menuChoice == 1) {
				System.out.println("Enter a word to add to the word list: ");
				String wordToAdd = stdIn.next();
				//Call addWord method 
				boolean evaluate = addWord(words, numWords, wordToAdd);
				if (evaluate == true) {
					System.out.println("Word added to word list.");
				} else {
					System.out.println("Error, word already in word list.");
					System.out.println("You cannot add the same word twice.");
				}


			} else if (menuChoice == 2) {

			} else if (menuChoice == 3) {
				printWords(words, numWords);

			} else {

			}

		} while (!(menuChoice == 4));
	}

	//This method prints the menu options to the screen, reads in the user’s selection, and validates it. It
	//returns the valid option selection.
	private static int getMenuChoice(Scanner stdIn) {
		int answer;
		//Do loop in case user doesn't choose 1 - 4
		do {
			//Print choose an option 1 -4
			System.out.println("Choose an option (1-4):");
			answer = stdIn.nextInt();

		} while(answer != 1 && answer != 2 && answer != 3 && answer != 4);
		return answer;
	}

	//This method searches for the word parameter in the words array. If found, it returns the index of
	//word; otherwise it returns -1.
	public static int findWord(String[] words, int numWords, String word) {
		//for loop to sift through each filled element of the array
		for (int i = 0; i < numWords; i++) {
			//if condition for if words of index i equals the searched for word
			if (words[i].equals(word)) {
				return i;
			}
		}
		return -1;

	}

	//This method adds the word parameter to the words array only if words does not already contain it.
	//It returns true if word was added to words; false otherwise.
	public static boolean addWord(String[] words, int numWords, String word) {
		int indexOfWord = findWord(words, numWords, word);
		if (indexOfWord == -1) {
			words[numWords] = word;
			return true;
		} else {
			return false;
		}
	}

	//This method removes the word parameter from the words array only if words contains it. It returns
	//true if word was found and removed from words; false otherwise.
	public static boolean removeWord(String[] words, int numWords, String word) {
		int indexOfWord = findWord(words, numWords, word);
		if (indexOfWord == -1) {
			return false;
		} else {
			String removeWord = words[indexOfWord];
			words.remove(removeWord);
		}

	}

	//This method prints all of the elements in the words array parameter to the screen - in some reasonable
	//format.
	public static void printWords(String[] words, int numWords) {

		for (int i = 0; i < numWords; i++) {
			System.out.println(words[i]);
			System.out.println("Test");
		}

	}

}
