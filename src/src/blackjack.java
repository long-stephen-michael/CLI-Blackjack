package src;

import java.util.Scanner;
import java.util.Random;

enum Suit
{
	SPADES, HEARTS, DIAMOND, CLUB;  
}

//enum Rank
//{
//	ACE, DUECE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
//}

public class blackjack {
		public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);
	    String HIT;
	     //int HIT;
	    String STAND;
	    String count = null;
	    String Continue = "y";
	    
	    
       int playerscard1;
       int playerscard2; 
       int dealersCard1; 
       int dealersCard2; 
       int nextcard;
       int playersCardTotal = 0;
       int dealersCardTotal = 0;


       int[] deck = new int[52];
		
		String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
	    String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	      "10", "Jack", "Queen", "King"};
	        
	    // Initialize cards
	    //for (int i = 0; i < deck.length; i++)
	      //deck[i] = i;
	    
	   
	    		
	    
	    // Shuffle the cards
	    for (int i = 0; i < deck.length; i++) {
	      // Generate an index randomly
	      int index = (int)(Math.random() * deck.length);
	      int temp = deck[i];
	      deck[i] = deck[index]; 
	      deck[index] = temp;
	    }

       // Begin dealing the players first two cards

       while (Continue == "y")
       {
           //dealers random cards
           dealersCard1 = (int)(Math.random()*10 + 1);
           dealersCard2 = (int)(Math.random()*10 + 1);

           //players random cards
           playerscard1 = (int)(Math.random()*10 + 1);
           playerscard2 = (int)(Math.random()*10 + 1);
           playersCardTotal = playerscard1 + playerscard2;

           //Dealers two card total and display only one dealer card
           dealersCardTotal = dealersCard1 + dealersCard2;
           //System.out.println("Dealer's: " + dealersCard1);

           //Display players Cards
           System.out.println("First Card: " + playerscard1);
           System.out.println();
           System.out.println("Both Cards: " + playerscard1 + ", " + playerscard2);
          

           System.out.print("Another Card (y/n)?: ");
          
           try {
           
           HIT = input.nextLine();
    
           while(HIT == "y")
           {
               nextcard = (int)(Math.random()*10 + 1);
               playersCardTotal += nextcard;
               System.out.println("Card: " + nextcard);
               System.out.println("Total: " + playersCardTotal);

               if (playersCardTotal > 21)
               {
              	System.out.println("Total: "+ playersCardTotal);
               System.out.println("BUST!!!!!, Dealer Wins");
               }   
               if (playersCardTotal < 21)
   
               System.out.println("Total: "+ playersCardTotal);
               System.out.print("Another Card (y/n)?: ");
               HIT = input.nextLine();


               while (count == "c" && dealersCardTotal < 17)
               {
                   nextcard = (int)(Math.random()*10 + 1);
                   dealersCardTotal += nextcard;

                   if (dealersCardTotal > 21)
                   {
                   System.out.println("Total: "+ dealersCardTotal);
                   System.out.println("Total: "+ playersCardTotal);
                   System.out.println("Dealer BUST, You Win!");
                   }
                  
               }

           }
      
           }
    	   catch (NumberFormatException e) {
    		   System.out.print("Please enter a number.");
    		   
    	   }
           
           
           
           }
           
     
	}
		
}

class Card{
	
	private final int rankCard;
	private final Suit suitCard;
	
	Card(Suit suit, int rank){
		this.rankCard = rank;
		this.suitCard = suit;
	}
	
	int getRank() {
		return rankCard;
	}
	
	Suit getSuit() {
		return suitCard;
	}
	
	public String toString() {
		String numString = "Error";
		
		switch(this.rankCard) {
		
		case 2:
			numString = "Two";
			break;
		case 3:
			numString = "Three";
			break;
		case 4:
			numString = "Four";
			break;
		case 5:
			numString = "Five";
			break;
		case 6:
			numString = "Six";
			break;	
		case 7:
			numString = "Seven";
			break;
		case 8:
			numString = "Eight";
			break;	
		case 9:
			numString = "Nine";
			break;
		case 10:
			numString = "Ten";
			break;
		case 11:
			numString = "Jack";
			break;
		case 12:
			numString = "Queen";
			break;
		case 13:
			numString = "King";
			break;
		case 1:
			numString = "Ace";
			break;
		default:
			numString = "Error";
			break;	
				
		}
		
	return numString + " of " + suitCard.toString();
	}	
}

class Deck{
	
	private Card[] myCards;
	private int numCards;
	
	Deck(int numDecks, boolean shuffle){
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		int c = 0;
		 for(int i = 0; i < numDecks; i++) {
		    	for(int j = 0; j < 4; j++) {
		    		for (int k = 0; k <= 13; k++) {
		    		this.myCards[c] = new Card(Suit.values()[j], k);
		    		}
		    	}
		    }
		
		
	}
	
	
}
