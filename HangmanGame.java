private static final String[] GAME_WORDS = {"java", "programming", "computer", "algorithm", "developer"};
private static final int MAX_ATTEMPTS = 7;

void main() {
	var targetWord = GAME_WORDS[(int) (Math.random() * GAME_WORDS.length)];
	var guessedLetters = "_".repeat(targetWord.length());
	int attemptsLeft = MAX_ATTEMPTS;

	println("Welcome to Hangman!");
	println("Try to guess the word. You have " + MAX_ATTEMPTS + " attempts.");
	var scanner = new Scanner(System.in);
	while (attemptsLeft > 0) {
		println("Current word: " + guessedLetters);
		print("Enter a letter: ");

		// Ensure valid input (non-empty and single character)
		var input = scanner.nextLine().trim();
		if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
			println("Invalid input. Please enter a single letter.");
			continue;
		}
		var guessedChar = input.charAt(0);
		var updatedWord = new StringBuilder(guessedLetters);
		boolean found = false;
		for (int i = 0; i < targetWord.length(); i++) {
			if (targetWord.charAt(i) == guessedChar && guessedLetters.charAt(i) == '_') {
				updatedWord.setCharAt(i, guessedChar);
				found = true;
			}
		}
		if (found) {
			guessedLetters = updatedWord.toString();
			println("Correct guess! The word has been updated: " + guessedLetters);
		} else {
			attemptsLeft--;
			println("Incorrect guess! You have " + attemptsLeft + " attempts left.");
		}
		if (guessedLetters.equals(targetWord)) {
			println("Congratulations! You guessed the word: " + targetWord);
			break;
		}
	}
	if (attemptsLeft == 0) System.out.println("Game Over. The word was: " + targetWord);
	scanner.close();
}