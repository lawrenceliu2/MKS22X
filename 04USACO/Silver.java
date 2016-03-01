import java.io.*;
import java.util.*;

public class Silver{
    private int[][] pasture;

    public Silver(int row, int col){
	pasture = new int[row][col];
    }

    public void add (int row, int col, int n){
	pasture[row][col]=n;
    }

    public static void solve(){
	try{
	    Scanner s = new Scanner(new File("ctravel.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    int seconds = s.nextInt();
	    Silver field = new Silver(rows, cols);

	    for (int i = 0;i<rows;i++){
		for (int k = 0;k<cols;k++){
		    field.add(i,k,s.nextInt());
		}
	    }


	}
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
    }

    public static void main(String[]args){
	solve();
    }
}
