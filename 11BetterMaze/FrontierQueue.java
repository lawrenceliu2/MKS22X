public class FrontierQueue<T> implements Frontier<T>{
    private MyQueue<T> data;

    public FrontierQueue(){
	data= new MyQueue<T>();
    }

    public boolean hasNext(){
	if (data.peek()!=null){
	    return true;
	}
	return false;
    }

    public T next(){
	return data.dequeue();
    }

    public void add(T element){
	data.enqueue(element);
    }

    public static void main(String[]args){
	FrontierQueue<Integer> data= new FrontierQueue<Integer>();
	data.add(7);
	System.out.println(data.next());
	System.out.println(data.hasNext());
    }
}
