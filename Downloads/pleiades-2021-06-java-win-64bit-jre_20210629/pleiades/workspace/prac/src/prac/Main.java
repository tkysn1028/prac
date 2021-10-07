package prac;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new  CyclicBarrier(5, () -> {
			System.out.println("all done!");
		});		
		for(int i = 0; i< 5 ; i++) {
			exec.submit(new SampleThread(barrier));
			
		}
}
}