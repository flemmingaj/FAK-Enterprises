import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class  King extends Piece {
	
	JLabel kingImgW = new JLabel( new ImageIcon("Wking.png") );
	JLabel kingImgB = new JLabel( new ImageIcon("Bking.png") );
	
	King(int c, int r, boolean w, char t){
		super(c, r, w, t);
	}
	
	public JLabel getImage() {
		if(super.getColor() == true)
			return kingImgW;
		else 
			return kingImgB;
	}
}