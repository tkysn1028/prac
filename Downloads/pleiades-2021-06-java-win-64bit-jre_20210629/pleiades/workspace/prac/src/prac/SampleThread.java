package prac;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SampleThread{
	public static void main(String[] args) {

		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.schedule(() -> {
			System.out.println("finish");
			exec.shutdown();
		}, 10, TimeUnit.SECONDS);
		
		int count = 0;
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	
		if(exec.isShutdown()) {
			break;
		}
		System.out.println((++count) * 100 + " ms");
		
	}
	
	}
	
}

	