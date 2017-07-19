package com.teksys.poc.testj4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJ4Impl implements TestJ4Service{

	@Override
	public int[] findPrimes(int arg) throws NegativeNumException {
		if(arg <0){
			throw new NegativeNumException(arg);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= arg; i++) {
			if (isPrime(i)){
				list.add(i);
			}
		}
int[] res = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
	res[i]= list.get(i);
}
		return  res;

	}

	boolean isPrime(int n) {
	    //if not, then just check the odds
	    for(int i=2;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public static void main(String[] args) throws Exception {
		TestJ4Service service = new TestJ4Impl();
		//Displays Prime numbers before 10 , User can change this value to obtain list of Prime Numbers between 0 and User value. 
		int[] findPrimes = service.findPrimes(10);
		System.out.println(Arrays.toString(findPrimes));
		findPrimes = service.findPrimes(-5);
	}
}
