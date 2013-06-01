
/**
 * This class defines Suit interface
 * @author Titi Gu
 *
 */


class Suit 
{
	static final int CLUBS = 1;
	static final int DIAMONDS = 2;
	static final int HEARTS = 3;
	static final int SPADES = 4;   
	int suitValue;    
	Suit(int i) { suitValue = i; }
	public String toString() 
	{
		switch (suitValue) 
		{      
			case CLUBS: return "clubs";       
			case DIAMONDS: return "diamonds";
			case HEARTS: return "hearts";
			case SPADES: return "spades";
			default: return "error";
		}
	}
}

