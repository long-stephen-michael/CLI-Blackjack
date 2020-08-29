package blackjacksrc;

import blackjacksrc.Card.card;
import blackjacksrc.Rank.rank;
import blackjacksrc.Suit.suit;

public class blackjack{
	
		public static void main(String[] args) {
		
		int dealer = 0;
		int player = 0;
		
		Card[] deck = new Card[52];
		for(suit s : suit.values()) {
			for(rank r :rank.values()) {
				card card = new card();
					card.suit = s;
					card.rank = r;
					System.out.println(card.suit.toString());
					System.out.println(card.rank.toString());
				}
		}

		//String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	    //String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	     // "10", "Jack", "Queen", "King"};
	        
	    // Initialize cards
	    //for (int i = 0; i < deck.length; i++)
	      //deck[i] = blackjackcard;
	    
	    // Shuffle the cards
	   /*
		for (int i = 0; i < deck.length; i++) {
	      // Generate an index randomly
	      dealer = (int)(Math.random() * deck.length);
	      player = (int)(Math.random() * deck.length);
	      //int temp = deck[i];
	      //deck[i] = deck[index]; 
	      //deck[index] = temp;
	    }
	    
	    System.out.println(dealer);
	    System.out.println(player);
*/
	     //Display the first four cards
	   //for (int i = 0; i < 4; i++) {
	      //String suit = suits[deck[i] / 13];
	      //String rank = ranks[deck[i] % 13];
	      //System.out.println("Card number " + deck[i] + ": " 
	        //+ rank + " of " + suit);
		
		        

		
		
		
	    }
	  }

