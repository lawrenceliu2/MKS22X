import java.io.*;
import java.util.*;

public class Silver{
    int[][] pasture;

    public Silver(int row, int col){
	pasture = new int[row][col];
    }

    public void add (int row, int col, int n){
	pasture[row][col]=n;
    }

    public int get (int row, int col){
	return pasture[row][col];
    }

    public static void solve(){
	try{
	    Scanner s = new Scanner(new File("ctravel.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    int seconds = s.nextInt();
	    Silver field = new Silver(rows, cols);

	    for (int i = 0;i<rows;i++){
		String next=s.next();
		for (int k = 0;k<cols;k++){
		    if (next.charAt(k)=='.'){
			field.add(i,k,0);
		    }else{
			field.add(i,k,-1);
		    }
		}
	    }

	    int startrow = s.nextInt()-1;
	    int startcol = s.nextInt()-1;
	    int endrow = s.nextInt()-1;
	    int endcol = s.nextInt()-1;
	    
	    if(field.get(startrow-1,startcol)!=-1&&startrow-1>=0){
		field.add(startrow-1,startcol,1);
	    }
	    if(field.get(startrow+1,startcol)!=-1&&startrow+1<rows){
		field.add(startrow+1,startcol,1);
	    }
	    if(field.get(startrow,startcol-1)!=-1&&startcol-1>=0){
		field.add(startrow,startcol-1,1);
	    }
	    if(field.get(startrow,startcol+1)!=-1&&startcol+1<cols){
		field.add(startrow,startcol+1,1);
	    }

	    for (int steps=1;steps<seconds;steps++){
		for (int i=0;i<rows-1;i++){
		    if (startcol%2==1||(startrow%2==0&&startcol==0)){
			for (int k=0;k<cols;k+=2){
			    field.helper(i,k);
			}
			for (int k=1;k<cols;k+=2){
			    field.helper(i,k);
			}
		    }else{
			for (int k=1;k<cols;k+=2){
			    field.helper(i,k);
			}
			for (int k=0;k<cols;k+=2){
			    field.helper(i,k);
			}
		    }
		}
	    }
	    
	    System.out.println(field.get(endrow,endcol));
	}
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
    }

    public void helper (int row, int col){
	if (pasture[row][col]>0){
	    pasture[row][col]=0;
	}else{
	    if(pasture[row][col]!=-1){
		
		if(pasture[row-1][col]!=-1&&row-1>0){
		    pasture[row][col]+=pasture[row-1][col];
		}
		
		if(pasture[row+1][col]!=-1&&row+1<pasture.length){
		    pasture[row][col]+=pasture[row+1][col];
		}
		
		if(pasture[row][col-1]!=-1&&col-1>0){
		    pasture[row][col]+=pasture[row][col-1];
		}
		
		if(pasture[row][col+1]!=-1&&col+1<pasture[0].length){
		    pasture[row][col]+=pasture[row][col+1];
		}
	    }
	}
    }


    public String toString(){
	String ans = "";
	for (int i=0;i<pasture.length;i++){
	    for (int k=0;k<pasture[i].length;k++){
		ans+= pasture[i][k]+" ";
	    }
	    ans+="\n";
	}
	return ans;
    }
    

    public static void main(String[]args){
	solve();
    }
}

