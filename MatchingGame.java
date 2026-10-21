import java.util.Random;
import java.util.Scanner;

public class MatchingGame {
	private CardLinkedList cards;
	private Scanner input;
	private int turns;
	
	public MatchingGame() {
		cards = new CardLinkedList();
		input = new Scanner(System.in);
		turns = 0;
	}
	
	public void setupGame() {
		String[] symbols = {"A", "A", "B", "B", "C", "C", "D", "D"};
		for(String symbol : symbols) {
			cards.addCard(symbol);
		}
		shuffleCards();
	}
	
	public void shuffleCards() {
		Random rand = new Random();
		
		for(int i = 0; i< cards.size(); i++) {
			int randomIndex = rand.nextInt(cards.size());
			cards.swapData(i,  randomIndex);
		}
	}
	
	public void playGame() {
		System.out.println("Match all pairs to win!");
		
		while(!cards.allMatched()){
			cards.displayBoard();
			
			int firstChoice = getValidChoice("Enter the first card position: ");
			CardNode firstCard = cards.getCardAt(firstChoice);
			firstCard.setRevealed(true);
			
			cards.displayBoard();
			
			int secondChoice = getValidChoice("Enter the second card position: ");
			while(secondChoice == firstChoice) {
				System.out.println("You cannot choose the same card twice.");
				secondChoice = getValidChoice("Enter a different second card choice: ");
			}
			CardNode secondCard = cards.getCardAt(secondChoice);
			secondCard.setRevealed(true);
			cards.displayBoard();
			turns++;
			
			checkMatch(firstCard, secondCard);
		}
	}
	
	public int getValidChoice(String prompt) {
		int choice = -1;
		boolean valid = false;
		
		while(!valid) {
			System.out.println(prompt);
			
			if(input.hasNextInt()) {
				choice = input.nextInt();
				
				CardNode chosenCard = cards.getCardAt(choice);
				
				if(choice >= 0 && choice < cards.size() &&chosenCard != null && !chosenCard.isMatched() && !chosenCard.isRevealed()) {
					valid = true;
				}
				else {
					System.out.println("Invalid choice.");
				}
			}
			else {System.out.println("Please enter a number.");
			input.next();
			}
		}
		return choice;
	}
	
	public void checkMatch(CardNode firstCard, CardNode secondCard) {
		if(firstCard.getSymbol().equals(secondCard.getSymbol())) {
			System.out.println("Match found");
			firstCard.setMatched(true);
			secondCard.setMatched(true);
			
		}
		else {
			System.out.println("Not a match.");
			pause();
			firstCard.setRevealed(false);
			secondCard.setRevealed(false);
		}
	}
	
	public void pause() {
		System.out.println("Press enter to continue");
		input.nextLine();
		input.nextLine();
	}

	public static void main(String[] args) {
		MatchingGame game = new MatchingGame();
		game.setupGame();
		game.playGame();

	}

}
