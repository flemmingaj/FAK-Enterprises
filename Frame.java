import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
// ####################################
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// ####################################
class Frame extends JFrame implements ActionListener,  MouseListener, MouseMotionListener{

	//************************************************
	// start screen elements
	JButton start = new JButton("START");
	JPanel StartScreen = new JPanel();
	boolean startVisited; 
	JLabel StartTitle = new JLabel("BASH");
	JPanel StartCenter = new JPanel();
	//************************************************
	// sign-in screen elements 
	JPanel SigninScreen = new JPanel();
	JTextField SigninTF = new JTextField();
	JButton TFButton = new JButton("ENTER");
	boolean signinVisited;
	JLabel SigninTitle = new JLabel("SIGN-IN");
	JPanel SigninCenter = new JPanel();
	//************************************************
	// menu screen elements 
	JPanel MenuScreen = new JPanel();
	JPanel MenuCenter = new JPanel();
	JButton BashMSButton = new JButton("BASH");
	JButton ChessMSButton = new JButton("Chess");
	JButton StatMSButton = new JButton("Stats");
	JButton OptionsMSButton = new JButton("Options");
	JButton SignoutMSButton = new JButton("SIGN-OUT");
	boolean menuVisited;
	JLabel MenuTitle = new JLabel("MAIN MENU");
	ImageIcon MainMenuCrown = new ImageIcon("MainMenuCrown.png");
	JLabel MMCrown = new JLabel();
	//boolean menuVisited = false;
	//************************************************
	// Bash screen elements (1 of 3)
	JPanel BashScreen = new JPanel();
	boolean bashVisited;
	JLabel BashTitle = new JLabel("BASH");
	JButton BashBackButton = new JButton("BACK");
	//************************************************
	// cards screen elements (2 of 3)
	//************************************************
	// Bash Game board (3 of 3)
	//************************************************
	// chess Game Board 
	JPanel chessBackground = new JPanel();
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	JPanel chessCenter = new JPanel();
	//************************************************
	// stats page elements 
	JPanel StatScreen = new JPanel();
	boolean statVisited;
	JLabel StatTitle = new JLabel("STATS");
	JButton StatBackButton = new JButton("BACK");
	JPanel StatCenter = new JPanel();
	//************************************************
	// options page elements 
	JPanel OptionScreen = new JPanel();
	JButton OptionBackButton = new JButton("BACK");
	boolean optionVisited;
	JLabel OptionTitle = new JLabel("OPTIONS");
	JPanel OptionCenter = new JPanel();
	//************************************************
	// Menu sub panels
	JPanel MenuNorth = new JPanel();
	JPanel MenuSouth = new JPanel();
	JPanel MenuEast = new JPanel();
	JPanel MenuWest = new JPanel();
	//************************************************
	Frame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1000, 1000);
		this.setTitle("Bash V 1.0");
		ImageIcon logo = new ImageIcon("Wrook.png");
		this.setIconImage(logo.getImage());
		startScreen(startVisited);
	}
	
	//checks what button was clicked and sends user to the proper menu screen
		public void actionPerformed(ActionEvent e) {
			//Start Screen actions
			if(e.getSource() == start) {
				StartScreen.setVisible(false);
				signinScreen(signinVisited);
			}
				
			
			//Sign-in screen actions
			if(e.getSource()== TFButton) {
				System.out.println("Welcome " + SigninTF.getText());
				SigninScreen.setVisible(false);
				mainMenu(menuVisited);	
			}
			
			//Menu screen actions
			if(e.getSource() == BashMSButton) {
				MenuScreen.setVisible(false);
				bashScreen(bashVisited);
			}
				
			
			if(e.getSource() == ChessMSButton) {
				MenuScreen.setVisible(false);
				chessBoard();
			}
				
			
			if(e.getSource() == StatMSButton) {
				MenuScreen.setVisible(false);
				statScreen(statVisited);
			}
				
			
			if(e.getSource() == OptionsMSButton) {
				MenuScreen.setVisible(false);
				optionScreen(optionVisited);
			}
			
			if(e.getSource()== SignoutMSButton) {
				MenuScreen.setVisible(false);
				startScreen(startVisited);
			}
			
			//Option screen
			if(e.getSource()== OptionBackButton) {
				OptionScreen.setVisible(false);
				mainMenu(menuVisited);
			}
			
			//Stats screen
			if(e.getSource() == StatBackButton) {
				StatScreen.setVisible(false);
				mainMenu(menuVisited);
			}
			
			//bash screen
			if(e.getSource() == BashBackButton) {
				BashScreen.setVisible(false);
				mainMenu(menuVisited);
			}
				
		}
	
	// creates the start screen 
	public void startScreen(boolean visited) {
		if(visited == false) {
		MenuNorth.setBackground(new Color(50,50,50));
		MenuSouth.setBackground(new Color(50,50,50));
		MenuEast.setBackground(new Color(50,50,50));
		MenuWest.setBackground(new Color(50,50,50));
		StartCenter.setBackground(new Color(0X99004C));
	    MenuNorth.setPreferredSize(new Dimension(100,100));
		MenuSouth.setPreferredSize(new Dimension(100,100));
		MenuEast.setPreferredSize(new Dimension(170,100));
		MenuWest.setPreferredSize(new Dimension(170,100));
		StartCenter.setPreferredSize(new Dimension(500,500));
		StartScreen.setLayout(new BorderLayout());
		StartScreen.add(MenuNorth, BorderLayout.NORTH);
		StartScreen.add(MenuSouth, BorderLayout.SOUTH);
		StartScreen.add(MenuEast, BorderLayout.EAST);
		StartScreen.add(MenuWest, BorderLayout.WEST);
		StartScreen.add(StartCenter, BorderLayout.CENTER);
		start.setBounds(200,100,100,10);
		start.addActionListener(this);
		StartCenter.add(start);
		StartTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		StartCenter.add(StartTitle);
		this.add(StartScreen);
		startVisited = true;
		}
		else {
			StartScreen.add(MenuNorth, BorderLayout.NORTH);
			StartScreen.add(MenuSouth, BorderLayout.SOUTH);
			StartScreen.add(MenuEast, BorderLayout.EAST);
			StartScreen.add(MenuWest, BorderLayout.WEST);
			StartScreen.add(StartCenter, BorderLayout.CENTER);
			StartScreen.setVisible(true);
		}
	}
	
	// disables the sign-in screen and creates the main menu screen 
	public void mainMenu(boolean visited) {
		if(visited == false) {
		 MenuCenter.setBackground(new Color(0X99004C));
		 MenuCenter.setPreferredSize(new Dimension(500,500));
		 MenuScreen.setLayout(new BorderLayout());
		 MenuScreen.add(MenuNorth, BorderLayout.NORTH);
		 MenuScreen.add(MenuSouth, BorderLayout.SOUTH);
		 MenuScreen.add(MenuEast, BorderLayout.EAST);
		 MenuScreen.add(MenuWest, BorderLayout.WEST);
		 MenuScreen.add(MenuCenter, BorderLayout.CENTER);
		 MMCrown.setIcon(MainMenuCrown);
		 MenuCenter.add(MMCrown);
		 MenuCenter.add(MenuTitle);
		 MenuTitle.setFont(new Font("MV Boli", Font.BOLD, 20));
		 MenuCenter.add(BashMSButton);
		 BashMSButton.addActionListener(this);
		 MenuCenter.add(ChessMSButton);
		 ChessMSButton.addActionListener(this);
		 MenuCenter.add(StatMSButton);
		 StatMSButton.addActionListener(this);
		 MenuCenter.add(OptionsMSButton);
		 OptionsMSButton.addActionListener(this);
		 MenuCenter.add(SignoutMSButton);
		 SignoutMSButton.addActionListener(this);
		 this.add(MenuScreen, BorderLayout.CENTER);
		 menuVisited = true;
		}
		else {
			MenuScreen.add(MenuNorth, BorderLayout.NORTH);
			MenuScreen.add(MenuSouth, BorderLayout.SOUTH);
			MenuScreen.add(MenuEast, BorderLayout.EAST);
			MenuScreen.add(MenuWest, BorderLayout.WEST);
			MenuScreen.add(MenuCenter, BorderLayout.CENTER);
			MenuScreen.setVisible(true);
		}
	}
	
	public void bashScreen(boolean visited) {
		if(visited == false) {
		 BashScreen.setBackground(new Color(0X99004C));
		 BashScreen.add(BashBackButton);
		 BashBackButton.addActionListener(this);
		 BashTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		 BashScreen.add(BashTitle);
		 this.add(BashScreen, BorderLayout.CENTER);
		 bashVisited = true;
		}
		else {
			BashScreen.setVisible(true);
		}
		
	}
	
	public void chessBoard() {
		 //ChessGameBoard.setBackground(Color.ORANGE);
		 //this.add(ChessGameBoard, BorderLayout.CENTER);
		chessGameDemo();
	}
	
	public void statScreen(boolean visited) {
		if(visited == false) {
		 StatCenter.setBackground(new Color(0X99004C));
		 StatCenter.setPreferredSize(new Dimension(500,500));
		 StatScreen.setLayout(new BorderLayout());
		 StatScreen.add(MenuNorth, BorderLayout.NORTH);
		 StatScreen.add(MenuSouth, BorderLayout.SOUTH);
		 StatScreen.add(MenuEast, BorderLayout.EAST);
		 StatScreen.add(MenuWest, BorderLayout.WEST);
		 StatScreen.add(StatCenter, BorderLayout.CENTER);
		 StatTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		 StatCenter.add(StatTitle);
		 StatCenter.add(StatBackButton);
		 StatBackButton.addActionListener(this);
		 this.add(StatScreen, BorderLayout.CENTER);
		 statVisited = true;
		}
		else {
			StatScreen.add(MenuNorth, BorderLayout.NORTH);
			StatScreen.add(MenuSouth, BorderLayout.SOUTH);
			StatScreen.add(MenuEast, BorderLayout.EAST);
			StatScreen.add(MenuWest, BorderLayout.WEST);
			StatScreen.add(StatCenter, BorderLayout.CENTER);
			StatScreen.setVisible(true);
		}
		
	}
	
	public void optionScreen(boolean visited) {
		if(visited == false) {
		 OptionCenter.setBackground(new Color(0X99004C));
		 OptionCenter.setPreferredSize(new Dimension(500,500));
		 OptionScreen.setLayout(new BorderLayout());
		 OptionScreen.add(MenuNorth, BorderLayout.NORTH);
		 OptionScreen.add(MenuSouth, BorderLayout.SOUTH);
		 OptionScreen.add(MenuEast, BorderLayout.EAST);
		 OptionScreen.add(MenuWest, BorderLayout.WEST);
		 OptionScreen.add(OptionCenter, BorderLayout.CENTER);
		 OptionCenter.add(OptionBackButton);
		 OptionBackButton.addActionListener(this);
		 OptionTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		 OptionCenter.add(OptionTitle);
		 this.add(OptionScreen, BorderLayout.CENTER);
		 optionVisited = true;
		}
		else {
			OptionScreen.add(MenuNorth, BorderLayout.NORTH);
			OptionScreen.add(MenuSouth, BorderLayout.SOUTH);
			OptionScreen.add(MenuEast, BorderLayout.EAST);
			OptionScreen.add(MenuWest, BorderLayout.WEST);
			OptionScreen.add(OptionCenter, BorderLayout.CENTER);
			OptionScreen.setVisible(true);
		}
	}
	
	// disables the sign-in screen and creates the main menu screen 
		public void signinScreen(boolean visited) {
			if(visited == false) {
			 SigninCenter.setBackground(new Color(0X99004C));
			 SigninCenter.setPreferredSize(new Dimension(500,500));
			 SigninScreen.setLayout(new BorderLayout());
			 SigninScreen.add(MenuNorth, BorderLayout.NORTH);
			 SigninScreen.add(MenuSouth, BorderLayout.SOUTH);
			 SigninScreen.add(MenuEast, BorderLayout.EAST);
			 SigninScreen.add(MenuWest, BorderLayout.WEST);
			 SigninScreen.add(SigninCenter, BorderLayout.CENTER);
			 SigninTF.setPreferredSize(new Dimension(250, 40));
			 SigninTF.setFont(new Font("Consolas", Font.BOLD,35));
		     SigninTF.setForeground(Color.BLUE);
		     SigninTF.setBackground(Color.BLACK);
		     SigninTF.setCaretColor(Color.BLUE);
			 SigninCenter.add(SigninTF);
			 SigninCenter.add(TFButton);
			 TFButton.addActionListener(this);
			 SigninTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
			 SigninCenter.add(SigninTitle);
			 this.add(SigninScreen, BorderLayout.CENTER);
			 signinVisited = true;
			}
			else {
				SigninScreen.add(MenuNorth, BorderLayout.NORTH);
				SigninScreen.add(MenuSouth, BorderLayout.SOUTH);
				SigninScreen.add(MenuEast, BorderLayout.EAST);
				SigninScreen.add(MenuWest, BorderLayout.WEST);
				SigninScreen.add(SigninCenter, BorderLayout.CENTER);
				SigninScreen.setVisible(true);
			}
		}
		// ########################### TEST #########################
		 
		  public void chessGameDemo(){
		  
	      Dimension boardSize = new Dimension(600, 600);
		  //  Use a Layered Pane for this this application
		  layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);
		  chessBackground.setLayout(new BorderLayout());
		  chessBackground.add(MenuNorth, BorderLayout.NORTH);
		  chessBackground.add(MenuSouth, BorderLayout.SOUTH);
		  chessBackground.add(MenuEast, BorderLayout.EAST);
	      chessBackground.add(MenuWest, BorderLayout.WEST);
		  chessBackground.add(chessCenter, BorderLayout.CENTER);
          chessCenter.setBackground(new Color(50, 50, 50));
		  chessCenter.add(layeredPane);
		  
		  
		  this.add(chessBackground);
		  //Add a chess board to the Layered Pane 
		 
		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout());
		  chessBoard.add( square );
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? new Color(0xFFD700) :new Color(0X99004C) ); // 1     Bash
		  else
		  square.setBackground( i % 2 == 0 ? new Color(0X99004C) : new Color(0xFFD700) ); //Bash     1
		  }
		 
		  //Add pieces to the board
		  JLabel piece = new JLabel( new ImageIcon("Brook.png") );
		  JPanel panel = (JPanel)chessBoard.getComponent(0);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Bknight.png") );
		  panel = (JPanel)chessBoard.getComponent(1);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Bbishop.png") );
		  panel = (JPanel)chessBoard.getComponent(2);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Bqueen.png") );
		  panel = (JPanel)chessBoard.getComponent(3);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Bking.png") );
		  panel = (JPanel)chessBoard.getComponent(4);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Bbishop.png") );
		  panel = (JPanel)chessBoard.getComponent(5);
		  panel.add(piece);
		  
		  piece = new JLabel(new ImageIcon("Bknight.png"));
		  panel = (JPanel)chessBoard.getComponent(6);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Brook.png") );
		  panel = (JPanel)chessBoard.getComponent(7);
		  panel.add(piece);
		  
		  for(int i = 8; i < 16; i++) {
			  piece = new JLabel( new ImageIcon("Bpawn.png") );
			  panel = (JPanel)chessBoard.getComponent(i);
			  panel.add(piece);
		  }
		  
		  for(int i = 48; i < 56; i++) {
			  piece = new JLabel( new ImageIcon("Wpawn.png") );
			  panel = (JPanel)chessBoard.getComponent(i);
			  panel.add(piece);
		  }
		  
		  piece = new JLabel( new ImageIcon("Wrook.png") );
		  panel = (JPanel)chessBoard.getComponent(56);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wknight.png") );
		  panel = (JPanel)chessBoard.getComponent(57);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wbishop.png") );
		  panel = (JPanel)chessBoard.getComponent(58);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wqueen.png") );
		  panel = (JPanel)chessBoard.getComponent(59);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wking.png") );
		  panel = (JPanel)chessBoard.getComponent(60);
		  panel.add(piece);
		  
		  piece = new JLabel(new ImageIcon("Wbishop.png"));
		  panel = (JPanel)chessBoard.getComponent(61);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wknight.png") );
		  panel = (JPanel)chessBoard.getComponent(62);
		  panel.add(piece);
		  
		  piece = new JLabel( new ImageIcon("Wrook.png") );
		  panel = (JPanel)chessBoard.getComponent(63);
		  panel.add(piece);
		  
		 
		  }
		 
		  public void mousePressed(MouseEvent e){
		  chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JPanel) 
		  return;
		 
		  Point parentLocation = c.getParent().getLocation();
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		  }
		 
		  //Move the chess piece around
		  
		  public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) return;
		 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		 }
		 
		  //Drop the chess piece back onto the chess board
		 
		  public void mouseReleased(MouseEvent e) {
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
		  }
		  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
		  }
		 
		  chessPiece.setVisible(true);
		  }
		 
		  public void mouseClicked(MouseEvent e) {
		  
		  }
		  public void mouseMoved(MouseEvent e) {
		 }
		  public void mouseEntered(MouseEvent e){
		  
		  }
		  public void mouseExited(MouseEvent e) {
		  
		  }
	

}
