package src;

import java.util.Scanner;

public class blackjack {
		public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);
	    String HIT;
	     //int HIT;
	    String STAND;
	    String count = null;
	    String Continue = "y";
       int playerscard1;
       int  playerscard2; 
       int dealersCard1; 
       int dealersCard2; 
       int nextcard;
       int playersCardTotal = 0;
       int dealersCardTotal = 0;


       int[] deck = new int[52];
		
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	      "10", "Jack", "Queen", "King"};
	        
	    // Initialize cards
	    for (int i = 0; i < deck.length; i++)
	      deck[i] = i;
	    
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
               nextcard = (int)(Math.random()*10 + 1);;
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
