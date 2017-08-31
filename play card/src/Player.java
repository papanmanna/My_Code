import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> player=new ArrayList<Card>();
	int cardsInHand=0,points=0;
	Card trump=null;
	public String getImage(int i) {
		Card c=player.get(i);
		return c.strimage ;
	}
	public void createBid() {
	
		
	}
	

	
	
	
	
}
