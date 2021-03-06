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
import java.io.IOException;
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
	JLayeredPane StartLayered = new JLayeredPane();
	JPanel StartDesign = new JPanel();
	JPanel StartDrag = new JPanel();
	JLabel StartImg = new JLabel();
	//************************************************
	// sign-in screen elements 
	JPanel SigninScreen = new JPanel();
	JLabel SigninUser = new JLabel("Username: ");
	JLabel SigninPass = new JLabel("Password: ");
	JTextField SigninTF = new JTextField();
	JTextField SigninTF2 = new JTextField();
	JButton TFButton = new JButton("ENTER");
	JButton guestButton = new JButton("Sign-in as Guest");
	JButton createAccount = new JButton("CREATE ACCOUNT");
	boolean signinVisited;
	JLabel SigninTitle = new JLabel("SIGN-IN");
	JPanel SigninCenter = new JPanel();
	ImageIcon SignoutIcon =loadImage("/imgs/Wking.png");
	JLayeredPane SigninLayered = new JLayeredPane();
	JPanel SigninDesign = new JPanel();
	JPanel SigninDrag = new JPanel();
	//************************************************
	// create account elements
	JPanel createAccountScreen = new JPanel();
	JLabel username = new JLabel ("Username: ");
	JLabel password = new JLabel ("Password: ");
	JTextField accountName = new JTextField();
	JTextField accountPassword = new JTextField();
	JButton createButton = new JButton("CREATE");
	JButton goBackButton = new JButton("EXIT");
	boolean createVisited;
	JLabel createAccountTitle = new JLabel("CREATE ACCOUNT");
	JPanel createAccountCenter = new JPanel();
	JLayeredPane createAccountLayered = new JLayeredPane();
	JPanel createAccountDesign = new JPanel();
	JPanel createAccountDrag = new JPanel();
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
	ImageIcon MenuIcon =loadImage("/imgs/Wpawn.png");
	JLabel MenuImg = new JLabel();
	JLayeredPane MenuLayered = new JLayeredPane();
	JPanel MenuDesign = new JPanel();
	JPanel MenuDrag = new JPanel();
	//boolean menuVisited = false;
	//************************************************
	// Bash screen elements (1 of 3)
	JPanel BashScreen = new JPanel();
	boolean bashVisited;
	JLabel BashTitle = new JLabel("COMING SOON");
	JButton BashBackButton = new JButton("BACK");
	ImageIcon BashIcon = loadImage("/imgs/Wknight.png");
	JPanel BashCenter = new JPanel();
	JLayeredPane BashLayered = new JLayeredPane();
	JPanel BashDesign = new JPanel();
	JPanel BashDrag = new JPanel();
	//************************************************
	// cards screen elements (2 of 3)
	//************************************************
	// Bash Game board (3 of 3)
	//************************************************
	// chess Game Board 
	JPanel chessBackground = new JPanel();
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JPanel chessBoardIndex;
	JLabel chessPiece;
	int xAdjustment;
	int yAdjustment;
	JPanel chessCenter = new JPanel();
	ImageIcon ChessIcon =loadImage("/imgs/Wqueen.png");
	JButton ExitToMain = new JButton("EXIT");
	JButton ResetBoard = new JButton("Reset");
	//************************************************
	// stats page elements 
	JPanel StatScreen = new JPanel();
	boolean StatVisited;
	JLabel StatTitle = new JLabel("STATS");
	JButton StatBackButton = new JButton("BACK");
	JLabel StatPawn = new JLabel("Pawns captured: ");
	JLabel StatRook = new JLabel("Rooks captured: ");
	JLabel StatBishop = new JLabel("Bishops captured: ");
	JLabel StatKnight = new JLabel("Knights captured: ");
	JLabel StatQueen = new JLabel("Queens captured: ");
	JLabel StatKing = new JLabel("Kings captured: ");
	JLabel StatWins = new JLabel("Wins: ");
	JPanel StatCenter = new JPanel();
	ImageIcon StatIcon =loadImage("/imgs/Wbishop.png");
	JLayeredPane StatLayered = new JLayeredPane();
	JPanel StatDesign = new JPanel();
	JPanel StatDrag = new JPanel();
	//************************************************
	// options page elements 
	JPanel OptionsScreen = new JPanel();
	JButton OptionsBackButton = new JButton("BACK");
	boolean optionsVisited;
	JLabel OptionsTitle = new JLabel("OPTIONS");
	JPanel OptionsCenter = new JPanel();
	JTextField OptionsChangeTF = new JTextField();
	JButton OptionsChangeButton = new JButton("CHANGE NAME");
	//JButton red = new JButton("RED");
	//JButton blue = new JButton("BLUE");
	//JButton def = new JButton("DEFAULT");
	ImageIcon OptionsIcon =loadImage("/imgs/Wrook.png");
	JLayeredPane OptionsLayered = new JLayeredPane();
	JPanel OptionsDesign = new JPanel();
	JPanel OptionsDrag = new JPanel();
	//************************************************
	// Menu sub panels
	JPanel MenuNorth = new JPanel();
	JPanel MenuSouth = new JPanel();
	JPanel MenuEast = new JPanel();
	JPanel MenuWest = new JPanel();
	ImageIcon Img;
	JLabel User = new JLabel();
	JLayeredPane NorthLayered = new JLayeredPane();
	JPanel NorthDesign = new JPanel();
	JPanel NorthDrag = new JPanel();
	
	//************************************************
	Frame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("Bash V 1.0");
		ImageIcon logo = new ImageIcon("Wqueen.png");
		this.setIconImage(logo.getImage());
		startScreen(startVisited);
	}
	public ImageIcon loadImage(String s) {
		try {
			Img = new ImageIcon(Frame.class.getResource(s));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Img;
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
				User.setText("User: " + SigninTF.getText());
				System.out.println("Welcome " + SigninTF.getText());
				SigninScreen.setVisible(false);
				mainMenu(menuVisited);	
			}
			if(e.getSource() == guestButton) {
				User.setText("User: Guest");
				System.out.println("Welcome Guest");
				SigninScreen.setVisible(false);
				mainMenu(menuVisited);
			}
			
			if(e.getSource() == createAccount) {
				SigninScreen.setVisible(false);
				createAccountScreen(createVisited);
			}
			
			if(e.getSource() == OptionsChangeButton) {
				String n = OptionsChangeTF.getText();
				System.out.println(n);
				if(n != "") {
					User.setText(n);
					OptionsChangeTF.setText("");
					OptionsScreen.setVisible(false);
					mainMenu(menuVisited);
				}
				else {
					System.out.println("Please enter a username");
				}
			}
			//Create account screen actions
			if(e.getSource() == createButton) {
				String name = accountName.getText();
				String pw = accountPassword.getText();
				if(name != "" && pw != "") {
					account u = new account(name, pw);
					User.setText(name);
					createAccountScreen.setVisible(false);
					mainMenu(menuVisited);
				}
				else {
					System.out.println("Username and password cannot be empty");
				}
			}
			
			if(e.getSource() == goBackButton) {
				createAccountScreen.setVisible(false);
				signinScreen(signinVisited);
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
				statScreen(StatVisited);
			}
				
			
			if(e.getSource() == OptionsMSButton) {
				MenuScreen.setVisible(false);
				optionScreen(optionsVisited);
			}
			
			if(e.getSource()== SignoutMSButton) {
				User.setText("");
				MenuDrag.remove(User);
				MenuScreen.setVisible(false);
				startScreen(startVisited);
			}
			
			//Option screen
			if(e.getSource()== OptionsBackButton) {
				OptionsScreen.setVisible(false);
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
			// chess screen
			if(e.getSource() == ExitToMain) {
				chessBackground.setVisible(false);
				layeredPane.removeAll();
				chessBackground.removeAll();
				chessCenter.removeAll();
				ExitToMain.setVisible(false);
				ResetBoard.setVisible(false);
				mainMenu(menuVisited);
			}
			if(e.getSource() == ResetBoard) {
				chessBackground.setVisible(false);
				layeredPane.removeAll();
				chessBackground.removeAll();
				chessCenter.removeAll();
				ExitToMain.setVisible(false);
				ResetBoard.setVisible(false);
				chessGameDemo();
			}
				
		}
	
	// creates the start screen 
	public void startScreen(boolean visited) {
		if(visited == false) {
		MenuNorth.setBackground(new Color(50,50,50));
		MenuSouth.setBackground(new Color(50,50,50));
		MenuEast.setBackground(new Color(50,50,50));
		MenuWest.setBackground(new Color(50,50,50));
		StartCenter.setBackground(new Color(50,50,50));
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
		//start elements
		StartCenter.add(StartLayered);
		StartLayered.setPreferredSize(new Dimension(1200,1200));
		StartLayered.add(StartDesign, Integer.valueOf(0)); // bottom layer
		StartLayered.add(StartDrag, Integer.valueOf(1)); // top layer
		StartDrag.setOpaque(false);
		StartDrag.setBounds(0, 0, 1200, 1200);
		StartDrag.setLayout(null);
		start.addActionListener(this);
		StartDrag.add(start);
		start.setForeground(Color.white);
		start.setBackground(Color.black);
		StartImg.setText("BASH");
		StartImg.setFont(new Font("MV Boli", Font.BOLD, 40));
		StartImg.setForeground(Color.white);
		StartImg.setIcon(BashIcon);
		StartImg.setVerticalTextPosition(JLabel.BOTTOM);
		StartImg.setHorizontalTextPosition(JLabel.CENTER);
		StartDrag.add(StartImg);
		// spacing of start elements
		StartImg.setBounds(560, 200, 325, 150);
		start.setBounds(450,350,350,100);
		// start design
		 StartDesign.setLayout( new GridLayout(24, 24) );
		 StartDesign.setBounds(0, 0, 1200, 1200);
		 for(int i = 0; i < 24; i++) {
			  for(int j = 0; j < 24; j++ ) {
				  JPanel square = new JPanel( new BorderLayout());
				  StartDesign.add( square );
				  int row = i % 2;
				  if (row == 0)
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Bash
				  else
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Bash     1     
				 
				  
			  }
		  }
		this.add(StartScreen);
		startVisited = true;
		}
		else {
			StartScreen.add(MenuNorth, BorderLayout.NORTH);
			StartScreen.add(MenuSouth, BorderLayout.SOUTH);
			StartScreen.add(MenuEast, BorderLayout.EAST);
			StartScreen.add(MenuWest, BorderLayout.WEST);
			StartScreen.add(StartCenter, BorderLayout.CENTER);
			MenuNorth.setBackground(new Color(50,50,50));
			StartImg.setText("BASH");
			StartImg.setFont(new Font("MV Boli", Font.BOLD, 40));
			StartImg.setForeground(Color.white);
			StartImg.setIcon(BashIcon);
			StartImg.setVerticalTextPosition(JLabel.BOTTOM);
			StartImg.setHorizontalTextPosition(JLabel.CENTER);
			StartDrag.add(StartImg);
			StartImg.setBounds(560, 200, 325, 150);
			StartScreen.setVisible(true);
		}
	}
	
	// disables the sign-in screen and creates the main menu screen 
	public void mainMenu(boolean visited) {
		if(visited == false) {
		 MenuCenter.setPreferredSize(new Dimension(1500,1500));
		 MenuScreen.setLayout(new BorderLayout());
		 MenuScreen.add(MenuNorth, BorderLayout.NORTH);
		 MenuScreen.add(MenuSouth, BorderLayout.SOUTH);
		 MenuScreen.add(MenuEast, BorderLayout.EAST);
		 MenuScreen.add(MenuWest, BorderLayout.WEST);
		 MenuScreen.add(MenuCenter, BorderLayout.CENTER);
		 MenuCenter.add(MenuLayered);
		 MenuCenter.setBackground(new Color(50, 50, 50));
		 MenuLayered.setPreferredSize(new Dimension(1200,1200));
		 MenuLayered.add(MenuDesign, Integer.valueOf(0)); // bottom layer
		 MenuLayered.add(MenuDrag, Integer.valueOf(1)); // top layer
		 // Main Menu elements 
		 MenuDrag.setOpaque(false);
		 MenuDrag.setBounds(0, 0, 1200, 1200);
		 MenuDrag.setLayout(null);
		 MenuImg.setIcon(MenuIcon);
		 MenuImg.setText("MAIN MENU");
		 MenuDrag.add(MenuImg);
		 MenuImg.setFont(new Font("MV Boli", Font.BOLD, 40));
		 MenuImg.setForeground(Color.white);
		 MenuDrag.add(User);
		 User.setFont(new Font("MV Boli", Font.BOLD, 20));
		 User.setForeground(Color.white);
		 //chess button
		 MenuDrag.add(ChessMSButton);
		 ChessMSButton.addActionListener(this);
		 ChessMSButton.setIcon(ChessIcon);
		 ChessMSButton.setForeground(Color.white);
		 ChessMSButton.setBackground(Color.black);
		 // stats button 
		 MenuDrag.add(StatMSButton);
		 StatMSButton.addActionListener(this);
		 StatMSButton.setIcon(StatIcon);
		 StatMSButton.setForeground(Color.white);
		 StatMSButton.setBackground(Color.black);
		 // bash button
		 MenuDrag.add(BashMSButton);
		 BashMSButton.addActionListener(this);
		 BashMSButton.setIcon(BashIcon);
		 BashMSButton.setForeground(Color.white);
		 BashMSButton.setBackground(Color.black);
		 // options button
		 MenuDrag.add(OptionsMSButton);
		 OptionsMSButton.addActionListener(this);
		 OptionsMSButton.setIcon(OptionsIcon);
		 OptionsMSButton.setForeground(Color.white);
		 OptionsMSButton.setBackground(Color.black);
		 // sign-out button 
		 MenuDrag.add(SignoutMSButton);
		 SignoutMSButton.addActionListener(this);
		// SignoutMSButton.setIcon(SignoutIcon);
		 SignoutMSButton.setForeground(Color.white);
		 SignoutMSButton.setBackground(Color.black);
		 // spacing of menu elements 
		 User.setBounds(10, 10, 250,50);// x, y, width, height
		 MenuImg.setBounds(10, 50, 350, 100); // x, y, width, height
		 ChessMSButton.setBounds(25, 150,  150, 70);
		 BashMSButton.setBounds(25, 250, 150, 70);
		 StatMSButton.setBounds(25,  350, 150, 70);
		 OptionsMSButton.setBounds(25, 450, 150, 70);
		 SignoutMSButton.setBounds(25,550, 150,70);
		 // menu design 
		 // menu design 
		 MenuDesign.setLayout( new GridLayout(24, 24) );
		 MenuDesign.setBounds(0, 0, 1200, 1200);
		 for(int i = 0; i < 24; i++) {
			  for(int j = 0; j < 24; j++ ) {
				  JPanel square = new JPanel( new BorderLayout());
				  MenuDesign.add( square );
				  int row = i % 2;
				  if (row == 0)
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Bash
				  else
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Bash     1     
				 
				  
			  }
		  }
		 //************************
		 
		 this.add(MenuScreen);
		 menuVisited = true;
		}
		else {
			MenuScreen.add(MenuNorth, BorderLayout.NORTH);
			MenuScreen.add(MenuSouth, BorderLayout.SOUTH);
			MenuScreen.add(MenuEast, BorderLayout.EAST);
			MenuScreen.add(MenuWest, BorderLayout.WEST);
			MenuScreen.add(MenuCenter, BorderLayout.CENTER);
			MenuDrag.add(User);
			User.setFont(new Font("MV Boli", Font.BOLD, 20));
		    User.setForeground(Color.white);
		    User.setBounds(10, 10, 250,50);// x, y, width, height
			MenuScreen.setVisible(true);
		}
	}
	
	public void bashScreen(boolean visited) {
		if(visited == false) {
			BashCenter.setBackground(new Color(50,50,50));
		  /*  MenuNorth.setPreferredSize(new Dimension(100,100));
			MenuSouth.setPreferredSize(new Dimension(100,100));
			MenuEast.setPreferredSize(new Dimension(170,100));
			MenuWest.setPreferredSize(new Dimension(170,100));*/
			BashCenter.setPreferredSize(new Dimension(500,500));
			BashScreen.setLayout(new BorderLayout());
			BashScreen.add(MenuNorth, BorderLayout.NORTH);
			BashScreen.add(MenuSouth, BorderLayout.SOUTH);
			BashScreen.add(MenuEast, BorderLayout.EAST);
			BashScreen.add(MenuWest, BorderLayout.WEST);
			BashScreen.add(BashCenter, BorderLayout.CENTER);
			MenuNorth.setBackground(new Color(0x153c7a));
			//Bash elements
			BashCenter.add(BashLayered);
			BashLayered.setPreferredSize(new Dimension(1200,1200));
			BashLayered.add(BashDesign, Integer.valueOf(0)); // bottom layer
			BashLayered.add(BashDrag, Integer.valueOf(1)); // top layer
			BashDrag.setOpaque(false);
			BashDrag.setBounds(0, 0, 1200, 1200);
			BashDrag.setLayout(null);
			BashBackButton.addActionListener(this);
			BashDrag.add(BashBackButton);
			BashBackButton.setForeground(Color.white);
			BashBackButton.setBackground(Color.black);
			BashTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
			BashTitle.setForeground(Color.white);
			BashDrag.add(BashTitle);
			// spacing of Bash elements
			BashTitle.setBounds(465, 200, 325, 150);
			BashBackButton.setBounds(10, 10, 100, 50);
			// Bash design
			 BashDesign.setLayout( new GridLayout(24, 24) );
			 BashDesign.setBounds(0, 0, 1200, 1200);
			 for(int i = 0; i < 24; i++) {
				  for(int j = 0; j < 24; j++ ) {
					  JPanel square = new JPanel( new BorderLayout());
					  BashDesign.add( square );
					  int row = i % 2;
					  if (row == 0)
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Bash
					  else
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Bash     1     
					 
					  
				  }
			  }
			this.add(BashScreen);
			bashVisited = true;
		}
		else {
			BashScreen.setVisible(true);
			MenuNorth.setBackground(new Color(0x153c7a));
		}
		
	}
	
	public void chessBoard() {
		 //ChessGameBoard.setBackground(Color.ORANGE);
		 //this.add(ChessGameBoard, BorderLayout.CENTER);
		chessGameDemo();
	}
	
	public void statScreen(boolean visited) {
		if(visited == false) {
		StatCenter.setBackground(new Color(50,50,50));
		/*MenuNorth.setPreferredSize(new Dimension(100,100));
		MenuSouth.setPreferredSize(new Dimension(100,100));
		MenuEast.setPreferredSize(new Dimension(170,100));
		MenuWest.setPreferredSize(new Dimension(170,100)); */
		StatCenter.setPreferredSize(new Dimension(500,500));
		StatScreen.setLayout(new BorderLayout());
		StatScreen.add(MenuNorth, BorderLayout.NORTH);
		StatScreen.add(MenuSouth, BorderLayout.SOUTH);
		StatScreen.add(MenuEast, BorderLayout.EAST);
		StatScreen.add(MenuWest, BorderLayout.WEST);
		StatScreen.add(StatCenter, BorderLayout.CENTER);
		//Stat elements
		StatCenter.add(StatLayered);
		StatLayered.setPreferredSize(new Dimension(1200,1200));
		StatLayered.add(StatDesign, Integer.valueOf(0)); // bottom layer
		StatLayered.add(StatDrag, Integer.valueOf(1)); // top layer
		StatDrag.setOpaque(false);
		StatDrag.setBounds(0, 0, 1200, 1200);
		StatDrag.setLayout(null);
		StatBackButton.addActionListener(this);
		StatDrag.add(StatBackButton);
		StatBackButton.setForeground(Color.white);
		StatBackButton.setBackground(Color.black);
		StatTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		StatTitle.setForeground(Color.white);
		StatDrag.add(StatTitle);
		Font stats = new Font("MV Boli", Font.BOLD,15);
		StatPawn.setFont(stats);
		StatBishop.setFont(stats);
		StatRook.setFont(stats);
		StatKnight.setFont(stats);
		StatQueen.setFont(stats);
		StatKing.setFont(stats);
		StatWins.setFont(stats);
		StatPawn.setForeground(Color.white);
		StatBishop.setForeground(Color.white);
		StatRook.setForeground(Color.white);
		StatKnight.setForeground(Color.white);
		StatQueen.setForeground(Color.white);
		StatKing.setForeground(Color.white);
		StatWins.setForeground(Color.white);
		StatDrag.add(StatPawn);
		StatDrag.add(StatBishop);
		StatDrag.add(StatRook);
		StatDrag.add(StatKnight);
		StatDrag.add(StatQueen);
		StatDrag.add(StatKing);
		StatDrag.add(StatWins);
		// spacing of Stat elements
		StatTitle.setBounds(530, 25, 325, 150);
		StatBackButton.setBounds(10, 10, 100, 50);
		StatPawn.setBounds(330,100,500,100);
		StatBishop.setBounds(330,150,500,100);
		StatRook.setBounds(330,200,500,100);
		StatKnight.setBounds(330,250,500,100);
		StatQueen.setBounds(330,300,500,100);
		StatKing.setBounds(330,350,500,100);
		StatWins.setBounds(330,400,500,100);
		// Stat design
		 StatDesign.setLayout( new GridLayout(24, 24) );
		 StatDesign.setBounds(0, 0, 1200, 1200);
		 for(int i = 0; i < 24; i++) {
			  for(int j = 0; j < 24; j++ ) {
				  JPanel square = new JPanel( new BorderLayout());
				  StatDesign.add( square );
				  int row = i % 2;
				  if (row == 0)
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Stat
				  else
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Stat     1     
					  }
		  }
		this.add(StatScreen);
		StatVisited = true; 
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
		OptionsCenter.setBackground(new Color(50,50,50));
		/*MenuNorth.setPreferredSize(new Dimension(100,100));
		MenuSouth.setPreferredSize(new Dimension(100,100));
		MenuEast.setPreferredSize(new Dimension(170,100));
		MenuWest.setPreferredSize(new Dimension(170,100));*/
		OptionsCenter.setPreferredSize(new Dimension(500,500));
		OptionsScreen.setLayout(new BorderLayout());
		OptionsScreen.add(MenuNorth, BorderLayout.NORTH);
		OptionsScreen.add(MenuSouth, BorderLayout.SOUTH);
		OptionsScreen.add(MenuEast, BorderLayout.EAST);
		OptionsScreen.add(MenuWest, BorderLayout.WEST);
		OptionsScreen.add(OptionsCenter, BorderLayout.CENTER);
		//Options elements
		OptionsCenter.add(OptionsLayered);
		OptionsLayered.setPreferredSize(new Dimension(1200,1200));
		OptionsLayered.add(OptionsDesign, Integer.valueOf(0)); // bottom layer
		OptionsLayered.add(OptionsDrag, Integer.valueOf(1)); // top layer
		OptionsDrag.setOpaque(false);
		OptionsDrag.setBounds(0, 0, 1200, 1200);
		OptionsDrag.setLayout(null);
		OptionsBackButton.addActionListener(this);
		OptionsDrag.add(OptionsBackButton);
		OptionsBackButton.setForeground(Color.white);
		OptionsBackButton.setBackground(Color.black);
		OptionsTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
		OptionsTitle.setForeground(Color.white);
		OptionsDrag.add(OptionsTitle);
		OptionsChangeTF.setFont(new Font("MV Boli", Font.BOLD,25));
		OptionsChangeTF.setForeground(new Color(0x21a628));
		OptionsChangeTF.setBackground(Color.BLACK);
		OptionsChangeTF.setCaretColor(new Color(0x21a628));
		OptionsChangeButton.setForeground(Color.white);
		OptionsChangeButton.setBackground(Color.black);
		OptionsChangeButton.addActionListener(this);
		OptionsDrag.add(OptionsChangeTF);
		OptionsDrag.add(OptionsChangeButton);
		// spacing of Options elements
		OptionsTitle.setBounds(530, 25, 325, 150);
		OptionsBackButton.setBounds(10, 10, 100, 50);
		OptionsChangeTF.setBounds(330,200,325,100);
		OptionsChangeButton.setBounds(680,200,125,100);
		// Options design
		 OptionsDesign.setLayout( new GridLayout(24, 24) );
		 OptionsDesign.setBounds(0, 0, 1200, 1200);
		 for(int i = 0; i < 24; i++) {
			  for(int j = 0; j < 24; j++ ) {
				  JPanel square = new JPanel( new BorderLayout());
				  OptionsDesign.add( square );
				  int row = i % 2;
				  if (row == 0)
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Options
				  else
				  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Options     1     
					  }
		  }
		this.add(OptionsScreen);
		optionsVisited = true;
		}
		else {
			OptionsScreen.add(MenuNorth, BorderLayout.NORTH);
			OptionsScreen.add(MenuSouth, BorderLayout.SOUTH);
			OptionsScreen.add(MenuEast, BorderLayout.EAST);
			OptionsScreen.add(MenuWest, BorderLayout.WEST);
			OptionsScreen.add(OptionsCenter, BorderLayout.CENTER);
			OptionsScreen.setVisible(true);
		}
	}
	
	// disables the sign-in screen and creates the main menu screen 
		public void signinScreen(boolean visited) {
			if(visited == false) {			
			SigninCenter.setBackground(new Color(50,50,50));
			SigninCenter.setPreferredSize(new Dimension(500,500));
			SigninScreen.setLayout(new BorderLayout());
			SigninScreen.add(MenuNorth, BorderLayout.NORTH);
			SigninScreen.add(MenuSouth, BorderLayout.SOUTH);
			SigninScreen.add(MenuEast, BorderLayout.EAST);
			SigninScreen.add(MenuWest, BorderLayout.WEST);
			SigninScreen.add(SigninCenter, BorderLayout.CENTER);
			MenuNorth.setBackground(new Color(0x153c7a));
			StartImg.setText("BASH");
			StartImg.setFont(new Font("MV Boli", Font.BOLD, 20));
			StartImg.setForeground(Color.white);
			StartImg.setIcon(BashIcon);
			//StartImg.setVerticalTextPosition(JLabel.);
			//StartImg.setHorizontalTextPosition(JLabel.CENTER);
			MenuNorth.add(StartImg);
			//Signin elements
			SigninCenter.add(SigninLayered);
			SigninLayered.setPreferredSize(new Dimension(1200,1200));
			SigninLayered.add(SigninDesign, Integer.valueOf(0)); // bottom layer
			SigninLayered.add(SigninDrag, Integer.valueOf(1)); // top layer
			SigninDrag.setOpaque(false);
			SigninDrag.setBounds(0, 0, 1200, 1200);
			SigninDrag.setLayout(null);
			TFButton.addActionListener(this);
			createAccount.addActionListener(this);
			guestButton.addActionListener(this);
			SigninDrag.add(TFButton);
			SigninDrag.add(createAccount);
			SigninDrag.add(guestButton);
			TFButton.setForeground(Color.white);
			TFButton.setBackground(Color.black);
			createAccount.setForeground(Color.white);
			createAccount.setBackground(Color.black);
			guestButton.setForeground(Color.white);
			guestButton.setBackground(Color.black);
			SigninTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
			SigninTitle.setForeground(Color.white);
			SigninDrag.add(SigninTitle);
			SigninTF.setFont(new Font("MV Boli", Font.BOLD,25));
		    SigninTF.setForeground(new Color(0x21a628));
		    SigninTF.setBackground(Color.BLACK);
		    SigninTF.setCaretColor(new Color(0x21a628));
		    SigninTF2.setFont(new Font("MV Boli", Font.BOLD,25));
		    SigninTF2.setForeground(new Color(0x21a628));
		    SigninTF2.setBackground(Color.BLACK);
		    SigninTF2.setCaretColor(new Color(0x21a628));
		    SigninUser.setFont(new Font("MV Boli", Font.BOLD, 20));
		    SigninUser.setForeground(Color.white);
			SigninPass.setFont(new Font("MV Boli", Font.BOLD, 20));
			SigninPass.setForeground(Color.white);
			SigninDrag.add(SigninUser);
			SigninDrag.add(SigninPass);
	        SigninDrag.add(SigninTF);
	        SigninDrag.add(SigninTF2);
			// spacing of Signin elements
			SigninTitle.setBounds(535, 100, 325, 150);
			SigninUser.setBounds(325,250,350,100);
			SigninPass.setBounds(325,350,350,100);
			SigninTF.setBounds(450, 250, 350, 100);
			SigninTF2.setBounds(450,350,350,100);
			createAccount.setBounds(380,470,150,100);
			guestButton.setBounds(545, 470, 150, 100);
			TFButton.setBounds(710,470,150,100);
			
			// Signin design
			 SigninDesign.setLayout( new GridLayout(24, 24) );
			 SigninDesign.setBounds(0, 0, 1200, 1200);
			 for(int i = 0; i < 24; i++) {
				  for(int j = 0; j < 24; j++ ) {
					  JPanel square = new JPanel( new BorderLayout());
					  SigninDesign.add( square );
					  int row = i % 2;
					  if (row == 0)
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) ); // 1     Signin
					  else
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) ); //Signin     1     
							  }
			  }
			this.add(SigninScreen);
			signinVisited = true;
	    	}
		 else {
				SigninScreen.add(MenuNorth, BorderLayout.NORTH);
				SigninScreen.add(MenuSouth, BorderLayout.SOUTH);
				SigninScreen.add(MenuEast, BorderLayout.EAST);
				SigninScreen.add(MenuWest, BorderLayout.WEST);
				SigninScreen.add(SigninCenter, BorderLayout.CENTER);
				MenuNorth.setBackground(new Color(0x153c7a));
				StartImg.setText("BASH");
				StartImg.setFont(new Font("MV Boli", Font.BOLD, 20));
				StartImg.setForeground(Color.white);
				StartImg.setIcon(BashIcon);
				MenuNorth.add(StartImg);
				SigninScreen.setVisible(true);
			}
		}
		
		public void createAccountScreen(boolean visited) {
			if(visited == false) {			
			createAccountCenter.setBackground(new Color(50,50,50));
			createAccountCenter.setPreferredSize(new Dimension(500,500));
			createAccountScreen.setLayout(new BorderLayout());
			createAccountScreen.add(MenuNorth, BorderLayout.NORTH);
			createAccountScreen.add(MenuSouth, BorderLayout.SOUTH);
			createAccountScreen.add(MenuEast, BorderLayout.EAST);
			createAccountScreen.add(MenuWest, BorderLayout.WEST);
			createAccountScreen.add(createAccountCenter, BorderLayout.CENTER);
			createAccountCenter.add(createAccountLayered);
			createAccountLayered.setPreferredSize(new Dimension(1200,1200));
			createAccountLayered.add(createAccountDesign, Integer.valueOf(0)); // bottom layer
			createAccountLayered.add(createAccountDrag, Integer.valueOf(1)); // top layer
			createAccountDrag.setOpaque(false);
			createAccountDrag.setBounds(0, 0, 1200, 1200);
			createAccountDrag.setLayout(null);
			createButton.addActionListener(this);
			goBackButton.addActionListener(this);
			createAccountDrag.add(createButton);
			createAccountDrag.add(goBackButton);
			username.setFont(new Font("MV Boli", Font.BOLD, 20));
			password.setFont(new Font("MV Boli", Font.BOLD, 20));
			createAccountDrag.add(username);
			createAccountDrag.add(password);
			createButton.setForeground(Color.white);
			createButton.setBackground(Color.black);
			goBackButton.setForeground(Color.white);
			goBackButton.setBackground(Color.black);
			createAccountTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
			createAccountTitle.setForeground(Color.white);
			createAccountDrag.add(createAccountTitle);
			accountName.setFont(new Font("MV Boli", Font.BOLD,25));
		    accountName.setForeground(new Color(0x21a628));
		    accountName.setBackground(Color.BLACK);
		    accountName.setCaretColor(new Color(0x21a628));
		    accountPassword.setFont(new Font("MV Boli", Font.BOLD,25));
		    accountPassword.setForeground(new Color(0x21a628));
		    accountPassword.setBackground(Color.BLACK);
		    accountPassword.setCaretColor(new Color(0x21a628));
	        createAccountDrag.add(accountName);
	        createAccountDrag.add(accountPassword);
	        //Spacing of create account elements
			createAccountTitle.setBounds(430, 100, 400, 100);
			username.setBounds(325,250,350,100);
			password.setBounds(325,350,350,100);
			accountName.setBounds(450, 250, 350, 100);
			accountPassword.setBounds(450,350,350,100);
			createButton.setBounds(450,450,175,100);
			goBackButton.setBounds(625,450,175,100);
			// create account design
			 createAccountDesign.setLayout( new GridLayout(24, 24) );
			 createAccountDesign.setBounds(0, 0, 1200, 1200);
			 for(int i = 0; i < 24; i++) {
				  for(int j = 0; j < 24; j++ ) {
					  JPanel square = new JPanel( new BorderLayout());
					  createAccountDesign.add( square );
					  int row = i % 2;
					  if (row == 0)
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) :new Color(50,50,50) );   
					  else
					  square.setBackground( j % 2 == 0 ? new Color(50,50,50) : new Color(50,50,50) );    
							  }
			  }
			this.add(createAccountScreen);
			createVisited = true;
	    	}
			else {
				createAccountScreen.add(MenuNorth, BorderLayout.NORTH);
				createAccountScreen.add(MenuSouth, BorderLayout.SOUTH);
				createAccountScreen.add(MenuEast, BorderLayout.EAST);
				createAccountScreen.add(MenuWest, BorderLayout.WEST);
				createAccountScreen.add(createAccountCenter, BorderLayout.CENTER);
				createAccountScreen.setVisible(true);
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
		  //*******Buttons Added************ 
		  MenuSouth.setLayout(null);
		  MenuSouth.add(ExitToMain);
		  ExitToMain.setVisible(true);
		  ResetBoard.setVisible(true);
		  ExitToMain.addActionListener(this);
		  ExitToMain.setForeground(Color.white);
		  ExitToMain.setBackground(Color.black);
		  ExitToMain.setBounds(500, 0, 100, 50);
		  MenuSouth.add(ResetBoard);
		  ResetBoard.addActionListener(this);
		  ResetBoard.setForeground(Color.white);
		  ResetBoard.setBackground(Color.black);
		  ResetBoard.setBounds(1000, 0, 100, 50);
		  // *******************************
          chessCenter.setBackground(new Color(50, 50, 50));
		  chessCenter.add(layeredPane);
		  this.add(chessBackground);
		  //Add a chess board to the Layered Pane 
		  chessBoard = new JPanel();
		  chessBoardIndex = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 // Board chessGame = new Board();
		  for(int i = 0; i < 8; i++) {
			  for(int j = 0; j < 8; j++ ) {
				  JPanel square = new JPanel( new BorderLayout());
				  chessBoard.add( square );
				  int row = i % 2;
				  if (row == 0)
				  square.setBackground( j % 2 == 0 ? new Color(0x6EAEDD) :new Color(0x0A4773) ); // 1     Bash
				  else
				  square.setBackground( j % 2 == 0 ? new Color(0x0A4773) : new Color(0x6EAEDD) ); //Bash     1
				 
				  
			  }
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
		  
		  // pawn class works
		  for(int i = 8; i < 16; i++) {
			  piece = new JLabel(loadImage("/imgs/Bpawn.png"));
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
		  
		  chessBackground.setVisible(true);
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
	





