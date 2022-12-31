package prac;
public class Demo {
	public static void main(String[] args) {
		CLS1 c1 = new CLS1();
		CLS2 c2 = new CLS2();
		CLS3 c3 = new CLS3();
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
		c3.start();
		
		
	}

}
