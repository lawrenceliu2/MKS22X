import java.util.*;

public class MyQueue<T>{
    private MyLinkedList<T> queue;

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public void enqueue (T item){
	queue.add(item);
    }

    public T dequeue(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }

    public T peek(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }

    public int size(){
	return queue.size();
    }

    public boolean isEmpty(){
	return size()==0;
    }


    public static void main (String[]args){
	MyQueue<Integer> data = new MyQueue<Integer>();
	
	try{
	    data.dequeue();
	}catch (NoSuchElementException e){
	    System.out.println("No Empty Queue Dequeueing");
	}

	try{
	    data.peek();
	}catch (NoSuchElementException e){
	    System.out.println("No Empty Queue Peeking");
	}

	System.out.println(data.size());
	System.out.println(data.isEmpty());

	for (int i = 0; i < 1000;i++){
	    data.enqueue(i);
	}

	for (int i = 0; i < 1001; i++){
	    System.out.println(data.dequeue());
	}
    }	
}
