package lhe;

import junit.framework.TestCase;

public class AlgorithmsTest extends TestCase{

	public void testNSum(){
		Algorithms al = new Algorithms();
		System.out.println(al.nSum(100));
		Class c1= void.class;
		Class c2= int.class;
		Class c3= Integer.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c3.getName());
		System.out.println(c3.getSimpleName());
	}
	
	public void testFind2Number(){
		int a[] = {1,3,5,6,7,10,11,19,35,36}; 
    	for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
    	System.out.println();
		Algorithms alg = new Algorithms();
		alg.find2Number(a, 15);
	}
}
