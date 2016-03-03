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

    public static void main(String[]args){
	int[]ary={8,7,1,4,9};
	printArray(ary);
	//insertionSort(ary);
        //selectionSort(ary);
	bubbleSort(ary);
	printArray(ary);
    }
}
