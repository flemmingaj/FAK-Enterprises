import javax.swing.ImageIcon;
import javax.swing.JLabel;

 abstract class piece extends JLabel{
	
	public abstract boolean isValidMove();
	public boolean isWhite;

}

 class Pawn extends piece
 {
	 public Pawn(boolean white) {
		 this.isWhite = white;
		 if(this.isWhite) this.setIcon(new ImageIcon("Wpawn.png"));
		 else this.setIcon(new ImageIcon("Bpawn.png"));
	 }
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }

 class Rook extends piece{
	public Rook(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wrook.png"));
		else this.setIcon(new ImageIcon("Brook.png"));
	}
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
  class Bishop extends piece{
	  public Bishop(boolean white) {
			this.isWhite = white;
			if(white) this.setIcon(new ImageIcon("Wbishop.png"));
			else this.setIcon(new ImageIcon("Bbishop.png"));
		}
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class Knight extends piece{
	public Knight(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wknight.png"));
		else this.setIcon(new ImageIcon("Bknight.png"));
	}
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class Queen extends piece{
	public Queen(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wqueen.png"));
		else this.setIcon(new ImageIcon("Bqueen.png"));
	}
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }
class King extends piece{
	public King(boolean white) {
		this.isWhite = white;
		if(white) this.setIcon(new ImageIcon("Wking.png"));
		else this.setIcon(new ImageIcon("Bking.png"));
	}
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	 
 }