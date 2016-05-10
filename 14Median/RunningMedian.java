import java.util.*;

public class RunningMedian {
    private MyHeap<Integer> minHeap, maxHeap;
    private int median;


    public RunningMedian(){
	minHeap= new MyHeap<Integer>(false);
	maxHeap= new MyHeap<Integer>(true);
    }

    public double getMedian(){
	if (minHeap.getSize()==0 && maxHeap.getSize()==0){
	    throw new NoSuchElementException();
	}
	return 1.0;
    }

    public void add(Integer x){
        if (x<median){
	    minHeap.add(x);
	}else{
	    maxHeap.add(x);
	}
	if (Math.abs(minHeap.getSize()-maxHeap.getSize())>1){
	    //do stuffs?
	}
    }

}
