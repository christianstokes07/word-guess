import java.util.*;

public class WordGuess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = {"computer", "java", "keyboard", "science", "program"};
        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];
        char[] guessed = new char[word.length()];
        Arrays.fill(guessed, '_');
        int attemptsLeft = 6;
        HashSet<Character> usedLetters = new HashSet<>();

        System.out.println("=== Word Guess Game ===");
        System.out.println("Guess the word! You have " + attemptsLeft + " wrong guesses.");

        while (attemptsLeft > 0) {
            System.out.println("\nWord: " + String.valueOf(guessed));
            System.out.println("Used letters: " + usedLetters);
            System.out.print("Enter a letter: ");
            char guess = Character.toLowerCase(input.next().charAt(0));

            if (usedLetters.contains(guess)) {
                System.out.println("You already guessed that!");
                continue;
            }

            usedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Good guess!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessed[i] = guess;
                    }
                }
                if (String.valueOf(guessed).equals(word)) {
                    System.out.println("\nYou guessed the word: " + word + " 🎉");
                    break;
                }
            } else {
                attemptsLeft--;
                System.out.println("Wrong guess! Attempts left: " + attemptsLeft);
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("\nYou ran out of attempts! The word was: " + word);
        }

        input.close();
    }
}
