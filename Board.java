
public class Board {
	Piece[][] board = new Piece[8][8];
	Board(){
     //black pieces
	 board[0][0] = new Rook(0, 0, false, 'r');
	 board[0][1] = new Knight(1, 0, false, 'n');
	 board[0][2] = new Bishop(2, 0, false, 'b');
	 board[0][3] = new Queen(3, 0, false, 'q');
	 board[0][4] = new King(4, 0, false, 'k');
	 board[0][5] = new Bishop(5, 0, false, 'b');
	 board[0][6] = new Knight(6, 0, false, 'k');
	 board[0][7] = new Rook(7, 0, false, 'r');
	 //white pieces
	 board[0][0] = new Rook(0, 7, true, 'r');
	 board[0][1] = new Knight(1, 7, true, 'n');
	 board[0][2] = new Bishop(2, 7, true, 'b');
	 board[0][3] = new Queen(3, 7, true, 'q');
	 board[0][4] = new King(4, 7, true, 'k');
	 board[0][5] = new Bishop(5, 7, true, 'b');
	 board[0][6] = new Knight(6, 7, true, 'k');
	 board[0][7] = new Rook(7, 7, true, 'r');
	 //black and white pawns 
	 for(int i = 0; i < 8; i ++) {
		 board[1][i] = new Pawn(i, 1, false, 'p');
		 board[7][i] = new Pawn(i, 7, true, 'p');
	 }
	}
	//returns the piece at a particular board location
	public Piece getPieceAt(int i, int j) {
	 return board[i][j];
	}
	
	
}
