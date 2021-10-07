package prac;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SampleThread implements Runnable{
		private CyclicBarrier barrier;
		public SampleThread(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
		}
	@Override
	public void run() {
		long id =Thread.currentThread().getId();
		System.out.println("start : " + id);
		int r = new Random().nextInt(10);
		try {
			System.out.println(r);
			Thread.sleep(r * 1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("end : "  + id);
		
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		
		
		
		
		}
	}
}