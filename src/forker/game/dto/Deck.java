
package forker.game.dto;

import java.util.Random;

public class Deck
{
        // Data type get from 'Card' class
	private Card deck[];//array of  Card object 
	private int currentCard ;
	private final int NUMBER_OF_CARD = 52; //52 is constant value Can't be Change
	private Random randomNum;
	
	//Create Constructor from  DeckPack
	public Deck()
        {
            
		String faces[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String suits[] ={"H","D","C","S"};
                
                //String faces[] = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
                //String suits[] ={"Haerts","Diamond","Clubs","Spades"};
		//52 card value assign to the deck[] array 
		deck = new Card[NUMBER_OF_CARD];
		currentCard = 0;
		randomNum = new Random();
		
		//populate deck with card object
		 for (int count = 0; count < deck.length; count++) {
			deck[count]=
			       new Card(faces[count %13], suits[count / 13]);
		}
	
		
	}//end Constructor
	 
	//shuffle deckPack
	public void shuffle(){
		//after shuffle ,deal should be star at deck[0] again.
		currentCard = 0;
		for (int first = 0; first < deck.length; first++) {
			
			int second = randomNum.nextInt(NUMBER_OF_CARD);
			//swap the current card with random number that selected.
			Card temp   = deck[first];
			deck[first] = deck[second];
			deck[second]  = temp;
			
		}
	}
	//deal Card
	public Card dealCard(){
		
		if(currentCard < deck.length){
		return deck[currentCard++]; 
		}
		else {
			return null;
		}
	}
            
}
