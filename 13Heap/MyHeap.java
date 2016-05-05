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
	
    }

    private void pushUp(int k){
	
    }

    private void heapify(){
	
    }

    public T delete(){
	
    }

    public void add(T x){
	if (size+1==data.length){
	    doubleSize();
	}
	data[size+1]=x;
	size++;
    }

    private void doubleSize(){
	T[]vals = (T[]) new Comparable[size*2];
	for (int i = 1;i<=size;i++){
	    vals[i]=data[i];
	}
	data=vals;
    }

    public String toString(){
	
    }

    //do this last
    public MyHeap(boolean isMax){
	
    }

    public MyHeap(T[] array, boolean isMax){
	
    }
}

