package primeumberss;
public class Prime {
	public static void main(String[] args) {
		boolean value = true;
		for(int number=5; number<5; number++) {
		for(int i=2; i<10; i++) {
			if(i!=number) {
				System.out.println(i);
				System.out.println(number);
				System.out.println(number%i);
				if(number%i==0) {
					value = false;}}}
				
			
		if(value==true) 
			System.out.println(number + " is a priem number");
		if(value==false)
			System.out.println(number + " is not a prime one");
		}
		
	

}}
