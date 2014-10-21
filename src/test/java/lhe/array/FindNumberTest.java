package lhe.array;

import java.util.List;

import junit.framework.TestCase;

public class FindNumberTest extends TestCase {

	public void testFindShunXuNum(){
		
    	int a[] = {1,3,5,6,3,19,30,19,35,36}; 
    	for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
    	System.out.println();
    	FindNumber fm = new FindNumber();
    	List<Integer> maxList = fm.findShunXuNum(a);
    	for(int k : maxList){
    		System.out.print(k+" ");
    	}
    }

}
