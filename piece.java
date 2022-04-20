import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

 abstract class piece extends JLabel{
	public int comp;
	public abstract boolean isValidMove(int c);
	public boolean isWhite;
	public String parent;

}

 class Pawn extends piece
 {
	 Integer[] ws = {48, 49, 50, 51, 52, 53, 54, 55};
	 Integer[] bs = {8,9,10,11,12,13,14,15};
	 Integer[] we = {0,1,2,3,4,5,6,7};
	 Integer[] be = {56,57,58,59,60,61,62,63};
	 List<Integer> start;
	 List<Integer> end;
	 
	 public Pawn(boolean white, int comp) {
		 this.isWhite = white;
		 if(this.isWhite)
			 {
			 this.setIcon(new ImageIcon("Wpawn.png"));
			 start = Arrays.asList(ws);
			 end = Arrays.asList(we);
			 }
		 else {
			 this.setIcon(new ImageIcon("Bpawn.png"));
			 start = Arrays.asList(bs);
			 end = Arrays.asList(be);
		 	}
		 this.comp = comp;
		 this.setHorizontalAlignment(CENTER);
		 //System.out.println(this.toString());
		 //System.out.println(comp + " " + this.);
		 this.setToolTipText(""+this.comp);
	 }
	//this method should take a jpanel as an argument
	@Override
	public boolean isValidMove(int c) {
		int valid;
		if(this.isWhite) 
		{
			if(start.contains(this.comp)) 
			{
				if(c == this.comp - 8) this.comp = this.comp - 8;
				if(c == this.comp - 16) this.comp = this.comp - 16;
				return(c == this.comp - 8 || c == this.comp - 16);
			}
			valid = this.comp - 8;
		}
		else {
			if(start.contains(this.comp))
			{
				if(c == this.comp + 8) this.comp += 8;
				if(c == this.comp +16) this.comp += 16;
				return(c == this.comp + 8 || c== this.comp + 16);
			}
		    valid = this.comp + 8;
		}
		return (valid == c);
	}
	 
 }

 class Rook extends piece{
	public Rook(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wrook.png"));
		else this.setIcon(new ImageIcon("Brook.png"));
		this.setHorizontalAlignment(CENTER);
	}
	@Override
	public boolean isValidMove(int c) {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
  class Bishop extends piece{
	  public Bishop(boolean white) {
			this.isWhite = white;
			if(white) this.setIcon(new ImageIcon("Wbishop.png"));
			else this.setIcon(new ImageIcon("Bbishop.png"));
			this.setHorizontalAlignment(CENTER);
		}
	@Override
	public boolean isValidMove(int c) {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class Knight extends piece{
	public Knight(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wknight.png"));
		else this.setIcon(new ImageIcon("Bknight.png"));
		this.setHorizontalAlignment(CENTER);
	}
	@Override
	public boolean isValidMove(int c) {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class Queen extends piece{
	public Queen(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wqueen.png"));
		else this.setIcon(new ImageIcon("Bqueen.png"));
		this.setHorizontalAlignment(CENTER);
	}
	@Override
	public boolean isValidMove(int c) {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class King extends piece{
	public King(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wking.png"));
		else this.setIcon(new ImageIcon("Bking.png"));
		this.setHorizontalAlignment(CENTER);
	}
	@Override
	public boolean isValidMove(int c) {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
