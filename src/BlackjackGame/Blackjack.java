package BlackjackGame;
		
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
	
public class Blackjack {

	public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);
	        String name;
	        String user;

	     //    ask for Username
	        System.out.println("Enter your name?");
	        user = input.nextLine();
	        name = user;

	        // Loop
	        do {

	            // WELCOME MESSAGE
	            System.out.print("\n");
	            System.out.println("Welcome to Blackjack!!");
	            System.out.print("\n");

	           
	            Player player = new Player(name);
	            Player dealer = new Player("Dealer");
	            Deck deck = new Deck();
	            deck.shuffle();
	            boolean endGame = false;

	            // player gets 2 cards
	            player.addCard(deck.draw());
	            player.addCard(deck.draw());
	            System.out.println(player.getHandAsString(false));

	            // dealer gets 2 cards
	            dealer.addCard(deck.draw());
	            dealer.addCard(deck.draw());
	            System.out.println(dealer.getHandAsString(true));

	            // Asks Player to Hit or Stand
	            do {
	                System.out.println("Would " + player.getname() + " like to Hit or Stand? 'Hit/Stand'");
	                do {
	                    user = input.nextLine();
	                } while (!user.equalsIgnoreCase("Hit") && !user.equalsIgnoreCase("Stand"));

	                // Player chooses to Hit
	                if (user.equalsIgnoreCase("Hit")) {
	                    player.addCard(deck.draw());
	                    System.out.println(player.getname() + " drew a card.");
	                    System.out.println();
	                    System.out.println(player.getHandAsString(false));
	                    if (player.getHandSum() > 21) {
	                        System.out.println(
	                                "Busted and total is " + player.getHandSum() + ". Dealer wins!");
	                        endGame = true;
	                    }
	                }
	                // Player chooses to Stand
	                if (user.equalsIgnoreCase("Stand")) {
	                    System.out.println("You have chosen to stand. Player's hand: " + player.getHandSum());
	                }

	            } while (user.equalsIgnoreCase("Hit") && !endGame);

	            // dealer
	            if (!endGame) {
	                System.out.println();
	                System.out.println("- Dealer's game -");
	                System.out.println();
	                System.out.println(dealer.getHandAsString(false));
	            }

	            while (!endGame) {

	                if (dealer.getHandSum() <= 17) {
	                    // new card
	                    dealer.addCard(deck.draw());
	                    System.out.println(dealer.getname() + " drew another card");
	                    System.out.println();
	                    System.out.println(dealer.getHandAsString(false));
	                    if (dealer.getHandSum() == 17) {
	                        System.out.println("Blackjack! Dealer wins.");
	                        endGame = true;
	                    }
	                    if (dealer.getHandSum() > 21) {
	                        System.out.println("Dealer's busted and total is " + dealer.getHandSum() + ". "
	                                + player.getname() + " wins!");
	                        endGame = true;
	                    }

	                } else {
	                    // STAY
	                    System.out.println("Dealer choses to stand!");
	                    System.out.println();
	                    int dealerCardTotal = dealer.getHandSum();
	                    int playerCardTotal = player.getHandSum();

	                    if (dealerCardTotal > playerCardTotal) {
	                        System.out.println("Both players chose to stand. The winner is " + dealer.getname()
	                                + " with a total of " + dealerCardTotal + ".");
	                    } else {
	                        System.out.println("Both players chose to stand. The winner is " + player.getname()
	                                + " with a total of " + playerCardTotal + ".");
	                    }
	                    endGame = true;
	                }

	            }

	            // ask for new game
	            System.out.println();
	            System.out.println("Would you like to begin a new game?  'Yes/No' :");
	            do {
	                user = input.nextLine();
	            } while (!user.equalsIgnoreCase("Yes") && !user.equalsIgnoreCase("No"));

	        } while (user.equalsIgnoreCase("Yes"));

	        
	        input.close();
	    
	}

}

	class Player {

	     String name;

	     ArrayList<Card> hand;

	    public Player(String name) {
	        this.name = name;
	        this.hand = new ArrayList<Card>();
	    }

	    public String getname() {
	        return name;
	    }

	    public void addCard(Card card) {
	        hand.add(card);
	    }

	    public int getHandSum() {
	        int handSum = 0;
	        for (Card card : hand) {
	            handSum += card.getRank().getValue();
	        }
	        return handSum;
	    }

	    public String getHandAsString(boolean hideCard) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(name + "\'s current hand:");
	        sb.append('\n');
	        for (int i = 0; i < hand.size(); i++) {
	            if (i == 0 && hideCard) {
	                sb.append("[Hidden card]");
	                sb.append('\n');
	            } else {
	                sb.append(hand.get(i));
	                sb.append('\n');
	            }
	        }
	        return sb.toString();
	    }

}
 class Deck {

    private final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        // populate deck with cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(i + 1);
            sb.append('/');
            sb.append(cards.size());
            sb.append(' ');
            sb.append(cards.get(i));
            sb.append('\n');
        }
        return sb.toString();
    }

}
	
	 class Card {

	    private final Rank rank;

	    private final Suit suit;

	    public Card(Rank rank, Suit suit) {
	        this.rank = rank;
	        this.suit = suit;
	    }

	    public Rank getRank() {
	        return rank;
	    }

	    public Suit getSuit() {
	        return suit;
	    }

	    @Override
	    public String toString() {
	        return rank + " of " + suit;
	    }

}
		 
