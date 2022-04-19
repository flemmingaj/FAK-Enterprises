import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Pawn extends Piece {
	
	JLabel pawnImgW = new JLabel( new ImageIcon("Wpawn.png") );
	JLabel pawnImgB = new JLabel( new ImageIcon("Bpawn.png") );
	
	Pawn(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return pawnImgW;
		else 
			return pawnImgB;
	}

}
