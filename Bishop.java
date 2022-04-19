import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Bishop extends Piece {
	
	JLabel bishopImgW = new JLabel( new ImageIcon("Wbishop.png") );
	JLabel bishopImgB = new JLabel( new ImageIcon("Bbishop.png") );
	
	Bishop(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return bishopImgW;
		else 
			return bishopImgB;
	}
}