import java.util.*;

@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;

    public MyHeap(){
	data = (T[]) new Comparable[10];
    }

    public MyHeap(T[] array){
	size=array.length;
	data = (T[]) new Comparable [size+1];
	for (int i = 0;i<size;i++){
	    data[i+1]=array[i];
	}
	heapify();
    }

    private void pushDown(int k){
	if (k*2>data.length||k*2+1>data.length){}
	else if (data[k].compareTo(data[k*2])<0){
	    T ans = data[k];
	    data[k]=data[k*2];
	    data[k*2]=ans;
	    pushDown(k*2);
	}else if (data[k].compareTo(data[k*2+1])<0){
	    T ans = data[k];
	    data[k]=data[k*2+1];
	    data[k*2+1]=ans;
	    pushDown(k*2+1);
	}
    }

    private void pushUp(int k){
	if (k/2<1){}
	else{
	    T ans = data[k];
	    data[k]=data[k/2];
	    data[k/2]=ans;
	    if (data[k/2].compareTo(data[k/4])>0){
		pushUp(k/2);
	    }
	}
    }

    private void heapify(){
	for (int i=data.length;i>0;i--){
	    if (data[i].compareTo(data[i/2])
    }

    public T delete(){
	
    }

    public void add(T x){
	if (size+1==data.length){
	    doubleSize();
	}
	data[size+1]=x;
	size++;
	heapify();
    }

    private void doubleSize(){
	T[]vals = (T[]) new Comparable[size*2];
	for (int i = 1;i<=size;i++){
	    vals[i]=data[i];
	}
	data=vals;
    }

    public String toString(){
	String ans ="";
	for (int i = 0;i<data.length;i++){
	    ans+=data[i]+" ";
	}
	return ans;
    }

    //do this last
    public MyHeap(boolean isMax){
	
    }

    public MyHeap(T[] array, boolean isMax){
	
    }
}

