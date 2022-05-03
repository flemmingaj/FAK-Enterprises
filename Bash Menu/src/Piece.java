import javax.swing.JLabel;
import javax.swing.ImageIcon;

class Piece extends JLabel {
	
	int c; // column
	int r; // row
	boolean w; // true = white  false = black
	char t; // type of piece
	String s; // for image
    JLabel label; 
    ImageIcon Img;
	
	Piece(int c, int r, boolean w, char t){
	 	this.c = c;
	 	this.r = r;
	 	this.w = w;
	 	this.t = t;
	}
	public boolean getColor(){
		return w;
	}
	public char getType() {
		return t;
	}
	public ImageIcon loadImage(String s) {
		try {
			Img = new ImageIcon(Piece.class.getResource(s));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Img;
	}
	public JLabel getLabel() {
		return label;
	}
	public Piece getCopy() {
	 return new Piece(c, r, w, t);
	}
	
}
