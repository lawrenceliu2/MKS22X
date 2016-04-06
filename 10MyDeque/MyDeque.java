import java.util.*;

public class MyDeque<T>{
    private T[] data;
    private int size, start, end;
    private boolean freshDeque;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10];
	freshDeque=true;
    }

    public String toString(){
	String ans = "[";
	for (int i=0;i<data.length;i++){
	    if (i == data.length-1){
		ans+=data[i];
	    }else{
		ans+=data[i]+", ";
	    }
	}
	ans+="]\nSize: "+size+"\nStart: "+start+"\nEnd: "+end;
	return ans;
    }

    private void grow(){
	T[] newData = (T[]) new Object[data.length*2];
	int count=start;
	for (int i=0;i<data.length;i++){
	    newData[count]=data[i];
	    if (count==data.length-1){
		count=0;
	    }else{
		count++;
	    }
	}
	start=0;
	end=data.length-1;
	data=newData;
    }

    public void addFirst (T value){
	if (size==data.length){
	    grow();
	}		    
	if (freshDeque){
	    freshDeque=false;
        }else{
	    if (start==0){
		start=data.length-1;
	    }else{
		start--;
	    }
	}
	size++;
	data[start]=value;
    }

    public void addLast (T value){
	if (size==data.length){
	    grow();
	}
	if (freshDeque){
	    freshDeque=false;
	}else{
	    if (end==data.length-1){
		end=0;
	    }else{
		end++;
	    }
	}
	size++;
	data[end]=value;
    }

    public T removeFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ans = data[start];
	data[start] = null;
	if (start==0){
	    start=data.length-1;
	}else{
	    start--;
	}
	size--;
	return ans;
    }

    public T removeLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ans = data[end];
	size--;
	if (end==data.length-1){
	    end=0;
	}else{
	    end--;
	}
	size--;
	return ans;
    }

    public T getFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }


    public static void main(String[]args){
	MyDeque<Integer> blah = new MyDeque<Integer>();
	System.out.println(blah);
	blah.addFirst(0);
	blah.addFirst(1);
	blah.addFirst(2);
	blah.addFirst(3);
	blah.addFirst(4);
	blah.addFirst(5);
        blah.addLast(6);
	blah.addLast(7);
	blah.addLast(8);
	blah.addLast(9);
	blah.addFirst(5);
	blah.removeLast();
	blah.addLast(99);
	blah.addFirst(354);
	blah.removeFirst();
	System.out.println(blah);
	System.out.println(blah.getFirst());
	System.out.println(blah.getLast());
    }
}
