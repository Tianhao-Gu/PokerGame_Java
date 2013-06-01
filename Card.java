/**
 * This class defines Card interface which consists of Suit and Pips
 * @author Titi Gu
 *
 */


class Card 
{
	Suit suit;   
	Pips pip; 
	Card() {}  
	Card(Suit s, Pips p) { suit = s; pip = p; discarded = false;}
	Card(Card c) { suit = c.suit; pip = c.pip; discarded = false;} 
	private boolean discarded;

	/*
	 * Return Suit
	 */
	public Suit getSuit() { return suit; }
	
	/*
	 * Return Pip
	 */
	public Pips getPip() { return pip; }
	
	/*
	 * Return Card is a discarded card
	 */
	public boolean isDiscarded() { return discarded; }
	
	/*
	 * Set a card to discarded card
	 */
	public void setDiscarded(boolean value) { discarded = value; }
	

	public  String toString() 
	{
		return pip.toString() +":" +  suit.toString()+ " ";  
	} 
}
