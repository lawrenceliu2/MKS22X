import java.util.*;

public class MyQueue<T>{
    private MyLinkedList<T> queue;
    private int size;

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
	return size;
    }

    public boolean isEmpty(){
	return size==0;
    }

}
