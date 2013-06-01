
/**
 * This class defines current 5 cards in hand
 * @author Titi Gu
 *
 */

public class Hand 
{
	Card[] cards;

	public Hand()
	{
		cards = new Card[5];
	}

	/*
	 * Add a card to card set
	 */
	public void setCard(int i, Card c)
	{
		cards[i] = c;
	} 

	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < cards.length; i++)
		{
			str += "\t" + (i+1) + ": ";
			str += cards[i];
			if(cards[i].isDiscarded() == true)
				str += " DISCARDED";  
			str += "\n";
		}

		return str;
	}

	/*
	 * Return Flush card combination
	 */
	public boolean isFlush() {
		
		
		String card = cards[0].getSuit().toString();
		//Store the suit of the first card
		//Compared every other card's suit to that one
		for(int i = 1; i < cards.length; i++)
		{
			if(!(cards[i].getSuit().toString().equals(card)))
				return false; //Returns false if any suits do not match
		}
		
		return true;
	}

	/*
	 * Return Pair card combination
	 */
	public boolean isPair() 
	{
		String[] values = new String[5];
		int counter = 0;	
	
		//Put each cards numeric value into array
		for(int i = 0; i < cards.length; i++){
			values[i] = cards[i].getPip().toString();
		}

		//Loop through the values. Compare each value to all values
		//If exactly two matches are made - return true
		for(int x = 0; x < values.length; x++){
			for(int y = 0; y < cards.length; y++){
				if(values[x].equals(cards[y].getPip().toString()))
					counter++;
				if(counter == 2)
					return true;

			}
			counter = 0;
		}
		
		return false;  
	}

	
	/*
	 * Return Three-of-Kind card combination
	 */
	public boolean isThreeOfAKind() 
	{
                String[] values = new String[5];
                int counter = 0;

                for(int i = 0; i < cards.length; i++){
                        values[i] = cards[i].getPip().toString();
                }
		
		//Same process as isPair(), except return true for 3 matches
                for(int x = 0; x < values.length; x++){
                        for(int y = 0; y < cards.length; y++){
                                if(values[x].equals(cards[y].getPip().toString()))
                                        counter++;
                                if(counter == 3)
                                        return true;

                        }
                        counter = 0;
                }

                return false;
        }


	/*
	 * Return Straight card combination
	 */
	public boolean isStraight()
	{
		int[] values = new int[5];
		int pos;
		int temp;
		
		//Set values in array
		for(int i = 0; i < cards.length; i++)
		{
			values[i] = cards[i].getPip().getValue();
			//If Ace
			if(values[i] == 1)
				values[i] = 14;
		}
	
		//Sort Numerically
		for(int i = 1; i < values.length; i++)
		{
			pos = i;
			while(pos != 0){
				if(values[pos] < values[pos-1])
				{
					temp = values[pos];
					values[pos] = values[pos-1];
					values[pos-1]= temp;
				}
				pos--;
			}
		}

		//Test for Straight
		//Each successive card should be +1
		for(int i = 0; i < values.length - 1; i++)
		{
			if(values[i] != values[i+1] - 1)
				return false;
		}

		return true;
	}

	/*
	 * Return Four-of-Kind card combination
	 */
	public boolean isFourOfAKind() 
	{
		String[] values = new String[5];
		int counter = 0;

		for(int i = 0; i < cards.length; i++)
		{
			values[i] = cards[i].getPip().toString();
		}

		//Same process as isPair(), except return true for 4 matches
		for(int x = 0; x < values.length; x++)
		{
			for(int y = 0; y < cards.length; y++)
			{
				if(values[x].equals(cards[y].getPip().toString()))
					counter++;
				if(counter == 4)
					return true;
			}
			counter = 0;
		}
		
		return false;
	}

	/*
	 * Return Straight Flush card combination
	 */
	public boolean isStraightFlush()
	{
		//If there is a straight and a flush present
		if(isStraight() == true && isFlush() == true)
			return true;

		return false;
	}

	/*
	 * Return Royal card combination
	 */
	public boolean isRoyalFlush()
	{
		if(isFlush() == false || isStraight() == false)
			return false;
	
		int[] values = new int[5];
                int pos;
                int temp;

                //Set values in array
                for(int i = 0; i < cards.length; i++)
                {
                        values[i] = cards[i].getPip().getValue();
                        //If Ace
                        if(values[i] == 1)
                                values[i] = 14;
                }

                //Sort Numerically
                for(int i = 1; i < values.length; i++)
                {
                        pos = i;
                        while(pos != 0)
                        {
                                if(values[pos] < values[pos-1])
                                {
                                        temp = values[pos];
                                        values[pos] = values[pos-1];
                                        values[pos-1]= temp;
                                }
                                pos--;
                        }
                }

		//Royal flush is a straight flush, with the lowest card being a 10	
		if(values[0] == 10)
			return true;

		return false;			
	}

	/*
	 * Return Two Pairs card combination
	 */
	public boolean isTwoPair()
	{
		String[] values = new String[5];
		int counter = 0;
		int sum = 0;
		
		//Two pairs can resemble 4 of a kind
		if(isFourOfAKind() == true)
			return false;

		for(int i = 0; i < cards.length; i++)
		{
			values[i] = cards[i].getPip().toString();
		}

		for(int x = 0; x < values.length; x++)
		{      
			for(int y = 0; y < cards.length; y++)
			{           
				if(values[x].equals(cards[y].getPip().toString()))
				{                     
					counter++;
				}
			}    
			if(counter > 1)        
				sum++;
			
			counter = 0;
		}

		if(sum == 4)
			return true;
  
		return false;
	}


	/*
	 * Return Full-House card combination
	 */
	public boolean isFullHouse()
	{    
		String[] values = new String[5];
		int counter = 0;
		int sum = 0;
   
		if(isFourOfAKind() == true)     
			return false;
 
		for(int i = 0; i < cards.length; i++)
		{          
			values[i] = cards[i].getPip().toString();    
		}
    
		for(int x = 0; x < values.length; x++)
		{
			for(int y = 0; y < cards.length; y++)
			{      
				if(values[x].equals(cards[y].getPip().toString()))
				{
					counter++;
				}         
			}
			
			if(counter > 1)
				sum++;
			counter = 0;
		}

		if(sum == 5)       
			return true;
  
		return false;
	}

	/*
	 * Discard a card
	 */
	public void discardCard(int index)
	{
		if(cards[index].isDiscarded() == false)
			cards[index].setDiscarded(true);
		else
			cards[index].setDiscarded(false);
	}

	/*
	 * Replace a discarded card
	 */
	public void replaceDiscarded(Deck deck)
	{
		for(int i = 0; i < cards.length; i++)
		{
			if(cards[i].isDiscarded() == true)
				setCard(i, deck.dealCard());
		}
	}
}
