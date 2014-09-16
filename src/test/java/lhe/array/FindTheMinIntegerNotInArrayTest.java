package lhe.array;

import junit.framework.TestCase;

public class FindTheMinIntegerNotInArrayTest extends TestCase {

	public void testFindTheMinIntegerNotInArray(){
		
    	int a[] = {1,3,5,6,3,19,30,5,8,3,3,2}; 
    	for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
    	System.out.println();
    	FindTheMinIntegerNotInArray fm = new FindTheMinIntegerNotInArray(a);
    	fm.find();
    	fm.print();
    }
}
