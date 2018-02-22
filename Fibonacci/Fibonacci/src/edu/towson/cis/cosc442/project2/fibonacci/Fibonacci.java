
package edu.towson.cis.cosc442.project2.fibonacci;

import java.util.ArrayList;

/**
 * The Class Fibonacci to simply calculates the nth Fibonacci number given the input n.
 */
public class Fibonacci {
	
	/**
	 * Calculates and returns the nth Fibonacci number.
	 *
	 * @param n the index
	 * @return the nth Fibonacci number
	 */
	public int fibonacci(int n) {
		int a=1,b=1;
		if(n<3&&n>0){
			return 1;
		}
		
		else if(n>1){
			ArrayList<Integer> list=new ArrayList<Integer>();
			for (int x=0; x<n-2;x++){
				if(a>b){
					b+=a;
					list.add(b);
				}
				else{
					a+=b;
					list.add(a);
				}
			}
			return list.get(list.size()-1).intValue();
		}
		else{
			return 0;
		}
	}
}
