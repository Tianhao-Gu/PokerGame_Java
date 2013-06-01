
import java.util.Scanner;

/**
 * This class defines current poker game
 * @author Titi Gu
 *
 */
public class Poker 
{
	private static Scanner kb = new Scanner(System.in);
	private static Hand hand;
	private static Deck deck;
	private static int money;

	public static void main(String[] args)
	{
		String handValue;

		deck = new Deck();
		hand = new Hand();
		money = 20; //Given $20 pocket money

		System.out.println("Let's play Poker!\n");

		while(true)
		{
			//Shuffle deck and deal the hand
			deck.shuffle();
                	for (int i = 0; i<5; i++)
                        	hand.setCard(i, deck.dealCard());

			//Print Hand
			System.out.println("Your Current Hand Is:");
			System.out.println(hand);
			
			//Discarding
			doDiscard();
			
			//Show final hand
			System.out.println("\nYour Final Hand Is:");
			System.out.println(hand);
			System.out.println();

			//Display hand value
			handValue = getHandValue();
			System.out.println("Hand Value: " + handValue);

			//Display money
			money += updateMoney(handValue);
			System.out.println("Money: $" + money);
			
			//Play Again?
			if(money < 1){
				System.out.println("You are out of money.");
				break;
			} else {
				System.out.print("Do you want to play again? (y/n) : ");
				if(getOption().equals("N"))
					break;		
			}
		}	
	}

	/*
	 * Update pocket money
	 */
	private static int updateMoney(String handValue)
	{
		if(handValue.equals("Royal Flush"))
			return 250;
		if(handValue.equals("Straight Flush"))
			return 50;
		if(handValue.equals("Four of a Kind"))
			return 25;
		if(handValue.equals("Full House"))
			return 9;
		if(handValue.equals("Flush"))
			return 6;
		if(handValue.equals("Straight"))
			return 4;
		if(handValue.equals("Three of a Kind"))
			return 3;
		if(handValue.equals("Two Pair"))
			return 2;
		if(handValue.equals("Pair"))
			return 1;
		if(handValue.equals("Nothing"))
			return -1;

		return -1;
	}

	/*
	 * Check combinations of current hand
	 */
	private static String getHandValue(){
		if(hand.isRoyalFlush() == true)
			return "Royal Flush";
		if(hand.isStraightFlush() == true)
			return "Straight Flush";
		if(hand.isFourOfAKind() == true)
			return "Four of a Kind";
		if(hand.isFullHouse() == true)
			return "Full House";
		if(hand.isFlush() == true)
			return "Flush";
		if(hand.isStraight() == true)
			return "Straight";
		if(hand.isThreeOfAKind() == true)
			return "Three of a Kind";
		if(hand.isTwoPair() == true)
			return "Two Pair";
		if(hand.isPair() == true)
			return "Pair";

		return "Nothing";
	}

	/*
	 * Discard a card
	 */
	private static void doDiscard()
	{		
		int discard = -1;
    	
		System.out.println("Enter the numbers of the cards you wish to discard.");    	
		System.out.println("Entering the number of a discarded card retrieves it.");   	
		System.out.println("Enter 0 to stop discarding.");

		while(discard != 0)
		{
			discard = getDiscard();
			if(discard == 0)
				break;
			hand.discardCard(discard - 1);
			System.out.println(hand);
			System.out.println("Select another card or 0 to complete the discard.");
		}
		hand.replaceDiscarded(deck);
	}

	/*
	 * Return discarded card number
	 */
	private static int getDiscard()
	{
		String input;
		int num = -1;

		while(num < 0 ||  num > 5)
		{
			try {
				input = kb.nextLine();
				num = Integer.parseInt(input);
				if(num < 0 || num > 5)
					throw new NumberFormatException(); 
			} catch(NumberFormatException ex){
				System.out.println("- Enter a valid integer from 0 to 5");
			}
		}

		return num;
	}

	/*
	 * Pop player playing next round
	 */
	private static String getOption()
	{
		String option;
		
		while(true)
		{
			option = kb.nextLine();
			option = option.toUpperCase();
			if(option.equals("Y") || option.equals("N"))
			{
				return(option);
			} 
			else
			{
				System.out.println("- Enter a valid option: (y/n)");
			}
		}
	}
}
