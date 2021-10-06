package prac;

public class Main {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("sada");
		});
		
		t.start();
		System.out.println("main");
		
		
}
}