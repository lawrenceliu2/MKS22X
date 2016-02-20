public class KnightBoard{
    private int[][]board;
    private int knight;

    public KnightBoard (int size){
	board = new int[size][size];
	knight = 0;
    }

    public void printSolution (){
	for (int i=0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		if (board.length*board.length>=10){
		    if (board[i][k]<10){
			System.out.print(" "+board[i][k]+" ");
		    }
		}else{
		    System.out.print(board[i][k]+" ");
		}
	    }
	    System.out.print("\n");
	}
    }

    public boolean solve (){
	for (int i=0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		if (helper(i,k)){}
	    }
	}
	return true;
    }

    public boolean helper (int row, int col){
	//Making sure the row and col do not get off the board.
	if (row<0||col<0){
	    return false;
	}
	if (row>=board.length||col>=board.length){
	    return false;
	}
	
	//Return false if the knight was already here.
	if (board[row][col]!=0){
	    return false;
	}
	
	//Otherwise, we can place the knight there.
	board[row][col]= knight+1;

	//Check if it is solved after placing, if the knight landed on its last possible square.
	if (knight==board.length*board.length){
	    return true;
	}

	//Otherwise, go down the tree of possibilities.
	if (helper(row-2, col-1)){
	    return true;
	}
	if (helper(row-2, col+1)){
	    return true;
	}
	if (helper(row-1, col+2)){
	    return true;
	}
	if (helper(row+1, col+2)){
	    return true;
	}
	if (helper(row+2, col+1)){
	    return true;
	}
	if (helper(row+2, col-1)){
	    return true;
	}
	if (helper(row+1, col-2)){
	    return true;
	}
	if (helper(row-1, col-2)){
	    return true;
	}
	
	//If none of the possibilities work, we have to backtrack.
	board[row][col]=0;
        knight--;
	return false;
    }
    

    public static void main(String [] args){
	int n = Integer.parseInt (args[0]);
	KnightBoard board= new KnightBoard (n);
	board.solve();
	board.printSolution();
    }
}
