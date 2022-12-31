package prac;
public class CLS3 extends Thread  {
	public void run() {
	for(int i=0; i<10; i++) {
		System.out.println("hello from cls 3..........");
		try {Thread.sleep(3000);} catch (InterruptedException e) {}}}
}

