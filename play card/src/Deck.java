import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Deck {

	ArrayList<Card>card,tempcard;
	String path="./image/";
	int perHand=8;
	public void distriBute(Player[] usr) {
		tempcard=new ArrayList<Card>();
		tempcard.addAll(card);
		for(int i=0;i<4;i++)
		{	
			Player p1=new Player();
			while(p1.cardsInHand<perHand)
			{
				Random r=new Random();
				int j=r.nextInt(card.size());
				System.out.println(card.get(j).name+"--"+card.get(j).value);
				p1.player.add(p1.cardsInHand,card.get(j));
				p1.cardsInHand++;
				card.remove(j);
				((ArrayList<Card>) card).trimToSize();
				
				
			}
			System.out.println("hello"+p1.cardsInHand);
			usr[i]=p1;
			 
		}
		
	}
	public void cardCreate() {
		card=new ArrayList<Card>();
		for(int i=7;i<=14;i++)
		{
				String s2=path+i+"_of_clubs.png";
				String s1=path+i+"_of_diamonds.png";
				String s3=path+i+"_of_hearts.png";
				String s4=path+i+"_of_spades.png";
			
				card.add(new Card(i,1,s1));
				card.add(new Card(i,2,s2));
				card.add(new Card(i,3,s3));
				card.add(new Card(i,4,s4));			
			
		}
	}
	public Card searchCard(String str) {
		for(int i=0;i<tempcard.size();i++){
			Card card=tempcard.get(i);
			if(card.strimage.equals(str)){
				System.out.println(card.strimage);
				return card;
			}
				
		}
		return null;
	}
	public Card throwCard(Player p,int n,Card table[],int st) {
			
		Card maxcard,maincard;
		if(table[0]==null){
			maxcard=null;
			maincard=null;
		}
		else{
			maxcard=table[n-1];
			maincard=table[st];
		}
			//System.out.println("mmm"+maxcard.name+"--"+maxcard.value);
		for(int i=0;i<4;i++)
		{
			if(table[i]!=null && maxcard.value<table[i].value)
				maxcard=table[i];
		}
		int mask[]=new int[8];
		for(int i=0;i<8;i++)
			mask[i]=0;
		if(table[0]==null)
		{
			for(int i=0;i<8;i++)
				mask[i]=1;
		}
		else
		{	
			for(int i=0;i<p.player.size();i++)
			{
				Card c=p.player.get(i);
				System.out.println("mmm"+maxcard.name+"--"+maxcard.value);
				//System.out.println("pp"+c.name+"--"+c.value);
				if(c.name==maincard.name)
					mask[i]=1;
				if(mask[i]==1 && c.value>maxcard.value)
					mask[i]=2;
				if(p.trump!=null)
				{
					for(int i1=0;i1<p.player.size();i1++)
					{
						Card card1=p.player.get(i1);
						if(p.trump.name==card1.name)
							mask[i1]=3;
					}
				}
				
			}
		}
		
		Card card1=null,card2=null,card3=null;
		int pnt1=-1,pnt2=-1,pnt3=-1;
		for(int i=0;i<p.player.size();i++)
		{
			if(mask[i]==2)
			{
				card1=p.player.get(i);
				pnt1=i;
				
			}
			else if(mask[i]==1)
			{
				card2=p.player.get(i);
				pnt2=i;
				
			}
			else if(mask[i]==3)
			{
				card3=p.player.get(i);
				pnt3=i;
			}
		}
		if(card1!=null)
		{
			p.player.remove(pnt1);
			return card1;
		}
		else if(card2!=null)
		{
			p.player.remove(pnt2);
			return card2; 
		}
		else if(card3!=null)
		{
			p.player.remove(pnt3);
			return card3;
		}
		else if(p.trump!=null)
		{
			Random r=new Random();
			int i=r.nextInt(p.player.size());
			card1=p.player.get(i);
			p.player.remove(i);
			return card1;
		}
		return null;
		
	}
}

