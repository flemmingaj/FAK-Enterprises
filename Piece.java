
class Piece {
	
	int c; // column
	int r; // row
	boolean w; // true = white  false = black
	char t; // type of piece

	
	Piece(int c, int r, boolean w, char t){
	 	this.c = c;
	 	this.r = r;
	 	this.w = w;
	 	this.t = t;
	}
	public boolean getColor(){
		return w;
	}
	
}
