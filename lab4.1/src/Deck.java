
import java.util.ArrayList;

public class Deck {
	ArrayList<Card> unDealt;
	ArrayList<Card> dealt;
	
	public Deck(String[] rank,String[] suit,int[] pointValue) {
		unDealt = new ArrayList<Card>();
		dealt = new ArrayList<Card>();
		for(int s = 0; s < suit.length ; s++) {
			for(int i = 0; i < rank.length; i++) {
				unDealt.add(new Card(rank[i],suit[s],pointValue[i]));
			}
		}
	}
	public boolean isEmpty() {
		if(unDealt.size() == 0) {
			return true;
		}
		return false;
	}
	public int size() {
		return unDealt.size();
	}
	public Card deal() {
		if(unDealt.size() != 0) {
			Card x = unDealt.get(0);
			unDealt.remove(0);
			dealt.add(x);
			return x;
		}
		else {	
			return null;
		}
	}
	public void shuffle() {
		for(int i = 0; i < dealt.size(); i++) {
			Card x = dealt.get(i);
			dealt.remove(i);
			unDealt.add(x);
		}
		for(int i = 0; i <= 51; i++) {
			int j = (int)((Math.random()*51)+1);
			if(i==j) {
				i--;
			}
			else {
				Card temp = unDealt.get(i);
				unDealt.set(i, unDealt.get(j));
				unDealt.set(j, temp);
			}
		}
	}
}