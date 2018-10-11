import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * B0444205 楊兆寧
 * Try to write some comments for your codes (methods, 15 points)
 * 
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 嚙踝蕭謕蕭豲嚙踝蕭謕蕭豲���蕭��蕭謕蕭豲嚙踝蕭��嚙踝蕭謕
	 * @param nDeck ���蕭��蕭��蕭�嚙踝嚙踐�蕭豲���蕭��雓嚙踐�蕭豲�蕭嚙踐�蕭豲嚙踝蕭謕
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		for (int i = 1; i <= nDeck; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 13; k++) {
					Card card = new Card(j, k);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

		for(int l = 0; l < cards.size(); l++) {
			Card takecard = cards.get(l);
			takecard.printCard();
		}
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

		String su = "";
		String rk = "";

		switch (suit) {
		case 1:
			su = "Clubs";
			break;
		case 2:
			su = "Diamonds";
			break;
		case 3:
			su = "Hearts";
			break;
		case 4:
			su = "Spades";
			break;
		}

		switch (rank) {
		case 1:
			rk = "Ace";
			break;
		case 2:
			rk = "Two";
			break;
		case 3:
			rk = "Three";
			break;
		case 4:
			rk = "Four";
			break;
		case 5:
			rk = "Five";
			break;
		case 6:
			rk = "Six";
			break;
		case 7:
			rk = "Seven";
			break;
		case 8:
			rk = "Eight";
			break;
		case 9:
			rk = "Nine";
			break;
		case 10:
			rk = "Ten";
			break;
		case 11:
			rk = "Jack";
			break;
		case 12:
			rk = "Queen";
			break;
		case 13:
			rk = "King";
			break;
		}

		System.out.println(suit + "," + rank + " as " + su + " " + rk);
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
