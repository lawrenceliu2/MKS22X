public class FrontierStack<T> implements Frontier<T>{
    private MyStack<T> data;

    public FrontierStack(){
	data= new MyStack<T>();
    }

    public boolean hasNext(){
	if (data.peek()!=null){
	    return true;
	}
	return false;
    }

    public T next(){
	return data.pop();
    }

    public void add(T element){
	data.push(element);
    }

    public static void main(String[]args){
	FrontierStack<Integer> data= new FrontierStack<Integer>();
	data.add(7);
	System.out.println(data.next());
	System.out.println(data.hasNext());
    }
}
