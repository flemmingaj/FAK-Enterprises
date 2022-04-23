
class Piece {
	
	protected int c; // column
	protected int r; // row
	protected boolean w; // true = white  false = black
	protected char t; // type of piece

	
	Piece(int c, int r, boolean w, char t){
	 	this.c = c;
	 	this.r = r;
	 	this.w = w;
	 	this.t = t;
	}
	
	public int getColumn(){
		return c;
	}
	
	public int getRow(){
		return r;
	}
	
	public char getType(){
		return t;
	}
	
	public boolean getColor(){
		return w;
	}
	
}
