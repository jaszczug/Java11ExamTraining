package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockExample {

	
	static Lock lock = new ReentrantLock();	
	
	public static void main(String[] args) throws InterruptedException {
			
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		LockExample lockExample = new LockExample();
		
		
		IntStream.range(0, 100)
	    .forEach(i -> executor.submit(() -> lockExample.increment()));
		
	
		
		
		Thread.sleep(1);
		System.out.print(lockExample.count);
	}
	
	
	int count = 0;

    void increment() {
	    lock.lock();
	    try {
	        count++;
	    } finally {
	        lock.unlock();
	    }
	}

}
