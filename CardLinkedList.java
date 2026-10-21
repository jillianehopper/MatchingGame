
public class CardLinkedList {
	private CardNode head;
	private int size;
	
	public CardLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addCard(String symbol) {
		CardNode newNode = new CardNode(symbol);
		
		if(head == null) {
			head = newNode;
		}
		else {
			CardNode current = head;
			while(current.getNext()!= null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		size++;
	}
	
	public CardNode getCardAt(int position) {
		if(position < 0 || position >= size) {
			return null;
		}
		CardNode current = head;
		int index = 0;
		
		while(current != null) {
			if(index == position) {
				return current;
			}
			current = current.getNext();
			index++;
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean allMatched() {
		CardNode current = head;
		while(current != null) {
			if(!current.isMatched()){
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	public void displayBoard() {
		CardNode current = head;
		int index = 0;
		
		System.out.println("\nBoard:");
		while(current != null) {
			System.out.print("[" + index + ": ");
			if(current.isMatched() || current.isRevealed()) {
				System.out.print(current.getSymbol());
			}
			else {
				System.out.print("*");
			}
			
			System.out.print("] ");
			current = current.getNext();
			index++;
		}
		System.out.println();
	}
	
	public void hideUnmatchedRevealedCards() {
		CardNode current = head;
		
		while(current != null) {
			if(current.isRevealed() && !current.isMatched()) {
				current.setRevealed(false);
			}
			current = current.getNext();
		}
	}
	
	public void swapData(int pos1, int pos2) {
		if(pos1 == pos2) {
			return;
		}
		
		CardNode node1 = getCardAt(pos1);
		CardNode node2 = getCardAt(pos2);
		
		if(node1 == null || node2 == null) {
			return;
		}
		
		String tempSymbol = node1.getSymbol();
		boolean tempRevealed = node1.isRevealed();
		boolean tempMatched = node1.isMatched();
		
		node1.setSymbol(node2.getSymbol());
		node1.setRevealed(node2.isRevealed());
		node1.setMatched(node2.isMatched());
		
		node2.setSymbol(tempSymbol);
		node2.setRevealed(tempRevealed);
		node2.setMatched(tempMatched);
	}

}
