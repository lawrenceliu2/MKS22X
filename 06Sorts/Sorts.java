import java.util.*;

public class Sorts{

    public static void printArray(int[]data){
	System.out.print("{");
	for (int i = 0;i<data.length;i++){
	    if (i+1==data.length){
		System.out.print(data[i]);
	    }
	    else{
		System.out.print(data[i]+",");
	    }
	}
	System.out.print("}\n");
    }

    public static void insertionSort(int[]data){
	for (int i=1;i<data.length;i++){
	    int moving = data[i];
	    int x;
	    for (x=i-1;x>=0 && moving<data[x];x--){
		data[x+1]=data[x];
	    }
	    data[x+1]=moving;
	}
    }

    public static void selectionSort(int[]data){
	for (int i=0;i<data.length-1;i++){
	    int min = data[i];
	    int minIndex = i;
	    int min2 = data[i];
	    for (int k=i+1;k<data.length;k++){
		if (data[k]<min){
		    min=data[k];
		    minIndex=k;
		}
	    }
	    data[i]=min;
	    data[minIndex]=min2;
	    printArray(data);
	}
    }

    public static void bubbleSort(int[]data){
	boolean switched = false;
	for(int i=data.length-1;i>0;i--){
	    for (int k=i;k>0;k--){
		if (data[k-1]>data[k]){
		    int switching=data[k];
		    data[k]=data[k-1];
		    data[k-1]=switching;
		    switched=true;
		}
	    }
	    if (switched==false){
		i=0;
	    }
	    printArray(data);
	}
    }

    public static String name(){
	return "7,Liu,Lawrence";
    }

    public static int[] merge (int[]first,int[]second){
	int[]ans=new int[first.length+second.length];
	int firstIndex=0;
	int secondIndex=0;
	int i;
	
	for (i=0;i<ans.length&&firstIndex<first.length&&secondIndex<second.length;i++){
	  
	    if (first[firstIndex]>second[secondIndex]){
		ans[i]=second[secondIndex];
		secondIndex++;
	    }else{
		ans[i]=first[firstIndex];
		firstIndex++;
	    }
	    
	}

	int[]remainders;
	int remains;
	if (firstIndex==first.length){
	    remainders=second;
	    remains=secondIndex;
	}else{
	    remainders=first;
	    remains=firstIndex;
	}
	
	for (int k=remains;k<remainders.length;k++){
	    ans[i]=remainders[k];
	    i++;
	}
	return ans;
    }

    public static void mergesort (int[]data){
	int[]ans = helper(data);
	for (int i=0;i<data.length;i++){
	    data[i]=ans[i];
	}
    }


    public static int[] helper (int[]data){
	if (data.length==1){return data;}
	int end=data.length/2;
	int start=end;
	int[]firstHalf=Arrays.copyOfRange(data,0,end);
	int[]secondHalf=Arrays.copyOfRange(data,start,data.length);
        int[]ans=merge(helper(firstHalf),helper(secondHalf));
	return ans;
    }

    public static void main(String[]args){
	int[]ary={8,7,1,4,9};
	int[]ary2={324,5,345,234,-1};
        mergesort(ary);
	printArray(ary);
	mergesort(ary2);
	printArray(ary2);
    }
}
