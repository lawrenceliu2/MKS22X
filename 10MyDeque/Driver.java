import java.util.*;

public class Driver{

    public static void main(String[]args){

	MyDeque<Integer> a = new MyDeque<Integer>();

	Deque<Integer> b = new ArrayDeque<Integer>();




	for (int i = 0; i < 1000000; i++){

	    a.addFirst(i);

	    b.addFirst(i);

	}

	System.out.println(a.equals(b));




	for (int i = b.size(); i > 5000; i--){

	    a.removeLast();

	    b.removeLast();

	}

	System.out.println(a.equals(b));




	for (int i = 0; i < 50; i++){

	    a.removeFirst();

	    b.removeFirst();

	}

	System.out.println(a.equals(b));

	System.out.println(a.getFirst().equals(b.getFirst()));

	System.out.println(a.getLast().equals(b.getLast()));




	for (int i = 0; i < 100; i++){

	    a.addLast(i);

	    b.addLast(i);

	}

	System.out.println(a.equals(b));



    }

}
