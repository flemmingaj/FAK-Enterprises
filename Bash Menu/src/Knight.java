import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Knight extends Piece {
	
	JLabel knightImgW = new JLabel( new ImageIcon("Wknight.png") );
	JLabel knightImgB = new JLabel( new ImageIcon("Bknight.png") );
	
	Knight(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return knightImgW;
		else 
			return knightImgB;
	}
}