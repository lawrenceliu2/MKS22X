public class KnightBoard{
    private int[][]board;

    public KnightBoard (int n){
	board = new int[n][n];
    }

    public void printSolution (){
	for (int i=0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		System.out.print(board[i][k]+" ");
	    }
	    System.out.print("\n");
	}
    }

    public boolean move (int row, int col){
	if (board[row-2][col-1]!=0&&
	    board[row-1][col-2]!=0){
	    return false;
	}
    }

    public boolean solve (){
	
    }

    public boolean helper(int col){

    }
}
