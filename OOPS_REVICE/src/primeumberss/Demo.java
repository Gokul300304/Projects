package primeumberss;
import java.util.ArrayList;
import java.util.Scanner;
public class Demo {
	public static void main(String[] args) {
//data
    int range=100;
    boolean value =  true;
    ArrayList alist = new ArrayList();
//for range
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the range: ");
//    range = s.nextInt();
    
// for find
    for(int number=2; number<=range; number++) {
    for(int i=2; i<=9; i++) {
    	if(i!=number)
    		if(number%i==0)
    			value = false;}
    if(value==true)
    	System.out.println(number);}
//Print
	}}

