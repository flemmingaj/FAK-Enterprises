import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Queen extends Piece {
	
	JLabel queenImgW = new JLabel( new ImageIcon("Wqueen.png") );
	JLabel queenImgB = new JLabel( new ImageIcon("Bqueen.png") );
	
	Queen(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return queenImgW;
		else 
			return queenImgB;
	}
}