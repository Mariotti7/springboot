package org.generation.blogPessoal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class Testes {
	
	@Test
		void testarStrings() {
		String obj1="Junit";
		String obj2="Junit";
		assertEquals(obj1, obj2);
	}
	
	@Test
	void testarInteiros() {
	int obj1=  1;
	int obj2= 1;
	assertEquals(obj1, obj2);
}
	
	@Test
	void testarNulo() {
	String obj1="teste";
	String obj2="Junit";
	assertNotNull(obj1);
}
	
	@Test
	void testarForça() {
		int soco1 = 300;
		int soco2 = 302;
		assertNotEquals(soco1, soco2);
	}
	
	@Test
	void whenAssertingNotSameObject_thenDifferent() {
		Object cat = new Object();
		Object dog = new Object();
		assertNotSame(cat, dog);
	}
	
	@Test
	void whenAssertingNotSameObject_thenEquals() {
		Object cat = new Object();
		Object dog = new Object();
		assertNotEquals(cat, dog);
	}
	
	@Test
	public void whenAssertingEquality_thenEqual() {
	    String expected = "Baeldung";
	    String actual = "Baeldung";
	 
	    assertEquals(expected, actual);
	}
	
	@Test
	public void whenAssertingArraysEquality_thenEqual() {
	    char[] expected = {'J','u','n','i','t'};
	    char[] actual = "Junit".toCharArray();
	    
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void whenAssertingNull_thenTrue() {
	    Object car = null;
	    
	    assertNull("The car should be null", car);
	}
	
}
