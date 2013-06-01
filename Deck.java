/**
 * This class defines a deck of playing cards
 * @author Titi Gu
 *
 */

public class Deck 
{
	Card[] deck;
	private int cardsUsed;
  
	public Deck() 
	{
		deck = new Card[52];    
		for (int i = 0; i < deck.length; i++)
			deck[i] = new Card(new Suit(i / 13 + 1),
                      new Pips(i % 13 + 1));
		cardsUsed = 0;                   
	}


	/*
	 * Shuffle deck of cards
	 */
	public void shuffle() 
	{   
		for (int i = 0; i < deck.length; i++)
		{
			int k = (int)(Math.random() * 52);
			Card t = deck[i];
			deck[i] = deck[k];
			deck[k] = t;    
		}

		for(int i = 0; i < deck.length; i++)
			deck[i].setDiscarded(false);
 
		cardsUsed = 0; 
	} 

	/*
	 * This function returns the number of cards that are still left in the deck
	 */
	public int cardsLeft() 
	{

        return 52 - cardsUsed;
    }
    
	/*
	 * Deals one card from the deck and returns it
	 */
    public Card dealCard() 
    {

        if (cardsUsed == 52)
           shuffle();
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
  
    public  String toString()  
    { 
    	String t = ""; 
    	for (int i = 0; i < 52; i++)
    		if ( (i + 1) % 5 == 0)
    			t = t  + deck[i] + "\n";
    		else     
    			t = t + deck[i];
    	return t;
    }

}
