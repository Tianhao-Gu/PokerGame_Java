/**
 * This class defines Pip interface
 * @author Titi Gu
 *
 */

class Pips 
{
	int p;

	Pips(int i) { p = i; }
	public String toString() 
	{
		if (p > 1 && p < 11)
			return String.valueOf(p);
		else if (p == 1)
			return "Ace";
		else if (p == 11)
			return "Jack";
		else if (p == 12)
			return "Queen";
		else if (p == 13)
			return "King";
		else return "error";
	}

	/*
	 * Get Pip
	 */
	public int getValue() { return p; }
}
