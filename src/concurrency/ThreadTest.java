package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		//run method of the thread		
		Runnable runnableTask = () -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(300);
		        System.out.println("run");
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};
		
		
		Callable<String> callableTask = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution";
		};		
		
		ExecutorService executor = Executors.newFixedThreadPool(10);		
		
		// execute single thread
		executor.execute(runnableTask);
				
		// execute single thread and get result
		Future<String> future =  executor.submit(callableTask);
		
		
		System.out.println("future done? " + future.isDone());

		String result = future.get(2000, TimeUnit.MILLISECONDS);
		
		try {
			 result = future.get();

			System.out.println("future done? " + future.isDone());
			System.out.print("result: " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ExecutorService executorSingle = Executors.newSingleThreadExecutor();
		executorSingle.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
		
		executorSingle.shutdownNow();
		
		
		
		ExecutorService executorService = 
				  new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,   
				  new LinkedBlockingQueue<Runnable>());
		
		/**
		 * Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks. Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. Threads that have not been used for sixty seconds are terminated and removed from the cache. 
		 */
		ExecutorService executorExam = Executors.newCachedThreadPool();
		
		executorExam.execute(() -> System.out.print("Ping "));
		
		Callable callableTask5 =   ()  ->  {return "Pong";};  //n1
		Future<String> future5 = executorExam.submit(callableTask5 );
		
		 String result5 = future.get();
		 System.out.print(result5);
		 
		 executorExam.shutdown();
		
		
		

	}

}
