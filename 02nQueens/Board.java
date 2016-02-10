public class Board{
    private int[][]board;

    
    public Board(int n){
	board = new int[n][n];
    }

    public void showBoard(){
	for (int i=0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		System.out.print(board[i][k]+" ");
	    }
	    System.out.print("\n");
	}
    }

    public void addQueen(int row, int col){
	board[row][col] = 1;
	for (i=row+1;i<board.length;i++){
	    for (k=0;k<board[i].length;k++){

	    }
	}
    }

    public void removeQueen(int row, int col){
	board[row][col] = 0;
	for (i=row+1;i<board.length;i++){
	    for (k=0;k<board[i].length;k++){

	    }
	}
    }

}
