
public class CardNode {
	private String symbol;
	private boolean revealed;
	private boolean matched;
	private CardNode next;
	
	public CardNode(String symbol) {
		this.symbol = symbol;
		this.revealed = false;
		this.matched = false;
		this.next = null;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public boolean isRevealed() {
		return revealed;
	}
	
	public boolean isMatched() {
		return matched;
	}
	
	public CardNode getNext() {
		return next;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	
	public void setNext(CardNode next) {
		this.next = next;
	}

}
