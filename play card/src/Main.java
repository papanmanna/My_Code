import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener,MouseListener,Runnable{
	
	
	private static JFrame jf;
	Player[] usr;
	Deck deck;
	Card card,trumpcard;
	Card[] table;
	JPanel  buttonPanel,cardPanel;
	JButton btn,bidBtn;
	static JLabel lb9,lb10,lb11,lb12,left,right,up,down,plr1,plr2,plr3,user;
	static JLabel[] lb=new JLabel[9];
	String path[]=new String[9];
	TextArea inslbl;
	private boolean gamestart=false;
	private Thread t;
	private boolean bidcomp=false;
	private boolean running=false;
	private JComboBox<Object> callList;
	private boolean bidTrap=true;
	private int highestBid;
	private boolean trumpselect=false,cardselect=false,trumpshow=false;
	private int index=-1;
	int mask[];
	
	Main()
	{
		
		t=new Thread(this);
       setBackground( new Color(96,96,96) );
        setLayout( null );
        
        buttonPanel=new JPanel();
	    
		buttonPanel.setBounds(1100, 0,300,700);
		buttonPanel.setLayout(null);
		buttonPanel.setBackground( new Color(220,200,180) );
	    add(buttonPanel);
	    
		btn=new JButton("START");
		
		btn.setBackground(Color.blue.brighter());
		btn.setBounds(100,60,100,50);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setOpaque(true);
		btn.addActionListener(this);
		
	    inslbl=new TextArea();	   
	    inslbl.setBounds(0,400 ,300, 400);
	    inslbl.setBackground(Color.white);	
	    inslbl.setVisible(true);
	    inslbl.setForeground(Color.red);
	    inslbl.setText("click start button.");
	    
	    Object[] listModel ={16,17,18,19,20,21,22,"PASS"}; 
	     //create the list 
	    callList = new JComboBox<>(listModel); 
	    callList.setBounds(30,150,100,30);
	    callList.setVisible(false);
	    callList.setEnabled(false);
	    
	    bidBtn=new JButton("Submit");
		bidBtn.setBounds(160,150,90,30);

		bidBtn.setOpaque(true);
		bidBtn.addActionListener(this);
	    bidBtn.setVisible(false);
	    buttonPanel.add(callList);
		buttonPanel.add(btn);
		buttonPanel.add(bidBtn);
		buttonPanel.add(inslbl);
		buttonPanel.setEnabled(false);
		cardPanel=new JPanel();
		cardPanel.setBounds(0, 0,1090,700);
		cardPanel.setLayout(null);
		cardPanel.setBackground( new Color(155,55,53) );
	    add(cardPanel);
	
	    left=new JLabel();	   
	    left.setBounds(220,250 ,10, 10);
	    left.setBackground(Color.green);	
	    left.setLayout(null);
	    left.setVisible(false);
	    left.setOpaque(true);
	    left.addMouseListener(this);
	    
	    right=new JLabel();	   
	    right.setBounds(780,250 ,10, 10);
	    right.setBackground(Color.green);	
	    right.setLayout(null);
	    right.setVisible(false);
	    right.setOpaque(true);
	    right.addMouseListener(this);
	    
	    up=new JLabel();	   
	    up.setBounds(480,160 ,10, 10);
	    up.setBackground(Color.green);	
	    up.setLayout(null);
	    up.setVisible(false);
	    up.setOpaque(true);
	    up.addMouseListener(this);
	    
	    down=new JLabel();	   
	    down.setBounds(485,480 ,10, 10);
	    down.setBackground(Color.green);	
	    down.setLayout(null);
	    down.setVisible(false);
	    down.setOpaque(true);
	    down.addMouseListener(this);
	    
	    plr1=new JLabel();	   
	    plr1.setBounds(450,180 ,90, 140);
	    plr1.setBackground(new Color(155,55,53));	
	    plr1.setLayout(null);
	    plr1.setVisible(true);
	    plr1.setOpaque(true);
	    plr1.addMouseListener(this);
	    
	    
	    plr2=new JLabel();	   
	    plr2.setBounds(350,250 ,90, 140);
	    plr2.setBackground(new Color(155,55,53));	
	    plr2.setLayout(null);
	    plr2.setVisible(true);
	    plr2.setOpaque(true);
	    plr2.addMouseListener(this);
	    
	    
	    plr3=new JLabel();	   
	    plr3.setBounds(550,250 ,90, 140);
	    plr3.setBackground(new Color(155,55,53));	
	    plr3.setLayout(null);
	    plr3.setVisible(true);
	    plr3.setOpaque(true);
	    plr3.addMouseListener(this);
	    
	    
	    user=new JLabel();	   
	    user.setBounds(450,330,90, 140);
	    user.setBackground(new Color(155,55,53));	
	    user.setLayout(null);
	    user.setVisible(true);
	    user.setOpaque(true);
	    user.addMouseListener(this);
	    
	    
	    
	    lb[1]=new JLabel();	   
	    lb[1].setBounds(110,500 ,90, 150);
	    lb[1].setBackground(new Color(155,55,53));	
	    lb[1].setLayout(null);
	    lb[1].setVisible(true);
	    lb[1].setOpaque(true);
	    lb[1].addMouseListener(this);
	    
	    lb[2]=new JLabel();	   
	    lb[2].setBounds(110+100,500 ,90, 150);
	    lb[2].setBackground(new Color(155,55,53));	
	    lb[2].setLayout(null);
	    lb[2].setVisible(true);
	    lb[2].setOpaque(true);
	    lb[2].addMouseListener(this);
	   
	    
	    lb[3]=new JLabel();	   
	    lb[3].setBounds(110+200,500 ,90, 150);
	    lb[3].setBackground(new Color(155,55,53));	
	    lb[3].setLayout(null);
	    lb[3].setVisible(true);
	    lb[3].setOpaque(true);
	    lb[3].addMouseListener(this);
	    
	    lb[4]=new JLabel();	   
	    lb[4].setBounds(110+300,500 ,90, 150);
	    lb[4].setBackground(new Color(155,55,53));	
	    lb[4].setLayout(null);
	    lb[4].setVisible(true);
	    lb[4].setOpaque(true);
	    lb[4].addMouseListener(this);
	    
	    lb[5]=new JLabel();	   
	    lb[5].setBounds(110+400,500 ,90, 150);
	    lb[5].setBackground(new Color(155,55,53));	
	    lb[5].setLayout(null);
	    lb[5].setVisible(true);
	    lb[5].setOpaque(true);
	    lb[5].addMouseListener(this);
	    
	    lb[6]=new JLabel();	   
	    lb[6].setBounds(110+500,500 ,90, 150);
	    lb[6].setBackground(new Color(155,55,53));	
	    lb[6].setLayout(null);
	    lb[6].setVisible(true);
	    lb[6].setOpaque(true);
	    lb[6].addMouseListener(this);
	    
	    lb[7]=new JLabel();	   
	    lb[7].setBounds(110+600,500 ,90, 150);
	    lb[7].setBackground(new Color(155,55,53));	
	    lb[7].setLayout(null);
	    lb[7].setVisible(true);
	    lb[7].setOpaque(true);
	    lb[7].addMouseListener(this);
	    
	    lb[8]=new JLabel();	   
	    lb[8].setBounds(110+700,500 ,90, 150);
	    lb[8].setBackground(new Color(155,55,53));	
	    lb[8].setLayout(null);
	    lb[8].setVisible(true);
	    lb[8].setOpaque(true);
	    lb[8].addMouseListener(this);
	    
	    lb9=new JLabel();	   
	    lb9.setBounds(110+700,200 ,90, 150);
	    lb9.setBackground(new Color(155,55,53));	
	    lb9.setLayout(null);
	    lb9.setVisible(true);
	    lb9.setOpaque(true);
	   
	    
	    lb10=new JLabel();	   
	    lb10.setBounds(200+250,20 ,90, 130);
	    lb10.setBackground(new Color(155,55,53));	
	    lb10.setLayout(null);
	    lb10.setVisible(true);
	    lb10.setOpaque(true);
	    
	    
	    lb11=new JLabel();	   
	    lb11.setBounds(110,200 ,90, 150);
	    lb11.setBackground(new Color(155,55,53));	
	    lb11.setLayout(null);
	    lb11.setVisible(true);
	    lb11.setOpaque(true);
	    
	    
	    lb12=new JLabel();	   
	    lb12.setBounds(10,10 ,90,150);
	    
	   
	   lb12.setBackground(new Color(155,55,53));	
	    lb12.setLayout(null);
	    lb12.setVisible(true);
	    lb12.setOpaque(true);

	    
	    
	    cardPanel.add(lb[1],BorderLayout.PAGE_END);
	    cardPanel.repaint();
	    cardPanel.add(lb[2],BorderLayout.PAGE_END);
	    cardPanel.repaint();
	    cardPanel.add(lb[3],BorderLayout.PAGE_END);
	    cardPanel.repaint();
	    cardPanel.add(lb[3],BorderLayout.PAGE_END);
	    cardPanel.add(lb[4],BorderLayout.PAGE_END);
	    cardPanel.add(lb[5],BorderLayout.PAGE_END);
	    cardPanel.add(lb[6],BorderLayout.PAGE_END);
	    cardPanel.add(lb[7],BorderLayout.PAGE_END);
	    cardPanel.add(lb[8],BorderLayout.PAGE_END);
	    cardPanel.add(lb9,BorderLayout.PAGE_END);
	    cardPanel.add(lb10,BorderLayout.PAGE_END);
	    cardPanel.add(lb11,BorderLayout.PAGE_END);
	    cardPanel.add(lb12,BorderLayout.PAGE_END);
	    cardPanel.add(left,BorderLayout.PAGE_END);
	    cardPanel.add(right,BorderLayout.PAGE_END);
	    cardPanel.add(up,BorderLayout.PAGE_END);
	    cardPanel.add(down,BorderLayout.PAGE_END);
	    cardPanel.add(plr1,BorderLayout.PAGE_END);
	    cardPanel.add(plr2,BorderLayout.PAGE_END);
	    cardPanel.add(plr3,BorderLayout.PAGE_END);
	    cardPanel.add(user,BorderLayout.PAGE_END);
	  
	    
	    cardPanel.repaint();
	    jf.pack();
	    cardPanel.setVisible(true);
		deck=new Deck();
	
	}
	public static void main(String[] arg)
	{
		jf=new JFrame();
		Main mn=new Main();
		jf.setContentPane(mn);
		jf.setBounds(0,0,1400,700);
		jf.setLayout(null);
		jf.setVisible(true);
		//jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mouseClicked(MouseEvent arg0) {

		
	}

	public void mouseEntered(MouseEvent arg0) {

		
	}
	
	public void mouseExited(MouseEvent arg0) {
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getComponent()!=null && bidcomp && !trumpselect)
		{
			String str = null;
			//JLabel c=(JLabel) e.getComponent();
		//	lb12.setIcon(c.getIcon());
			inslbl.setText("Start play\n");
			trumpselect=true;
			//
			for(int i=1;i<9;i++)
			{
				if(e.getSource()==lb[i])
				{
					str=path[i];
					break;
				}
			}
			usr[0].trump=deck.searchCard(str);
			trumpcard=usr[0].trump;
			lb12.setIcon(new ImageIcon(new ImageIcon("./image/joker.png").getImage().getScaledInstance(lb12.getWidth(),lb12.getHeight(), Image.SCALE_SMOOTH)));
			System.out.println(str);
		
		}
		if(e.getComponent().isEnabled() && trumpselect && running && !cardselect && index<3)
		{
			//JLabel c=(JLabel) e.getComponent();
	//		user.setIcon(c.getIcon());
			String str=null;
			int in = 0;
			for(int i=1;i<9;i++)
			{
				if(e.getSource()==lb[i])
				{
					str=path[i];
					in=i;
					break;
				}
			}
			for(int j=0;j<usr[0].player.size();j++)
			{	
				if(str.equals(usr[0].player.get(j).strimage) && mask[j]==1)
				{
					table[++index]=usr[0].player.get(j);
					usr[0].player.remove(j);
					lb[in].setEnabled(false);
					user.setIcon(new ImageIcon(new ImageIcon(str).getImage().getScaledInstance(user.getWidth(),user.getHeight(), Image.SCALE_SMOOTH)));
					//	System.out.println(table[0].name+"  -------"+table[0].value);
					cardselect=true;
					cardPanel.revalidate();
					break;
				}
						
			}
			if(!cardselect){
				inslbl.append("\n!!!YOU CAN'T MOVE.......TRY ANOTHER ONE!!!");
				}
					
		}
	}
	public void mouseReleased(MouseEvent arg0) {
		
	}

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==bidBtn){
			bidTrap=false;
			bidBtn.setVisible(false);
			callList.setVisible(false);
		    callList.setEnabled(false);
		    bidBtn.setEnabled(false);
		    bidBtn.removeAll();
		    callList.removeAll();
		}
		
		//JOptionPane.showMessageDialog(btn, "thank you for using java","Question",JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource()==btn){
		gamestart=true;
		btn.setEnabled(false);
		inslbl.append("\ncard distributed....");
		deck.cardCreate();
		usr=new Player[4];
		deck.distriBute(usr);
		t.start();

		}

		
	}
	

	public void run() {
		
		int chance=0;
		table=new Card[4];
		while(gamestart)
		{
			if(gamestart && !running && !bidcomp){
		
				setIcon1();	
				inslbl.append("\nstart bid.");
				startBid();
				bidcomp=true;
				repaint();
				inslbl.update(inslbl.getGraphics());
				
			}
			else if(bidcomp && !running && gamestart){
				inslbl.append("\nbid complete.");
				inslbl.append("\nall player passes.");
				inslbl.append("\nSelect trump\n");
				while(!trumpselect){
					try {
						
						Thread.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
				setIcon2();
				running=true;
				inslbl.append("\nHighest call:"+highestBid);
			}
			else if(running && gamestart)
			{
				
				
				mask=new int[8];
				inslbl.setText("");
				while(index<3)
				{	
				if(chance%4==1 && index<3)
				{
					 up.setVisible(false);
					 down.setVisible(false);
					 left.setVisible(false);
					 right.setVisible(true);
					 try {
						 inslbl.append("\nplayer1 is calculating....");
					//	 System.out.println("mmmmmm"+table[0].name+"----"+table[0].value);
							table[++index]=deck.throwCard(usr[1],index,table,0);
							if(table[index]==null)
							{
								inslbl.append("\nPlayer 1 want to see trump");
								int dialogResult =JOptionPane.showConfirmDialog((Component)null, "Player 1 want to see trump", "Player 1 want to see trump",JOptionPane.YES_NO_OPTION);
								
								if(dialogResult == JOptionPane.YES_OPTION){
									
									lb12.setIcon(new ImageIcon(new ImageIcon(trumpcard.strimage).getImage().getScaledInstance(lb12.getWidth(),lb12.getHeight(), Image.SCALE_SMOOTH)));	
									for(int i=1;i<4;i++)
										usr[i].trump=trumpcard;
									trumpshow=true;
									table[index]= deck.throwCard(usr[1],index,table,0);
								}
							}
							plr3.setIcon(new ImageIcon(new ImageIcon(table[index].strimage).getImage().getScaledInstance(plr3.getWidth(),plr3.getHeight(), Image.SCALE_SMOOTH)));
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					 chance++;
					// break;
				}
				 if(chance%4==2 && index<3)
				 {
					 up.setVisible(true);
					 down.setVisible(false);
					 left.setVisible(false);
					 right.setVisible(false);
					 try {
						 inslbl.append("\nplayer 2 is calculating....");
						 table[++index]= deck.throwCard(usr[2],index,table,0);
							if(table[index]==null)
							{
								inslbl.append("\n......player 2 want to see trump........");	
								int dialogResult =JOptionPane.showConfirmDialog((Component)null, "Player 2 want to see trump", "Player 2 want to see trump",JOptionPane.YES_NO_OPTION);
								
								if(dialogResult == JOptionPane.YES_OPTION){
									
									lb12.setIcon(new ImageIcon(new ImageIcon(trumpcard.strimage).getImage().getScaledInstance(lb12.getWidth(),lb12.getHeight(), Image.SCALE_SMOOTH)));	
									for(int i=1;i<4;i++)
										usr[i].trump=trumpcard;
									trumpshow=true;
									table[index]= deck.throwCard(usr[2],index,table,0);
								}
							}
							plr1.setIcon(new ImageIcon(new ImageIcon(table[index].strimage).getImage().getScaledInstance(plr3.getWidth(),plr3.getHeight(), Image.SCALE_SMOOTH)));
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					 
					 chance++;
				// break;
				 }
				 if(chance%4==3 && index<3){
					 up.setVisible(false);
					 down.setVisible(false);
					 left.setVisible(true);
					 right.setVisible(false);
					 try {
						 inslbl.append("\nplayer 3 is calculating....");
						 table[++index]=deck.throwCard(usr[3],index,table,0);
							if(table[index]==null)
							{
								inslbl.append("\nPlayer 3 want to see trump");
								int dialogResult =JOptionPane.showConfirmDialog((Component)null, "Player 3 want to see trump", "Player 3 want to see trump",JOptionPane.YES_NO_OPTION);
								
								if(dialogResult == JOptionPane.YES_OPTION){		
									lb12.setIcon(new ImageIcon(new ImageIcon(trumpcard.strimage).getImage().getScaledInstance(lb12.getWidth(),lb12.getHeight(), Image.SCALE_SMOOTH)));	
									for(int i=1;i<4;i++)
										usr[i].trump=trumpcard;
									trumpshow=true;
									table[index]= deck.throwCard(usr[3],index,table,0);
								}
							}
							plr2.setIcon(new ImageIcon(new ImageIcon(table[index].strimage).getImage().getScaledInstance(plr3.getWidth(),plr3.getHeight(), Image.SCALE_SMOOTH)));
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					 chance++;
					// break;
				 }
				 if(chance%4==0 && index<3){
					 cardselect=false;
					 createMask(table);
					 inslbl.append("\nIt's your turn");
					 up.setVisible(false);
					 down.setVisible(true);
					 left.setVisible(false);
					 right.setVisible(false);
					 
						while(!cardselect){
							try {			
								Thread.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					 chance++;
					
					 
				 }
	
			}
			if(!usr[0].player.isEmpty() || !usr[3].player.isEmpty()){	
				inslbl.append("\nCalculating.......");
				try{
					chance=lookup(table,chance-1);
					index=-1;
					Thread.sleep(4530);
				}catch(Exception e){}
				user.setIcon(null);
				user.revalidate();
				plr1.setIcon(null);
				plr2.setIcon(null);
				plr3.setIcon(null);
				plr1.revalidate();
				plr2.revalidate();
				plr3.revalidate();
				}
			else{
				chance=lookup(table,chance-1);
				inslbl.setText("GAME......\n.......OVER");
				gamestart=false;
				running=false;
				bidcomp=false;
				}
			
				
			for(int i=0;i<4;i++)
				table[i]=null;
				
			}
			
			}
		}
			
			
	
		private void createMask(Card[] table2) {
		Card card;
		boolean flag=false;
		for(int i=0;i<8;i++)
			mask[i]=0;
		if(table[0]==null)
		{
			for(int i=0;i<8;i++)
				mask[i]=1;
			
		}
		else{

		for(int i=0;i<usr[0].player.size();i++)
		{
			card=usr[0].player.get(i);
			if(table[0].name==card.name)
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			for(int i=0;i<usr[0].player.size();i++)
			{
				card=usr[0].player.get(i);
				if(table[0].name==card.name)
					mask[i]=1;
				
			}
		}
		else{
			for(int i=0;i<usr[0].player.size();i++)
				mask[i]=1;
		}
		}
	}
		private int lookup(Card[] table2,int st) {
			int st1=(st-3)%4;
			int win=0;
			Card maxcard=table2[0],card;
			
			if(trumpshow)
			{
				for(int i=0;i<4;i++)
				{
					card=table2[i];
					if(card.name==trumpcard.name)
					{
						if(maxcard.name!=trumpcard.name || maxcard.value<card.value)
						{
							maxcard=card;
							win=i;
						}

					}
					else if(card.name==maxcard.name && card.value>maxcard.value)
					{
						maxcard=card;
						win=i;
					}
				}
			}
			else
			{
				for(int i=0;i<4;i++)
				{
					card=table2[i];
					if(card.name==maxcard.name && card.value>maxcard.value){
						maxcard=card;
						win=i;
					}
					
				}
			}
			
		System.out.println("WIN:"+win+"st1:"+st1);
				return (st1+win)%4;
		
		
	}
	private void startBid()  {
		callList.setVisible(true);
	    callList.setEnabled(true);
	    bidBtn.setEnabled(true);
	    bidBtn.setVisible(true);
	    inslbl.append("\nSelect Call");
		System.out.println(callList.getSelectedItem());
		while(bidTrap!=false){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		highestBid=(int) callList.getSelectedItem();
		
		
		
	}
	private void setIcon1() {
		lb[1].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(0)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[2].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(1)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[3].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(2)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[4].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(3)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb9.setIcon(new ImageIcon(new ImageIcon("./image/back.jpg").getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb10.setIcon(new ImageIcon(new ImageIcon("./image/back.jpg").getImage().getScaledInstance(lb10.getWidth(),lb10.getHeight(), Image.SCALE_SMOOTH)));
		lb11.setIcon(new ImageIcon(new ImageIcon("./image/back.jpg").getImage().getScaledInstance(lb11.getWidth(),lb11.getHeight(), Image.SCALE_SMOOTH)));
		
		lb12.setText("TRUMP");
		repaint();
		path[1]=usr[0].getImage(0);
		path[2]=usr[0].getImage(1);
		path[3]=usr[0].getImage(2);
		path[4]=usr[0].getImage(3);
		
	}
	private void setIcon2() {
	
		lb[5].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(4)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[6].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(5)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[7].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(6)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		lb[8].setIcon(new ImageIcon(new ImageIcon(usr[0].getImage(7)).getImage().getScaledInstance(lb[1].getWidth(),lb[1].getHeight(), Image.SCALE_SMOOTH)));
		repaint();
		path[5]=usr[0].getImage(4);
		path[6]=usr[0].getImage(5);
		path[7]=usr[0].getImage(6);
		path[8]=usr[0].getImage(7);
		
	}

	
}

