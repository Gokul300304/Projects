package reflux;
import java.lang.reflect.*;
public class Demo {
	public static void main(String[] args) {
      UnKnown u = new UnKnown();
      Class cls =  u.getClass();
 // for class name
      System.out.println(cls.getName());
 // for print methods
      Method[]m = cls.getMethods();
      for(Method meth: m) {
    	  System.out.println(meth);}
 // method invoke
      try {
		m[0].invoke(u, null);}
	    catch (IllegalAccessException e) {
		e.printStackTrace();}
	    catch (InvocationTargetException e) {
		e.printStackTrace();}
	

}}
