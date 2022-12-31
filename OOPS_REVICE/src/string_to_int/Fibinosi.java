package string_to_int;
public class Fibinosi {
	public static void main(String[] args) {
	int fst =0, scd=1 , sum =0;
	System.out.println(fst);
	System.out.println(scd);
    for(int i=0; i<10; i++) {
    	sum = fst+scd;
    	System.out.println(sum);
    	fst = scd;
    	scd = sum;
    }
	}

}
