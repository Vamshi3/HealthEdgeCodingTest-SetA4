package com.teksys.poc.testj4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.teksys.poc.testj4.NegativeNumException;
import com.teksys.poc.testj4.TestJ4Impl;
import com.teksys.poc.testj4.TestJ4Service;

public class TestJ4ServiceTest {
	// Test to Find Prime
	@Test
	public void testFindPrime() throws Exception {
		assertEquals(3,new TestJ4Impl().findPrimes(5).length);
	}
	//Test to find Negative Number Exception
	@Test
	(expected = NegativeNumException.class)
	public void testNegativeNumException() throws Exception {
		new TestJ4Impl().findPrimes(-5);
	}
}
