import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  Rook extends Piece {
	
	JLabel rookImgW = new JLabel( new ImageIcon("Wrook.png") );
	JLabel rookImgB = new JLabel( new ImageIcon("Brook.png") );
	
	Rook(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return rookImgW;
		else 
			return rookImgB;
	}
}