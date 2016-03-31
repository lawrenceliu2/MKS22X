import java.util.*;

public class MyStack<T>{
    private MyLinkedList<T> stack;

    public MyStack(){
	stack=new MyLinkedList<T>();
    }

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
	return stack.size();
    }

    public boolean isEmpty(){
	return size()==0;
    }

    public static void main (String[]args){
	MyStack<Integer> data = new MyStack<Integer>();
	
	try{
	    data.pop();
	}catch (NoSuchElementException e){
	    System.out.println("No Empty Stack Popping");
	}

	try{
	    data.peek();
	}catch (NoSuchElementException e){
	    System.out.println("No Empty Stack Peeking");
	}

	System.out.println(data.size());
	System.out.println(data.isEmpty());

	for (int i = 0; i < 1000;i++){
	    data.push(i);
	}

	System.out.println();
	System.out.println(data.size());
	System.out.println(data.isEmpty());

	for (int i = 0; i < 1001; i++){
	    System.out.println(data.pop());
	}
    }	
}
