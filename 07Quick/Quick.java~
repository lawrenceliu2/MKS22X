import java.util.*;

public class Quick{

    public static String name(){
	return "7,Liu,Lawrence";
    }

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

    /* Mr. K's partition was better
      private static int partition (int[]data, int left, int right){
	int element = data[(int)(Math.random()*(right-left+1))+left];
	int[]ans = new int[data.length];
	int low = 0;
	int high = ans.length-1;
	
	for (int i=0;i<ans.length;i++){
	    if (data[i]<element){
		ans[low]=data[i];
		low++;
	    }else{
		if (data[i]==element){}
		else{
		    ans[high]=data[i];
		    high--;
		}
	    }
	}
	
	ans[low]=element;
	for (int i=0;i<ans.length;i++){
	    data[i]=ans[i];
	}
	return low;
	}*/

    private static void swap (int[]data, int x, int y){
	int placeholder=data[x];
	data[x]=data[y];
	data[y]=placeholder;
    }

    private static int partitionOld (int[]data, int left, int right){
	int index = (int) (left+Math.random()*(right-left+1));
	int value = data[index];
	swap(data, index, right);
	for (int i=left;i<right;i++){
	    if (data[i]<=value){
		swap(data, left, i);
		left++;
	    }
	}
	swap(data,left,right);
	return left;
    }

    public static int quickSelectOld (int[]data, int k){
	return quickSelectOld (data, k, 0, data.length-1);
    }

    public static int quickSelectOld (int[]data, int k, int left, int right){
	int ans = partitionOld(data, left, right);
	if (left==right){
	    return data[left];
	}else{
	    if (ans<k){
		return quickSelectOld (data,k,ans+1,right);
	    }else{
		return quickSelectOld (data,k,left,ans-1);
	    }
	}
    }

    public static void quickSortOld (int[]data){
	quickSortOld (data, 0, data.length-1);
    }

    public static void quickSortOld (int[]data, int left, int right){
	if (left<=right){
	    int index = partitionOld (data, left, right);
	    quickSortOld (data, index+1, right);
	    quickSortOld (data, left, index-1);
	}
    }



    private static int[] partition (int[]data, int left, int right){
	int index = (int) (left+(Math.random()*(right-left+1)));
	int value = data[index];
	int[]ans=new int[data.length];
	int leftCount = left;
	int rightCount = right;
	
	for (int i = left;i<=right;i++){
	    if (data[i]<value){
		ans[leftCount]=data[i];
		leftCount++;
	    }
	    if (data[i]>value){
		ans[rightCount]=data[i];
		rightCount--;
	    }
	}
	
	for (int i = leftCount;i<=rightCount;i++){
	    ans[i]=value;
	}

	for (int i =left;i<=right;i++){
	    data[i]=ans[i];
	}

	int[]blah=new int[2];
	blah[0]=leftCount-1;
	blah[1]=rightCount+1;
	return blah;
    }

    public static void quickSort (int[]data){
	quickSort (data, 0, data.length-1);
    }

    public static void quickSort (int[]data, int left, int right){
	if (left<right){
	    int[] index = partition (data, left, right);
	    quickSort (data, left, index[0]-1);
	    quickSort (data, index[1]+1,right);
	}
    }

    
    public static void main(String[]args){
	/*int[]data = {6,-3,2,12,-18,123};
	int[]data2 = {6,-3,2,12,-18,123};
	int[]data3 = {6,-3,2,12,-18,123};
	Arrays.sort(data);
	printArray(data);
	quickSortOld(data2);
	printArray(data2);
	quickSort(data3);
	printArray(data3);*/
        int[] a = new int [4000000];

	for(int i = 0; i < a.length; i++){
	    a[i]= (int)(Math.random()*Integer.MAX_VALUE);
	}
	
	long start = System.currentTimeMillis();
	quickSort(a);
	long elapsedTimeMillis = System.currentTimeMillis()-start;
	float elapsedTimeSec = elapsedTimeMillis/1000F;
	System.out.println(elapsedTimeSec);
    }
}
