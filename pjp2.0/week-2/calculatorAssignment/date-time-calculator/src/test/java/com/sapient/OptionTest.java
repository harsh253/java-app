package com.sapient;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OptionTest {
	
	private Option option;


	@Test
	public void testGetOptionName() {
		option = new Option("Add Two Dates");
		String result = option.getOptionName();
		assertNotNull(result);
		assertEquals("Add Two Dates", result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionForNullOption() {
		option = new Option(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionForEmptyOption() {
		option = new Option("");
	}

}
