package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
	private ArrayList<Card> cards;
	
	
	public Deck(int NumbrofJacks, ArrayList<Card> WildCards){
		this();
		//Scanner input = new Scanner(System.in);
		//NumbrofJacks = input.nextInt();
		System.out.println("How many jokers are in the deck?");
		for(int i=0; i < NumbrofJacks; i++){
			cards.add(new Card(eSuit.JOKER,eRank.JOKER));
		}
		//insert for each to iterate through the arraylist of wildcards
		for(Card deckCard : cards){
			for(Card Wild: WildCards){
				if((deckCard.getSuit() == (Wild.getSuit())) && (deckCard.getRank() == Wild.getRank())){
					deckCard.setWild();
				}
			}
			
		}
		shuffleCards();
	}

	public Deck() {

		//	Create an ArrayList of Cards, add each card
		ArrayList<Card> MakingDeck = new ArrayList<Card>();
		for (short i = 0; i <= 3; i++) {
			eSuit SuitValue = eSuit.values()[i];			
			for (short j = 0; j <= 12; j++) {
				eRank RankValue = eRank.values()[j];				
				Card NewCard = new Card(SuitValue,RankValue);
				MakingDeck.add(NewCard);
			}
		}
		
		//	Set the instance variable
		cards = MakingDeck;
		shuffleCards();
		
		
	}
	private void shuffleCards(){
//		Shuffle the cards
			Collections.shuffle(cards);
	}

	public Card drawFromDeck() {
		// Removes the first card from the deck and return the card
		Card FirstCard = cards.get(0);
		cards.remove(0);
		return FirstCard;
	}

	public int getTotalCards() {
		// Returns the total number of cards still in the deck
		return cards.size();
	}
}