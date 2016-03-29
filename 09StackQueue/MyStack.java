import java.util.*;

public class MyStack<T>{
    private MyLinkedList<T> stack;
    private int size;

    public void push (T item){
	stack.add(0,item);
    }

    public T pop(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	return stack.remove(0);
    }

    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	return stack.get(0);
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size==0;
    }
}
